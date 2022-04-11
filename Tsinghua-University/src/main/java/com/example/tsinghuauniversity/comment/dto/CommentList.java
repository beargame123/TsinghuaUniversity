package com.example.tsinghuauniversity.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentList {
    Integer id;
    String comment;

    @Builder
    public CommentList(int id, String comment){
        this.comment = comment;
        this.id = id;
    }
}
