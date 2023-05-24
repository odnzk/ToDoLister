package com.odnzk.study.service.impl;

import com.odnzk.study.exception.EntityDoesNotExistException;
import com.odnzk.study.model.Achievement;
import com.odnzk.study.model.dto.UpdateUserFormDto;
import com.odnzk.study.model.entity.UserEntity;
import com.odnzk.study.repository.UserRepository;
import com.odnzk.study.service.AchievementService;
import com.odnzk.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final AchievementService achievementService;

    @Override
    public void update(UpdateUserFormDto userFormDto, Long userId) {
        Optional<UserEntity> optionalUser = repository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new EntityDoesNotExistException("User cannot be updated because he does not exist");
        }
        UserEntity user = optionalUser.get();
        user.setEmail(userFormDto.getEmail());
        user.setUsername(userFormDto.getUsername());
        repository.save(user);
        achievementService.unlockAchievement(Achievement.CHANGE_PROFILE_DATA, user.getId());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
