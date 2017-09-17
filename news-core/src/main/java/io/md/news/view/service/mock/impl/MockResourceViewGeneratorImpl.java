package io.md.news.view.service.mock.impl;

import com.google.common.io.Resources;
import io.md.news.data.service.spec.DataAccessService;
import io.md.news.data.service.spec.JsonSerializer;
import io.md.news.data.service.spec.TextResourceService;
import io.md.news.dto.TextResourceDto;
import io.md.news.view.model.Link;
import io.md.news.view.service.ViewConstant;
import io.md.news.view.service.mock.MockUtil;
import io.md.news.view.service.spec.ResourceViewGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockResourceViewGeneratorImpl implements ResourceViewGenerator {
    @Autowired
    private TextResourceService textResourceService;

    @Autowired
    private DataAccessService dataAccessService;

    @Autowired
    private JsonSerializer jsonSerializer;

    @Override
    public void load(Model model) {
        Map<String, String> resources = loadResources();
        model.addAttribute(ViewConstant.TEXT, jsonSerializer.write(resources));
    }

    /**
     * Initialize mock text resources.
     */
    @PostConstruct
    public void init() throws Exception {
        URL url = getClass().getClassLoader().getResource("text-resources.properties");
        List<String> lines = Resources.readLines(url, Charset.defaultCharset());
        for (String property : lines) {
            String[] data = property.split("=");
            dataAccessService.insert(Arrays.asList(data[0]), new TextResourceDto(data[0], data[1]));
        }
    }

    private Map<String, String> loadResources() {
        Map<String, String> textResources = new HashMap<>();
        textResources.putAll(textResourceService.getText(getHeaderResourceKeys()));
        textResources.putAll(textResourceService.getText(getBodyResourceKeys()));
        textResources.putAll(textResourceService.getText(getFooterResourceKeys()));
        return textResources;
    }

    private List<String> getHeaderResourceKeys() {
        return MockUtil.HEADER_ELEMENTS.stream().map(Link::getText).collect(Collectors.toList());
    }

    private List<String> getBodyResourceKeys() {
        return MockUtil.BODY_ELEMENTS;
    }

    private List<String> getFooterResourceKeys() {
        return MockUtil.FOOTER_ELEMENTS;
    }
}