package io.md.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Footer {
    private String copyright;
    private LinkList social;
    private LinkList services;
    private Contact contact;
}