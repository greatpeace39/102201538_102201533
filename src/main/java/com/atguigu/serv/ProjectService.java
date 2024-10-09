package com.atguigu.serv;


import com.atguigu.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.mapper.ProjectMapper;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public void createProject(Project project) {
        projectMapper.createProject(project);
    }

    public List<Project> findProjectsByOwner(Long ownerId) {
        return projectMapper.findProjectsByOwner(ownerId);
    }

    public List<Project> findAllProjects() {
        return projectMapper.findAllProjects();
    }
}
