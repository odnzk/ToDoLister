package com.odnzk.study.service;

import com.odnzk.study.model.dto.UserFormDto;
import com.odnzk.study.model.entity.UserEntity;

public interface UserService {
    void update(UserFormDto userFormDto);

    void deleteById(Long id);
}
