package com.example.tsinghuauniversity.post.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate date;

    @Column
    private String category;

    public Post(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = LocalDate.now();
    }
}
