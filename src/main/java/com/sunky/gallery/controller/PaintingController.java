package com.sunky.gallery.controller;

import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.dto.PaintingDTO;
import com.sunky.gallery.service.PaintingService;
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
@RequestMapping("/painting")
@Log4j2
@RequiredArgsConstructor
public class PaintingController {

    private final PaintingService paintingService;

    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(PaintingDTO paintingDTO, RedirectAttributes redirectAttributes){
        log.info("paintingDTO: " + paintingDTO);

        Long pno = paintingService.register(paintingDTO);

        redirectAttributes.addFlashAttribute("msg", pno);

        return "redirect:/painting/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("pageRequestDTO: " + pageRequestDTO);
        model.addAttribute("result", paintingService.getList(pageRequestDTO));
    }

    @GetMapping({"/read", "/modify"})
    public void read(long pno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("pno: " + pno);
        model.addAttribute("dto", paintingService.getPainting(pno));
    }
}
