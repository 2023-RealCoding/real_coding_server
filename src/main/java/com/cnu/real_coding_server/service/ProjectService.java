package com.cnu.real_coding_server.service;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.entity.Project;
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
    public Project createProject(ProjectRequest projectRequest) {return projectRepository.save(projectRequest.toEntity());}
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }
    public Optional<Project> getProject(Integer postId) {
        return projectRepository.findById(postId);
    }
    public Optional<Project> updateProject(Integer postId, ProjectRequest projectRequest) {
        return projectRepository.findById(postId)
                .map(post -> {
                    post.setTitle(projectRequest.getTitle());
                    post.setContents(projectRequest.getContents());
                    post.setTag(projectRequest.getTag());
                    return projectRepository.save(post);
                });
    }
    public void deleteProject(Integer postId) {
        projectRepository.findById(postId)
                .ifPresent(projectRepository::delete);
    }

}
