package com.odnzk.study.service;

import com.odnzk.study.model.entity.AchievementEntity;
import com.odnzk.study.model.entity.UserEntity;

import java.util.List;

public interface UserAchievementService {
    void unlock(UserEntity user, AchievementEntity achievement);

    List<AchievementEntity> getAllAchievements();
}
