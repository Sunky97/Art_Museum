package com.sunky.gallery.service;

import com.sunky.gallery.dto.ArtDTO;
import com.sunky.gallery.entity.Art;
import com.sunky.gallery.entity.Member;

public interface ArtService {

    Long register(ArtDTO dto);

    default Art dtoToEntity(ArtDTO dto){

        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Art art = Art.builder().pno(dto.getPno()).title(dto.getTitle()).content(dto.getContent())
                .writer(member)
                .build();

        return art;
    }
}
