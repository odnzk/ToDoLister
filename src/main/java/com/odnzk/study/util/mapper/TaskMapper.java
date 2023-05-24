package com.odnzk.study.util.mapper;

import com.odnzk.study.model.dto.TaskFormDto;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.model.entity.TaskEntity;

public class TaskMapper {

    public static TaskEntity from(TaskFormDto form, ProjectEntity project) {
        return TaskEntity
                .builder()
                .priority(form.getPriority())
                .isCompleted(false)
                .title(form.getTitle())
                .project(project)
                .build();
    }

}
