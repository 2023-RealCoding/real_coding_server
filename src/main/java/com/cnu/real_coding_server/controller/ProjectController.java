package com.cnu.real_coding_server.controller;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.service.PostService;
import com.cnu.real_coding_server.service.ProjectService;
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
    public ResponseEntity<Project> createPost(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createPost(projectRequest));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getPosts() {
        return ResponseEntity.ok(projectService.getPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Project> getPost(@PathVariable("postId") Integer postId) {
        return ResponseEntity.ok(projectService.getPost(postId).orElse(null));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Project> updatePost(@PathVariable("postId")Integer postId,
                                           @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.updatePost(postId, projectRequest).orElse(null));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Integer postId) {
       projectService.deletePost(postId);

        return ResponseEntity.noContent().build();
    }
}

