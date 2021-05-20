package com.sunky.gallery.controller;

import com.sunky.gallery.dto.BoardDTO;
import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {

        log.info("-------------pagerequest" + pageRequestDTO);
        log.info("-------------" + boardService.getList(pageRequestDTO));

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register() {
        log.info("register get...");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
        log.info("dto..." + dto);
        Long pno = boardService.register(dto);
        redirectAttributes.addFlashAttribute("msg", pno);

        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long pno, Model model) {

        log.info("pno: " + pno);

        BoardDTO boardDTO = boardService.get(pno);

        model.addAttribute("dto", boardDTO);
    }

}
