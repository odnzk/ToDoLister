package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArchiveProjectController {
    private final ProjectService service;

    @GetMapping(TodoListerEndpoint.ARCHIVE_PROJECT + "/{projectId}")
    public void getPage(@PathVariable Long projectId) {
        service.archiveProject(projectId);
    }
}
