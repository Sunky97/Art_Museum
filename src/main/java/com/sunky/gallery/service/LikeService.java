package com.sunky.gallery.service;


import com.sunky.gallery.dto.LikeDTO;

public interface LikeService {

    Long register(LikeDTO likeDTO);

    void remove(Long lno);
}
