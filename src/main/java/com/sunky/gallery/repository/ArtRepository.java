package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Art;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtRepository extends JpaRepository<Art, Long> {

    @Query("select a, w from Art a left join a.writer w where a.pno =:pno")
    Object getArtWithWriter(@Param("pno") Long pno);

    @Query("select a, r from Art a left join Reply r ON r.art = a where a.pno = :pno")
    List<Object[]> getArtWithReply(@Param("pno") Long pno);

    @Query(value = "SELECT a, w, count(r) " +
            " FROM Art a " +
            " LEFT JOIN a.writer w " +
            " LEFT JOIN Reply r ON r.art = a " +
            " GROUP BY a", countQuery = "SELECT count(a) FROM Art a")
    Page<Object[]> getArtWithReplyCount(Pageable pageable);

    @Query("SELECT a, w, count(r) " +
            " FROM Art a LEFt JOIN a.writer w" +
            " LEFT OUTER JOIN Reply r ON r.art = a" +
            " WHERE a.pno = :pno")
    Object getArtByPno(@Param("pno") Long pno);

}
