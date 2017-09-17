package io.md.news.view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Header {
    private Link logo;
    private List<Link> tabs;
    private String active;
}