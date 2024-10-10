package com.atguigu.mapper;


import com.atguigu.pojo.Project;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ProjectMapper {
    @Insert("INSERT INTO project(title, description, owner_id) VALUES(#{title}, #{description}, #{ownerId})")
    @Options(useGeneratedKeys = true, keyProperty = "id") //
    void createProject(Project project);

    @Select("SELECT * FROM project WHERE owner_id = #{ownerId}")
    List<Project> findProjectsByOwner(Long ownerId);

    @Select("SELECT * FROM project")
    List<Project> findAllProjects();

    @Delete("DELETE FROM project where id  = #{projextId}")
    void deleteByProject(Long projectId);
}
