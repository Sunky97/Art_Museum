package com.sunky.gallery.service;

import com.sunky.gallery.dto.LikeDTO;
import com.sunky.gallery.entity.Likes;
import com.sunky.gallery.repository.LikeRepository;
import com.sunky.gallery.repository.PaintingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class LikeServiceImpl implements LikeService{

    private LikeRepository likeRepository;
    private PaintingRepository paintingRepository;

    @Override
    @Transactional
    public void addLike(LikeDTO likeDTO) {

//        if(isNotAlreadyLike(likeDTO)){
            Likes likes = dtoToEntity(likeDTO);
            likeRepository.save(likes);
            paintingRepository.upLike(likeDTO.getPno());
//        }else {
//            likeRepository.deleteById(likeDTO.getMid());
//            paintingRepository.downLike(likeDTO.getPno());
//        }


//        return false;

    }

    @Override
    public boolean removeLike(Long lno) {

        return true;
    }

    private boolean isNotAlreadyLike(LikeDTO likeDTO){
        return likeRepository.findByMemberAndPainting(likeDTO.getId(), likeDTO.getPno()).isPresent();
    }


}
