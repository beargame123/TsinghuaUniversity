package com.example.tsinghuauniversity.comment.service;

import com.example.tsinghuauniversity.comment.dto.CommentDto;
import com.example.tsinghuauniversity.comment.entity.Comment;
import com.example.tsinghuauniversity.comment.dto.CommentList;
import com.example.tsinghuauniversity.comment.repository.CommentRepository;
import com.example.tsinghuauniversity.post.entity.Post;
import com.example.tsinghuauniversity.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public void create(Integer id,CommentDto commentDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not find"));
        Comment comment = Comment.builder()
                .comment(commentDto.getComment())
                .post(post)
                .build();
        commentRepository.save(comment);
    }

    @Transactional
    public List<CommentList> commentList(Integer id){
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found"));
        List<Comment> comments = commentRepository.findAll();
        List<CommentList> commentLists = new ArrayList<>();

        for(Comment comment: comments){
            if(comment.getPost().getId() == post.getId()){

                CommentList commentList = CommentList.builder()
                        .id(comment.getId())
                        .comment(comment.getComment())
                        .build();
                commentLists.add(commentList);
            }
        }
        return commentLists;
    }
}
