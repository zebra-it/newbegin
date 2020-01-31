package com.newbegin.project.newbegin.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "text_tag")
    private String textTag;



    public Tag(String textTag) {
        this.textTag = textTag;

    }
}
