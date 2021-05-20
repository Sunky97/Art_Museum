package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Art;
import com.sunky.gallery.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply(){

        IntStream.rangeClosed(1, 300).forEach(i ->{
            long pno = (long)(Math.random()*100)+1;

            Art art = Art.builder().pno(pno).build();

            Reply reply = Reply.builder()
                    .text("Reply.."+i)
                    .art(art)
                    .replyer("guest"+pno)
                    .build();

            replyRepository.save(reply);
        });
    }
}
