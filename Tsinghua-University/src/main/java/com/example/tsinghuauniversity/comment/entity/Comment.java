package com.example.tsinghuauniversity.comment.entity;

import com.example.tsinghuauniversity.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Builder
    public Comment(String comment){
        this.comment = comment;
    }

    public Comment(String comment, Integer id) {
        this.comment = comment;
        this.id = id;
    }
}
