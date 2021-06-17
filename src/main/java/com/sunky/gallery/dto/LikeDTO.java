package com.sunky.gallery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class LikeDTO {

    private Long mid;
    private Long pno;

}
