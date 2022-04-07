package com.example.tsinghuauniversity.post.service;

import com.example.tsinghuauniversity.post.dto.PostDto;
import com.example.tsinghuauniversity.post.dto.PostList;
import com.example.tsinghuauniversity.post.entity.Post;
import com.example.tsinghuauniversity.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void create(PostDto postDto){
        Post post = new Post(postDto.getTitle(), postDto.getContent(), postDto.getCategory());
        postRepository.save(post);
    }

    public void delete(int id){
        Post post = postRepository.findById(id).get();
        postRepository.delete(post);
    }

    public void get(){
        postRepository.findAll();
    }

    public List<PostList> postList(){
        Sort sort = Sort.by(Sort.Direction.ASC, "date");
        List<Post> posts = postRepository.findAll(sort);
        List<PostList> latestListDto = new ArrayList<>();

        for(Post post : posts){
            PostList dto = PostList.builder()
                    .title(post.getTitle())
                    .category(post.getCategory())
                    .content(post.getContent())
                    .date(post.getDate())
                    .id(post.getId())
                    .build();
            latestListDto.add(dto);
        }
        return latestListDto;
    }

}
