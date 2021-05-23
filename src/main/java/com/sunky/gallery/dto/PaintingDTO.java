package com.sunky.gallery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaintingDTO {

    private Long pno;
    private String title;

    @Builder.Default
    private List<PaintingImageDTO> imageDTOList = new ArrayList<>();
}
