package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.Priority;
import com.odnzk.study.model.entity.ArchivedProjectEntity;
import com.odnzk.study.model.entity.TaskEntity;
import com.odnzk.study.service.ProjectService;
import com.odnzk.study.service.TaskService;
import com.odnzk.study.util.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.STATS)
public class StatsController {
    private final TaskService taskService;
    private final ProjectService projectService;

    @GetMapping
    public String getPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        List<TaskEntity> tasks = taskService.getOrderedTasks(Priority.LOW);
        List<ArchivedProjectEntity> projects = projectService.getByUserId(userDetails.getUser().getId());
        model.addAttribute("tasks", tasks);
        model.addAttribute("projects", projects);
        return "stats";
    }

}
