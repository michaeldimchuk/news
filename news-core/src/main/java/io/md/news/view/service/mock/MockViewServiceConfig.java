package io.md.news.view.service.mock;

import io.md.news.data.config.DataAccessConfig;
import io.md.news.data.config.JsonConfig;
import io.md.news.data.config.TextResourceConfig;
import io.md.news.view.service.impl.ViewGeneratorImpl;
import io.md.news.view.service.mock.impl.MockModelGeneratorImpl;
import io.md.news.view.service.mock.impl.MockResourceViewGeneratorImpl;
import io.md.news.view.service.spec.ModelGenerator;
import io.md.news.view.service.spec.ResourceViewGenerator;
import io.md.news.view.service.spec.ViewGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        JsonConfig.class,
        TextResourceConfig.class,
        DataAccessConfig.class
})
@Configuration
public class MockViewServiceConfig {
    @Bean
    public ViewGenerator viewGenerator() {
        return new ViewGeneratorImpl();
    }

    @Bean
    public ModelGenerator modelGenerator() {
        return new MockModelGeneratorImpl();
    }

    @Bean
    public ResourceViewGenerator resourceViewGenerator() {
        return new MockResourceViewGeneratorImpl();
    }
}