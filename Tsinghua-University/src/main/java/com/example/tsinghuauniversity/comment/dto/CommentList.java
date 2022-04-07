package com.example.tsinghuauniversity.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CommentList {
    int id;
    String comment;

    public CommentList(int id,String comment){
        this.comment = comment;
        this.id = id;
    }
}
