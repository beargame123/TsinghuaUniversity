package com.example.tsinghuauniversity.comment.service;

import com.example.tsinghuauniversity.comment.dto.CommentDto;
import com.example.tsinghuauniversity.comment.entity.Comment;
import com.example.tsinghuauniversity.comment.dto.CommentList;
import com.example.tsinghuauniversity.comment.repository.CommentRepository;
import com.example.tsinghuauniversity.post.entity.Post;
import com.example.tsinghuauniversity.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public void create(int id,CommentDto commentDto){
        Post post = postRepository.findById(id).get();
        Comment comment = new Comment(commentDto.getComment(), post.getId());
        commentRepository.save(comment);
    }

    public List<CommentList> commentList(@PathVariable int id){
        Post post = postRepository.findById(id).get();
        List<Comment> comments = commentRepository.findAll();
        List<CommentList> commentLists = new ArrayList<>();

        for(Comment comment: comments){
            if(post.getId().equals(id)){

                CommentList commentList = CommentList.builder()
                        .comment(comment.getComment())
                        .build();
                commentLists.add(commentList);
            }
        }
        return commentLists;
    }
}
