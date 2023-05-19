package com.odnzk.study.model;

import java.util.Date;
import java.util.List;

public record Project(
        Long id,
        Long userId,
        String title,
        boolean isCompleted,
        Date startDate,
        Date deadlineDate,
        Integer progress, // todo remove from database entity
        List<Task> tasks // todo remove from database entity
) {
}
