package io.md.news.data.config;

import io.md.news.data.service.mock.MockDataAccessServiceImpl;
import io.md.news.data.service.spec.DataAccessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAccessConfig {
    @Bean
    public DataAccessService dataAccessService() {
        return new MockDataAccessServiceImpl();
    }
}