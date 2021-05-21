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

    @GetMapping({"/read", "/modify"})
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long pno, Model model) {

        log.info("pno: " + pno);

        BoardDTO boardDTO = boardService.get(pno);

        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/remove")
    public String remove(long pno, RedirectAttributes redirectAttributes){

        log.info("pno:"+pno);

        boardService.removeWithReplies(pno);

        redirectAttributes.addFlashAttribute("msg", pno);

        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes){

        log.info("post modify.........");

        boardService.modify(dto);

        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("type", requestDTO.getType());
        redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());

        redirectAttributes.addAttribute("pno", dto.getPno());

        return "redirect:/board/read";
    }

}
