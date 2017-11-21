package api;

import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

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
    String tags ()
    {
        // return all tags
        
        return "Hello im a Tag";
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
        return "Created tag «" + tag.label + "»";
    }
    
    // UPDATE
    
    @RequestMapping(method = PUT, value = "/{tagId}")
    String putTag (@PathVariable String tagId, @RequestBody Tag newTag)
    {
        return String.format("Changed tag with id %s to label %s", tagId, newTag.label);
    }
    
    // DELETE
    
    @RequestMapping(method = DELETE, value = "/{tagId}")
    String deleteTag (@PathVariable String tagId)
    {
        return "Del";
    }
}

@Entity
class Tag
{
    public long   id;
    public String label;
}