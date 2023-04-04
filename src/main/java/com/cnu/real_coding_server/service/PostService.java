package com.cnu.real_coding_server.service;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public Post createPost(PostRequest postRequest){
        return postRepository.save(postRequest.toEntity());
    }
    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public Post getPost(Integer postId) {
        return postRepository.findById(postId).get();
    }

    public Optional<Post> updatePost(@RequestBody PostRequest postRequest, @PathVariable Integer postId) {
        return postRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postRequest.getTitle());
                    post.setContents(postRequest.getContents());
                    post.setTag(postRequest.getTag());
                    return postRepository.save(post);
                });
    }

    public void deletePost(Integer postId) {
        postRepository.findById(postId).ifPresent(postRepository::delete);
    }
}
