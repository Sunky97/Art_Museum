package com.sunky.gallery.service;

import com.sunky.gallery.dto.LikeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class LikeServiceImpl implements LikeService{

    @Override
    public Long register(LikeDTO likeDTO) {
        return null;
    }

    @Override
    public void remove(Long lno) {

    }
}
