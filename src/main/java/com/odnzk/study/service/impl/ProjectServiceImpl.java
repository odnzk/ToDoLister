package com.odnzk.study.service.impl;

import com.odnzk.study.exception.DoesNotExistException;
import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.dto.UpdateProjectFormDto;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.model.entity.TaskEntity;
import com.odnzk.study.model.entity.UserEntity;
import com.odnzk.study.repository.ProjectRepository;
import com.odnzk.study.repository.TaskRepository;
import com.odnzk.study.service.ProjectService;
import com.odnzk.study.util.mapper.ProjectMapper;
import com.odnzk.study.util.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    @Override
    public void create(ProjectFormDto projectForm, UserEntity user) {
        projectForm.setUser(user);
        ProjectEntity project = ProjectMapper.from(projectForm);
        repository.save(project);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(UpdateProjectFormDto formDto) {
        Optional<ProjectEntity> optional = repository.findById(formDto.id());
        if (optional.isEmpty()) throw new DoesNotExistException("Cannot update project since it does not exist");
        ProjectEntity project = optional.get();
        project.setCompleted(formDto.isCompleted());
        project.setTitle(formDto.title());
        project.setDeadlineDate(formDto.finishDate());
        repository.save(project);
    }

    @Override
    public List<ProjectEntity> getUserProjects(UserEntity user) {
        return  repository.findProjectEntitiesByUser(user);
    }

    @Override
    public ProjectEntity getProjectById(Long id) {
        Optional<ProjectEntity> optional = repository.findById(id);
        if (optional.isEmpty()) throw new DoesNotExistException("Project with this id does not exist");
        return optional.get();
    }
}
