package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository <Reply, Long>{

    @Modifying
    @Query("delete from Reply r where r.art.pno =:pno")
    void deleteByPno(Long pno);

}
