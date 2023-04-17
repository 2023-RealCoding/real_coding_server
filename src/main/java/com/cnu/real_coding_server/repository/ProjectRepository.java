package com.cnu.real_coding_server.repository;

import com.cnu.real_coding_server.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
//    Project save(Project project); // 정록: JpaRepository 상속 받아서 아래 함수들을 알아서 제공해줌
//    List<Project> findAll();
//    Optional<Project> findById(Integer ProjcetId);
//    void delete(Project project);
}
