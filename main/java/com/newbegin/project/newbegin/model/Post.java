package com.newbegin.project.newbegin.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Напишите 'Привет!', для начала...")
    @Length(max = 256, message = "Слишком длинное сообщение, может разбить на два?")
    private String text;


    private String tags;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    private String createDate;
    private String createTime;

    public Post(String text, String tags, User user) {
        this.author = user;
        this.text = text;
        this.tags = tags;
    }
}
