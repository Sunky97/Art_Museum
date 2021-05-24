package com.sunky.gallery.service;

import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import com.sunky.gallery.dto.PaintingDTO;
import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.PaintingImage;
import com.sunky.gallery.repository.PaintingImageRepository;
import com.sunky.gallery.repository.PaintingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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

    @Override
    public PageResultDTO<PaintingDTO, Object[]> getList(PageRequestDTO requestDTO){

        Pageable pageable = requestDTO.getPageable(Sort.by("pno").descending());

        Page<Object[]> result = paintingRepository.getListPage(pageable);

        Function<Object[], PaintingDTO> fn = (arr -> entitiesToDTO(
                (Painting) arr[0],
                (List<PaintingImage>) (Arrays.asList((PaintingImage)arr[1])),
                (Double) arr[2],
                (Long) arr[3])
        );
        return new PageResultDTO<>(result,fn);
    }

}
