package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.LOGIN)
public class LoginController {
//    AuthService service;

    @GetMapping
    public String getPage(Model model) {
        return "login";
    }

//    @PostMapping
//    public String login(LoginFormDto loginForm) {
//        service.login(loginForm);
//        return "redirect:/projects";
//    }

}
