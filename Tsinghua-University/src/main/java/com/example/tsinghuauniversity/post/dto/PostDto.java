package com.example.tsinghuauniversity.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostDto {

    private String content;
    private String title;
    private LocalDate date;
    private String category;
}
