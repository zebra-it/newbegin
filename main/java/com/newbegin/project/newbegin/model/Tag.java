package com.newbegin.project.newbegin.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createDate;
    private Time createTime;

    private String textTag;

    public Tag(String textTag) {
        this.textTag = textTag;
    }
}
