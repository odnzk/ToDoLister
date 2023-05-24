package com.odnzk.study.repository;

import com.odnzk.study.model.entity.AchievementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAchievementsRepository extends JpaRepository<AchievementEntity,Integer> {

}
