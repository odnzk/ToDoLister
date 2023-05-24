package com.odnzk.study.service;

import com.odnzk.study.model.dto.ResetPasswordFormDto;
import com.odnzk.study.model.dto.SignUpFormDto;

public interface AuthService {
    void signUp(SignUpFormDto signUpFormDto);

    void resetPassword(ResetPasswordFormDto passwordFormDto);
}
