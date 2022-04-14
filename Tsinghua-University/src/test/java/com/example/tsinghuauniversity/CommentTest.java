package com.example.tsinghuauniversity;

import com.example.tsinghuauniversity.comment.entity.Comment;
import com.example.tsinghuauniversity.comment.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentRepository commentRepository;

    public Comment create(){
        Comment comment = Comment.builder()
                .comment("동의합니다")
                .build();
        return comment;
    }

    @Test
    public void saveTest(){
        var comment = create();
        var expected = commentRepository.save(comment);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getId());
    }

    @Test
    public void commentList(){
        Comment comment1 = create();
        commentRepository.save(comment1);

        Comment comment2 = create();
        commentRepository.save(comment2);

        int count = commentRepository.findAll().size();
        Assertions.assertEquals(2, count);

    }
}
