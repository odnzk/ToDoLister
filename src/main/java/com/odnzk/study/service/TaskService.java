package com.odnzk.study.service;

import com.odnzk.study.model.Priority;
import com.odnzk.study.model.dto.TaskFormDto;
import com.odnzk.study.model.dto.UpdateTaskFormDto;
import com.odnzk.study.model.entity.TaskEntity;

import java.util.List;

public interface TaskService {
    void create(TaskFormDto taskFormDto);

    void update(UpdateTaskFormDto updateTaskFormDto);

    void deleteById(Long id);

    void updateIsCompletedState(Long taskId);

    List<TaskEntity> getOrderedTasks(Priority priority);
}
