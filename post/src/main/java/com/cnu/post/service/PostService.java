package com.cnu.post.service;

import com.cnu.post.client.AdvertisementClient;
import com.cnu.post.entity.Post;
import com.cnu.post.model.request.PostRequest;
import com.cnu.post.model.response.PostResponse;
import com.cnu.post.repository.PostRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final AdvertisementClient advertisementClient;
    public Post createPost(PostRequest postRequest) {
        return postRepository.save(postRequest.toEntity());
    }

    public List<Post> getPost() {
        return postRepository.findAll();
    }

    public Optional<PostResponse> getPost(Integer postId) {
        return postRepository.findById(postId)
                .map(post -> new PostResponse(post, advertisementClient.getAd()));
    }

    public Optional<Post> updatePost(Integer postId, PostRequest postRequest) {
        return postRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postRequest.getTitle());
                    post.setContents(postRequest.getContents());
                    post.setTag(postRequest.getTag());
                    return  postRepository.save(post);
                });
    }

    public void deletePost(Integer postId) {
        postRepository.findById(postId)
                .ifPresent(postRepository::delete);
    }

}
