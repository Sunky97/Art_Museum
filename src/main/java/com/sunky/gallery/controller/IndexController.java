package com.sunky.gallery.controller;

import com.sunky.gallery.config.auth.LoginUser;
import com.sunky.gallery.config.auth.dto.SessionUser;
import com.sunky.gallery.dto.PageRequestDTO;
import com.sunky.gallery.service.PaintingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PaintingService paintingService;
    private HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, PageRequestDTO pageRequestDTO){
        model.addAttribute("result", paintingService.getList(pageRequestDTO));

        return "/painting/list";
    }
}
