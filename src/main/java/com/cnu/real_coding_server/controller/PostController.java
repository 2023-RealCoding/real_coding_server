package com.cnu.real_coding_server.controller;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        postService.createPost(postRequest)
                );
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> findAllPost() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        postService.getPosts()
                );
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable("postId") Integer postId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        postService.getPost(postId).orElse(null)
                );
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(
            @PathVariable("postId") Integer postId,
            @RequestBody PostRequest postRequest
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        postService.updatePost(postId, postRequest).orElse(null)
                );
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Integer postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
