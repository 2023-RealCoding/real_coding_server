package com.cnu.real_coding_server.repository;

import com.cnu.real_coding_server.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
//    Post save(Post post);
//    List<Post> findAll(); 모든 정보를 볼 수 있도록 하는 함수이다.
//    Optional<Post> findById(Integer postId); 아이디를 알고 있다면 특정 게시물을 불러와줘
//    void delete(Post post);
}
