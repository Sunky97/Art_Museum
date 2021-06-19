package com.sunky.gallery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class LikeDTO {

    private Long lno;
    private Long id;
    private Long pno;

}
