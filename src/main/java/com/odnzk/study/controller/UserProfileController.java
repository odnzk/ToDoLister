package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.UserFormDto;
import com.odnzk.study.service.UserService;
import com.odnzk.study.util.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String update(UserFormDto userFormDto) {
        service.update(userFormDto);
        return "redirect:" + TodoListerEndpoint.PROFILE;
    }

    @DeleteMapping()
    public String delete(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        service.deleteById(userDetails.getUser().getId());
        return "redirect:" + TodoListerEndpoint.LOGOUT;
    }
}
