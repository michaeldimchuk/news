package io.md.news.config;

import io.md.news.controller.NewsController;
import io.md.news.controller.PagedNewsController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;


@Import(MockApplicationConfig.class)
@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    @Bean
    public NewsController newsController() {
        return new NewsController();
    }

    @Bean
    public PagedNewsController pagedNewsController() {
        return new PagedNewsController();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.DAYS));
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.DAYS));
    }
}