package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
