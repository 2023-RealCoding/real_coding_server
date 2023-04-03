package com.cnu.real_coding_server.service;

import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project createProject(ProjectRequest projectRequest) {
        return projectRepository.save(projectRequest.toEntity());
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }
}
