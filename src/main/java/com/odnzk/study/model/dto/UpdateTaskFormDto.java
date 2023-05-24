package com.odnzk.study.model.dto;

import com.odnzk.study.model.Priority;
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
public class UpdateTaskFormDto {
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    private Priority priority;
    @NotNull
    private Boolean isComplete;
}
