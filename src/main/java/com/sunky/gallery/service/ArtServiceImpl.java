package com.sunky.gallery.service;

import com.sunky.gallery.dto.ArtDTO;
import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import com.sunky.gallery.entity.Art;
import com.sunky.gallery.entity.Member;
import com.sunky.gallery.repository.ArtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class ArtServiceImpl implements ArtService{

    private final ArtRepository repository;

    @Override
    public Long register(ArtDTO dto){

        log.info(dto);

        Art art = dtoToEntity(dto);

        repository.save(art);

        return art.getPno();
    }

    @Override
    public PageResultDTO<ArtDTO, Object[]> getList(PageRequestDTO pageRequestDTO){

        log.info(pageRequestDTO);

        Function<Object[], ArtDTO> fn = (en -> entityToDTO((Art) en[0], (Member) en[1],(Long) en[2]));

        Page<Object[]> result = repository.getArtWithReplyCount(pageRequestDTO.getPageable(Sort.by("pno").descending()));

        return new PageResultDTO<>(result, fn);
    }
}
