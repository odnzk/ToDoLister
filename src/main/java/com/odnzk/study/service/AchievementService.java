package com.odnzk.study.service;

import com.odnzk.study.model.Achievement;
import com.odnzk.study.model.entity.AchievementEntity;

import java.util.List;

public interface AchievementService {
    void unlockAchievement(Achievement achievement, Long userId);
    List<AchievementEntity> getAll();
}
