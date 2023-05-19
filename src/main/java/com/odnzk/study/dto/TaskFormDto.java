package com.odnzk.study.dto;

import com.odnzk.study.model.Priority;

public record TaskFormDto(
        Long projectId,
        String title,
        Priority priority
) {
}
