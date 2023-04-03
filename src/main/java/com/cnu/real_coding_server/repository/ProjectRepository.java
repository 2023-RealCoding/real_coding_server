package com.cnu.real_coding_server.repository;

import com.cnu.real_coding_server.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project save(Project project);
    List<Project> findAll();
    Optional<Project> findById(Integer postId);
    void delete(Project project);
}

