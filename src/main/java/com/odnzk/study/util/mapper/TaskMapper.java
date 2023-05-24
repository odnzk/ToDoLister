package com.odnzk.study.util.mapper;

import com.odnzk.study.model.Priority;
import com.odnzk.study.model.dto.TaskFormDto;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.model.entity.TaskEntity;

public class TaskMapper {

    public static TaskEntity from(TaskFormDto form) {
        return TaskEntity
                .builder()
                .priority(form.getPriority())
                .isCompeted(false)
                .title(form.getTitle())
//                .project(form.project())
                .build();
    }

//    public static TaskEntity starterTask(ProjectEntity project) {
//        return TaskEntity
//                .builder()
//                .priority(Priority.LOW)
//                .isCompeted(false)
//                .title("Starter task")
////                .project(project)
//                .build();
//    }


}
