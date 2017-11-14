package api;

import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping("/page")
public class PageController extends Controller{
    
    public PageController (EntityManager em) {
        super(em);
    }
    
    @RequestMapping(method = GET)
    String pages() {
        // return all pages
        return "Hello im a Page";
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
    
    @RequestMapping(method = POST, value = "/{pageId}/attachement")
    String addTagToPage(@PathVariable String pageId, @RequestBody Attachement attachement) {
        return String.format("Add attachement to page with id %s, %s", pageId, attachement.toString());
    }
}

@Entity
class Page {
    
    public String title;
    public String content;
}

@Entity
class Attachement {
    
    public String filename;
    public String content;
    
    @Override
    public String toString () {
        return String.format("Filename: %s\nContent: %s", filename, content);
    }
}