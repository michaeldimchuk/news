package io.md.news.config;

import io.md.news.controller.NewsController;
import io.md.news.controller.PagedNewsController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(MockApplicationConfig.class)
@Configuration
public class ApplicationConfig {
    @Bean
    public NewsController newsController() {
        return new NewsController();
    }

    @Bean
    public PagedNewsController pagedNewsController() {
        return new PagedNewsController();
    }
}