package com.odnzk.study.util.mapper;

import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.entity.ProjectEntity;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;

public class ProjectMapper {

    public static ProjectEntity from(ProjectFormDto form) {
        return ProjectEntity.builder()
                .deadlineDate(form.getFinishDate())
                .startDate(form.getStartDate())
                .title(form.getTitle())
                .tasks(Collections.emptyList())
                .user(form.getUser())
                .build();
    }

//    public static ProjectFormDto starterProject() {
//        return ProjectFormDto.builder()
//                .startDate(Date.from(Instant.now()))
//                .title("Starter project")
//                .build();
//    }


}
