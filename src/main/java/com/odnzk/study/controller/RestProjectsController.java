package com.odnzk.study.controller;

import com.odnzk.study.config.TodoListerEndpoint;
import com.odnzk.study.model.dto.ProjectFormDto;
import com.odnzk.study.model.entity.ProjectDto;
import com.odnzk.study.service.ProjectService;
import com.odnzk.study.util.mapper.ProjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@Tags(value = {@Tag(name = "Projects")})
@Schema(description = "Projects methods")
@RequestMapping(TodoListerEndpoint.REST_PROJECTS)
public class RestProjectsController {
    private static final String USER_NOT_AUTHORIZED_MESSAGE = "Not authorized";
    private final ProjectService service;

    @Operation(summary = "Get all projects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "projects",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            ),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    })
    @GetMapping
    public ResponseEntity<?> getPage(Authentication authentication) {
        try {
            if (authentication != null && authentication.isAuthenticated()) {
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                List<ProjectDto> project = ProjectMapper.from(service.getUserProjects(username));
                return new ResponseEntity<>(project, HttpStatus.OK);
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(ErrorResponse.builder(new Throwable(), HttpStatus.UNAUTHORIZED, USER_NOT_AUTHORIZED_MESSAGE).build());
            }
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ErrorResponse.builder(e, HttpStatus.NOT_FOUND, e.getMessage()).build());
        }
    }

    @Operation(summary = "Create project")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Created"),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
    })
    @PostMapping
    public ResponseEntity<?> add(Authentication authentication, ProjectFormDto projectFormDto) {
        try {
            if (authentication != null && authentication.isAuthenticated()) {
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                service.create(projectFormDto, username);
                return ResponseEntity.accepted().build();
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(ErrorResponse.builder(new Throwable(), HttpStatus.UNAUTHORIZED, USER_NOT_AUTHORIZED_MESSAGE).build());
            }
        } catch (NotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ErrorResponse.builder(e, HttpStatus.NOT_FOUND, e.getMessage()).build());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ErrorResponse.builder(e, HttpStatus.BAD_REQUEST, e.getMessage()).build());
        }
    }

}
