package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.ResetPasswordFormDto;
import com.odnzk.study.model.dto.ResetPasswordDto;
import com.odnzk.study.service.AuthService;
import com.odnzk.study.util.EmailManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping(TodoListerEndpoint.RESTORE_PASSWORD)
public class RestorePasswordController {
    private final EmailManager emailManager;
    private final AuthService authService;

    @GetMapping
    void restorePage(@RequestBody ResetPasswordDto formDto) throws IOException {
        emailManager.sendEmail(formDto.username());
    }

    @PostMapping
    public void restorePassword(@RequestBody ResetPasswordFormDto passwordFormDto) {
        authService.resetPassword(passwordFormDto);
    }

}
