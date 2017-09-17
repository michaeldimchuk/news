package io.md.news.view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Footer {
    private LabeledList social;
    private LabeledList services;
    private LabeledText contact;
    private String copyright;
}