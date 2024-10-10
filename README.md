# 开发环境搭建与使用指南

## 目录
1. [安装 JDK](#安装-jdk)
2. [安装 IntelliJ IDEA](#安装-intellij-idea)
3. [安装和配置 Maven](#安装和配置-maven)
4. [安装和配置 MySQL 数据库](#安装和配置-mysql-数据库)
5. [创建一个 Spring Boot 项目](#创建一个-spring-boot-项目)
6. [常见问题及解决方案](#常见问题及解决方案)

## 安装 JDK
1. 访问 Oracle JDK 下载页面：[Oracle JDK 下载](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)。
2. 选择适合您操作系统的 JDK 版本并下载（推荐 JDK 17）。
3. 安装 JDK，按照安装向导进行操作，选择默认路径或自定义安装路径。
4. 安装完成后，配置 `JAVA_HOME` 环境变量：
   - **Windows**: 
     1. 右键 `此电脑` → `属性` → `高级系统设置` → `环境变量`。
     2. 在 `系统变量` 中，点击 `新建`，输入：
        - 变量名: `JAVA_HOME`
        - 变量值: JDK 的安装路径，如 `C:\Program Files\Java\jdk-17`
     3. 在 `系统变量` 中找到 `Path`，点击 `编辑`，添加 `%JAVA_HOME%\bin`。
   - **macOS/Linux**: 编辑 `~/.bash_profile` 或 `~/.zshrc`，添加：
     ```bash
     export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home
     export PATH=$JAVA_HOME/bin:$PATH
     ```
5. 在终端中运行 `java -version`，检查是否成功安装。

## 安装 IntelliJ IDEA
1. 访问 JetBrains 官网：[IntelliJ IDEA 下载](https://www.jetbrains.com/idea/download/)。
2. 下载适合您操作系统的版本，建议选择 `Community` 版本（免费）。
3. 运行安装文件，按照默认步骤安装 IntelliJ IDEA。
4. 打开 IntelliJ IDEA，选择创建新项目或打开现有项目。

## 安装和配置 Maven
1. 访问 Maven 官网：[Maven 下载](https://maven.apache.org/download.cgi)。
2. 下载并解压 `Binary zip archive` 文件。
3. 配置 `MAVEN_HOME` 环境变量：
   - **Windows**:
     1. 右键 `此电脑` → `属性` → `高级系统设置` → `环境变量`。
     2. 点击 `新建`，输入：
        - 变量名: `MAVEN_HOME`
        - 变量值: Maven 的安装路径，如 `C:\Program Files\Apache\apache-maven-3.8.5`
     3. 编辑 `Path` 变量，添加 `%MAVEN_HOME%\bin`。
   - **macOS/Linux**: 编辑 `~/.bash_profile` 或 `~/.zshrc`，添加：
     ```bash
     export MAVEN_HOME=/path/to/maven
     export PATH=$MAVEN_HOME/bin:$PATH
     ```
4. 在终端中运行 `mvn -version` 检查 Maven 是否成功安装。

## 安装和配置 MySQL 数据库
1. 访问 MySQL 官网：[MySQL 下载](https://dev.mysql.com/downloads/installer/)。
2. 下载 `MySQL Community Server` 和 `MySQL Workbench`，适用于您的操作系统。
3. 运行安装程序，选择自定义安装，并选中 `MySQL Server` 和 `MySQL Workbench`。
4. 安装过程中会要求设置 **root 用户的密码**，记住该密码。
5. 安装完成后，启动 MySQL Server，并打开 MySQL Workbench 进行连接。
6. 在 MySQL Workbench 中，使用以下命令创建数据库：
   ```sql
   CREATE DATABASE project_management;
## 如何在本地运行本项目
1.调整maven配置，默认字符改为UTF-8，镜像源改为国内镜像源，并且在idea中使用下载的maven源，详细教程在这份文档中的第一章<https://www.wolai.com/fbnhGx8eE9JfZugFpbCWmC>
2.在本地创建一个数据库名为sm_db,并创建俩个表project，project_number。也可以在idea中实现数据库的可视化
    创建这俩个表的sql语句如下：
                            1：CREATE TABLE project (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    owner_id BIGINT NOT NULL,
    numbers INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 创建时间
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- 更新时间
);

                            2：CREATE TABLE project_number (
    user_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 创建时间
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- 更新时间
    PRIMARY KEY (user_id, project_id),  -- 复合主键
    FOREIGN KEY (project_id) REFERENCES project(id) ON DELETE CASCADE  -- 外键，项目删除时同步删除
);

3.运行文件中的main函数访问localhost：8080即可

## 声明
  如果还是无法运行请联系作者来帮你们配置环境，作者qq：2531136105
