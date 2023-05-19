package com.odnzk.study.service;

import com.odnzk.study.dto.LoginFormDto;
import com.odnzk.study.dto.SignUpFormDto;

public interface AuthService {
    void login(LoginFormDto loginFormDto);

    void signUp(SignUpFormDto signUpFormDto);
}
