package io.md.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class View {
    private Header header;
    private Body body;
    private Footer footer;
    private String mode;
}
