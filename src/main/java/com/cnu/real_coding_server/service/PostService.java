package com.cnu.real_coding_server.service;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private final PostRepository postRepository;
    public Post createPost(PostRequest postRequest) {
        return postRepository.save(postRequest.toEntity());
    }

    //모든 post 조회
    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    //특정 post 조회 (findbyid 사용)
    public Optional<Post> getPost(Integer postId){
        return postRepository.findById(postId);
        }


        //특정 post 수정, 수정하기 전에 해당 post가 존재하는지 확인후 , 있다면
    public Optional<Post> updatePost(Integer postId, PostRequest postRequest){
        return postRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postRequest.getTitle());
                    post.setContents(postRequest.getContents());
                    post.setTag(postRequest.getTag());
                    return postRepository.save(post);
                });
    }

    //삭제하려는 post가 없는경우 뭔가를 리턴할 수도 있지만 일단 void
    //optional에서 제공하는 delete함수를 사ㅛㅇㅇ함
    public void deletePost(Integer postId){
        postRepository.findById(postId)
                .ifPresent(post -> postRepository.delete(post));
    }

}


