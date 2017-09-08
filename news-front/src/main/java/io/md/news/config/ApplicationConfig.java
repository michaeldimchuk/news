package io.md.news.config;

import io.md.news.controller.IndexController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {
    @Bean
    public IndexController indexController() {
        return new IndexController();
    }
}
