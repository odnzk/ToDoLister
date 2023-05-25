package com.odnzk.study.repository;

import com.odnzk.study.model.Priority;
import com.odnzk.study.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query("SELECT t FROM TaskEntity t " +
            "WHERE t.isCompleted = true AND t.priority = :priority ORDER BY t.title")
    List<TaskEntity> getOrderedTasks(Priority priority);
}
