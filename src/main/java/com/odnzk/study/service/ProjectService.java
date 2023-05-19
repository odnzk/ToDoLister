package com.odnzk.study.service;

import com.odnzk.study.dto.ProjectFormDto;
import com.odnzk.study.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    void create(ProjectFormDto projectForm);

    void deleteById(Integer id);

    void update(ProjectFormDto projectForm);

    List<Project> getUserProjects(Integer userId);

    Optional<Project> getProjectById(Integer projectId);
}
