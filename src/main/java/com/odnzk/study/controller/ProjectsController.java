package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.dto.UpdateProjectFormDto;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.service.ProjectService;
import com.odnzk.study.util.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.PROJECTS)
public class ProjectsController {
    private final ProjectService service;

    @GetMapping
    public String getPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        List<ProjectEntity> projects = service.getUserProjects(userDetails.getUser());
        model.addAttribute("projects", projects);
        return "projects";
    }

    @PostMapping("/add")
    public String add(@AuthenticationPrincipal UserDetailsImpl userDetails, ProjectFormDto projectFormDto) {
        service.create(projectFormDto, userDetails.getUser());
        return "redirect:" + TodoListerEndpoint.PROJECTS;
    }

    @PatchMapping
    public String update(UpdateProjectFormDto form) {
        service.update(form);
        return "redirect:" + TodoListerEndpoint.PROJECTS;
    }

    // todo map to  /delete?id=${project.id}
    @DeleteMapping("delete")
    public String delete(@RequestParam("id") Long id) {
        service.deleteById(id);
        return "redirect:/" + TodoListerEndpoint.PROJECTS;
    }


}
