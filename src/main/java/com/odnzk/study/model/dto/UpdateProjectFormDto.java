package com.odnzk.study.model.dto;

import java.util.Date;

public record UpdateProjectFormDto(
        Long id,
        String title,
        Date finishDate,
        Boolean isCompleted
) {
}
