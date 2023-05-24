package com.odnzk.study.util.mapper;

import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.entity.ProjectEntity;

import java.util.Collections;

public class ProjectMapper {

    public static ProjectEntity from(ProjectFormDto form) {
        return ProjectEntity.builder()
                .deadlineDate(form.getFinishDate())
                .startDate(form.getStartDate())
                .title(form.getTitle())
                .tasks(Collections.emptyList())
                .user(form.getUser())
                .build();
    }
}
