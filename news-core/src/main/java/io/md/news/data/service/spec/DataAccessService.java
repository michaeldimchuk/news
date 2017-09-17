package io.md.news.data.service.spec;

import java.util.List;

public interface DataAccessService {
    <T> void insert(List<?> keys, T entity);

    <T> T getSingle(List<?> keys, Class<T> entity);

    <T> List<T> getMultiple(List<?> keys, Class<T> entity);
}