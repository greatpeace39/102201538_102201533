package com.atguigu.serv;

import com.atguigu.mapper.ProjectNumberMapper;
import com.atguigu.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectNumberService {
    @Autowired
    private ProjectNumberMapper projectNumberMapper;


    //事务回滚注解
    @Transactional
    public void join(Long currentProjectId, Long userId){
        int count = projectNumberMapper.isJoined(currentProjectId, userId);
        if (count > 0) {
            throw new IllegalArgumentException("您已经加入该项目。");
        }
       projectNumberMapper.join(currentProjectId, userId);
       projectNumberMapper.addnumbers(currentProjectId);
    }
    int isJoined(Long projectId, Long userId) {
        return projectNumberMapper.isJoined(projectId, userId);
    }

    public List<Project> getNumber(Long userid) {return projectNumberMapper.getjionedbyid(userid);}

    public void exitbyuserid(Long projectId, Long userId) {
        projectNumberMapper.exitbyid(projectId,userId);
        projectNumberMapper.subnumbers(projectId);
    }

}
