package com.sunky.gallery.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@ToString
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Painting painting;

    @Builder
    public Likes(Long lno,Member member, Painting painting) {
        this.lno = lno;
        this.member = member;
        this.painting = painting;
    }
}
