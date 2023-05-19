package com.odnzk.study.model;

public record Task(
        Long id,
        Long projectId,
        String title,
        boolean isCompeted,
        Priority priority
) {
}
