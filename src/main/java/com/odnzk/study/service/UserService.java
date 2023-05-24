package com.odnzk.study.service;

import com.odnzk.study.model.dto.UpdateUserFormDto;

public interface UserService {
    void update(UpdateUserFormDto userFormDto, Long userId);

    void deleteById(Long id);
}
