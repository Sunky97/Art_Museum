package com.sunky.gallery.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Painting extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String title;

    private String author;

    private int year;

    private String material;

    private String size;

    private String etc;

    @Column(name = "viewCnt")
    @ColumnDefault("0")
    private int viewCnt;

    @Column(name = "likeCnt")
    @ColumnDefault("0")
    private int likeCnt;

}
