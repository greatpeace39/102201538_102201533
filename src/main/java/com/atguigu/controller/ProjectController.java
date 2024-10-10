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

    @GetMapping("/owner/{userId}")
    public List<Project> getProjectsByOwner(@PathVariable Long userId) {
        return projectService.findProjectsByOwner(userId);
    }

    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectService.findAllProjects();
    }

    @DeleteMapping("delete/{projectId}/{userId}")
    public void deleteprocess(@PathVariable Long projectId) {
        projectService.deletebyid(projectId);
    }

}
