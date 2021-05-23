package com.sunky.gallery.service;

import com.sunky.gallery.dto.PaintingDTO;
import com.sunky.gallery.dto.PaintingImageDTO;
import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.PaintingImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface PaintingService {
    Long register(PaintingDTO paintingDTO);

    default Map<String ,Object> dtoToEntity(PaintingDTO paintingDTO){

        Map<String ,Object> entityMap = new HashMap<>();

        Painting painting = Painting.builder()
                .pno(paintingDTO.getPno())
                .title(paintingDTO.getTitle())
                .build();

        entityMap.put("painting", painting);

        List<PaintingImageDTO> imageDTOList = paintingDTO.getImageDTOList();

        if(imageDTOList != null && imageDTOList.size() > 0){
            List<PaintingImage> paintingImageList = imageDTOList.stream().map(paintingImageDTO -> {

                PaintingImage paintingImage = PaintingImage.builder()
                        .path(paintingImageDTO.getPath())
                        .imgName(paintingImageDTO.getImgName())
                        .uuid(paintingImageDTO.getUuid())
                        .painting(painting)
                        .build();
                return paintingImage;
            }).collect(Collectors.toList());

            entityMap.put("imgList", paintingImageList);
        }
        return entityMap;
    }
}
