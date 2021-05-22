package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Member;
import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void 리뷰_등록(){

        IntStream.rangeClosed(1,200).forEach(i -> {

            Long pno = (long)(Math.random()*100) + 1;

            Long mid = (long)(Math.random()*100) + 1;
            Member member = Member.builder().mid(mid).build();

            Review movieReview = Review.builder()
                    .member(member)
                    .painting(Painting.builder().pno(pno).build())
                    .grade((int)(Math.random()*5)+1)
                    .text("이 작품에 내한 제 느낌은요 ..."+i)
                    .build();

            reviewRepository.save(movieReview);
        });
    }
}
