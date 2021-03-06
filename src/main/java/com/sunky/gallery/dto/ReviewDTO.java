package com.sunky.gallery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    //review num
    private Long reviewnum;

    //painting num
    private Long pno;

    //member id
    private Long id;
    //member name
    private String name;

    private String email;

    private int grade;
    private String text;
    private LocalDateTime regDate, modDate;

}
