package io.md.news.data.service.spec;

public interface JsonSerializer {
    <T> String write(T value);

    <T> T read(String value, Class<T> type);
}
