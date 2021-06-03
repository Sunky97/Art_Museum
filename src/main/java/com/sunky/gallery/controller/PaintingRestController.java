package com.sunky.gallery.controller;

import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PageResultDTO;
import com.sunky.gallery.dto.PaintingDTO;
import com.sunky.gallery.service.PaintingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PaintingRestController {

    private final PaintingService paintingService;

    @PostMapping("/api/getPosts")
    public @ResponseBody PageResultDTO<PaintingDTO, Object[]> getList(@RequestBody Map<String, Object> param){

        PageRequestDTO requestDTO = new PageRequestDTO();
        requestDTO.setPage((int)param.get("page"));
        return paintingService.getList(requestDTO);
    }
}
