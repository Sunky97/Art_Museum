package com.sunky.gallery.service;

import com.sunky.gallery.dto.ArtDTO;
import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArtServiceTests {

    @Autowired
    private ArtService artService;

    @Test
    public void testRegister(){

        ArtDTO dto = ArtDTO.builder()
                .title("test101")
                .content("test...")
                .writerEmail("user55@aaa.com")
                .build();

        Long pno = artService.register(dto);
    }

    @Test
    public void 게시물_목록(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<ArtDTO, Object[]> result = artService.getList(pageRequestDTO);

        for(ArtDTO artDTO : result.getDtoList()){
            System.out.println(artDTO);
        }
    }

    @Test
    public void 게시물_조회(){

        Long pno = 100L;

        ArtDTO artDTO = artService.get(pno);

        System.out.println(artDTO);
    }
}