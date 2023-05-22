package com.odnzk.study.model.dto;

import com.odnzk.study.model.Priority;
import com.odnzk.study.model.entity.ProjectEntity;

public record TaskFormDto(
        ProjectEntity project,
        String title,
        Priority priority
) {
}
