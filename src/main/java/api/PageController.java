package api;

import entity.data.DataPage;
import entity.data.DataTag;
import entity.domain.Attachment;
import entity.domain.Page;
import entity.domain.Tag;
import entity.domain.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/page")
public class PageController extends Controller
{
    
    public PageController (EntityManager em)
    {
        super(em);
    }
    
    @RequestMapping(method = GET)
    public DataPage[] pages ()
    {
        Query query = em.createNamedQuery("Page.findAll", Page.class);
        
        if (query.getMaxResults() == 0) return new DataPage[0];
        
        List<Page> tags      = query.getResultList();
        DataPage[] dataPages = new DataPage[tags.size()];
        for (int i = 0; i < tags.size(); i++)
        {
            dataPages[i] = dataFromDomain(tags.get(i));
        }
        return dataPages;
    }
    
    public static DataPage dataFromDomain (Page page)
    {
        List<DataTag> tags = new ArrayList<>();
        page.getTags().forEach(tag -> tags.add(TagController.dataFromDomain(tag)));
        
        
        return new DataPage(page.getTitle(), page.getContent(), tags.toArray(new DataTag[0]), page
                .getAuthor().getId());
    }
    
    @RequestMapping(method = GET, value = "/{pageId}")
    public DataPage getPage (@PathVariable long pageId)
    {
        return dataFromDomain(em.createNamedQuery("Page.findPageById", Page.class)
                                .setParameter(1, pageId)
                                .getSingleResult());
    }
    
    @RequestMapping(method = POST)
    @Transactional
    public void postPage (@RequestBody NewPage newPage, HttpSession session) throws Exception
    {
        User user = ((User) session.getAttribute("User"));
        
        if (user == null)
        {
            throw new Exception("User not logged in");
        }
        
        List<Tag> tags = new ArrayList<>();
        
        for (long id : newPage.tagIds)
        {
            tags.add(em.find(Tag.class, id));
        }
        
        Page page = new Page(newPage.title, newPage.content, tags, user);
        em.persist(page);
    }
    
    @RequestMapping(method = POST, value = "/{pageId}/tag")
    @Transactional
    public void addTagToPage (@PathVariable long pageId, @RequestBody long tagId) throws Exception
    {
        Page page = em.find(Page.class, pageId);
        Tag  tag  = em.find(Tag.class, tagId);
        
        if (page != null && tag != null)
        {
            page.getTags().add(tag);
            em.merge(page);
        }
        else
        {
            throw new Exception("Cannot add tag to page. Please check the ids");
        }
    }
    
    
    @RequestMapping(method = PUT, value = "/{pageId}")
    @Transactional
    public void putPage (
            @PathVariable long pageId, @RequestBody ChangePage newPage, HttpSession session) throws Exception
    {
        User user = ((User) session.getAttribute("User"));
        
        if (user == null)
        {
            throw new Exception("User not logged in");
        }
        
        Page page = em.find(Page.class, pageId);
        
        if (page == null)
        {
            throw new Exception("Page nicht gefunden");
        }
        
        if (newPage.getTitle() != null) page.setTitle(newPage.getTitle());
        
        if (newPage.getContent() != null) page.setContent(newPage.getContent());
        
        em.merge(page);
    }
    
    @RequestMapping(method = DELETE, value = "/{pageId}")
    @Transactional
    public void deletePage (@PathVariable long pageId, HttpSession session) throws Exception
    {
        User user = ((User) session.getAttribute("User"));
        
        if (user == null)
        {
            throw new Exception("User not logged in");
        }
        
        Page page = em.find(Page.class, pageId);
        
        if (page == null)
        {
            throw new Exception("Page nicht gefunden");
        }
        
        em.remove(page);
    }
    
    @RequestMapping(method = DELETE, value = "/{pageId}/tag")
    @Transactional
    public void removeTagFromPage (
            @PathVariable long pageId, @RequestBody long tagId, HttpSession session) throws Exception
    {
        User user = ((User) session.getAttribute("User"));
        
        if (user == null)
        {
            throw new Exception("User not logged in");
        }
        
        Page page = em.find(Page.class, pageId);
        Tag  tag  = em.find(Tag.class, tagId);
        
        if (page == null || tag == null)
        {
            throw new Exception("Page oder Tag nicht gefunden");
        }
        
        page.getTags().remove(tag);
        
        em.merge(page);
    }
    
    @RequestMapping(method = DELETE, value = "/{pageId}/attachment")
    String removeAttFromPage (@PathVariable String pageId, @RequestBody long attachmentId)
    {
        return String.format("Remove attachment to page with id %s, %d", pageId, attachmentId);
    }
    
    @RequestMapping(method = POST, value = "/{pageId}/attachment")
    String addAttToPage (@PathVariable String pageId, @RequestBody Attachment attachment)
    {
        return String.format("Add attachment to page with id %s, %s", pageId, attachment.toString());
    }
}

class NewPage extends ChangePage
{
    long   authorId;
    long[] tagIds;
    
    public long getAuthorId ()
    {
        return authorId;
    }
    
    public void setAuthorId (long authorId)
    {
        this.authorId = authorId;
    }
    
    public long[] getTagIds ()
    {
        return tagIds;
    }
    
    public void setTagIds (long[] tagIds)
    {
        this.tagIds = tagIds;
    }
}

class ChangePage
{
    String title;
    String content;
    
    public String getTitle ()
    {
        return title;
    }
    
    public void setTitle (String title)
    {
        this.title = title;
    }
    
    public String getContent ()
    {
        return content;
    }
    
    public void setContent (String content)
    {
        this.content = content;
    }
    
}