package com.atguigu.controller;

import com.atguigu.serv.ProjectNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectNumberController {
    @Autowired
    private ProjectNumberService projectNumberService;

    @PostMapping("join/{currentProjectId}")
    public void join(@PathVariable Long currentProjectId, @RequestBody Map<String, Long> payload){

        try {
            projectNumberService.join(currentProjectId, payload.get("userId"));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
