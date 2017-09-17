package io.md.news.data.service.mock;

import io.md.news.data.config.TextResourceConfig;
import io.md.news.data.service.spec.ArticleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(TextResourceConfig.class)
@Configuration
public class MockServiceConfig {
    @Bean
    public ArticleService articleService() {
        return new MockArticleServiceImpl();
    }
}