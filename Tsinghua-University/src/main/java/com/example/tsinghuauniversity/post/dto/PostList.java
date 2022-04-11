package com.example.tsinghuauniversity.post.dto;

import com.example.tsinghuauniversity.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostList {

    private Integer id;
    private String title;
    private LocalDate date;
    private String content;
    private String category;

    @Builder
    public PostList(Integer id,String title, String category, String content, LocalDate date){
        this.title = title;
        this.date = date;
        this.content = content;
        this.id = id;
        this.category = category;
    }
}
