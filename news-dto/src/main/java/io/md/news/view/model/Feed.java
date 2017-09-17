package io.md.news.view.model;

import io.md.news.mode.FeedMode;
import io.md.news.mode.ViewMode;
import lombok.Data;

import java.util.List;

@Data
public class Feed extends Body {
    private List<FeedElement> articles;
    private LabeledList local;
    private FeedMode feedMode;

    public Feed(List<FeedElement> articles, LabeledList local, FeedMode feedMode) {
        super(ViewMode.NORMAL);
        this.articles = articles;
        this.local = local;
        this.feedMode = feedMode;
    }
}