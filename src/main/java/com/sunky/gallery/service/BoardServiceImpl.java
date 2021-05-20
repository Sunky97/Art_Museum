package com.sunky.gallery.service;

import com.sunky.gallery.dto.BoardDTO;
import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import com.sunky.gallery.entity.Board;
import com.sunky.gallery.entity.Member;
import com.sunky.gallery.repository.BoardRepository;
import com.sunky.gallery.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    private final ReplyRepository replyRepository;

    @Override
    public Long register(BoardDTO dto){

        log.info(dto);

        Board Board = dtoToEntity(dto);

        repository.save(Board);

        return Board.getPno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO){

        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board) en[0], (Member) en[1],(Long) en[2]));

        Page<Object[]> result = repository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("pno").descending()));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO get(Long pno) {

        Object result = repository.getBoardByPno(pno);

        Object[] arr = (Object[])result;

        return entityToDTO((Board) arr[0], (Member) arr[1],(Long) arr[2]);
    }

    @Override
    @Transactional
    public void removeWithReplies(Long pno){
        replyRepository.deleteByPno(pno);
        repository.deleteById(pno);
    }

    @Transactional
    @Override
    public void modify(BoardDTO boardDTO) {
        Board Board = repository.getOne(boardDTO.getPno());

        Board.changeTitle(boardDTO.getTitle());
        Board.changeContent(boardDTO.getContent());

        repository.save(Board);
    }
}
