package com.odnzk.study.model.dto;

import com.odnzk.study.model.Priority;
import com.odnzk.study.model.entity.ProjectEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskFormDto {
    private ProjectEntity project;
    @NotBlank
    private String title;
    @NotNull
    private Priority priority;
}
