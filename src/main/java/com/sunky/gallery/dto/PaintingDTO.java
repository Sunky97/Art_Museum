package com.sunky.gallery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaintingDTO {

    private Long pno;
    private String title;
    private String author;
    private int year;
    private String material;
    private String size;
    private String etc;

    @Builder.Default
    private List<PaintingImageDTO> imageDTOList = new ArrayList<>();

    private double avg;

    private int reviewCnt;

    private LocalDateTime regDate;

    private LocalDateTime modDate;
}
