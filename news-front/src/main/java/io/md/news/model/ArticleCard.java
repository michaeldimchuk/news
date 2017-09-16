package io.md.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCard {
    private String cardImage;
    private String cardTitle;
    private String title;
    private String text;
    private Link link;
}
