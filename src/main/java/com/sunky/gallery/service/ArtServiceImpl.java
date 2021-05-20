package com.sunky.gallery.service;

import com.sunky.gallery.dto.ArtDTO;
import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import com.sunky.gallery.entity.Art;
import com.sunky.gallery.entity.Member;
import com.sunky.gallery.repository.ArtRepository;
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
public class ArtServiceImpl implements ArtService{

    private final ArtRepository repository;

    private final ReplyRepository replyRepository;

    @Override
    public Long register(ArtDTO dto){

        log.info(dto);

        Art art = dtoToEntity(dto);

        repository.save(art);

        return art.getPno();
    }

    @Override
    public PageResultDTO<ArtDTO, Object[]> getList(PageRequestDTO pageRequestDTO){

        log.info(pageRequestDTO);

        Function<Object[], ArtDTO> fn = (en -> entityToDTO((Art) en[0], (Member) en[1],(Long) en[2]));

        Page<Object[]> result = repository.getArtWithReplyCount(pageRequestDTO.getPageable(Sort.by("pno").descending()));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public ArtDTO get(Long pno) {

        Object result = repository.getArtByPno(pno);

        Object[] arr = (Object[])result;

        return entityToDTO((Art) arr[0], (Member) arr[1],(Long) arr[2]);
    }

    @Override
    @Transactional
    public void removeWithReplies(Long pno){
        replyRepository.deleteByPno(pno);
        repository.deleteById(pno);
    }

    @Transactional
    @Override
    public void modify(ArtDTO artDTO) {
        Art art = repository.getOne(artDTO.getPno());

        art.changeTitle(artDTO.getTitle());
        art.changeContent(artDTO.getContent());

        repository.save(art);
    }
}
