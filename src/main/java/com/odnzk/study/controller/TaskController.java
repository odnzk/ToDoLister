package com.odnzk.study.controller;

import com.odnzk.study.dto.TaskFormDto;
import com.odnzk.study.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/tasks")
public class TaskController {
    TaskService service;

    @PostMapping("/add")
    public String add(TaskFormDto taskFormDto) {
        service.create(taskFormDto);
        return "redirect:/projects";
    }

    // todo map to  /delete?id=${project.id}
    @DeleteMapping("delete")
    public String delete(@RequestParam("id") Integer id) {
        service.deleteById(id);
        return "redirect:/projects";
    }
}
