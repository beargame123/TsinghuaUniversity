package com.example.tsinghuauniversity.comment.controller;

import com.example.tsinghuauniversity.comment.dto.CommentDto;
import com.example.tsinghuauniversity.comment.dto.CommentList;
import com.example.tsinghuauniversity.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{id}/create")
    public void create(@PathVariable int id,CommentDto commentDto){
        commentService.create(id,commentDto);
    }

    @GetMapping("/List/{id}")
    public List<CommentList> commentList(@PathVariable int id){
        return commentService.commentList(id);
    }

}
