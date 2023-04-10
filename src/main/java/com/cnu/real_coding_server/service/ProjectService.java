package com.cnu.real_coding_server.service;


import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project creatProject(ProjectRequest postRequest) {
        return  projectRepository.save(postRequest.toEntity());
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProject(Integer projectId) {
        return projectRepository.findById(projectId);
    }

    public Optional<Project> updateProject(Integer projectId, ProjectRequest projectRequest){
        return projectRepository.findById(projectId)
                .map(project -> {
                    project.setTitle(projectRequest.getTitle());
                    project.setSummary(projectRequest.getSummary());
                    project.setDescription(projectRequest.getDescription());
                    project.setStartDate(projectRequest.getStartDate());
                    project.setEndDate(projectRequest.getEndDate());
                    project.setIsInProgress(projectRequest.getIsInProgress());
                    return projectRepository.save(project);
                });
        //람다식 이라내요 익숙해지는걸 추천
    }

    public void deleteProject(Integer projectId){
        projectRepository.findById(projectId)
                .ifPresent(project -> projectRepository.delete(project));
        //optional일때 가능한 .ifPresent
        //줄여쓰면 .ifPresent(projectRepository::delete);
    }
    //공통적으로 projectRepository에 있는 형식과 같게
}