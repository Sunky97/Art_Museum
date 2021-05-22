package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Member;
import com.sunky.gallery.entity.Painting;
import com.sunky.gallery.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByPainting(Painting painting);

    @Modifying
    @Query("DELETE FROM Review mr WHERE mr.member = :member")
    void deleteByMember(Member member);
}
