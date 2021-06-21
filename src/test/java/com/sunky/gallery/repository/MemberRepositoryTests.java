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

    @Commit
    @Transactional
    @Test
    public void 회원_삭제(){

        Long id = 2L;

        Member member = Member.builder().build();

        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(id);
    }
}
