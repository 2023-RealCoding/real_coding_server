package com.cnu.real_coding_server.service;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.repository.PostRepository;
import com.cnu.real_coding_server.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project createPost(ProjectRequest projectRequest) {
        return projectRepository.save(projectRequest.toEntity());
    }

    public List<Project> getPosts() {
        return projectRepository.findAll();
    }

    public Optional<Project> getPost(Integer postId) {
        return projectRepository.findById(postId);
    }

    public Optional<Project> updatePost(Integer postId, ProjectRequest projectRequest) {
        return projectRepository.findById(postId)
                .map(project -> {
                    project.setTitle(projectRequest.getTitle());
                    project.setSummary(projectRequest.getSummary());
                    project.setDescription(projectRequest.getDescription());
                    project.setEndDate(projectRequest.getEndDate());
                    project.setStartDate(projectRequest.getStartDate());
                    project.setIsInProgress(projectRequest.getIsInProgress());
                    return projectRepository.save(project);
                });
    }

    public void deletePost(Integer postId) {
        projectRepository.findById(postId)
                .ifPresent(projectRepository::delete);
    }
}
