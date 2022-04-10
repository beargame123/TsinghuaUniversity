package com.example.tsinghuauniversity.post.controller;

import com.example.tsinghuauniversity.post.dto.PostDto;
import com.example.tsinghuauniversity.post.dto.PostList;
import com.example.tsinghuauniversity.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/List")
    public List<PostList> postList(){
        return postService.postList();
    }

    @PostMapping("/create")
    public void create(@RequestBody PostDto postDto){
        postService.create(postDto);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable int id){
        postService.delete(id);
    }
