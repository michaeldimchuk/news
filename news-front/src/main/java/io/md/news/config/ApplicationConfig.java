package io.md.news.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.md.news.controller.IndexController;
import io.md.news.service.MockViewServiceImpl;
import io.md.news.service.ViewService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper;
    }

    @Bean
    public ViewService viewService() {
        return new MockViewServiceImpl();
    }

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }
}
