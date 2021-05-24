package com.sunky.gallery.controller;

import com.sunky.gallery.dto.ReviewDTO;
import com.sunky.gallery.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/reviews")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{pno}/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("pno") Long pno){
        log.info("pno: " + pno);
        List<ReviewDTO> reviewDTOList = reviewService.getListOfPainting(pno);
        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }

    @PostMapping("/{pno}")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO pReviewDTO) {
        log.info("reviewDTO: " + pReviewDTO);

        Long reviewnum = reviewService.register(pReviewDTO);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }

    @PutMapping("/{pno}/{reviewnum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long reviewnum, @RequestBody ReviewDTO pReviewDTO){
        log.info("review: " + pReviewDTO);
        reviewService.modify(pReviewDTO);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }

    @DeleteMapping("/{pno}/{reviewnum}")
    public ResponseEntity<Long> removeReview(@PathVariable Long reviewnum){
        log.info("----------modify removeReview-----------");
        reviewService.remove(reviewnum);
        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }
}
