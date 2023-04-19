package com.cnu.post.controller;

import com.cnu.post.entity.Post;
import com.cnu.post.entity.Project;
import com.cnu.post.model.request.ProjectRequest;
import com.cnu.post.model.response.PostResponse;
import com.cnu.post.service.PostService;
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
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Project> createPost(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createPost(projectRequest));
    }
    @GetMapping
    public ResponseEntity<List<Project>> getPosts() {
        return ResponseEntity.ok(projectService.getPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("postId") Integer postId) {
        return ResponseEntity.ok(postService.getPost(postId).orElse(null));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Project> updatePost(@PathVariable("postId") Integer postId, @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.updatePost(postId, projectRequest).orElse(null));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Integer postId) {
        projectService.deletePost(postId);

        return ResponseEntity.noContent().build();
    }
}
