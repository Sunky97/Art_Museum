package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Art;
import com.sunky.gallery.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    @Test
    @Transactional
    public void testRead(){

        Optional<Art> result = artRepository.findById(100L);

        Art art = result.get();

        System.out.println(art);
        System.out.println(art.getWriter());
    }

    @Test
    public void testReadWithWriter(){

        Object result = artRepository.getArtWithWriter(100L);

        Object[] arr = (Object[]) result;

        System.out.println("-------------------------");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testGetArtWithReply(){

        List<Object[]> result = artRepository.getArtWithReply(40L);

        for(Object[] arr:result){
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void testWithReplyCount(){

        Pageable pageable = PageRequest.of(0,10, Sort.by("pno").descending());

        Page<Object[]> result = artRepository.getArtWithReplyCount(pageable);

        result.get().forEach(row -> {

            Object[] arr = (Object[])row;

            System.out.println(Arrays.toString(arr));
        });
    }

    @Test
    public void 특정_게시물조회(){

        Object result = artRepository.getArtByPno(100L);

        Object[] arr = (Object[]) result;

        System.out.println(Arrays.toString(arr));
    }
}
