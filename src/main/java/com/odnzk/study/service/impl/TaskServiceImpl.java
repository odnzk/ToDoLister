package com.odnzk.study.service.impl;

import com.odnzk.study.exception.EntityDoesNotExistException;
import com.odnzk.study.model.Achievement;
import com.odnzk.study.model.Priority;
import com.odnzk.study.model.dto.TaskFormDto;
import com.odnzk.study.model.dto.UpdateTaskFormDto;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.model.entity.TaskEntity;
import com.odnzk.study.repository.ProjectRepository;
import com.odnzk.study.repository.TaskRepository;
import com.odnzk.study.service.AchievementService;
import com.odnzk.study.service.TaskService;
import com.odnzk.study.util.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final ProjectRepository projectRepository;
    private final AchievementService achievementService;

    @Override
    public void create(TaskFormDto form) {
        ProjectEntity project = projectRepository.findById(form.getProjectId())
                .orElseThrow(() -> new EntityDoesNotExistException("Cannot create task for non-existing project"));
        TaskEntity task = TaskMapper.from(form, project);
        repository.save(task);
        achievementService.unlockAchievement(Achievement.TASK_CREATED, project.getUser().getId());
    }

    @Override
    public void update(UpdateTaskFormDto form) {
        Optional<TaskEntity> optional = repository.findById(form.getId());
        if (optional.isEmpty()) throw new EntityDoesNotExistException("Cannot update task since it does not exist");
        TaskEntity task = optional.get();
        task.setIsCompleted(form.getIsComplete());
        task.setPriority(form.getPriority());
        task.setTitle(form.getTitle());
        repository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateIsCompletedState(Long taskId) {
        TaskEntity task = repository.findById(taskId).orElseThrow(() -> new EntityDoesNotExistException("Task cannot be updated since it does not exist"));
        task.setIsCompleted(!task.getIsCompleted());
        repository.save(task);
        if (task.getIsCompleted()) {
            achievementService.unlockAchievement(Achievement.TASK_COMPLETED, task.getProject().getUser().getId());
        }
    }

    @Override
    public List<TaskEntity> getOrderedTasks(Priority priority) {
        return repository.getOrderedTasks(priority);
    }
}
