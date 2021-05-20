package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Art;
import com.sunky.gallery.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ArtRepositoryTests {

    @Autowired
    private ArtRepository artRepository;

    @Test
    public void insertArt(){

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder().email("user"+i+"@aaa.com").build();

            Art art = Art.builder()
                    .title("Title..."+i)
                    .content("content"+i)
                    .writer(member)
                    .build();

            artRepository.save(art);
        });
    }
}
