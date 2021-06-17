package com.sunky.gallery.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class LikeRepositoryTests {

    @Autowired
    private LikeRepository likeRepository;

    @Commit
    @Transactional
    @Test
    public void 등록() {



        likeRepository.save();
    }
}
