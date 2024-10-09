package com.atguigu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProjectNumberMapper {
    @Select("SELECT COUNT(*) from project_number WHERE project_id = #{projectId} AND user_id = #{userId}")
    int isJoined(Long projectId, Long userId);

     @Insert("INSERT INTO project_number(project_id, user_id) VALUES(#{projectId}, #{userId})")
    void join(Long projectId, Long userId);

    @Update("update project set numbers = numbers + 1 where id = #{currentId} ")
    void updatanumbers(Long currentId);
}
