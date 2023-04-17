package com.cnu.post.service;

import com.cnu.post.entity.Project;
import com.cnu.post.model.request.ProjectRequest;
import com.cnu.post.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Project> getProject(Integer projectId) {
        return projectRepository.findById(projectId);
    }

    public Optional<Project> updateProject(Integer projectId, ProjectRequest projectRequest) {
        return projectRepository.findById(projectId)
                .map(project -> {
                    project.setTitle(projectRequest.getTitle());
                    project.setDescription(projectRequest.getDescription());
                    project.setSummary(projectRequest.getSummary());
                    project.setStartDate(projectRequest.getStartDate());
                    project.setEndDate(projectRequest.getEndDate());
                    project.setIsInProgress(projectRequest.getIsInProgress());
                    return projectRepository.save(project);
                });
    }

    public void deleteProject(Integer projectId) {
        projectRepository.findById(projectId)
                .ifPresent(projectRepository::delete);
    }
}