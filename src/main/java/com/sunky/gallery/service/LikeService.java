package com.sunky.gallery.service;


import com.sunky.gallery.dto.LikeDTO;
import com.sunky.gallery.entity.Likes;
import com.sunky.gallery.entity.Member;
import com.sunky.gallery.entity.Painting;

public interface LikeService {

    boolean addLike(LikeDTO likeDTO);

    boolean removeLike(Long lno);

    default Likes dtoToEntity(LikeDTO mLikeDTO){

        Likes likes = Likes.builder()
                .member(Member.builder().id(mLikeDTO.getMid()))
                .painting(Painting.builder().pno(mLikeDTO.getPno()))
                .build();

        return likes;
    }
}
