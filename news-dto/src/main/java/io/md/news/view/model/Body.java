package io.md.news.view.model;

import io.md.news.mode.ViewMode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Body {
    private ViewMode mode;
}