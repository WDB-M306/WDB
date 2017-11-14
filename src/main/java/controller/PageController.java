package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import persistence.Page;

import java.util.ArrayList;
import java.util.Collection;


@RestController
@RequestMapping("/page")
public class PageController {

    @RequestMapping(method = RequestMethod.GET)
    String pages() {
        return "Hello im a Page";
    }
}
