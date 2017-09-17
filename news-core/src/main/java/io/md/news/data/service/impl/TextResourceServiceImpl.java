package io.md.news.data.service.impl;

import io.md.news.data.service.spec.DataAccessService;
import io.md.news.data.service.spec.TextResourceService;
import io.md.news.dto.TextResourceDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextResourceServiceImpl implements TextResourceService {
    @Autowired
    private DataAccessService dataAccessService;

    @Override
    public String getText(String key) {
        TextResourceDto entity = dataAccessService.getSingle(Arrays.asList(key), TextResourceDto.class);
        return valueOrNull(entity);
    }

    @Override
    public Map<String, String> getText(List<String> keys) {
        List<TextResourceDto> entities = dataAccessService.getMultiple(convertKeys(keys), TextResourceDto.class);
        Map<String, String> resources = new HashMap<>();

        for(TextResourceDto entity : entities) {
            resources.put(entity.getTextKey(), entity.getTextValue());
        }

        return resources;
    }

    private List<List<String>> convertKeys(List<String> keys) {
        return keys.stream().map(Arrays::asList).collect(Collectors.toList());
    }

    private String valueOrNull(TextResourceDto entity) {
        if(entity != null) {
            return entity.getTextValue();
        }
        return null;
    }
}