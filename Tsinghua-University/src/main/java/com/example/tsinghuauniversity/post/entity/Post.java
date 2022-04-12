package com.example.tsinghuauniversity.post.entity;

import com.example.tsinghuauniversity.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime dateTime;

    @Column
    private String category;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    public Post(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.dateTime = LocalDateTime.now();
    }
}
