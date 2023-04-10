package com.cnu.real_coding_server.repository;

import com.cnu.real_coding_server.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    // JPA repository 상속 ->
//    Post save(Post post);
//    List<Post> findAll();
//    Optional<Post> findById(Integer postId);
//    void delete(Post post);
}
