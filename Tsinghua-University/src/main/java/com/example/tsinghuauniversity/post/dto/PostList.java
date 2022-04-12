package com.example.tsinghuauniversity.post.dto;

import com.example.tsinghuauniversity.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class PostList {

    private Integer id;
    private String title;
    private LocalDateTime dateTime;
    private String content;
    private String category;

    @Builder
    public PostList(Integer id,String title, String category, String content, LocalDateTime dateTime){
        this.title = title;
        this.dateTime = dateTime;
        this.content = content;
        this.id = id;
        this.category = category;
    }
}
