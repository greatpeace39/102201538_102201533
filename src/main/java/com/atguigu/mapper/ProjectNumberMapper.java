package com.atguigu.mapper;

import com.atguigu.pojo.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectNumberMapper {
    @Select("SELECT COUNT(*) from project_number WHERE project_id = #{projectId} AND user_id = #{userId}")
    int isJoined(Long projectId, Long userId);

     @Insert("INSERT INTO project_number(project_id, user_id) VALUES(#{projectId}, #{userId})")
    void join(Long projectId, Long userId);

    @Update("update project set numbers = numbers + 1 where id = #{currentId} ")
    void addnumbers(Long currentId);

    @Update("update project set numbers = numbers - 1 where id = #{currentId} ")
    void subnumbers(Long currentId);

    @Select("SELECT * FROM project WHERE id IN (SELECT project_id FROM project_number WHERE user_id = #{userProjectId})")
    List<Project> getjionedbyid(Long userProjectId);

    @Delete("delete from project_number WHERE project_id = #{projectId} AND user_id = #{userId} ")
    void exitbyid(Long  projectId, Long userId);
}
