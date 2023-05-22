package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.UserFormDto;
import com.odnzk.study.service.UserService;
import com.odnzk.study.util.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.PROFILE)
public class UserProfileController {
    UserService service;

    @GetMapping
    public String getPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        model.addAttribute("user", userDetails.getUser());
        return "profile";
    }

    @PatchMapping("/update")
    public String update(UserFormDto userFormDto) {
        service.update(userFormDto);
        return "redirect:" + TodoListerEndpoint.PROFILE;
    }

    @DeleteMapping("delete")
    public String delete(@RequestParam("id") Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        service.deleteById(userDetails.getUser().getId());
        return "redirect:" + TodoListerEndpoint.PROFILE;
    }
}
