package com.cnu.real_coding_server.controller;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.creatPost(postRequest));
    }
    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable("postId") Integer postId) {
        return ResponseEntity.ok(postService.getPost(postId).orElse(null));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable("postId") Integer postId,
                                           @RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.updatePost(postId,postRequest).orElse(null));
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Integer postId){
        postService.deletePost(postId);

        return ResponseEntity.noContent().build();
        //성공하면 ok가아니라 nocontent로
    }

    //조회는 GetMapping
    //뒤에 ()에 넣는 건 그형식들
    // optional 이라서 예외처리가 안되서? orElse를 넣은듯
    //.orElse는 앞이아니면, 뒤를 할게
    // null넣었으니 null줄듯?

}
