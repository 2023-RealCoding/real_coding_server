package com.cnu.real_coding_server.service;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post save(PostRequest postRequest) {
        return postRepository.save(postRequest.toEntity());
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Integer id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("It doesn't exist in the Repository"));
    }

    public Post updatePost(Integer id, PostRequest postRequest) {
        return postRepository.findById(id).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setContents(postRequest.getContents());
            post.setTag(postRequest.getTag());
            return postRepository.save(post);
        }).orElseThrow(() -> new NoSuchElementException("그런 포스트는 없어용~"));
    }

    public void deletePost(Integer id) {
//        postRepository.findById(id).map(post -> {
//            postRepository.delete(post);
//            return null;
//        }).orElseThrow(() -> new NoSuchElementException("그런 포스트는 없어용~"));
//    }
        postRepository.findById(id).ifPresent(postRepository::delete);
    }
}
