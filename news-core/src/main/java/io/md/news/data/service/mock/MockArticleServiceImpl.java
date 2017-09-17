package io.md.news.data.service.mock;

import io.md.news.data.service.spec.ArticleService;
import io.md.news.dto.ArticleDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.md.news.view.service.mock.MockUtil.*;

public class MockArticleServiceImpl implements ArticleService {
    @Override
    public ArticleDto getArticle(String articleId) {
        return new ArticleDto(articleId, MOCK_TITLE + " " + articleId, MOCK_IMAGE, MOCK_PREVIEW, MOCK_CONTENT);
    }

    @Override
    public List<ArticleDto> getLatest() {
        List<ArticleDto> articles = new ArrayList<>();
        for (int x = 0; x < 7; x++) {
            articles.add(getArticle(Integer.toString(x)));
        }
        return articles;
    }

    @Override
    public List<ArticleDto> getLocalArticles() {
        List<ArticleDto> articles = new ArrayList<>();
        for (int x = 100; x < 106; x++) {
            articles.add(getArticle(Integer.toString(x)));
        }
        return articles;
    }

    @Override
    public List<ArticleDto> getArticles(String category, int page) {
        if (page > LAST_PAGE) {
            return Collections.emptyList();
        }
        List<ArticleDto> articles = new ArrayList<>();
        int realPage = getOffset(page);
        for (int x = realPage * 9; x < realPage * 9 + 9; x++) {
            ArticleDto article = getArticle(Integer.toString(x));
            article.setTitle(category + ": " + article.getTitle());
            articles.add(article);
        }
        return articles;
    }

    private int getOffset(int page) {
        if (page < FIRST_PAGE) {
            return FIRST_PAGE;
        }
        return page;
    }
}