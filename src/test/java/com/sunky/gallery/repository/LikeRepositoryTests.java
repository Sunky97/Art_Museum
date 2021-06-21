package com.sunky.gallery.repository;

import com.sunky.gallery.dto.LikeDTO;
import com.sunky.gallery.entity.Likes;
import com.sunky.gallery.entity.Member;
import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.service.LikeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class LikeRepositoryTests {

    @Autowired
    private LikeRepository likeRepository;

    @Test
    public void likes_register(){

        Likes likes = Likes.builder()
                .member(Member.builder().id(1L).build())
                .painting(Painting.builder().pno(8L).build())
                .build();

        likeRepository.save(likes);
    }
}
