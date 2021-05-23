package com.sunky.gallery.service;

import com.sunky.gallery.dto.PaintingDTO;
import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.PaintingImage;
import com.sunky.gallery.repository.PaintingImageRepository;
import com.sunky.gallery.repository.PaintingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class PaintingServiceImpl implements PaintingService{

    private final PaintingRepository paintingRepository;

    private final PaintingImageRepository imageRepository;

    @Transactional
    @Override
    public Long register(PaintingDTO paintingDTO){

        Map<String, Object> entityMap = dtoToEntity(paintingDTO);
        Painting painting = (Painting) entityMap.get("painting");
        List<PaintingImage> paintingImageList = (List<PaintingImage>) entityMap.get("imgList");

        paintingRepository.save(painting);

        paintingImageList.forEach(paintingImage -> {
            imageRepository.save(paintingImage);
        });
        return painting.getPno();
    }


}
