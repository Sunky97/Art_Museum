package com.sunky.gallery.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"painting","member"})
public class Review extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewnum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Painting painting;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private int grade;

    private String text;

    public void changeGrade(int grade){
        this.grade = grade;
    }

    public void changeText(String text){
        this.text = text;
    }

}
