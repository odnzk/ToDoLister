package com.odnzk.study.controller;

import com.odnzk.study.dto.SignUpFormDto;
import com.odnzk.study.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/signup")
public class SignUpController {
    AuthService service;

    @GetMapping
    public String getPage(Model model) {
        return "signup";
    }

    @PostMapping
    public String signup(SignUpFormDto signUpForm) {
        service.signUp(signUpForm);
        return "redirect:/login";
    }

}
