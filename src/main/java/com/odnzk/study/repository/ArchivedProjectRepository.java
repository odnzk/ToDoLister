package com.odnzk.study.repository;

import com.odnzk.study.model.entity.ArchivedProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArchivedProjectRepository extends JpaRepository<ArchivedProjectEntity, Long> {
    @Query("SELECT p FROM ArchivedProjectEntity p WHERE p.user IN (SELECT u FROM UserEntity u WHERE u.id = :userId) ORDER BY p.tasksCount DESC")
    List<ArchivedProjectEntity> findByUserId(Long userId);

    @Query("SELECT p FROM ArchivedProjectEntity p WHERE p.projectId = :projectId")
    Optional<ArchivedProjectEntity> findByProjectId(Long projectId);

}
