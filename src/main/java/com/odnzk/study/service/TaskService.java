package com.odnzk.study.service;

import com.odnzk.study.model.dto.TaskFormDto;
import com.odnzk.study.model.dto.UpdateTaskFormDto;

public interface TaskService {
    void create(TaskFormDto taskFormDto);

    void update(UpdateTaskFormDto updateTaskFormDto);

    void deleteById(Long id);

   Long countAll();
}
