package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.TaskFormDto;
import com.odnzk.study.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.TASKS)
public class TaskController {
    private final TaskService service;

    @PatchMapping()
    public void update(@RequestParam("id") Long id) {
        service.updateIsCompletedState(id);
    }

    @PostMapping
    public String add(TaskFormDto taskFormDto) {
        service.create(taskFormDto);
        return "redirect:" + TodoListerEndpoint.PROJECTS;
    }

    @DeleteMapping()
    public void delete(@RequestParam("id") Long id) {
        service.deleteById(id);
    }
}
