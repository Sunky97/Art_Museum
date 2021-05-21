package com.sunky.gallery.repository.search;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import com.sunky.gallery.entity.Board;
import com.sunky.gallery.entity.QBoard;
import com.sunky.gallery.entity.QMember;
import com.sunky.gallery.entity.QReply;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository {

    public SearchBoardRepositoryImpl(){
        super(Board.class);
    }

    @Override
    public Board search1(){

        QBoard board = QBoard.board;
        QReply reply = QReply.reply;
        QMember member = QMember.member;

        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(reply).on(reply.board.eq(board));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(board, member.email, reply.count());
        tuple.groupBy(board);

        log.info("-------------");
        log.info(jpqlQuery);
        log.info("-------------");

        List<Tuple> result = tuple.fetch();

        return null;
    }

    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable){
        return null;
    }
}
