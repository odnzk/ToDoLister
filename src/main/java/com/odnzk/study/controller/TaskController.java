package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.TaskFormDto;
import com.odnzk.study.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.TASKS)
public class TaskController {
    private final TaskService service;

    @PatchMapping()
    public String update(@RequestParam("id") Long id) {
        service.updateIsCompletedState(id);
        return "redirect:" + TodoListerEndpoint.PROJECTS;
    }

    @PostMapping()
    public String add(TaskFormDto taskFormDto) {
        service.create(taskFormDto);
        return "redirect:" + TodoListerEndpoint.PROJECTS;
    }

    // todo map to  /delete?id=${project.id}
    @DeleteMapping()
    public String delete(@RequestParam("id") Long id) {
        service.deleteById(id);
        return "redirect:" + TodoListerEndpoint.PROJECTS;
    }
}
