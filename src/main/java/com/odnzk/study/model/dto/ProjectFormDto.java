package com.odnzk.study.model.dto;

import com.odnzk.study.model.entity.UserEntity;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class ProjectFormDto {
    @NotBlank
    private String title;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishDate;
    private UserEntity user;
}
