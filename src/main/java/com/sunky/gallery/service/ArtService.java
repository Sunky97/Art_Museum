package com.sunky.gallery.service;

import com.sunky.gallery.dto.ArtDTO;
import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import com.sunky.gallery.entity.Art;
import com.sunky.gallery.entity.Member;

public interface ArtService {

    Long register(ArtDTO dto);

    PageResultDTO<ArtDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    ArtDTO get(Long pno);

    default Art dtoToEntity(ArtDTO dto){

        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Art art = Art.builder().pno(dto.getPno()).title(dto.getTitle()).content(dto.getContent())
                .writer(member)
                .build();

        return art;
    }

    default ArtDTO entityToDTO(Art art,Member member,Long replyCount){

        ArtDTO artDTO = ArtDTO.builder()
                .pno(art.getPno())
                .title(art.getTitle())
                .content(art.getContent())
                .regDate(art.getRegDate())
                .modDate(art.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())
                .build();

                return artDTO;
    }
}
