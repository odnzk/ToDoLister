package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.dto.ProjectFormDto;
import com.odnzk.study.model.Project;
import com.odnzk.study.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/" + TodoListerEndpoint.PROJECTS)
public class ProjectsController {
    ProjectService service;

    @GetMapping
    public String getPage(Model model) {
        // todo get userId
        Integer userId = -1;
        List<Project> projects = service.getUserProjects(userId);
        model.addAttribute("projects", projects);
        return TodoListerEndpoint.PROJECTS;
    }

    @PostMapping("/add")
    public String add(ProjectFormDto projectFormDto) {
        service.create(projectFormDto);
        return "redirect:/" + TodoListerEndpoint.PROJECTS;
    }

    @PatchMapping
    public String update(ProjectFormDto projectFormDto) {
        service.update(projectFormDto);
        return "redirect:/" + TodoListerEndpoint.PROJECTS;
    }

    // todo map to  /delete?id=${project.id}
    @DeleteMapping("delete")
    public String delete(@RequestParam("id") Integer id) {
        service.deleteById(id);
        return "redirect:/" + TodoListerEndpoint.PROJECTS;
    }


}
