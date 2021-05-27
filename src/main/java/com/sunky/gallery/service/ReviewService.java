package com.sunky.gallery.service;

import com.sunky.gallery.dto.ReviewDTO;
import com.sunky.gallery.entity.Member;
import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.Review;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> getListOfPainting(Long pno);

    Long register(ReviewDTO pReviewDTO);

    void modify(ReviewDTO pReviewDTO);

    void remove(Long reviewnum);

    default Review dtoToEntity(ReviewDTO pReviewDTO){

        Review pReview = Review.builder()
                .reviewnum(pReviewDTO.getReviewnum())
                .painting(Painting.builder().pno(pReviewDTO.getPno()).build())
                .member(Member.builder().name(pReviewDTO.getName()).build())
                .grade(pReviewDTO.getGrade())
                .text(pReviewDTO.getText())
                .build();

        return pReview;
    }

    default ReviewDTO entityTODto(Review pReview){

        ReviewDTO pReviewDTO = ReviewDTO.builder()
                .reviewnum(pReview.getReviewnum())
                .pno(pReview.getPainting().getPno())
                .id(pReview.getMember().getId())
                .name(pReview.getMember().getName())
                .grade(pReview.getGrade())
                .text(pReview.getText())
                .regDate(pReview.getRegDate())
                .modDate(pReview.getModDate())
                .build();

        return pReviewDTO;
    }
}
