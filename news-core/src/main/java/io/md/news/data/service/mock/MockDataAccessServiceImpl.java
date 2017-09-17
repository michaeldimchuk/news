package io.md.news.data.service.mock;

import io.md.news.data.service.spec.DataAccessService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MockDataAccessServiceImpl implements DataAccessService {

    private final Map<Class<?>, Map<List<?>, Object>> inMemoryDatabase = new ConcurrentHashMap<>();

    public <T> void insert(List<?> keys, T entity) {
        findDatabase(entity.getClass()).put(keys, entity);
    }

    @Override
    public <T> T getSingle(List<?> keys, Class<T> entity) {
        return (T) findDatabase(entity).get(keys);
    }

    @Override
    public <T> List<T> getMultiple(List<?> keys, Class<T> entity) {
        Map<List<?>, Object> database = findDatabase(entity);
        List<T> results = new ArrayList<>();

        for (Object key : keys) {
            T value = (T) database.get(key);
            if (value != null) {
                results.add(value);
            }
        }

        return results;
    }

    private <T> Map<List<?>, Object> findDatabase(Class<T> entity) {
        return inMemoryDatabase.computeIfAbsent(entity, p -> new ConcurrentHashMap<>());
    }
}