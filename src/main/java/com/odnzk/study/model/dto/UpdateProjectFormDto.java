package com.odnzk.study.model.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateProjectFormDto {
    @NotNull
    private Long id;
    @NotBlank
    private String title;
    @Future
    private Date finishDate;
}
