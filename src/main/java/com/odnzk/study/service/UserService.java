package com.odnzk.study.service;

import com.odnzk.study.dto.UserFormDto;
import com.odnzk.study.model.User;

public interface UserService {
    void update(UserFormDto userFormDto);
    void deleteById(Integer id);
    User getCurrentUser();
}
