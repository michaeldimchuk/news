package io.md.news.view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedElement {
    private Link image;
    private Link readMore;
    private LabeledText content;
}