package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.ArchiveRequestDto;
import com.odnzk.study.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArchiveProjectController {
    private final ProjectService service;

//    todo complete native queries

    @PostMapping(TodoListerEndpoint.ARCHIVE_PROJECT)
    public void getPage(ArchiveRequestDto archiveRequestDto) {
        service.archiveProject(archiveRequestDto.getProjectId());
    }
}
