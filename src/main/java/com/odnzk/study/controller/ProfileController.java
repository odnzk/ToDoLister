package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.dto.UserFormDto;
import com.odnzk.study.model.User;
import com.odnzk.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/" + TodoListerEndpoint.PROFILE)
public class ProfileController {
    UserService service;

    @GetMapping
    public String getPage(Model model) {
        User user = service.getCurrentUser();
        model.addAttribute("user", user);
        return TodoListerEndpoint.PROFILE;
    }

    @PatchMapping("/update")
    public String update(UserFormDto userFormDto) {
        service.update(userFormDto);
        return "redirect:/" + TodoListerEndpoint.PROFILE;
    }

    // todo map to  /delete?id=${project.id}
    @DeleteMapping("delete")
    public String delete(@RequestParam("id") Integer id) {
//         todo get userId
        service.deleteById(0);
        return "redirect:/" + TodoListerEndpoint.PROFILE;
    }
}
