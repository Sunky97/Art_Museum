package com.sunky.gallery.service;

import com.sunky.gallery.dto.ArtDTO;
import com.sunky.gallery.entity.Art;
import com.sunky.gallery.repository.ArtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
