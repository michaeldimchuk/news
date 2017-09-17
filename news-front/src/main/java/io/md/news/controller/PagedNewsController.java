package io.md.news.controller;

import io.md.news.data.service.spec.JsonSerializer;
import io.md.news.view.model.View;
import io.md.news.view.service.spec.ViewGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagedNewsController {
    @Autowired
    private ViewGenerator viewGenerator;

    @Autowired
    private JsonSerializer jsonSerializer;

    @RequestMapping("/page/{category}/{page}")
    public String pagedNews(@PathVariable String category, @PathVariable(required = false) String page) {
        View view = viewGenerator.generateFeed(category, page);
        return jsonSerializer.write(view.getBody());
    }
}