package io.md.news.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.md.news.model.View;
import io.md.news.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    private static final String DATA = "data";

    private static final Integer FIRST_PAGE = 1;

    private static final Integer LAST_PAGE = 5;

    @Autowired
    private ViewService viewService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/")
    public String index(Model model) throws Exception {
        return index(FIRST_PAGE, model);
    }

    @RequestMapping("/{page}")
    public String index(@PathVariable(required = false) Integer page, Model model) throws Exception {
        Integer currentPage = getValidPage(page);
        View view = viewService.getView(currentPage, currentPage == FIRST_PAGE);
        model.addAttribute(DATA, objectMapper.writeValueAsString(view));
        return "index";
    }

    @RequestMapping("/article/{article}")
    public String article(@PathVariable(required = false) Integer article, Model model) throws Exception {
        if(article == null) {
            return index(FIRST_PAGE, model);
        }
        return "index";
    }

    private Integer getValidPage(Integer page) {
        if(page == null || page < FIRST_PAGE) {
            return FIRST_PAGE;
        }
        return page > LAST_PAGE ? LAST_PAGE : page;
    }
}