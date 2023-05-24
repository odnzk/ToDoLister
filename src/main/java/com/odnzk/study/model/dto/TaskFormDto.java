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
public class TaskFormDto {
    @NotNull
    private Long projectId;
    @NotBlank
    private String title;
//    @NotNull
//    private Priority priority;
}
