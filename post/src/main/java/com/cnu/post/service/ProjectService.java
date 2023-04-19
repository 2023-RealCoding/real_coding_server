package com.cnu.post.service;

import com.cnu.post.client.AdvertisementClient;
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
    private final AdvertisementClient advertisementClient;
    public Project createPost(ProjectRequest projectRequest) {
        return projectRepository.save(projectRequest.toEntity());
    }

    public List<Project> getPosts() {
        return projectRepository.findAll();
    }



    public Optional<Project> updatePost(Integer postId, ProjectRequest projectRequest) {
        return projectRepository.findById(postId)
                .map(project -> {
                    project.setTitle(projectRequest.getTitle());
                    project.setSummary(projectRequest.getSummary());
                    project.setDescription(projectRequest.getDescription());
                    project.setStartDate(projectRequest.getStartDate());
                    project.setEndDate(projectRequest.getEndDate());
                    project.setIsInProgress(projectRequest.getIsInProgress());
                    return projectRepository.save(project);
                });
    }

    public void deletePost(Integer postId) {
        projectRepository.findById(postId)
                .ifPresent(projectRepository::delete);
    }
}
