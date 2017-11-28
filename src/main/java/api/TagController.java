package api;

import entity.data.DataTag;
import entity.domain.Tag;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/tag")
public class TagController extends Controller
{
    
    public TagController (EntityManager em)
    {
        super(em);
    }
    
    private static entity.domain.Tag domainFromData (DataTag dataTag)
    {
        return new entity.domain.Tag(dataTag.getLabel());
    }
    
    private static DataTag dataFromDomain (entity.domain.Tag tag)
    
    {
        DataTag dataTag1 = new DataTag(tag.getName());
        dataTag1.setId(tag.getId());
        return dataTag1;
    }
    
    @RequestMapping(method = GET)
    DataTag[] getTags ()
    {
        Query query = em.createNamedQuery("Tag.findAll", entity.domain.Tag.class);
        
        if (query.getMaxResults() == 0) return new DataTag[0];
        
        List<Tag> tags         = query.getResultList();
        DataTag[] dataDataTags = new DataTag[tags.size()];
        for (int i = 0; i < tags.size(); i++)
        {
            dataDataTags[i] = dataFromDomain(tags.get(i));
        }
        return dataDataTags;
    }
    
    @RequestMapping(method = GET, value = "/{tagId}")
    DataTag getTag (@PathVariable long tagId)
    {
        Query query = em.createNamedQuery("Tag.findTagById", Tag.class);
        query.setParameter(1, tagId);
        Tag tag = (Tag) query.getSingleResult();
        return dataFromDomain(tag);
    }
    
    // CREATE
    
    // UPDATE
    
    @RequestMapping(method = GET, value = "/{tagId}/page")
    String getPagesFromTag (@PathVariable String tagId)
    {
        return "Id: " + tagId;
    }
    
    // DELETE
    
    @RequestMapping(method = POST)
    @Transactional
    public void postTag (@RequestBody String label)
    {
        Tag tag = new Tag(label);
        em.persist(tag);
    }
    
    
    @RequestMapping(method = PUT, value = "/{tagId}")
    @Transactional
    public void putTag (@PathVariable long tagId, @RequestBody String label)
    {
        Tag tag = em.find(Tag.class, tagId);
        
        tag.setName(label);
    
        System.out.println("Changed tag "+ tag.getId() + " to " + label);
        
        em.merge(tag);
    }
    
    @RequestMapping(method = DELETE, value = "/{tagId}")
    String deleteTag (@PathVariable String tagId)
    {
        return "Del";
    }
}