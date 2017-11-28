package api;

import entity.data.DataTag;
import entity.domain.Tag;
import org.springframework.web.bind.annotation.*;

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
    
    @RequestMapping(method = GET)
    DataTag[] getTags ()
    {
        Query query = em.createNamedQuery("Tag.findAll", entity.domain.Tag.class);
        
        if (query.getMaxResults() == 0)
            return new DataTag[0];
        
        List<Tag> tags = query.getResultList();
        DataTag[]           dataDataTags = new DataTag[tags.size()];
        for (int i = 0; i < tags.size(); i++)
        {
            dataDataTags[i] = dataFromDomain(tags.get(i));
        }
        return dataDataTags;
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
    String postTag (@RequestBody DataTag tag)
    {
        return "Created tag «" + tag.getLabel() + "»";
    }
    
    // UPDATE
    
    @RequestMapping(method = PUT, value = "/{tagId}")
    String putTag (@PathVariable String tagId, @RequestBody DataTag newTag)
    {
        return String.format("Changed tag with id %s to label %s", tagId, newTag.getLabel());
    }
    
    // DELETE
    
    @RequestMapping(method = DELETE, value = "/{tagId}")
    String deleteTag (@PathVariable String tagId)
    {
        return "Del";
    }
    
    private static entity.domain.Tag domainFromData(DataTag dataTag)
    {
        return new entity.domain.Tag(dataTag.getLabel());
    }
    
    private static DataTag dataFromDomain(entity.domain.Tag tag)
    
    {
        DataTag dataTag1 = new DataTag(tag.getName());
        tag.setId(tag.getId());
        return dataTag1;
    }
}