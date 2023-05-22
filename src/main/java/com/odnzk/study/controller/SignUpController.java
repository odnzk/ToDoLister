package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.SignUpFormDto;
import com.odnzk.study.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.SIGNUP)
public class SignUpController {
    private final AuthService service;

    @GetMapping
    public String getPage(Model model) {
        return "signup";
    }

    @PostMapping
    public String signup(SignUpFormDto signUpForm) {
        service.signUp(signUpForm);
        return "redirect:" + TodoListerEndpoint.LOGIN;
    }

}
