package com.sunky.gallery.service;

import com.sunky.gallery.dto.ArtDTO;
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
}
