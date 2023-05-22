package com.odnzk.study.model.dto;

import com.odnzk.study.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class ProjectFormDto {
    private String title;
    private Date startDate;
    private Date finishDate;
    private UserEntity user;
}
