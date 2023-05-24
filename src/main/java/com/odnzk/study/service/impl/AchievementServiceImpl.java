package com.odnzk.study.service.impl;

import com.odnzk.study.exception.EntityDoesNotExistException;
import com.odnzk.study.model.Achievement;
import com.odnzk.study.model.entity.AchievementEntity;
import com.odnzk.study.model.entity.UserEntity;
import com.odnzk.study.repository.UserAchievementsRepository;
import com.odnzk.study.repository.UserRepository;
import com.odnzk.study.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class AchievementServiceImpl implements AchievementService {
    private final UserAchievementsRepository achievementRepository;
    private final UserRepository userRepository;

    public void unlockAchievement(Achievement achievement, Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityDoesNotExistException("User with this id does not exist"));
        if (user.getAchievements()
                .stream()
                .map(AchievementEntity::getId)
                .anyMatch(it -> Objects.equals(it, achievement.getId()))) {
            return;
        }
        AchievementEntity achievementEntity = achievementRepository.findById(achievement.getId())
                .orElseThrow(() -> new EntityDoesNotExistException("Achievement with this id does not exist"));
        Set<AchievementEntity> updatedAchievements = user.getAchievements();
        updatedAchievements.add(achievementEntity);
        user.setAchievements(updatedAchievements);
        userRepository.save(user);
    }

    @Override
    public List<AchievementEntity> getAll() {
        return achievementRepository.findAll();
    }
}
