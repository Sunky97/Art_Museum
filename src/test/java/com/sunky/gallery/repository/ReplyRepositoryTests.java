package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Board;
import com.sunky.gallery.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply(){

        IntStream.rangeClosed(1, 300).forEach(i ->{
            long pno = (long)(Math.random()*100)+1;

            Board board = Board.builder().pno(pno).build();

            Reply reply = Reply.builder()
                    .text("Reply.."+i)
                    .board(board)
                    .replyer("guest"+pno)
                    .build();

            replyRepository.save(reply);
        });
    }

    @Test
    public void readReply1(){

        Optional<Reply> result = replyRepository.findById(2L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }
}