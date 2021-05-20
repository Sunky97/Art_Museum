package com.sunky.gallery.service;

import com.sunky.gallery.dto.BoardDTO;
import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import com.sunky.gallery.entity.Board;
import com.sunky.gallery.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    BoardDTO get(Long pno);

    void removeWithReplies(Long pno);

    void modify(BoardDTO boardDTO);

    default Board dtoToEntity(BoardDTO dto){

        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Board board = Board.builder().pno(dto.getPno()).title(dto.getTitle()).content(dto.getContent())
                .writer(member)
                .build();

        return board;
    }

    default BoardDTO entityToDTO(Board board, Member member, Long replyCount){

        BoardDTO boardDTO = BoardDTO.builder()
                .pno(board.getPno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())
                .build();

                return boardDTO;
    }
}
