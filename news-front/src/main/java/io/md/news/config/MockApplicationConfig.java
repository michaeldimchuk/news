package io.md.news.config;

import io.md.news.data.service.mock.MockServiceConfig;
import io.md.news.view.service.mock.MockViewServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        MockServiceConfig.class,
        MockViewServiceConfig.class

})
@Configuration
public class MockApplicationConfig {

}