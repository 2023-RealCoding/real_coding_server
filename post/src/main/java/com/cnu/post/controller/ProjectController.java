package com.cnu.post.controller;

import com.cnu.post.entity.Project;
import com.cnu.post.model.request.ProjectRequest;
import com.cnu.post.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createProject(projectRequest));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") Integer projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId).orElse(null));
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable("projectId") Integer projectId, @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.updateProject(projectId, projectRequest).orElse(null));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable("projectId") Integer projectId) {
        projectService.deleteProject(projectId);

        return ResponseEntity.noContent().build();
    }
}

//1