package com.odnzk.study.service.impl;

import com.odnzk.study.exception.EntityDoesNotExistException;
import com.odnzk.study.model.Achievement;
import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.dto.UpdateProjectFormDto;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.model.entity.UserEntity;
import com.odnzk.study.repository.ArchivedProjectRepository;
import com.odnzk.study.repository.ProjectRepository;
import com.odnzk.study.service.AchievementService;
import com.odnzk.study.service.ProjectService;
import com.odnzk.study.util.mapper.ArchivedProjectMapper;
import com.odnzk.study.util.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;
    private final AchievementService achievementService;
    private final ArchivedProjectRepository archivedProjectRepository;

    @Override
    public void create(ProjectFormDto projectForm, UserEntity user) {
        projectForm.setUser(user);
        ProjectEntity project = ProjectMapper.from(projectForm);
        repository.save(project);
        achievementService.unlockAchievement(Achievement.PROJECT_CREATED, user.getId());
    }

    @Override
    public void deleteById(Long id) {
        ProjectEntity project = getProjectById(id);
        if (project.isCompleted()) {
            achievementService.unlockAchievement(Achievement.PROJECT_COMPLETED, project.getUser().getId());
        }
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void update(UpdateProjectFormDto formDto) {
        Optional<ProjectEntity> optional = repository.findById(formDto.getId());
        if (optional.isEmpty()) throw new EntityDoesNotExistException("Cannot update project since it does not exist");
        ProjectEntity project = optional.get();
        project.setTitle(formDto.getTitle());
        project.setDeadlineDate(formDto.getFinishDate());
        repository.save(project);
    }

    @Override
    public List<ProjectEntity> getUserProjects(UserEntity user) {
        return repository.findProjectEntitiesByUser(user);
    }

    @Override
    public ProjectEntity getProjectById(Long id) {
        Optional<ProjectEntity> optional = repository.findById(id);
        if (optional.isEmpty()) throw new EntityDoesNotExistException("Project with this id does not exist");
        return optional.get();
    }

    @Override
    public void archiveProject(Long id) {
        ProjectEntity projectEntity = repository.findById(id).orElseThrow(() -> new EntityDoesNotExistException("Project with this id does not exist"));
        archivedProjectRepository.save(ArchivedProjectMapper.from(projectEntity));
    }
}
