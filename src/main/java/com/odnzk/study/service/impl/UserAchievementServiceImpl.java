package com.odnzk.study.service.impl;

import com.odnzk.study.model.entity.AchievementEntity;
import com.odnzk.study.model.entity.UserEntity;
import com.odnzk.study.repository.UserAchievementsRepository;
import com.odnzk.study.repository.UserRepository;
import com.odnzk.study.service.UserAchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserAchievementServiceImpl implements UserAchievementService {

    private final UserAchievementsRepository repository;
    private final UserRepository userRepository;

    @Override
    public void unlock(UserEntity user, AchievementEntity achievement) {
        // todo insert to user?
        List<AchievementEntity> updatedAchievements = user.getAchievements();
        updatedAchievements.add(achievement);
        user.setAchievements(updatedAchievements);
        userRepository.save(user);
    }


    @Override
    public List<AchievementEntity> getAllAchievements() {
        return repository.findAll();
    }
}
