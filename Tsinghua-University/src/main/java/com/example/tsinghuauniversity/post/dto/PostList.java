package com.example.tsinghuauniversity.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostList {

    private int id;
    private String title;
    private LocalDate date;
    private String content;
    private String category;

    @Builder
    public PostList(String title, LocalDate date, String content, int id, String category){
        this.title = title;
        this.date = date;
        this.content = content;
        this.id = id;
        this.category = category;
    }
}
