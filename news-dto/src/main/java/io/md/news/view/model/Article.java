package io.md.news.view.model;

import io.md.news.mode.ViewMode;
import lombok.Data;

import java.util.List;

@Data
public class Article extends Body {
    private String title;
    private String image;
    private List<String> paragraphs;

    public Article(String title, String image, List<String> paragraphs) {
        super(ViewMode.ARTICLE);
        this.title = title;
        this.image = image;
        this.paragraphs = paragraphs;
    }
}