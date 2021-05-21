package com.sunky.gallery.repository.search;

import com.sunky.gallery.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchBoardRepository{

    Board search1();

    Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
