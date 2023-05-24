package com.odnzk.study.util.mapper;

import com.odnzk.study.model.entity.ArchivedProjectEntity;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.model.entity.TaskEntity;

public class ArchivedProjectMapper {

    public static ArchivedProjectEntity from(ProjectEntity project) {
        return ArchivedProjectEntity.builder()
                .deadlineDate(project.getDeadlineDate())
                .startDate(project.getStartDate())
                .title(project.getTitle())
                .completedTasksCount((int) project.getTasks().stream().filter(TaskEntity::getIsCompleted).count())
                .tasksCount(project.getTasks().size())
                .user(project.getUser())
                .build();
    }
}
