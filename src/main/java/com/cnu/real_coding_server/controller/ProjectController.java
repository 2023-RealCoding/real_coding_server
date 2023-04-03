package com.cnu.real_coding_server.controller;

import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/save")
    public Project save(@RequestBody ProjectRequest projectRequest) {
        return projectService.save(projectRequest);
    }

    @GetMapping("/readAll")
    public List<Project> readAll() {
        return projectService.readAll();
    }

    @GetMapping("/read/{id}")
    public Project read(@PathVariable Integer id) {
        return projectService.read(id);
    }

    @PutMapping("/update/{id}")
    public Project update(@PathVariable Integer id, @RequestBody ProjectRequest projectRequest) {
        return projectService.update(id, projectRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        projectService.delete(id);
    }
}
