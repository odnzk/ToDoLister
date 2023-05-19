package com.odnzk.study.service;

import com.odnzk.study.model.Achievement;

import java.util.List;

public interface UserAchievementService {
    void unlock(Integer userId, Integer achievementId);

    List<Achievement> getUserAchievements(Integer userId);

    List<Achievement> getAllAchievements();
}
