package com.atguigu.controller;

import com.atguigu.pojo.Project;
import com.atguigu.serv.ProjectNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectNumberController {
    @Autowired
    private ProjectNumberService projectNumberService;

    @PostMapping("join/{currentProjectId}")
    public boolean join(@PathVariable Long currentProjectId, @RequestBody Map<String, Long> payload){
            projectNumberService.join(currentProjectId, payload.get("userId"));
            return true;
    }
    @GetMapping("joined/{userId}")
    public List<Project> getNumber(@PathVariable Long userId){
        return projectNumberService.getNumber(userId);
    }
    //退出项目
    @PostMapping("exit/{projectId}")
    public void exit(@PathVariable Long projectId ,@RequestBody Map<String, Long> payload) {
        projectNumberService.exitbyuserid(projectId, payload.get("userId"));
    }
}
