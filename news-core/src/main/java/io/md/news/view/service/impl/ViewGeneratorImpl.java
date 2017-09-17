package io.md.news.view.service.impl;

import io.md.news.data.service.spec.ArticleService;
import io.md.news.data.service.spec.JsonSerializer;
import io.md.news.dto.ArticleDto;
import io.md.news.view.model.View;
import io.md.news.view.service.ViewConstant;
import io.md.news.view.service.spec.ModelGenerator;
import io.md.news.view.service.spec.ResourceViewGenerator;
import io.md.news.view.service.spec.ViewGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

public class ViewGeneratorImpl implements ViewGenerator {

    @Autowired
    private ResourceViewGenerator resourceViewGenerator;

    @Autowired
    private ModelGenerator modelGenerator;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private JsonSerializer jsonSerializer;

    @Override
    public void generateFeed(Model model) {
        resourceViewGenerator.load(model);
        List<ArticleDto> articles = articleService.getLatest();
        List<ArticleDto> local = articleService.getLocalArticles();
        View view = modelGenerator.generateTopFeed(articles, local);
        loadData(model, view);
    }

    @Override
    public void generateFeed(Model model, String category, String page) {
        resourceViewGenerator.load(model);
        loadData(model, generateFeed(category, page));
    }

    @Override
    public View generateFeed(String category, String page) {
        int realPage = parsePage(page);
        List<ArticleDto> articles = articleService.getArticles(category, realPage);
        List<ArticleDto> local = articleService.getLocalArticles();
        return modelGenerator.generateNormalFeed(category, articles, local, realPage, articles.size() > 0);
    }

    @Override
    public void generateArticle(Model model, String articleId) {
        resourceViewGenerator.load(model);
        ArticleDto article = articleService.getArticle(articleId);
        View view = modelGenerator.generateArticle(article);
        loadData(model, view);
    }

    private void loadData(Model model, View view) {
        model.addAttribute(ViewConstant.DATA, jsonSerializer.write(view));
    }

    private int parsePage(String page) {
        if (page == null) {
            return 0;
        }
        try {
            return Integer.parseInt(page);
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }
}