package com.odnzk.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectDto {
    private Long id;
    private String title;
    private Date startDate;
    private Date deadlineDate;
}
