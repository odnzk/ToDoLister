package com.odnzk.study.service;

import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.dto.UpdateProjectFormDto;
import com.odnzk.study.model.entity.ArchivedProjectEntity;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.model.entity.UserEntity;

import java.util.List;

public interface ProjectService {
    void create(ProjectFormDto projectForm, UserEntity user);

    void create(ProjectFormDto projectForm, String username);

    void deleteById(Long id);

    void deleteAll();

    void update(UpdateProjectFormDto formDto);

    List<ProjectEntity> getUserProjects(UserEntity user);

    List<ProjectEntity> getUserProjects(String username);

    ProjectEntity getProjectById(Long id);

    void archiveProject(Long id);

    List<ArchivedProjectEntity> getByUserId(Long userId);
}
