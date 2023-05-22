package com.odnzk.study.service.impl;

import com.odnzk.study.exception.AlreadyExistsException;
import com.odnzk.study.model.dto.SignUpFormDto;
import com.odnzk.study.model.entity.UserEntity;
import com.odnzk.study.repository.UserRepository;
import com.odnzk.study.service.AuthService;
import com.odnzk.study.service.ProjectService;
import com.odnzk.study.util.mapper.ProjectMapper;
import com.odnzk.study.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpFormDto signUpFormDto) {
        Optional<UserEntity> optional = repository.findByUsername(signUpFormDto.getUsername());
        if (optional.isPresent()) throw new AlreadyExistsException("User with this username already exists");
        UserEntity user = UserMapper.from(signUpFormDto, passwordEncoder);
        repository.save(user);
    }
}
