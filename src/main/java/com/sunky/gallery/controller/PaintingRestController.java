package com.sunky.gallery.controller;

import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import com.sunky.gallery.dto.PaintingDTO;
import com.sunky.gallery.service.PaintingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaintingRestController {

    private final PaintingService paintingService;

    @GetMapping("/api/getPosts")
    public ResponseEntity<PageResultDTO> getList(PageRequestDTO pageRequestDTO, Model model){
        PageResultDTO result = paintingService.getList(pageRequestDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
