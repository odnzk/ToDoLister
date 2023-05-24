package com.odnzk.study.service.impl;

import com.odnzk.study.exception.EntityDoesNotExistException;
import com.odnzk.study.model.dto.TaskFormDto;
import com.odnzk.study.model.dto.UpdateTaskFormDto;
import com.odnzk.study.model.entity.TaskEntity;
import com.odnzk.study.repository.TaskRepository;
import com.odnzk.study.service.TaskService;
import com.odnzk.study.util.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public void create(TaskFormDto form) {
        TaskEntity task = TaskMapper.from(form);
        repository.save(task);
    }

    @Override
    public void update(UpdateTaskFormDto form) {
        Optional<TaskEntity> optional = repository.findById(form.getId());
        if (optional.isEmpty()) throw new EntityDoesNotExistException("Cannot update task since it does not exist");
        TaskEntity task = optional.get();
        task.setCompeted(form.getIsComplete());
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
        task.setCompeted(!task.isCompeted());
        repository.save(task);
    }

    @Override
    public Long countAll() {
        return repository.count();
    }
}
