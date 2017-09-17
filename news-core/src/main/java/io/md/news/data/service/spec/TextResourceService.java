package io.md.news.data.service.spec;

import java.util.List;
import java.util.Map;

public interface TextResourceService {
    String getText(String key);

    Map<String, String> getText(List<String> keys);
}