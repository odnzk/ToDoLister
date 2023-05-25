package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.ResetPasswordFormDto;
import com.odnzk.study.service.AuthService;
import com.odnzk.study.util.EmailManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping(TodoListerEndpoint.RESTORE_PASSWORD)
public class RestorePasswordController {
    private final EmailManager emailManager;
    private final AuthService authService;

    @GetMapping
    public String restorePage(@RequestParam("username") String username, Model model) {
        String sentTo = emailManager.sendEmail(username);
        model.addAttribute("email", sentTo);
        return "send_email_success";
    }

    @PostMapping
    public void restorePassword(@RequestBody ResetPasswordFormDto passwordFormDto) {
        authService.resetPassword(passwordFormDto);
    }

}
