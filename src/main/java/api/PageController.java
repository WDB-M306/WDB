package api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping("/page")
public class PageController {

    @RequestMapping(method = GET)
    String pages() {
        // return all pages
        return "Hello im a Page";
    }
    
    @RequestMapping(method = GET, value = "/{pageId}")
    String getPage(@PathVariable String pageId) {
        return "Id: " + pageId;
    }
}
