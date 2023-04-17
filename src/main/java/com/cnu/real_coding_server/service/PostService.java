package com.cnu.real_coding_server.service;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(PostRequest postRequest) {
        return postRepository.save(postRequest.toEntity());
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPost(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));
    }

    public Optional<Post> updatePost(Integer postId, PostRequest postRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));

        post.setTitle(postRequest.getTitle());
        post.setContents(postRequest.getContents());
        post.setTag(postRequest.getTag());

        return Optional.of(postRepository.save(post));
    }

    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));

        postRepository.delete(post);
    }
}
