package io.md.news.view.model;

import io.md.news.mode.FeedMode;
import lombok.Data;

import java.util.List;

@Data
public class NormalFeed extends Feed {
    private Pagination pagination;
    private String category;
    private String contextPath;

    public NormalFeed(List<FeedElement> articles, LabeledList local, Pagination pagination,
                      String category, String contextPath) {
        super(articles, local, FeedMode.NORMAL);
        this.pagination = pagination;
        this.category = category;
        this.contextPath = contextPath;
    }
}