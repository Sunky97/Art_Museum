package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Member;
import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void 리뷰_등록(){

        IntStream.rangeClosed(1,200).forEach(i -> {

            Long pno = (long)(Math.random()*100) + 1;

            Long id = (long)(Math.random()*100) + 1;
            Member member = Member.builder().id(id).build();

            Review movieReview = Review.builder()
                    .member(member)
                    .painting(Painting.builder().pno(pno).build())
                    .grade((int)(Math.random()*5)+1)
                    .text("이 작품에 내한 제 느낌은요 ..."+i)
                    .build();

            reviewRepository.save(movieReview);
        });
    }

    @Test
    public void 그림의_모든리뷰_불러오기(){

        Painting painting = Painting.builder().pno(23L).build();

        List<Review> result = reviewRepository.findByPainting(painting);

        result.forEach(paintingReview -> {

            System.out.println("-------------------------------------");
            System.out.println(paintingReview.getReviewnum());
            System.out.println(paintingReview.getGrade());
            System.out.println(paintingReview.getText());
            System.out.println(paintingReview.getMember().getEmail());
            System.out.println("-------------------------------------");
        });
    }

}
