package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.ResetPasswordFormDto;
import com.odnzk.study.service.AuthService;
import com.odnzk.study.util.EmailManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Log4j2
@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping(TodoListerEndpoint.RESTORE_PASSWORD)
public class RestorePasswordController {
    private final EmailManager emailManager;
    private final AuthService authService;

    @GetMapping
    void restorePage(@RequestParam String username) throws IOException {
        emailManager.sendEmail(username);
    }

    @PostMapping
    public void restorePassword(@RequestBody ResetPasswordFormDto passwordFormDto) {
        authService.resetPassword(passwordFormDto);
    }

}
