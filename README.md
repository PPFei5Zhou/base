<!-- TOC -->
- [1. 基础框架搭建](#1-基础框架搭建)
  - [1.1. 相关 API Doc](#11-相关-api-doc)
  - [1.2. 环境搭建](#12-环境搭建)
    - [1.2.1. Java环境](#121-java环境)
      - [1.2.1.1. 下载 jdk](#1211-下载-jdk)
      - [1.2.1.2. 安装](#1212-安装)
      - [1.2.1.3. Windows 系统环境变量配置](#1213-windows-系统环境变量配置)
      - [1.2.1.4. 验证](#1214-验证)
    - [1.2.2. maven环境](#122-maven环境)
      - [1.2.2.1. 下载 Maven](#1221-下载-maven)
      - [1.2.2.2. 解压](#1222-解压)
      - [1.2.2.3. Windows 系统环境配置](#1223-windows-系统环境配置)
      - [1.2.2.4. Maven 配置](#1224-maven-配置)
  - [1.3. 创建 Spring Boot 项目](#13-创建-spring-boot-项目)
    - [1.3.1. 官网创建](#131-官网创建)
    - [1.3.2. IntelliJ IDEA 创建](#132-intellij-idea-创建)
    - [1.3.3. Visual Studio Code 创建](#133-visual-studio-code-创建)
  - [1.4. Spring Boot 项目目录结构](#14-spring-boot-项目目录结构)
    - [1.4.1. 简介](#141-简介)
  - [1.5. Spring Boot 项目配置](#15-spring-boot-项目配置)
    - [1.5.1. `application.yml`/`application.properties` 配置](#151-applicationymlapplicationproperties-配置)
      - [1.5.1.1. `yml` 和 `properties` 区别](#1511-yml-和-properties-区别)
      - [1.5.1.2. `application` 配置(以`yml`为例)](#1512-application-配置以yml为例)
    - [1.5.2. <span id='spanPomXML'>`pom.xml` 配置</span>](#152-pomxml-配置)
      - [1.5.2.1. 节点说明](#1521-节点说明)
    - [1.5.3. Maven 常用命令](#153-maven-常用命令)
  - [1.6. Spring Example](#16-spring-example)
    - [1.6.1. 命名规则 (建议按照以下规范进行编程)](#161-命名规则-建议按照以下规范进行编程)
    - [1.6.2. 配置项目 `MAVEN`](#162-配置项目-maven)
      - [1.6.2.1. 添加依赖](#1621-添加依赖)
      - [1.6.2.2. 打包静态资源](#1622-打包静态资源)
    - [1.6.3. 创建 数据传输类 及 数据访问类](#163-创建-数据传输类-及-数据访问类)
    - [1.6.4. 创建 MyBatis 数据访问逻辑](#164-创建-mybatis-数据访问逻辑)
    - [1.6.5. 创建 service](#165-创建-service)
    - [1.6.6. 对 `UserServiceImpl` 建立单元测试](#166-对-userserviceimpl-建立单元测试)
    - [1.6.7. 运行单元测试](#167-运行单元测试)
    - [1.6.8. 创建 控制器](#168-创建-控制器)
    - [1.6.9. 测试控制器](#169-测试控制器)
      - [1.6.9.1. 使用 IDEA 的 `PostMan`](#1691-使用-idea-的-postman)
    - [1.6.10. 整合 `Spring Data Jpa`](#1610-整合-spring-data-jpa)
      - [1.6.10.1. 添加依赖](#16101-添加依赖)
      - [1.6.10.2. 配置 `application.yml`](#16102-配置-applicationyml)
      - [1.6.10.3. 创建 `Entity` 类](#16103-创建-entity-类)
      - [1.6.10.4. 创建 `repository`](#16104-创建-repository)
      - [1.6.10.5. 扩展 `UserServiceImpl.java` 的 `listObjectFactory` 工厂方法](#16105-扩展-userserviceimpljava-的-listobjectfactory-工厂方法)
      - [1.6.10.6. 单元测试](#16106-单元测试)
      - [1.6.10.7. 多条件动态查询](#16107-多条件动态查询)
    - [1.6.11. 整合 Spring session](#1611-整合-spring-session)
      - [1.6.11.1. 安装redis](#16111-安装redis)
        - [1.6.11.1.1. 下载redis](#161111-下载redis)
        - [1.6.11.1.2. 安装redis](#161112-安装redis)
        - [1.6.11.1.3. 测试](#161113-测试)
      - [1.6.11.2. 添加依赖](#16112-添加依赖)
      - [1.6.11.3. 配置`application.yml`](#16113-配置applicationyml)
      - [1.6.11.4. 使用 Spring session](#16114-使用-spring-session)
        - [1.6.11.4.1. 在控制器中创建登录/获取用户/注销的方法](#161141-在控制器中创建登录获取用户注销的方法)
        - [1.6.11.4.2. 测试及验证](#161142-测试及验证)
    - [1.6.12. lombok](#1612-lombok)
      - [1.6.12.1. 官方文檔](#16121-官方文檔)
- [2. 异常处理](#2-异常处理)
  - [2.1. IDEA 开发环境中, 修改了 html, 浏览器中访问的 html 仍是修改前的版本](#21-idea-开发环境中-修改了-html-浏览器中访问的-html-仍是修改前的版本)
    - [2.1.1. 问题原因:](#211-问题原因)
    - [2.1.2. 解决办法:](#212-解决办法)
  - [2.2. 单元测试的异常](#22-单元测试的异常)
    - [2.2.1. 依赖注入失败](#221-依赖注入失败)

# 1. 基础框架搭建
[SVN源码地址](http://10.134.154.103/svn/CFAWeb/JAVA/Base) 

Tips: 
1. SVN地址可以在浏览器直接打开，登录后即可浏览，不建议登录时勾选记住密码 
2. README.md 文件在 SVN 中预览的效果可能不好

## 1.1. 相关 API Doc

1. [Java(TM) Platform, Standard Edition 8 API Specification](https://docs.oracle.com/javase/8/docs/api/)
2. [Java(TM) EE 7 Specification APIs](https://docs.oracle.com/javaee/7/api/overview-summary.html)
3. [Apache Tomcat 7.0.104 API](http://tomcat.apache.org/tomcat-7.0-doc/api/overview-summary.html)
4. [Spring Framework 5.2.6.RELEASE API](https://docs.spring.io/spring/docs/5.2.6.RELEASE/javadoc-api/)
5. [Spring Boot 2.3.0.RELEASE API](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/api/)
5. [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/2.3.0.RELEASE/reference/html/#reference)
6. [Hibernate JavaDoc (5.4.17.Final)](https://docs.jboss.org/hibernate/orm/5.4/javadocs/)

## 1.2. 环境搭建
### 1.2.1. Java环境
#### 1.2.1.1. 下载 jdk
[下载链接](https://www.java.com/en/download/windows-64bit.jsp)

#### 1.2.1.2. 安装

#### 1.2.1.3. Windows 系统环境变量配置
1. 添加系统变量 

    变量名称: `JAVA_HOME` 

    变量值: `{Java安装目录}`

2. 修改Path变量 
    
    变量值里添加: `%JAVA_HOME%\bin;`, `%JAVA_HOME%\jre\bin;`
    
#### 1.2.1.4. 验证 

CMD命令: `java -version`

### 1.2.2. maven环境
#### 1.2.2.1. 下载 Maven
[下载链接](https://mirror.bit.edu.cn/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)

#### 1.2.2.2. 解压
Tips: 解压目录中最好不要包含空格

#### 1.2.2.3. Windows 系统环境配置
1. 添加系统变量 

    (1). 变量名: `M2_HOME`变量值: `{maven解压目录}` 
    
    (2). 变量名: `MAVEN_HOME` 变量值: `{maven解压目录}`  
    
2. 修改Path变量 

    变量值里添加: `%MAVEN_HOME%\bin;` 
    
3. 验证 

    CMD 命令: `mvn -v`

#### 1.2.2.4. Maven 配置 

1. 配置文件所在目录: `D:\apache-maven-3.6.0\conf\settings.xml` 

2. 添加以下节点 (下面配置的`<settings />`不要复制)
    ```
    <settings>
        <!-- 本地仓目录设置 -->
        <localRepository>D:\rep</localRepository>
        
        <!-- 代理设置 -->
        <proxies>
            <proxy>
                <!-- 代理节点ID -->
                <id>company</id> 
                <!-- 启用此ID的代理设置,若配置并启用了多个代理设置,只会有一个代理设置生效 -->
                <active>true</active>
                <protocol>http</protocol>
                <username>{账号}</username>
                <password>{密码}</password>
                <!-- 代理服务器ip -->
                <host>{ip}</host>
                <!-- 代理服务器端口 -->
                <port>{port}</port>
                <nonProxyHosts>{不使用代理服务器访问的网址或ip}</nonProxyHosts>
            </proxy>
        </proxies>
        
        <!-- 私服/公共仓库配置, 获取时按先后顺序查询仓库 -->
        <mirrors>
            <!-- 下面两个是公网上的仓库, 内网可通过上面设置的代理访问 -->
            <mirror>
                <id>sprintio</id>
                <mirrorOf>central</mirrorOf>
                <name>Human Readable Name for this Mirror.</name>
                <url>https://repo.spring.io/libs-snapshot/</url>
            </mirror>
            <mirror>
                <id>alimaven</id>
                <name>aliyun maven</name>
                <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
                <mirrorOf>central</mirrorOf>        
            </mirror>
        </mirrors>
    </settings>
    ``` 

3. 配置文件其他节点配置可参阅[官方文檔](http://maven.apache.org/settings.html)

## 1.3. 创建 Spring Boot 项目
### 1.3.1. 官网创建
[官网](https://start.spring.io/) 

1. `Project` 选择 `Maven Project`
2. `Language` 选择 `Java`
3. `Spring Boot` 选择 `任一版本号(最好是不带SNAPSHOT的版本, SNAPSHOT版本不是稳定版本)`
4. `Project Metadata` 根据实际情况填写, 其中 

    `Packaging` 选择 `War`, 意思是Maven打包后生成War包 
    
    `Java` 选择 8 
    
5. `Dependencies` 根据实际情况选择相应的依赖(生成项目后,后续可以在项目的`pom.xml`文件里添加其他依赖 ) 
    
    此项目中初步选择了以下依赖包: 
    
    - `Spring Boot DevTools`
    - `Lombok` 此依赖包在IntelliJ IDEA 中打开时会提示要安装`Lombok`插件
    - `Spring Web`
    - `JDBC API`
    - `Spring Data JPA`
    - `MyBatis Framework`
    - `MS SQL Server Driver` 
    
6. 点击 `GENERATE` 即可下载项目压缩包

### 1.3.2. IntelliJ IDEA 创建
1. Create New Project
2. 选择左边菜单 `Spring Initializer` 
     
     `Project SDK` 选择计算机中的Java版本 
     
     `Choose starter service URL` 选择 `Default` 
     
     点击右下角 `Next`

3. Spring Initializr Project Settings 

    根据实际情况填写 `Group` `Artifact` `Version` `Name` `Description` 
    
    `Type` 选择 `Maven POM` 
    
    `Language` 选择 `Java` 
    
    `Packaging` 选择 `War` 
    
    `Java Version` 选择 `8` 
     
     点击右下角 `Next`
     
4. `Dependencies` 根据实际情况选择相应的依赖(生成项目后,后续可以在项目的`pom.xml`文件里添加其他依赖 ) 

    `Spring Boot` 选择 `任一版本号(最好是不带SNAPSHOT的版本, SNAPSHOT版本不是稳定版本)`

    此项目中初步选择了以下依赖包: 
    
    - `Spring Boot DevTools`
    - `Lombok` 此依赖包在IntelliJ IDEA 中打开时会提示要安装`Lombok`插件
    - `Spring Web`
    - `JDBC API`
    - `Spring Data JPA`
    - `MyBatis Framework`
    - `MS SQL Server Driver` 
    
    点击右下角 `Next` 

5. `Project location` 选择项目目录 
    
    点击右下角 `Finish` 

### 1.3.3. Visual Studio Code 创建
1. 安装Java开发的插件 `Java Extension Pack`
2. 安装Spring Boot的插件 `Spring Boot Extension Pack`
3. 环境设置 
 
    `Ctrl + Shift + p` 搜索 `settings.json` 

    添加以下节点
    ``` 
    "java.home": "{Java安装目录}\\jdk1.8.0_191",
    "java.configuration.maven.userSettings": "{Maven安装目录}\\conf\\settings.xml",
    "maven.executable.path": "{Maven安装目录}\\bin",
    ``` 
   
4. Ctrl+Shift+p打开终端，输入`Spring initializr: Generate Maven Project`创建项目
5. 后续的选择项和前面两种创建步骤类似

## 1.4. Spring Boot 项目目录结构
### 1.4.1. 简介 


    ·
    | HELP.md
    | mvnw
    | mvnw.cmd
    | pom.xml
    | README.md
    |
    └─ src
        | main
        |  ├─ java
        |  |   └─ com
        |  |       └─ wia
        |  |           └─ base
        |  |               |  BaseApplication.java
        |  |               |
        |  |               ├─ config
        |  |               |
        |  |               ├─ controller
        |  |               |   |  PageController.java
        |  |               |   |
        |  |               |   └─ UserController.java
        |  |               |
        |  |               ├─ dao
        |  |               |   | BaseMapper.java
        |  |               |   |
        |  |               |   ├─ mapper
        |  |               |   |   └─ UserMapper.java
        |  |               |   |
        |  |               |   └─ jpa
        |  |               |       └─ UserRepository.java
        |  |               |
        |  |               ├─ domain
        |  |               |   ├─ dao
        |  |               |   |   └─ UserInfoDAO.java
        |  |               |   |
        |  |               |   ├─ dto
        |  |               |   |   |  BaseDTO.java
        |  |               |   |   |  JsonResult.java
        |  |               |   |   └─ UserDTO.java
        |  |               |   |
        |  |               |   ├─ entity
        |  |               |   |   └─ UserInfoEntity.java
        |  |               |   |
        |  |               |   └─ vo
        |  |               |       └─ UserInfoEntity.java
        |  |               |
        |  |               ├─ service
        |  |               |   └─ impl
        |  |               |       | BaseService.java
        |  |               |       |
        |  |               |       └─ impl
        |  |               |           └─ UserServiceImpl.java
        |  |               |
        |  |               └─ utils
        |  └─ resources
        |      |  application.yml
        |      |  application-dev.yml
        |      |  application-prd.yml
        |      |  banner.txt
        |      |  logback-spring-dev.xml
        |      |  logback-spring-pro.xml
        |      |
        |      ├─ mappers
        |      |
        |      ├─ static
        |      |   ├─ js
        |      |   ├─ css
        |      |   ├─ layui
        |      |   └─ html
        |      |       |  login.html
        |      |       └─ index.html
        |      └─ templates
        |
        └─ test
            └─ java
                └─ com
                    └─ wia
                        └─ base
                            ├─ BaseApplicationTests.java
                            └─ ServiceTests.java


## 1.5. Spring Boot 项目配置
### 1.5.1. `application.yml`/`application.properties` 配置
#### 1.5.1.1. `yml` 和 `properties` 区别 

`yml`文件,通过 `:` 来分层,结构上有比较明显的层次感, 最后`key`赋值的 `:` 需要留一个空格 

`properties` 文件, 通过 `.` 来链接, 通过 `=` 来赋值, 没有分层的效果, 但比较直接 

两种文件的配置实现的效果是一样的, 区别只是在于写法不同 

([原文](https://www.jianshu.com/p/941aee2a99cf))
#### 1.5.1.2. `application` 配置(以`yml`为例) 

1. 主配置文件命名为: `application.yml` 

2. 其他配置文件的命名格式为: `application-{active}.yml`

3. 设置多个 `yml` 配置文件情况下,设置项目要使用的配置文件, `spring.profiles.active` 的值和配置文件后的{active}名称是一致的 

    如: 在`application.yml`配置以下信息, 则项目启动后, 会使用 `application-dev.yml` 配置文件
   ```
    spring:
      profiles:
       active: dev
    ``` 
   
4. 项目运行端口设置 

   ```
    server:
      port: {port}
    ``` 

5. 应用的上下文路径设置 (此设置的层级和端口设置的层级同属`server`下),[查看原文](https://blog.csdn.net/onedaycbfly/article/details/80108129)

    此设置是应用的上下文路径,也可以称项目路径,是构成url的一部分`http://{网址}/{context}` 
    
    ```
    server:
     port: {port} 
     servlet:
       context-path: /{context}
    ``` 
   
6. 项目数据库连接配置 

    6.1 SQL Server 配置 
    
    ```
    spring:
        datasource:
        driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
        url: jdbc:sqlserver://{ip}:{port};DatabaseName={DatabaseName}
        username: {username}
        password: {password}
    ``` 
   
    若使用Microsoft SQL Server(6.5，7，2000，2005，2008 和 2012)的版本, 可以使用`jtds`的`JDBC`驱动, 配置如下 

   ```
    spring:
      datasource:
        driver-class-name: net.sourceforge.jtds.jdbc.Driver
        url: jdbc:jtds:sqlserver://{ip}:{port};DatabaseName={DatabaseName}
        username: {username}
        password: {password}
        hikari:
          connection-test-query: SELECT 1
    ``` 

    其中 `spring.datasource.hikari.connection-test-query` 是因为
     `net.sourceforge.jtds.jdbc.JtdsConnection` 没有实现 `isValid` 方法，因此需要指定一个连接测试查询以确保不调用 `isValid` 方法
    [原文](https://stackoverflow.com/questions/42247864/configure-hikaricp-in-spring-boot-with-jtds) 

    在下一小节将会添加 `jtds` 驱动 maven 依赖(配置方式参考[`pom.xml` 配置](#spanPomXML)) 

    6.2 MYSQL 配置 
    
    ```
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/popkart?serverTimezone=UTC&characterEncoding=utf-8
       username: {username}
       password: {password}
   ``` 
   
   在下一小节将会添加MySQL驱动 maven 依赖 
   
7. `Session` 配置 

   ```
    server:
      servlet:
        session:
          timeout: 900
    ``` 
   
8. Log 日志配置

   ```
   logging:
     config: classpath:logback-spring-dev.xml 
   ```
   
9. mybatis 配置

   ```
   mybatis:
     type-aliases-package: com.easy.base.domain
     mapper-locations: "classpath:mappers/*.xml"
    ```
   
### 1.5.2. <span id='spanPomXML'>`pom.xml` 配置</span>
#### 1.5.2.1. 节点说明
1. `<packaging />`: 打包的机制, 如pom, jar, maven-plugin, ejb, war, ear, rar, par，默认为jar 
2. `<properties />`: 为pom定义一些常量，在pom中的其他地方可以直接引用, 使用方式如: `${file.encoding}`
3. `<dependencies />`: 定义项目的依赖关系 

    - `<dependency />`: 创建新的依赖, 也可以理解为导入jar包, 子节点如下所示, maven通过 `groupId`, `artifactId`, `version` 这三个子节点来检索构件, 然后引入到项目中. 可以到此[网站](https://mvnrepository.com/)搜索相应的jar包的maven依赖
    
        (1) `<groupId>`: 
        
        (2) `<artifactId>`:
        
        (3) `<version>`: 
        
        (4) `<scope>`: 取值可以是: compile(编译范围), provided(已提供范围), runtime(运行时范围), test(测试范围), system(系统范围) 
    
    - `<build />`: maven 构建配置 
        
        - `<resources />`

         - `<resource />` 配置项目相关的所有资源路径列表, 这些资源将会被打包到打包文件中, 如果没有配置此节点, 可能会出现静态资源404的情况 

         - `<directory />`: 资源所在目录, 路径是相对pom路径, 如 `src/main/resources/mappers/***.xml`, `src`和`pom.xml`是在同一级的目录中
         - `<includes />`: 包含的模式列表 
           - `<include />`: 如: `<include>**/*.yml</include>`, 意思是,匹配 `<directory />` 目录下的所有目录的扩展名是 `.yml` 的文件 
        
        - `<finalName />`: 打包文件的名称 

4. 其他配置, 可参阅:[博客](https://blog.csdn.net/qq_33363618/article/details/79438044)

### 1.5.3. Maven 常用命令
1. `mvn clean` 

    清除产生的项目 
   
2. `mvn package` 

    打包, 打包的war文件(这里的配置设置为war包)存放在项目目录的`target`中 

3.  `mvn dependency:copy-dependencies` 

    下载`pom.xml`中的依赖

4. 使用过程中的问题或其他命令使用方式, 请百度或谷歌 

## 1.6. Spring Example
### 1.6.1. 命名规则 (建议按照以下规范进行编程)
1. 所有编程相关命名均不能以下划线或美元符号开始, 也不能以下划线或美元符号结束 

    反例: 

    ```
    _name / __name / $Object / name_ / name$ / Object$
    ``` 

2. 所有编程相关命名严禁使用拼音与英文混合的方式 

3. 类名使用 `UpperCamelCase` 风格, 必须遵从驼峰形式, 但以下情形例外: (`domain` 模型相关命名) `DO/DTO/VO/DAO` 等 

4. 方法名, 参数名, 成员变量, 局部变量都统一使用 `lowerCamelCase` 风格, 必须遵从驼峰形式 

    正例: 

    ```
    localValue / getHttpMessage() /inputUserId
    ``` 

5. 常量命名全部大写, 单词间隔用下划线隔开, 语义力求表达完整清楚, 不要嫌命名过长 

    正例: 

    ```
    MAX_STOCK_COUNT
    ``` 

    反例: 

    ```
    MAX_COUNT
    ```

6. 抽象类命名使用 `Abstract` 或 `base` 开头; 异常类命名以 `Exception` 结尾; 测试类命名以测试的类的名称开始, 以 `Test` 结尾 

7. POJO类中的任何布尔类型的变量, 都不要加is, 否则部分框架解析会引起串行化错误

8. 报名同意使用小写, 点分隔符之间有且仅有一个自然语义的英语单词. 包名统一使用单数形式, 但是类名如果有复数含义, 类名可以使用复数形式 

    正例: 

    ```
    com.alibaba.mpp.util // 包名
    MessageUtils // 类名
    ``` 

9. 其他编程规范参考[阿里Java开发规范手册](https://blog.csdn.net/qiagua8198/article/details/79678092) 

### 1.6.2. 配置项目 `MAVEN` 

#### 1.6.2.1. 添加依赖

在建立项目时已添加的依赖基础上, 添加以下依赖: 

  ```
  <dependencies>
      <dependency>
          <groupId>net.sourceforge.jtds</groupId>
          <artifactId>jtds</artifactId>
          <version>1.3.1</version>
      </dependency>
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <scope>runtime</scope>
      </dependency>
      <dependency>
          <groupId>org.mybatis.spring.boot</groupId>
          <artifactId>mybatis-spring-boot-starter-test</artifactId>
          <version>2.1.2</version>
          <scope>test</scope>
      </dependency>
      <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>4.13</version>
          <scope>test</scope>
      </dependency>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-test</artifactId>
          <scope>test</scope>
          <exclusions>
              <exclusion>
                  <groupId>org.junit.vintage</groupId>
                  <artifactId>junit-vintage-engine</artifactId>
              </exclusion>
          </exclusions>
      </dependency>
  </dependencies>
  ``` 

这些依赖包含了 `jtds` (用于连接 SQL server 2008及旧版的 SQL server), 和 `Junit` , `MyBatis` (用于单元测试) 

添加依赖后, 在项目目录中打开PowerShell, 执行以下命令, 将依赖下载到项目中 

  ```
  mvn dependency:copy-dependencies
  ```

#### 1.6.2.2. 打包静态资源 

在 `<build>` 标签中添加以下节点 

  ```
  <resources>
    <resource>
        <directory>src/main/resources</directory>
        <includes>
            <include>**/*.txt</include>
            <include>**/*.xml</include>
            <include>**/*.properties</include>
            <include>**/*.yml</include>
            <include>**/*.html</include>
            <include>**/*.js</include>
            <include>**/*.css</include>
            <include>**/*.woff</include>
            <include>**/*.woff2</include>
            <include>**/*.ttf</include>
            <include>**/*.gif</include>
            <include>**/*.png</include>
            <include>**/*.ico</include>
        </includes>
    </resource>
  </resources>
  ```

### 1.6.3. 创建 数据传输类 及 数据访问类 

1. 创建 `BaseDTO` 类 
    
    在 `domain` 包中创建 `BaseDTO` 类 

    其他的DTO类可以继承此类, 可以阅读 [java 继承](https://www.runoob.com/java/java-inheritance.html)

    - `@Data` 批注是 lombok 提供的功能, 默认生成类中所有属性的 `getter/setter` 方法, 以及重写 `toString()`, `equals()`, `hashCode()` 方法

2. 创建 `ResponseDTO`类 

    在 `domain/dto` 包中创建 `ResponseDTO` 类 

    给 service 层或其他层返回指定的类型

    - `@NoArgsConstructor` 批注是 lombok 提供的功能, 生成无参构造器
    - `@Scope("prototype")` 批注是 spring 提供的批注, 意思是每次通过 spring 容器获取到的实例都是一个新的实例, 如果不设置改批注, 则默认是单例模式, 还有其他的值可以设置, 可参阅[@Scope说明](https://blog.csdn.net/ColdFireMan/article/details/100576702)
    - `@Component` 批注是 Spring 的批注, 实现 bean 注入功能, 一般是用于各种组件实例化, 另外相同功能的批注为: `@controller`, `@service`, `@repository`, 这三个批注意义和 `@Component` 不同, `@controller` 为控制器, `@service` 一般用于 service 层, `@repository` 一般用于数据访问层

3. 创建 `User` 相关的 `DTO` 和 `DAO` 类 

    `DAO` 是根据数据库表的字段来定义的类, 用于保存查询结果 

    在 `domain.dao` 包中创建 `UserInfoDAO` 类 

    在 `domain.dto` 包中创建 `UserDTO` 类, 继承 `BaseDTO` 类 

### 1.6.4. 创建 MyBatis 数据访问逻辑 

1. 创建 `BaseDAO` 接口 

    在 `dao` 包中创建接口

    ```
    package com.easy.base.dao;

    public interface BaseDAO {
        int saveObject();
        int updateObject();
        int removeObject();
    }
    ``` 

2. 创建 `UserMapper` 接口

    在 `dao.mapper` 包中创建接口 

    ```
    public interface UserMapper extends BaseMapper {
        @Override
        int saveObject();

        @Override
        int updateObject();

        @Override
        int removeObject();

        List<UserInfoDAO> listUser(UserDTO dto);
    }
    ``` 

3. 创建 `UserMapper` 接口对应的 xml 

    在 `resources/mappers` 活页夹创建 `UserMapper.xml` 

    - `<mapper>` 的 `namespace` 属性的值是 `UserMapper` 的全限定名
    - `<resultMap>` 自动映射查询结果, 可参阅[官方文檔](https://mybatis.org/mybatis-3/zh/sqlmap-xml.html#-mapping),
    `id` 属性的值是当前映像的名称, `type` 属性的值是要映像的类的全限定名 
    - `<id>` 和 `<result>` 的 `property` 属性是指映像的类的属性, `column` 属性是指表的字段名称(也可以是查询语句的别名)
    - `<id>` 是指表的主键 
    - `<sql>` 是可被其他语句引用的可重用语句块
    - `<insert>`, `<update>`, `<select>` 包含了 `id` 属性, `id`的值, 要和 `UserMapper` 接口的方法名一致 
    - `#{property}` 是 `UserMapper` 接口的方法的参数变量的名称, 如果参数是类类型, 则是对应类里的各个属性名 
    - `<trim>` 动态拼接 SQL 语句, `prefix` 属性是前缀, `suffixOverrides` 属性是移除多余的后缀, 其他属性可参阅
    - `<if>` 条件判断, `test` 属性是判断的条件
    [此博客](https://blog.csdn.net/weixin_34123613/article/details/93397418)
    - `<include>` 是引用 `<sql>` 的语句
    - `<where>` 可动态生成 where 条件的 SQL 语句 

### 1.6.5. 创建 service 
这里会使用到工厂模式, [Java多态](https://www.zhihu.com/question/30082151?sort=created)的知识 

1. 创建 `BaseService` 接口
    
    ```
    package com.easy.base.service;
    
    import com.easy.base.domain.dto.BaseDTO;
    import com.easy.base.domain.dto.JsonResult;
    
    public interface BaseService {
        ResponseDTO saveObject(BaseDTO dto);
        ResponseDTO updateObject(BaseDTO dto);
        ResponseDTO removeObject(BaseDTO dto);
        ResponseDTO getSingleObject(BaseDTO dto);
        ResponseDTO listObjectFactory(BaseDTO dto, String type);
    }
    ```
   
2. 实现 `BaseService` 接口 

    - 使用 `@Service` 批注 
    - 使用构造器方法注入依赖 

### 1.6.6. 对 `UserServiceImpl` 建立单元测试 

在 `src/test/java/com/wia/base` 目录下创建 `ServiceTests` 类 

1. `@RunWith(SpringRunner.class)` 

    - 让测试用例在 spring 容器环境中运行 
  
2. `@MapperScan` 

    - 扫描 MyBatis 的 mapper 接口类所在的包
    - 在编译之后都生成相应的实现类 
  
3. `@ComponentScan` 

      - 扫描指定的包下所有的配置类(使用了 `@Controller`, `@Service`, `@Component`, `@Repository` 批注的类) 
      - 注册到 spring 容器中

4. `@ConfigureTestDatabase(replace = ConfigureTestDatabase.Replace.NONE)` 

      - `ConfigureTestDatabase` 批注: 因为使用了 `@MybatisTest`, 所以会替换 spring 的数据源配置为虚拟数据源 
      - `ConfigureTestDatabase.Replace.NONE` 表示: 不替换数据源配置 
  
5. 单元测试的 `insert`, `update`, `delete` 和事务都会回滚

完整代码: 

### 1.6.7. 运行单元测试 
1. IntelliJ IDEA 

    - 在对应的测试方法左边有一个绿色的箭头, 点击后, 选 `Run '{方法名}()'`, 或选 `Debug '{方法名}()'`即可运行 
    - 右键点击方法名, 选 `Run '{方法名}()'`, 或选 `Debug '{方法名}()'` 

2. VSCode 

### 1.6.8. 创建 控制器 

1. 在 `controller` 包中创建 `UserController` 

    - `@Scope("session")` 表示控制器在每一个不同的 session 中都是不同的实例, 这个值需要 spring 是在 web 应用中
    - `@RestController` 表示控制器返回 JSON , XML 或其他文本, 而 `@Controller` 返回页面, [二者区别](https://www.jianshu.com/p/c89a3550588a)
    - `@RequestMapping(value = "/Login", method = RequestMethod.GET)` 
      - 此批注可以写在控制器类上和控制器的方法中
      - 写在控制器上, 则请求控制器里的方法, 都要在请求路径中加上对应的值, 如请求 `UserController` 的 `login()` 方法时, URL 要写成: `http://{ip}:{port}/User/Login`
      - `value` 表示映射值, 可以简写为: `@RequestMapping("/User")`
      - `method` 表示 `action` 的请求方式, 默认是 `GET`, 常用的有: `GET`, `POST`, `PUT`, `DELETE`

2. 在 `controller` 包中创建 `PageController` 

### 1.6.9. 测试控制器
#### 1.6.9.1. 使用 IDEA 的 `PostMan` 

### 1.6.10. 整合 `Spring Data Jpa` 

可以理解为 `.net` 中的 `EntityFramework` 框架, `Jpa` 可以将对象映像到数据库, 可以不用重复编写每个表的 `CRUD` 逻辑.

详细教程可以看
[官方文檔](https://docs.spring.io/spring-data/jpa/docs/2.3.0.RELEASE/reference/html/#reference)

#### 1.6.10.1. 添加依赖 

#### 1.6.10.2. 配置 `application.yml` 
  
  - `spring.jpa.hibernate.ddl-` 可赋值如下
  
    - `create`: 运行程序会新建表, 结束程序会清空表数据 
    - `create-drop`: 运行程序会新建表, 结束程序会删除表 
    - `update`: 运行程序如没有表则新建表, 表内数据不清空, 只更新 
    - `valid`: 运行程序会校验数据与数据库的字段类型是否相同, 不同会报错 
    
  - `spring.jpa.hibernate.naming.physical-strategy` 
  
    配置物理名称命名策略, `PhysicalNamingStrategyStandardImpl` 是直接映像, 不做处理 
    
  - `spring.jpa,properties.hibernate.dialect` 设置 Hibernate 的数据库方言(dialect) 

    设置方言是为了 Hibernate 可以根据数据库来识别 SQL 语句的差异

    可设置的值参考[官方文檔](https://docs.jboss.org/hibernate/orm/5.4/javadocs/)
  
    如果在连接 SQL server 2008 或更老的版本的数据库时候未配置方言, 在运行过程中会抛出下面的异常信息: 
    
    ```
    ...
    Caused by: org.hibernate.exception.SQLGrammarException: Unable to build DatabaseInformation
    ...
    Caused by: java.sql.SQLException: 无效的对象名称 'INFORMATION_SCHEMA.SEQUENCES'
    ```
  
`application.yml` 设置: 

```
spring:
  jpa:
    database: sql_server
    show-sql: true
    hibernate:
      ddl-: none
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    properties:
      hibernate:
        format_sql: true
``` 

`application-dev.yml` 设置: 

```
spring:
  jpa:
    properties:
      hibernate:
        dialect: "org.hibernate.dialect.SQLServer2008Dialect"
```

`application-prd.yml` 设置: 

```
spring:
  jpa:
    properties:
      hibernate:
        dialect: "org.hibernate.dialect.SQLServer2012Dialect"
```

#### 1.6.10.3. 创建 `Entity` 类

  - 在 `domain.entity` 创建类 `SYS_USERINFO` 
  - 添加 `@Data`, `@NoArgsConstructor`, `@Entity`, `@Table` 批注
  - 在主键的属性上使用 `@Id` 批注
  - 在属性中使用 `@Column` 批注, 指定持久属性或字段的映像列, 如果未指定任何列注释, 则使用默认值, 可阅读[官方文檔](https://docs.oracle.com/javaee/7/api/index.html?javax/persistence/Column.html)
  , 这里只罗列了这个例子中用到的属性 
    
    - `name`: 字段名称(非必要设置)
    - `unique`: 字段是否为唯一键, 默认值是 `false` 
    - `nullable`: 字段是否为空, 默认值是 `true`
    - `length`: 字段的长度
    - `columnDefinition`: 字段的类型 
    
#### 1.6.10.4. 创建 `repository` 

1. 在 `com/wia/base/dao/jpa` 创建 `UserRepository.java` 接口 

2. 接口继承 `JpaRepository<T, String>` 接口 

  `JpaRepository<T, String>` 接口包含了以下方法: 
  
  ```
  List<T> findAll();
  List<T> findAll(Sort var1);
  List<T> findAllById(Iterable<ID> var1);
  <S extends T> List<S> saveAll(Iterable<S> var1);
  void flush();
  <S extends T> S saveAndFlush(S var1);
  void deleteInBatch(Iterable<T> var1);
  void deleteAllInBatch();
  T getOne(ID var1);
  <S extends T> List<S> findAll(Example<S> var1);
  <S extends T> List<S> findAll(Example<S> var1, Sort var2);
  ``` 

  这些方法都可以直接调用, 若要自定义新的方法, 则在 `UserRepository` 接口中添加即可 
  
  假设要自定义查询方法, 方法名的命名规则如下 
  
  [官方文檔](https://docs.spring.io/spring-data/jpa/docs/2.3.0.RELEASE/reference/html/#jpa.query-methods)罗列的方法名关键词的列表 
  
  这里只展示一部分, 条件包括 `=`, `<>`, `>`, `>=`, `<`, `<=`, `AND`, `OR`, `LIKE`, `IS NULL`, `IS NOT NULL`, `ORDER BY` 


| Keyword | Sample | JPQL snippet |
| :-------- | :-------- | :-------- |
| `Is`, `Equals` | `findByFirstname`,`findByFirstnameIs`,`findByFirstnameEquals` | `… where x.firstname = ?1` |
| `Not` | `findByLastnameNot`,`findByFirstnameIs`,`findByFirstnameEquals` | `… where x.lastname <> ?1` |
| `GreaterThan` | `findByAgeGreaterThan` | `… where x.age > ?1` |
| `GreaterThanEqual` | `findByAgeGreaterThanEqual` | `… where x.age >= ?1` |
| `LessThan` | `findByAgeLessThan` | `… where x.age < ?1` |
| `LessThanEqual` | `findByAgeLessThanEqual` | `… where x.age <= ?1` |
| `AND` | `findByLastnameAndFirstname` | `… where x.lastname = ?1 and x.firstname = ?2` |
| `Or` | `findByLastnameOrFirstname` | `… where x.lastname = ?1 or x.firstname = ?2` |
| `Like` | `findByFirstnameLike` | `… where x.firstname like ?1` |
| `StartingWith` | `findByFirstnameStartingWith` | `… where x.firstname like ?1` (parameter bound with appended `%`) |
| `EndingWith` | `findByFirstnameEndingWith` | `… where x.firstname like ?1` (parameter bound with prepended `%`) |
| `Containing` | `findByFirstnameContaining` | `… where x.firstname like ?1` (parameter bound wrapped in `%`)) |
| `IsNull`, `Null` | `findByAge(Is)Null` | `… where x.age is null` |
| `IsNotNull`, `NotNull` | `findByAge(Is)NotNull` | `… where x.age not null` |
| `OrderBy` | `findByAgeOrderByLastnameDesc` | `… where x.age = ?1 order by x.lastname desc` |



#### 1.6.10.5. 扩展 `UserServiceImpl.java` 的 `listObjectFactory` 工厂方法 

#### 1.6.10.6. 单元测试 

1. 单元测试类的批注 把 `@MybatisTest` 改成 `@SpringBootTest` 

    因为 `@MybatisTest` 尽支持 MyBatis 的测试, 没有集成 jpa 的相关环境 
  
#### 1.6.10.7. 多条件动态查询 

可参阅下面两篇文章（待验证）

1. [Spring-Data-JPA criteria 查询](https://www.jianshu.com/p/0939cec7e207)
2. [Spring-Data-JPA 动态查询黑科技](https://www.jianshu.com/p/dbdf04070243)

### 1.6.11. 整合 Spring session 

#### 1.6.11.1. 安装redis 
 
##### 1.6.11.1.1. 下载redis 

##### 1.6.11.1.2. 安装redis 
1. Linux环境 

2. Windows环境 

    - [下载链接](https://github.com/tporadowski/redis/releases) 
    - 解压缩包, 并将目录重命名为 `redis`
    - 在目录中运行 cmd 命令: `.\redis-server.exe redis.windows.conf`(不要关闭此cmd窗口)
    
##### 1.6.11.1.3. 测试 
1. Linux环境 

2. Windows环境 

    - 在 `redis` 目录中运行 cmd 命令: `.\redis-cli.exe -h 127.0.0.1 -p 6379`
    - 设置键值对: `set myKey abc`
    - 获取键值对: `get myKey`

#### 1.6.11.2. 添加依赖 

```
<dependencies>
    <dependency>
        <groupId>org.springframework.session</groupId>
        <artifactId>spring-session-data-redis</artifactId>
    </dependency>
    <dependency>
        <groupId>redis.clients</groupId>
        <artifactId>jedis</artifactId>
        <version>3.3.0</version>
    </dependency>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-pool2</artifactId>
        <version>2.8.0</version>
    </dependency>
</dependencies>
``` 

下载依赖: `mvn dependency:copy-dependencies` 

重新打包: `mvn clean package`

#### 1.6.11.3. 配置`application.yml` 

1. Spring Boot 的配置 

```
spring.session.store-type=redis # Session store type.
server.servlet.session.timeout= # Session timeout. If a duration suffix is not specified, seconds is used.
spring.session.redis.flush-mode=on_save # Sessions flush mode.
spring.session.redis.namespace=spring:session # Namespace for keys used to store sessions.
``` 

2. Redis 连接配置 

```
spring.redis.host=localhost # Redis server host.
spring.redis.password= # Login password of the redis server.
spring.redis.port=6379 # Redis server port.
spring.redis.database=0 # Redis server port.
```

#### 1.6.11.4. 使用 Spring session 

##### 1.6.11.4.1. 在控制器中创建登录/获取用户/注销的方法

```
public class UserController {
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public ResponseDTO login(HttpServletRequest request, String account, String password) {
        HttpSession session = request.getSession();
        ResponseDTO jsonResult = new ResponseDTO();
        UserDTO userDTO = new UserDTO(account, password);
        userDTO.setMethodName("login");
        ResponseDTO result = userService.listObjectFactory(userDTO);
        UserInfoEntity userinfo = (UserInfoEntity)result.getObj();
        UserInfoEntity sessionObj = (UserInfoEntity)session.getAttribute("User");
        if (Objects.equals(sessionObj, userinfo)) {
            jsonResult.setObject(sessionObj);
        } else {
            session.setAttribute("User", userinfo);
            jsonResult.setObject(userinfo);
        }
        jsonResult.setResult(true);
        return jsonResult;
    }
    
    @RequestMapping(value = "/Logout", method = RequestMethod.POST)
    public ResponseDTO logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ResponseDTO jsonResult = new ResponseDTO();
        UserInfoEntity sessionObj = (UserInfoEntity)session.getAttribute("User");
        if (sessionObj != null) {
            session.removeAttribute("User");
        }
        jsonResult.setResult(true);
        return jsonResult;
    }
    
    @RequestMapping(value = "/GetSessionUser", method = RequestMethod.GET)
    public ResponseDTO getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ResponseDTO jsonResult = new ResponseDTO();
        UserInfoEntity sessionObj = (UserInfoEntity)session.getAttribute("User");
        if (sessionObj != null) {
            jsonResult.setResult(true);
            jsonResult.setObject(sessionObj);
        } else {
            jsonResult.setResult(false);
            session.removeAttribute("User");
        }
        return jsonResult;
    }
}
```

##### 1.6.11.4.2. 测试及验证 

1. postman 中调用控制器的登录方法 
2. 在 `redis` 目录中运行 cmd 命令: `.\redis-cli.exe -h 127.0.0.1 -p 6379`
3. 执行 `keys '*'` 命令, 可看到 `spring:session` 相关的 key 
4. postman 中调用控制器的获取用户方法,可看到返回的用户信息 
5. 执行 `del {keys}` 命令,其中, `keys`是`3.`中执行结果的前缀`spring:session:sessions:{...}`的key
6. postman 中调用控制器的获取用户方法,此时返回的用户信息为null

### 1.6.12. lombok
#### 1.6.12.1. 官方文檔
[链接](https://projectlombok.org/features/all)

# 2. 异常处理
## 2.1. IDEA 开发环境中, 修改了 html, 浏览器中访问的 html 仍是修改前的版本 
### 2.1.1. 问题原因: 
1. maven 打包的文件还是修改前的文件 
2. IDEA 自身的毛病 

### 2.1.2. 解决办法: 
1. 针对上述的原因1, 每次启动项目前, 都执行一次 maven 打包指令 `mvn clean package`
2. 重启 IDEA
3. 清除 IDEA 的设置缓存: `File -> Invalidate caches / Restart -> Invalidate / Restart` 

## 2.2. 单元测试的异常
### 2.2.1. 依赖注入失败
1. 编译程序DEBUG日志 

```
java.lang.IllegalStateException: Failed to load ApplicationContext
...
Caused by: 
  org.springframework.beans.factory.UnsatisfiedDependencyException: 
    Error creating bean with name '{类名}' defined in file [类文件路径]:
      Unsatisfied dependency expressed through constructor parameter 1; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException:
        No qualifying bean of type '{类全路径名}' available:
          expected at least 1 bean which qualifies as wire candidate. Dependency annotations: {}
``` 

2. 解决思路 

  - 排查 `@ComponentScan` 是否包含了用到的包, 如果是 `@ComponentScan("com.easy.base.*")` 那么, spring会扫描 `base` 下批注为 `@Service`, `@Repository`, `@Component` 类, 如果是 `@ComponentScan("com.easy.base.service.*")` 那么只会扫描 `service` 包里的批注为 `@Service`, `@Repository`, `@Component` 的类
