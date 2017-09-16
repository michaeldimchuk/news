package io.md.news.service;

import io.md.news.model.View;

public interface ViewService {
    public View getView(int page);
    public View getView(int page, boolean viewingTop);
    public View getArticleView(int page, boolean viewingTop);
}