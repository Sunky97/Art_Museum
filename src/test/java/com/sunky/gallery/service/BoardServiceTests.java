package com.sunky.gallery.service;

import com.sunky.gallery.dto.BoardDTO;
import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        BoardDTO dto = BoardDTO.builder()
                .title("test101")
                .content("test...")
                .writerEmail("user55@aaa.com")
                .build();

        Long pno = boardService.register(dto);
    }

    @Test
    public void 게시물_목록(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for(BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }
    }

    @Test
    public void 게시물_조회(){

        Long pno = 100L;

        BoardDTO boardDTO = boardService.get(pno);

        System.out.println(boardDTO);
    }

    @Test
    public void 댓글삭제(){
        Long pno = 86L;
        boardService.removeWithReplies(pno);
    }

    @Test
    public void 게시글_수정(){
        BoardDTO boardDTO = BoardDTO.builder().pno(2L).title("수정된 제목").content("수정된 내용").build();

        boardService.modify(boardDTO);
    }
}