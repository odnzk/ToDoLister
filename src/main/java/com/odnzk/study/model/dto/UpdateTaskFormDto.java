package com.odnzk.study.model.dto;

import com.odnzk.study.model.Priority;

public record UpdateTaskFormDto(
        Long id,
        String title,
        Priority priority,
        Boolean isCompleted
) {
}
