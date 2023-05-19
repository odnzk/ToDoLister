package com.odnzk.study.service;

import com.odnzk.study.dto.TaskFormDto;
import com.odnzk.study.model.Task;

import java.util.List;

public interface TaskService {
    void create(TaskFormDto taskFormDto);

    void update(Task task);

    void deleteById(Integer id);

    Integer countAll();

    List<Task> getProjectTasks(Integer projectId);
}
