package com.atguigu.controller;


import com.atguigu.pojo.Project;
import com.atguigu.serv.ProjectService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        projectService.createProject(project);
        return project;
    }

    @GetMapping("/owner/{ownerId}")
    public List<Project> getProjectsByOwner(@PathVariable Long ownerId) {
        return projectService.findProjectsByOwner(ownerId);
    }

    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectService.findAllProjects();
    }


}
