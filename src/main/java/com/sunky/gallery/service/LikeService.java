package com.sunky.gallery.service;


import com.sunky.gallery.dto.LikeDTO;
import com.sunky.gallery.entity.Likes;
import com.sunky.gallery.entity.Member;
import com.sunky.gallery.entity.Painting;

public interface LikeService {

    void addLike(LikeDTO likeDTO);

    boolean removeLike(Long lno);

    default Likes dtoToEntity(LikeDTO mLikeDTO){

        Likes likes = Likes.builder()
                .lno(mLikeDTO.getLno())
                .member(Member.builder().id(mLikeDTO.getId()).build())
                .painting(Painting.builder().pno(mLikeDTO.getPno()).build())
                .build();

        return likes;
    }
}
