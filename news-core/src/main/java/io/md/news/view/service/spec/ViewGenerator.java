package io.md.news.view.service.spec;

import io.md.news.view.model.View;
import org.springframework.ui.Model;

public interface ViewGenerator {
    void generateFeed(Model model);

    void generateFeed(Model model, String category, String page);

    View generateFeed(String category, String page);

    void generateArticle(Model model, String articleId);
}