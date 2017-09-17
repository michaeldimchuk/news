package io.md.news.data.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.md.news.data.service.spec.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class JsonSerializerImpl implements JsonSerializer {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public <T> String write(T value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T read(String value, Class<T> type) {
        try {
            return objectMapper.readValue(value, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}