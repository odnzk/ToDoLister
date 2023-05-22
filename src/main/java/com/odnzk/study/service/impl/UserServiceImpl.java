package com.odnzk.study.service.impl;

import com.odnzk.study.exception.EntityDoesNotExistException;
import com.odnzk.study.model.dto.UserFormDto;
import com.odnzk.study.model.entity.UserEntity;
import com.odnzk.study.repository.UserRepository;
import com.odnzk.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public void update(UserFormDto userFormDto) {
        Optional<UserEntity> optionalUser = repository.findById(userFormDto.getId());
        if (optionalUser.isEmpty()) {
            throw new EntityDoesNotExistException("User cannot be updated because he does not exist");
        }
        UserEntity user = optionalUser.get();
        user.setEmail(userFormDto.getEmail());
        user.setHashedPassword(userFormDto.getPassword()); // todo hash password
        user.setUsername(userFormDto.getUsername());
        repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
