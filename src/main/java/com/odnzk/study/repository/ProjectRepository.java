package com.odnzk.study.repository;

import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    List<ProjectEntity> findProjectEntitiesByUser(UserEntity user);
}
