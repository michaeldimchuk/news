package io.md.news.data.service.spec;

import io.md.news.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto getArticle(String articleId);

    List<ArticleDto> getLatest();

    List<ArticleDto> getLocalArticles();

    List<ArticleDto> getArticles(String category, int page);
}
