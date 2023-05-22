package com.odnzk.study.service;

import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.dto.UpdateProjectFormDto;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.model.entity.UserEntity;

import java.util.List;

public interface ProjectService {
    void create(ProjectFormDto projectForm, UserEntity user);

    void deleteById(Long id);

    void update(UpdateProjectFormDto formDto);

    List<ProjectEntity> getUserProjects(UserEntity user);

    ProjectEntity getProjectById(Long id);
}
