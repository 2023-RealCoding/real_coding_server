package com.cnu.real_coding_server.controller;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    @PostMapping("/v3/api-docs")
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.createPost(postRequest));
    }

    @GetMapping("/view")
    public ResponseEntity<List<Post>> loadAll(){
        return ResponseEntity.ok(postService.loadAll());
    }

    @PostMapping("/view/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable Integer postId){
        return ResponseEntity.ok(postService.getPost(postId).get());
    }

    @PostMapping("/modify/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer postId,
                                           @RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.updatePost(postId,postRequest).get());
    }

    @PostMapping("/delete/{postId}")
    public void delete(@PathVariable Integer postId){
        postService.delete(postId);
    }

}
