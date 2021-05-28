package com.sunky.gallery.service;

import com.sunky.gallery.dto.ReviewDTO;
import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.Review;
import com.sunky.gallery.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> getListOfPainting(Long pno){

        Painting painting = Painting.builder().pno(pno).build();

        List<Review> result = reviewRepository.findByPainting(painting);

        return result.stream().map(paintingReview -> entityToDto(paintingReview)).collect(Collectors.toList());
    }

    @Override
    public Long register(ReviewDTO pReviewDTO) {

        Review pReview = dtoToEntity(pReviewDTO);

        reviewRepository.save(pReview);

        return pReview.getReviewnum();
    }

    @Override
    public void modify(ReviewDTO pReviewDTO) {

        Optional<Review> result = reviewRepository.findById(pReviewDTO.getReviewnum());

        if(result.isPresent()){
            Review pReview = result.get();
            pReview.changeGrade(pReviewDTO.getGrade());
            pReview.changeText(pReviewDTO.getText());

            reviewRepository.save(pReview);
        }
    }

    @Override
    public void remove(Long reviewnum) {
        reviewRepository.deleteById(reviewnum);
    }
}
