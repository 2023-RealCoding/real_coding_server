package com.cnu.real_coding_server.service;

import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    public Project save(ProjectRequest projectRequest) {
        return projectRepository.save(projectRequest.toEntity());
    }

    public List<Project> readAll() {
        return projectRepository.findAll();
    }

    public Project read(Integer id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project id " + id + " doesn't exist in Repository"));
    }

    public Project update(Integer id, ProjectRequest projectRequest) {
        return projectRepository.findById(id).map(project -> {
            project.setTitle(projectRequest.getTitle());
            project.setSummary(projectRequest.getSummary());
            project.setDescription(projectRequest.getDescription());
            project.setStartDate(projectRequest.getStartDate());
            project.setEndDate(projectRequest.getEndDate());
            project.setIsInProgress(projectRequest.getIsInProgress());
            return projectRepository.save(project);
        }).orElseThrow(() -> new NoSuchElementException("그런 프로젝트는 없어용 ~"));
    }

    public void delete(Integer id) {
        projectRepository.deleteById(id);
    }
}
