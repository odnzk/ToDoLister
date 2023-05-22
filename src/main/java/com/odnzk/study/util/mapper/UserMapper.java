package com.odnzk.study.util.mapper;

import com.odnzk.study.model.UserRole;
import com.odnzk.study.model.UserStatus;
import com.odnzk.study.model.dto.SignUpFormDto;
import com.odnzk.study.model.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

public class UserMapper {
    public static UserEntity from(SignUpFormDto form, PasswordEncoder passwordEncoder) {
        return UserEntity.builder()
                .hashedPassword(passwordEncoder.encode(form.password()))
                .username(form.username())
                .email(form.email())
                .achievements(Collections.emptyList())
                .role(UserRole.USER)
                .status(UserStatus.ACTIVE)
                .build();
    }
}
