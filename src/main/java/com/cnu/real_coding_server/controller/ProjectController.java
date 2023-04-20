package com.cnu.real_coding_server.controller;


import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({ "/projects"})
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createProject(projectRequest));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {return ResponseEntity.ok(projectService.getProjects());}


    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") Integer postId) {
        return ResponseEntity.ok(projectService.getProject(postId).orElse(null));
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable("projectId")Integer postId,
                                           @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.updateProject(postId, projectRequest).orElse(null));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable("projectId") Integer postId) {
        projectService.deleteProject(postId);

        return ResponseEntity.noContent().build();
    }

}
