package io.md.news.view.service.spec;

import io.md.news.dto.ArticleDto;
import io.md.news.view.model.View;

import java.util.List;

public interface ModelGenerator {
    View generateArticle(ArticleDto article);

    View generateTopFeed(List<ArticleDto> articles, List<ArticleDto> local);

    View generateNormalFeed(String category, List<ArticleDto> articles, List<ArticleDto> local,
                            int page, boolean hasMore);
}