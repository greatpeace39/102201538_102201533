package com.atguigu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Project {
    private Long id;
    private String title;
    private String description;
    private Long ownerId;
    private Integer numbers;

    // 无参构造方法
    public Project() {
    }

    // 全参构造方法
    public Project(Long id, String title, String description, Long ownerId, Integer numbers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
        this.numbers = numbers;
    }

    // Getter 和 Setter 方法

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    // 可选：toString 方法（用于调试，避免包含敏感信息）

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", ownerId=" + ownerId +
                ", numbers=" + numbers +
                '}';
    }
}
