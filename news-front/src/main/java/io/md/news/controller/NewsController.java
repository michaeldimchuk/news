package io.md.news.controller;

import io.md.news.view.service.spec.ViewGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsController {
    @Autowired
    private ViewGenerator viewGenerator;

    @RequestMapping("/")
    public String index(Model model) {
        viewGenerator.generateFeed(model);
        return "index";
    }

    @RequestMapping("/category/{category}")
    public String category(@PathVariable String category, Model model) {
        viewGenerator.generateFeed(model, category, "0");
        return "index";
    }

    @RequestMapping("/articles/{articleId}")
    public String articles(@PathVariable String articleId, Model model) {
        viewGenerator.generateArticle(model, articleId);
        return "index";
    }
}