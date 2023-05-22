package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.UserFormDto;
import com.odnzk.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.PROFILE)
public class UserProfileController {
    UserService service;

    @GetMapping
    public String getPage(Model model) {
//        User user = service.getCurrentUser();
//        model.addAttribute("user", user);
        return "profile";
    }

    @PatchMapping("/update")
    public String update(UserFormDto userFormDto) {
        service.update(userFormDto);
        return "redirect:" + TodoListerEndpoint.PROFILE;
    }

    // todo map to  /delete?id=${project.id}
    @DeleteMapping("delete")
    public String delete(@RequestParam("id") Long id) {
//         todo get userId
        service.deleteById(0l);
        return "redirect:" + TodoListerEndpoint.PROFILE;
    }
}
