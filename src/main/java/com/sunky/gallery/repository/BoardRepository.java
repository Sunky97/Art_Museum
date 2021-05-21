package com.sunky.gallery.repository;

import com.sunky.gallery.entity.Board;
import com.sunky.gallery.repository.search.SearchBoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository {

    @Query("select b, w from Board b left join b.writer w where b.pno =:pno")
    Object getBoardWithWriter(@Param("pno") Long pno);

    @Query("select b, r from Board b left join Reply r ON r.board = b where b.pno = :pno")
    List<Object[]> getBoardWithReply(@Param("pno") Long pno);

    @Query(value = "SELECT b, w, count(r) " +
            " FROM Board b " +
            " LEFT JOIN b.writer w " +
            " LEFT JOIN Reply r ON r.board = b " +
            " GROUP BY b", countQuery = "SELECT count(b) FROM Board b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);

    @Query("SELECT b, w, count(r) " +
            " FROM Board b LEFt JOIN b.writer w" +
            " LEFT OUTER JOIN Reply r ON r.board = b" +
            " WHERE b.pno = :pno")
    Object getBoardByPno(@Param("pno") Long pno);

}
