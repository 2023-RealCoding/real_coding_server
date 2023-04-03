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

    public Post createPost(PostRequest postRequest){
        return postRepository.save(postRequest.toEntity());
    }

    public List<Post> loadAll(){
        return postRepository.findAll();
    }

    public Optional<Post> getPost(Integer id){
        return postRepository.findById(id);
    }

    public Optional<Post> updatePost(Integer id, PostRequest postRequest){
        return postRepository.findById(id).map(post ->{
            post.setTitle(postRequest.getTitle());
            post.setContents(postRequest.getContents());
            return postRepository.save(post);
        });
    }

    public void delete(Integer id){
        postRepository.findById(id).ifPresent(postRepository::delete);
    }
}
