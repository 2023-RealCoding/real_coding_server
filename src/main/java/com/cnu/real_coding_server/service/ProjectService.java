package com.cnu.real_coding_server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project createProject(ProjectRequest ProjectRequest) {
        return projectRepository.save(ProjectRequest.toEntity());
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProject(Integer ProjectId) {
        return projectRepository.findById(ProjectId);
    }

    public Optional<Project> updateProject(Integer ProjectId, ProjectRequest ProjectRequest) {
        return projectRepository.findById(ProjectId)
                .map(Project -> {
                    Project.setTitle(ProjectRequest.getTitle());
                    Project.setSummary(ProjectRequest.getSummary());
                    Project.setDescription(ProjectRequest.getDescription());
                    return projectRepository.save(Project);
                });
    }

    public void deleteProject(Integer ProjectId) {
        projectRepository.findById(ProjectId)
                .ifPresent(projectRepository::delete);
    }
}
