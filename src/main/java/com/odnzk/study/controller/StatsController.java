package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.Priority;
import com.odnzk.study.model.entity.TaskEntity;
import com.odnzk.study.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
    private final TaskService service;

    @GetMapping
    public String getPage(Model model) {
        List<TaskEntity> tasks = service.getOrderedTasks(Priority.HIGH);
        model.addAttribute("tasks", tasks);
        return "projects";
    }

}
