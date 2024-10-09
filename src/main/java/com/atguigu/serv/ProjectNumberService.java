package com.atguigu.serv;

import com.atguigu.mapper.ProjectNumberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectNumberService {
    @Autowired
    private ProjectNumberMapper projectNumberMapper;


    //事务回滚注解
    @Transactional
    public void join(Long currentProjectId, Long userId){
        int count = projectNumberMapper.isJoined(currentProjectId, userId);
        if (count > 1) {
            throw new IllegalArgumentException("您已经加入该项目。");
        }
       projectNumberMapper.join(currentProjectId, userId);
       projectNumberMapper.updatanumbers(currentProjectId);
    }
    int isJoined(Long projectId, Long userId) {
        return projectNumberMapper.isJoined(projectId, userId);
    }
}
