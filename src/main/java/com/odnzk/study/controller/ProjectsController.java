package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.dto.UpdateProjectFormDto;
import com.odnzk.study.model.entity.ProjectEntity;
import com.odnzk.study.service.ProjectService;
import com.odnzk.study.util.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping(TodoListerEndpoint.PROJECTS)
public class ProjectsController {
    private static final int DELETE_ALL_ID = -1;
    private final ProjectService service;

    @GetMapping
    public String getPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        List<ProjectEntity> projects = service.getUserProjects(userDetails.getUser());
        model.addAttribute("projects", projects);
        return "projects";
    }

    @PostMapping
    public String add(@AuthenticationPrincipal UserDetailsImpl userDetails, ProjectFormDto projectFormDto) {
        service.create(projectFormDto, userDetails.getUser());
        return "redirect:" + TodoListerEndpoint.PROJECTS;
    }

    @PatchMapping
    public String update(UpdateProjectFormDto form) {
        service.update(form);
        return "redirect:" + TodoListerEndpoint.PROJECTS;
    }

    @DeleteMapping
    public void delete(@RequestParam("id") Long id) {
        if (id != DELETE_ALL_ID) {
            service.deleteById(id);
        } else {
            service.deleteAll();
        }
    }

}
