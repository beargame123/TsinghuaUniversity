package com.example.tsinghuauniversity;

import com.example.tsinghuauniversity.post.entity.Post;
import com.example.tsinghuauniversity.post.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PostTest {

    @Autowired
    private PostRepository postRepository;


    public Post test(){
        var post = Post.builder()
                .title("저녁 점호를 없애주세요")
                .content("제곧내")
                .category("기숙사")
                .build();
        return post;
    }

    @Test
    public void saveTest(){
        var post = test();
        var expected = postRepository.save(post);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getId());
    }

    @Test
    public void listAllTest(){
        var post1 = test();
        postRepository.save(post1);

        var post2 = test();
        postRepository.save(post2);

        int count = postRepository.findAll().size();

        Assertions.assertEquals(2, count);
    }

}
