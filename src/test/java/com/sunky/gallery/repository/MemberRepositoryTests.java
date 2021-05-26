package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ReviewRepository reviewRepository;

//    @Test
//    public void 회원_등록(){
//
//        IntStream.rangeClosed(1,100).forEach(i -> {
//            Member member = Member.builder().email("r"+i+"@naver.com").password("1111").nickname("reviewer"+i).build();
//            memberRepository.save(member);
//        });
//    }

    @Commit
    @Transactional
    @Test
    public void 회원_삭제(){

        Long id = 2L;

        Member member = Member.builder()..build();

        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(id);
    }
}
