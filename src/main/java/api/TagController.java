package api;

import entity.data.Tag;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;

import java.lang.reflect.Array;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/tag")
public class TagController extends Controller
{
    
    public TagController (EntityManager em)
    {
        super(em);
    }
    
    @RequestMapping(method = GET)
    Tag[] getTags ()
    {
        entity.domain.Tag[] tags = em.createNamedQuery("Tag.selectAll", entity.domain.Tag.class).getResultList().toArray(new entity.domain.Tag[0]);
        Tag[] dataTags = new Tag[tags.length];
        for (int i = 0; i < tags.length; i++)
        {
            dataTags[i] = dataFromDomain(tags[i]);
        }
        return dataTags;
    }
    
    @RequestMapping(method = GET, value = "/{tagId}")
    String getTag (@PathVariable String tagId)
    {
        return "Id: " + tagId;
    }
    
    @RequestMapping(method = GET, value = "/{tagId}/page")
    String getPagesFromTag (@PathVariable String tagId)
    {
        return "Id: " + tagId;
    }
    
    // CREATE
    
    @RequestMapping(method = POST)
    String postTag (@RequestBody Tag tag)
    {
        return "Created tag «" + tag.getLabel() + "»";
    }
    
    // UPDATE
    
    @RequestMapping(method = PUT, value = "/{tagId}")
    String putTag (@PathVariable String tagId, @RequestBody Tag newTag)
    {
        return String.format("Changed tag with id %s to label %s", tagId, newTag.getLabel());
    }
    
    // DELETE
    
    @RequestMapping(method = DELETE, value = "/{tagId}")
    String deleteTag (@PathVariable String tagId)
    {
        return "Del";
    }
    
    private static entity.domain.Tag domainFromData(Tag tag)
    {
        return new entity.domain.Tag(tag.getLabel());
    }
    
    private static Tag dataFromDomain(entity.domain.Tag tag)
    
    {
        Tag tag1 = new Tag(tag.getName());
        tag.setId(tag.getId());
        return tag1;
    }
}