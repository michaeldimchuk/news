package io.md.news.data.config;

import io.md.news.data.service.impl.TextResourceServiceImpl;
import io.md.news.data.service.spec.TextResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(DataAccessConfig.class)
@Configuration
public class TextResourceConfig {
    @Bean
    public TextResourceService textResourceService() {
        return new TextResourceServiceImpl();
    }
}