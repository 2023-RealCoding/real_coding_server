package com.cnu.real_coding_server.controller;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.service.PostService;
import com.cnu.real_coding_server.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        projectService.createProject(projectRequest)
                );
    }

    @GetMapping("")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        projectService.getProjects()
                );
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getPost(@PathVariable("projectId") Integer projectId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        projectService.getProject(projectId).orElse(null)
                );
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProject(
            @PathVariable("projectId") Integer projectId,
            @RequestBody ProjectRequest projectRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        projectService.updateProject(projectId, projectRequest).orElse(null)
                );
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable("projectId") Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
