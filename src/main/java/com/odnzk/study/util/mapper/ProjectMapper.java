package com.odnzk.study.util.mapper;

import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.entity.ProjectDto;
import com.odnzk.study.model.entity.ProjectEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectEntity from(ProjectFormDto form) {
        return ProjectEntity.builder().deadlineDate(form.getFinishDate()).startDate(form.getStartDate()).title(form.getTitle()).tasks(Collections.emptyList()).user(form.getUser()).build();
    }

    public static ProjectDto from(ProjectEntity entity) {
        return ProjectDto.builder().deadlineDate(entity.getDeadlineDate()).startDate(entity.getStartDate()).title(entity.getTitle()).id(entity.getId()).build();
    }

    public static List<ProjectDto> from(List<ProjectEntity> entities) {
        return entities.stream().map(ProjectMapper::from).collect(Collectors.toList());
    }
}
