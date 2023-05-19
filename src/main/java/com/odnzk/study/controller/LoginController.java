package com.odnzk.study.controller;

import com.odnzk.study.dto.LoginFormDto;
import com.odnzk.study.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {
    AuthService service;

    @GetMapping
    public String getPage(Model model) {
        return "login";
    }

    @PostMapping
    public String login(LoginFormDto loginForm) {
        service.login(loginForm);
        return "redirect:/projects";
    }

}
