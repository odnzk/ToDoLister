package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.UpdateUserFormDto;
import com.odnzk.study.service.UserService;
import com.odnzk.study.util.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.PROFILE)
public class UserProfileController {
    private final UserService service;

    @GetMapping
    public String getPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        model.addAttribute("user", userDetails.getUser());
        return "profile";
    }

    @PostMapping()
    public String update(@AuthenticationPrincipal UserDetailsImpl userDetails, UpdateUserFormDto userFormDto) {
        service.update(userFormDto, userDetails.getUser().getId());
        return "redirect:" + TodoListerEndpoint.PROFILE;
    }
}
