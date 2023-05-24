package com.odnzk.study.util.mapper;

import com.odnzk.study.model.dto.AchievementDto;
import com.odnzk.study.model.entity.AchievementEntity;

public class AchievementMapper {
    public static AchievementDto from(AchievementEntity entity, Boolean isUnlocked) {
        return new AchievementDto(entity.getTitle(), isUnlocked, entity.getCategory());
    }
}
