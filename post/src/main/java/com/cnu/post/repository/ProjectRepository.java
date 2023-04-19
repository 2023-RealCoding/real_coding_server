package com.cnu.post.repository;

import com.cnu.post.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
//    Post save(Post post);
//    List<Post> findAll();
//    Optional<Post> findById(Integer postId);
//    void delete(Post post);
}
