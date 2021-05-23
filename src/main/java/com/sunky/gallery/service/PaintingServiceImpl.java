package com.sunky.gallery.service;

import com.sunky.gallery.dto.PaintingDTO;
import com.sunky.gallery.repository.PaintingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PaintingServiceImpl implements PaintingService{

    private final PaintingRepository paintingRepository;

    @Override
    public Long register(PaintingDTO paintingDTO){
        return null;
    }
}
