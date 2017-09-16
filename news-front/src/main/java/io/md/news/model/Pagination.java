package io.md.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {
    private boolean firstPage;
    private boolean lastPage;
    private int currentPage;
    private List<Link> pages;
    private String prefix;
}
