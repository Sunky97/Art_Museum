package com.sunky.gallery.service;

import com.sunky.gallery.dto.LikeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class LikeServiceTests {

    @Autowired
    private LikeService likeService;

    @Test
    public void 좋아요등록(){
        likeService.addLike(new LikeDTO(22L,1L,10L));
    }
}
