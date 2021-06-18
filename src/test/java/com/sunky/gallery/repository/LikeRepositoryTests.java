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
    @Autowired
    private LikeService likeService;

    @Commit
    @Transactional
    @Test
    public void 좋아요_등록() {

        LikeDTO likeDTO = new LikeDTO(1L,1L);

        System.out.println("likeDTO 값: "+likeDTO);
        likeService.addLike(likeDTO);
    }

    @Test
    public void 좋아요_조회() {
        Long id = 1L;
        Long pno = 1L;
        likeRepository.findByMemberAndPainting(id,pno);
    }

    @Test
    public void likes_register(){
        Likes likes = Likes.builder()
                .member(Member.builder().id(4L).build())
                .painting(Painting.builder().pno(4L).build())
                .build();
        likeRepository.save(likes);
    }
}
