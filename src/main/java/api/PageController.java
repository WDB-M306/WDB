package api;

import entity.data.DataPage;
import entity.data.DataTag;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/page")
public class PageController extends Controller{
    
    
    public PageController (EntityManager em) {
        super(em);
    }
    
    
    @RequestMapping(method = GET)
    String pages() {
        // return all pages
        return "Hello im a DataPage";
    }
    
    @RequestMapping(method = GET, value = "/{pageId}")
    String getPage(@PathVariable String pageId) {
        return "Id: " + pageId;
    }
    
    @RequestMapping(method = POST)
    String postPage(@RequestBody Page page) {
        return "Created page «"+page.title+"»";
    }
    
    @RequestMapping(method = POST, value = "/{pageId}/tag")
    String addTagToPage(@PathVariable String pageId, @RequestBody long tagId) {
        return String.format("Add tag with id %d to page with id %s", tagId, pageId);
    }
    
    @RequestMapping(method = POST, value = "/{pageId}/attachment")
    String addAttToPage(@PathVariable String pageId, @RequestBody Attachment attachment) {
        return String.format("Add attachment to page with id %s, %s", pageId, attachment.toString());
    }
    
    @RequestMapping(method = PUT, value = "/{pageId}")
    String putPage(@PathVariable String pageId, @RequestBody Page newPage) {
        return String.format("Changed page with id %s to title %s", pageId, newPage.title);
    }
    
    @RequestMapping(method = DELETE, value = "/{pageId}")
    String deletePage(@PathVariable String pageId)
    {
        return "Del";
    }
    
    @RequestMapping(method = DELETE, value = "/{pageId}/tag")
    String removeTagFromPage(@PathVariable String pageId, @RequestBody long tagId) {
        return String.format("Remove tag with id %d to page with id %s", tagId, pageId);
    }
    
    @RequestMapping(method = DELETE, value = "/{pageId}/attachment")
    String removeAttFromPage(@PathVariable String pageId, @RequestBody long attachmentId) {
        return String.format("Remove attachment to page with id %s, %d", pageId, attachmentId);
    }
}

@Entity
class Page {
    
    public String title;
    public String content;
    public long authorId;
    public long[] tagIds;
}

@Entity
class Attachment
{
    
    public String filename;
    public String content;
    
    @Override
    public String toString () {
        return String.format("Filename: %s\nContent: %s", filename, content);
    }
}