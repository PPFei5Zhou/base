<!-- TOC -->

- [1. 基礎框架搭建](#1-基礎框架搭建)
    - [1.1. 相關 API Doc](#11-相關-api-doc)
    - [1.2. 環境搭建](#12-環境搭建)
        - [1.2.1. Java環境](#121-java環境)
            - [1.2.1.1. 下載 jdk](#1211-下載-jdk)
            - [1.2.1.2. 安裝](#1212-安裝)
            - [1.2.1.3. Windows 系統環境變量配置](#1213-windows-系統環境變量配置)
            - [1.2.1.4. 驗證](#1214-驗證)
        - [1.2.2. maven環境](#122-maven環境)
            - [1.2.2.1. 下載 Maven](#1221-下載-maven)
            - [1.2.2.2. 解壓](#1222-解壓)
            - [1.2.2.3. Windows 系統環境配置](#1223-windows-系統環境配置)
            - [1.2.2.4. Maven 配置](#1224-maven-配置)
    - [1.3. 創建 Spring Boot 項目](#13-創建-spring-boot-項目)
        - [1.3.1. 官網創建](#131-官網創建)
        - [1.3.2. IntelliJ IDEA 創建](#132-intellij-idea-創建)
        - [1.3.3. Visual Studio Code 創建](#133-visual-studio-code-創建)
    - [1.4. Spring Boot 項目目錄結構](#14-spring-boot-項目目錄結構)
        - [1.4.1. 簡介](#141-簡介)
    - [1.5. Spring Boot 項目配置](#15-spring-boot-項目配置)
        - [1.5.1. `application.yml`/`application.properties` 配置](#151-applicationymlapplicationproperties-配置)
            - [1.5.1.1. `yml` 和 `properties` 區別](#1511-yml-和-properties-區別)
            - [1.5.1.2. `application` 配置(以`yml`為例)](#1512-application-配置以yml為例)
                - [1.5.1.2.1. 主配置文件命名為: `application.yml`](#15121-主配置文件命名為-applicationyml)
                - [1.5.1.2.2. 其他配置文件的命名格式為: `application-{active}.yml`](#15122-其他配置文件的命名格式為-application-activeyml)
        - [1.5.2. <span id='spanPomXML'>`pom.xml` 配置</span>](#152-span-idspanpomxmlpomxml-配置span)
            - [1.5.2.1. 節點說明](#1521-節點說明)
        - [1.5.3. Maven 常用命令](#153-maven-常用命令)
    - [1.6. Spring Example](#16-spring-example)
        - [1.6.1. 命名規則 (建議按照以下規範進行編程)](#161-命名規則-建議按照以下規範進行編程)
        - [1.6.2. 配置項目 `MAVEN`](#162-配置項目-maven)
            - [1.6.2.1. 添加依賴](#1621-添加依賴)
            - [1.6.2.2. 打包靜態資源](#1622-打包靜態資源)
        - [1.6.3. 創建 數據傳輸類 及 數據訪問類](#163-創建-數據傳輸類-及-數據訪問類)
        - [1.6.4. 創建 MyBatis 數據訪問邏輯](#164-創建-mybatis-數據訪問邏輯)
        - [1.6.5. 創建 service](#165-創建-service)
        - [1.6.6. 對 `UserServiceImpl` 建立單元測試](#166-對-userserviceimpl-建立單元測試)
        - [1.6.7. 運行單元測試](#167-運行單元測試)
        - [1.6.8. 創建 控制器](#168-創建-控制器)
        - [1.6.9. 測試控制器](#169-測試控制器)
            - [1.6.9.1. 使用 IDEA 的 `PostMan`](#1691-使用-idea-的-postman)
        - [1.6.10. 整合 `Spring Data Jpa`](#1610-整合-spring-data-jpa)
            - [1.6.10.1. 添加依賴](#16101-添加依賴)
            - [1.6.10.2. 配置 `application.yml`](#16102-配置-applicationyml)
            - [1.6.10.3. 創建 `Entity` 類](#16103-創建-entity-類)
            - [1.6.10.4. 創建 `repository`](#16104-創建-repository)
            - [1.6.10.5. 擴展 `UserServiceImpl.java` 的 `listObjectFactory` 工廠方法](#16105-擴展-userserviceimpljava-的-listobjectfactory-工廠方法)
            - [1.6.10.6. 單元測試](#16106-單元測試)
            - [1.6.10.7. 多條件動態查詢](#16107-多條件動態查詢)
        - [1.6.11. 整合 Spring session](#1611-整合-spring-session)
            - [1.6.11.1. 安装redis](#16111-安装redis)
                - [1.6.11.1.1. 下载redis](#161111-下载redis)
                - [1.6.11.1.2. 安装redis](#161112-安装redis)
                - [1.6.11.1.3. 測試](#161113-測試)
            - [1.6.11.2. 添加依賴](#16112-添加依賴)
            - [1.6.11.3. 配置`application.yml`](#16113-配置applicationyml)
            - [1.6.11.4. 使用 Spring session](#16114-使用-spring-session)
                - [1.6.11.4.1. 在控制器中創建登錄/獲取用戶/注銷的方法](#161141-在控制器中創建登錄獲取用戶注銷的方法)
                - [1.6.11.4.2. 測試及驗證](#161142-測試及驗證)
        - [1.6.12. lombok](#1612-lombok)
            - [1.6.12.1. 官方文檔](#16121-官方文檔)
- [2. 異常處理](#2-異常處理)
    - [2.1. IDEA 開發環境中, 修改了 html, 瀏覽器中訪問的 html 仍是修改前的版本](#21-idea-開發環境中-修改了-html-瀏覽器中訪問的-html-仍是修改前的版本)
        - [2.1.1. 問題原因:](#211-問題原因)
        - [2.1.2. 解決辦法:](#212-解決辦法)
    - [2.2. 單元測試的異常](#22-單元測試的異常)
        - [2.2.1. 依賴注入失敗](#221-依賴注入失敗)

<!-- /TOC -->

# 1. 基礎框架搭建
[SVN源碼地址](http://10.134.154.103/svn/CFAWeb/JAVA/Base) 

Tips: 
1. SVN地址可以在瀏覽器直接打開，登錄后即可瀏覽，不建議登錄時勾選記住密碼 
2. README.md 文件在 SVN 中預覽的效果可能不好

## 1.1. 相關 API Doc

1. [Java(TM) Platform, Standard Edition 8 API Specification](https://docs.oracle.com/javase/8/docs/api/)
2. [Java(TM) EE 7 Specification APIs](https://docs.oracle.com/javaee/7/api/overview-summary.html)
3. [Apache Tomcat 7.0.104 API](http://tomcat.apache.org/tomcat-7.0-doc/api/overview-summary.html)
4. [Spring Framework 5.2.6.RELEASE API](https://docs.spring.io/spring/docs/5.2.6.RELEASE/javadoc-api/)
5. [Spring Boot 2.3.0.RELEASE API](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/api/)
5. [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/2.3.0.RELEASE/reference/html/#reference)
6. [Hibernate JavaDoc (5.4.17.Final)](https://docs.jboss.org/hibernate/orm/5.4/javadocs/)

## 1.2. 環境搭建
### 1.2.1. Java環境
#### 1.2.1.1. 下載 jdk
[下載鏈接](https://www.java.com/en/download/windows-64bit.jsp)

#### 1.2.1.2. 安裝

#### 1.2.1.3. Windows 系統環境變量配置
1. 添加系統變量 

    變量名稱: `JAVA_HOME` 

    變量值: `{Java安裝目錄}`

2. 修改Path變量 
    
    變量值裡添加: `%JAVA_HOME%\bin;`, `%JAVA_HOME%\jre\bin;`
    
#### 1.2.1.4. 驗證 

CMD命令: `java -version`

### 1.2.2. maven環境
#### 1.2.2.1. 下載 Maven
[下載鏈接](https://mirror.bit.edu.cn/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)

#### 1.2.2.2. 解壓
Tips: 解壓目錄中最好不要包含空格

#### 1.2.2.3. Windows 系統環境配置
1. 添加系統變量 

    (1). 變量名: `M2_HOME`變量值: `{maven解壓目錄}` 
    
    (2). 變量名: `MAVEN_HOME` 變量值: `{maven解壓目錄}`  
    
2. 修改Path變量 

    變量值裡添加: `%MAVEN_HOME%\bin;` 
    
3. 驗證 

    CMD 命令: `mvn -v`

#### 1.2.2.4. Maven 配置 

1. 配置文件所在目錄: `D:\apache-maven-3.6.0\conf\settings.xml` 

2. 添加以下節點 (下面配置的`<settings />`不要複製)
    ```
    <settings>
        <!-- 本地倉目錄設置 -->
        <localRepository>D:\rep</localRepository>
        
        <!-- 代理設置 -->
        <proxies>
            <proxy>
                <!-- 代理節點ID -->
                <id>company</id> 
                <!-- 啟用此ID的代理設置,若配置並啟用了多個代理設置,只會有一個代理設置生效 -->
                <active>true</active>
                <protocol>http</protocol>
                <username>{賬號}</username>
                <password>{密碼}</password>
                <!-- 代理服務器ip -->
                <host>{ip}</host>
                <!-- 代理服務器端口 -->
                <port>{port}</port>
                <nonProxyHosts>{不使用代理服務器訪問的網址或ip}</nonProxyHosts>
            </proxy>
        </proxies>
        
        <!-- 私服/公共倉庫配置, 獲取時按先後順序查詢倉庫 -->
        <mirrors>
            <!-- 下面兩個是公網上的倉庫, 內網可通過上面設置的代理訪問 -->
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

3. 配置文件其他節點配置可參閱[官方文檔](http://maven.apache.org/settings.html)

## 1.3. 創建 Spring Boot 項目
### 1.3.1. 官網創建
[官網](https://start.spring.io/) 

1. `Project` 選擇 `Maven Project`
2. `Language` 選擇 `Java`
3. `Spring Boot` 選擇 `任一版本號(最好是不帶SNAPSHOT的版本, SNAPSHOT版本不是穩定版本)`
4. `Project Metadata` 根據實際情況填寫, 其中 

    `Packaging` 選擇 `War`, 意思是Maven打包後生成War包 
    
    `Java` 選擇 8 
    
5. `Dependencies` 根據實際情況選擇相應的依賴(生成項目後,後續可以在項目的`pom.xml`文件裡添加其他依賴 ) 
    
    此項目中初步選擇了以下依賴包: 
    
    - `Spring Boot DevTools`
    - `Lombok` 此依賴包在IntelliJ IDEA 中打開時會提示要安裝`Lombok`插件
    - `Spring Web`
    - `JDBC API`
    - `Spring Data JPA`
    - `MyBatis Framework`
    - `MS SQL Server Driver` 
    
6. 點擊 `GENERATE` 即可下載項目壓縮包

### 1.3.2. IntelliJ IDEA 創建
1. Create New Project
2. 選擇左邊菜單 `Spring Initializer` 
     
     `Project SDK` 選擇電腦中的Java版本 
     
     `Choose starter service URL` 選擇 `Default` 
     
     點擊右下角 `Next`

3. Spring Initializr Project Settings 

    根據實際情況填寫 `Group` `Artifact` `Version` `Name` `Description` 
    
    `Type` 選擇 `Maven POM` 
    
    `Language` 選擇 `Java` 
    
    `Packaging` 選擇 `War` 
    
    `Java Version` 選擇 `8` 
     
     點擊右下角 `Next`
     
4. `Dependencies` 根據實際情況選擇相應的依賴(生成項目後,後續可以在項目的`pom.xml`文件裡添加其他依賴 ) 

    `Spring Boot` 選擇 `任一版本號(最好是不帶SNAPSHOT的版本, SNAPSHOT版本不是穩定版本)`

    此項目中初步選擇了以下依賴包: 
    
    - `Spring Boot DevTools`
    - `Lombok` 此依賴包在IntelliJ IDEA 中打開時會提示要安裝`Lombok`插件
    - `Spring Web`
    - `JDBC API`
    - `Spring Data JPA`
    - `MyBatis Framework`
    - `MS SQL Server Driver` 
    
    點擊右下角 `Next` 

5. `Project location` 選擇項目目錄 
    
    點擊右下角 `Finish` 

### 1.3.3. Visual Studio Code 創建
1. 安裝Java開發的插件 `Java Extension Pack`
2. 安裝Spring Boot的插件 `Spring Boot Extension Pack`
3. 環境設置 
 
    `Ctrl + Shift + p` 搜索 `settings.json` 

    添加以下節點
    ``` 
    "java.home": "{Java安裝目錄}\\jdk1.8.0_191",
    "java.configuration.maven.userSettings": "{Maven安裝目錄}\\conf\\settings.xml",
    "maven.executable.path": "{Maven安裝目錄}\\bin",
    ``` 
   
4. Ctrl+Shift+p打開終端，輸入`Spring initializr: Generate Maven Project`创建项目
5. 後續的選擇項和前面兩種創建步驟類似

## 1.4. Spring Boot 項目目錄結構
### 1.4.1. 簡介 


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
        |  |               |   |   |  ResponseDTO.java
        |  |               |   |   └─ UserDTO.java
        |  |               |   |
        |  |               |   ├─ entity
        |  |               |   |   └─ SYS_USERINFO.java
        |  |               |   |
        |  |               |   └─ vo
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


## 1.5. Spring Boot 項目配置
### 1.5.1. `application.yml`/`application.properties` 配置
#### 1.5.1.1. `yml` 和 `properties` 區別 

`yml`文件,通過 `:` 來分層,結構上有比較明顯的層次感, 最後`key`賦值的 `:` 需要留一個空格 

`properties` 文件, 通過 `.` 來鏈接, 通過 `=` 來賦值, 沒有分層的效果, 但比較直接 

兩種文件的配置實現的效果是一樣的, 區別只是在於寫法不同 

([原文](https://www.jianshu.com/p/941aee2a99cf))
#### 1.5.1.2. `application` 配置(以`yml`為例) 

1. 主配置文件命名為: `application.yml` 

2. 其他配置文件的命名格式為: `application-{active}.yml`

3. 設置多個 `yml` 配置文件情況下,設置項目要使用的配置文件, `spring.profiles.active` 的值和配置文件後的{active}名稱是一致的 

    如: 在`application.yml`配置以下信息, 則項目啟動後, 會使用 `application-dev.yml` 配置文件
   ```
    spring:
      profiles:
       active: dev
    ``` 
   
4. 項目運行端口設置 

   ```
    server:
      port: {port}
    ``` 

5. 應用的上下文路徑設置 (此設置的層級和端口設置的層級同屬`server`下),[查看原文](https://blog.csdn.net/onedaycbfly/article/details/80108129)

    此設置是應用的上下文路徑,也可以稱項目路徑,是構成url的一部分`http://{網址}/{context}` 
    
    ```
    server:
     port: {port} 
     servlet:
       context-path: /{context}
    ``` 
   
6. 項目數據庫連接配置 

    6.1 SQL Server 配置 
    
    ```
    spring:
        datasource:
        driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
        url: jdbc:sqlserver://{ip}:{port};DatabaseName={DatabaseName}
        username: {username}
        password: {password}
    ``` 
   
    若使用Microsoft SQL Server(6.5，7，2000，2005，2008 和 2012)的版本, 可以使用`jtds`的`JDBC`驅動, 配置如下 

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

    其中 `spring.datasource.hikari.connection-test-query` 是因為
     `net.sourceforge.jtds.jdbc.JtdsConnection` 沒有實現 `isValid` 方法，因此需要指定一個連接測試查詢以確保不調用 `isValid` 方法
    [原文](https://stackoverflow.com/questions/42247864/configure-hikaricp-in-spring-boot-with-jtds) 

    使用 `jtds` 驅動,需要在 `pom.xml` 文件中添加以下依賴(配置方式參考[`pom.xml` 配置](#spanPomXML)) 

    ```
    <dependency>
        <groupId>net.sourceforge.jtds</groupId>
        <artifactId>jtds</artifactId>
        <version>1.3.1</version>
    </dependency>
    ```

    6.2 MYSQL 配置 
    
    ```
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/popkart?serverTimezone=UTC&characterEncoding=utf-8
       username: {username}
       password: {password}
   ``` 
   
   驱动 maven 依赖 
   
   ```
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <scope>runtime</scope>
   </dependency>
   ```

7. `Session` 配置 

   ```
    server:
      servlet:
        session:
          timeout: 900
    ``` 
   
8. Log 日志配置(這裡是引用本地開發時日誌配置文件) 

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
#### 1.5.2.1. 節點說明
1. `<packaging />`: 打包的機制, 如pom, jar, maven-plugin, ejb, war, ear, rar, par，默認為jar 
2. `<properties />`: 為pom定義一些常量，在pom中的其他地方可以直接引用, 使用方式如: `${file.encoding}`
3. `<dependencies />`: 定義項目的依賴關係 

    - `<dependency />`: 創建新的依賴, 也可以理解為導入jar包, 子節點如下所示, maven通過 `groupId`, `artifactId`, `version` 這三個子節點來檢索構件, 然後引入到項目中. 可以到此[網站](https://mvnrepository.com/)搜索相應的jar包的maven依賴
    
        (1) `<groupId>`: 
        
        (2) `<artifactId>`:
        
        (3) `<version>`: 
        
        (4) `<scope>`: 取值可以是: compile(編譯範圍), provided(已提供範圍), runtime(運行時範圍), test(測試範圍), system(系統範圍) 
    
    - `<build />`: maven 構建配置 
        
        - `<resources />`

         - `<resource />` 配置項目相關的所有資源路徑列表, 這些資源將會被打包到打包文件中, 如果沒有配置此節點, 可能會出現靜態資源404的情況 

         - `<directory />`: 資源所在目錄, 路徑是相對pom路徑, 如 `src/main/resources/mappers/***.xml`, `src`和`pom.xml`是在同一級的目錄中
         - `<includes />`: 包含的模式列表 
           - `<include />`: 如: `<include>**/*.yml</include>`, 意思是,匹配 `<directory />` 目錄下的所有目錄的擴展名是 `.yml` 的文件 
        
        - `<finalName />`: 打包文件的名稱 

4. 其他配置, 可參閱此[網站](https://blog.csdn.net/qq_33363618/article/details/79438044), 或搜索: pom.xml 配置

### 1.5.3. Maven 常用命令
1. `mvn clean` 

    清除產生的項目 
   
2. `mvn package` 

    打包, 打包的war文件(這裡的配置設置為war包)存放在項目目錄的`target`中 

3.  `mvn dependency:copy-dependencies` 

    下载`pom.xml`中的依賴

4. 使用過程中的問題或其他命令使用方式, 請百度或谷歌 

## 1.6. Spring Example
### 1.6.1. 命名規則 (建議按照以下規範進行編程)
1. 所有編程相關命名均不能以下劃線或美元符號開始, 也不能以下劃線或美元符號結束 

    反例: 

    ```
    _name / __name / $Object / name_ / name$ / Object$
    ``` 

2. 所有編程相關命名嚴禁使用拼音與英文混合的方式 

3. 類名使用 `UpperCamelCase` 風格, 必須遵從駝峰形式, 但以下情形例外: (`domain` 模型相關命名) `DO/DTO/VO/DAO` 等 

4. 方法名, 參數名, 成員變量, 局部變量都統一使用 `lowerCamelCase` 風格, 必須遵從駝峰形式 

    正例: 

    ```
    localValue / getHttpMessage() /inputUserId
    ``` 

5. 常量命名全部大寫, 單詞間隔用下劃線隔開, 語義力求表達完整清楚, 不要嫌命名過長 

    正例: 

    ```
    MAX_STOCK_COUNT
    ``` 

    反例: 

    ```
    MAX_COUNT
    ```

6. 抽象類命名使用 `Abstract` 或 `base` 開頭; 異常類命名以 `Exception` 結尾; 測試類命名以測試的類的名稱開始, 以 `Test` 結尾 

7. POJO類中的任何布爾類型的變量, 都不要加is, 否則部分框架解析會引起序列化錯誤

8. 報名同意使用小寫, 點分隔符之間有且僅有一個自然語義的英語單詞. 包名統一使用單數形式, 但是類名如果有複數含義, 類名可以使用複數形式 

    正例: 

    ```
    com.alibaba.mpp.util // 包名
    MessageUtils // 類名
    ``` 

9. 其他編程規範參考[阿里Java開發規範手冊](https://blog.csdn.net/qiagua8198/article/details/79678092) 

### 1.6.2. 配置項目 `MAVEN` 

#### 1.6.2.1. 添加依賴

在建立項目時已添加的依賴基礎上, 添加以下依賴: 

  ```
  <dependencies>
      <dependency>
          <groupId>net.sourceforge.jtds</groupId>
          <artifactId>jtds</artifactId>
          <version>1.3.1</version>
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

這些依賴包含了 `jtds` (用於連接 SQL server 2008及舊版的 SQL server), 和 `Junit` , `MyBatis` (用於單元測試) 

添加依賴後, 在項目目錄中打開PowerShell, 執行以下命令, 將依賴下載到項目中 

  ```
  mvn dependency:copy-dependencies
  ```

#### 1.6.2.2. 打包靜態資源 

在 `<build>` 標籤中添加以下節點 

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

### 1.6.3. 創建 數據傳輸類 及 數據訪問類 

1. 創建 `BaseDTO` 類 
    
    在 `domain` 包中創建 `BaseDTO` 類 

    其他的DTO類可以繼承此類, 可以閱讀 [java 繼承](https://www.runoob.com/java/java-inheritance.html)

    - `@Data` 註解是 lombok 提供的功能, 默認生成類中所有屬性的 `getter/setter` 方法, 以及重寫 `toString()`, `equals()`, `hashCode()` 方法

2. 創建 `ResponseDTO`類 

    在 `domain/dto` 包中創建 `ResponseDTO` 類 

    給 service 層或其他層返回指定的類型

    - `@NoArgsConstructor` 註解是 lombok 提供的功能, 生成無參構造器
    - `@Scope("prototype")` 註解是 spring 提供的註解, 意思是每次通過 spring 容器獲取到的實例都是一個新的實例, 如果不設置改註解, 則默認是單例模式, 還有其他的值可以設置, 可參閱[@Scope說明](https://blog.csdn.net/ColdFireMan/article/details/100576702)
    - `@Component` 註解是 Spring 的註解, 實現 bean 注入功能, 一般是用於各種組件實例化, 另外相同功能的註解為: `@controller`, `@service`, `@repository`, 這三個註解意義和 `@Component` 不同, `@controller` 為控制器, `@service` 一般用於 service 層, `@repository` 一般用於數據訪問層

3. 創建 `User` 相關的 `DTO` 和 `DAO` 類 

    `DAO` 是根據數據庫表的字段來定義的類, 用於保存查詢結果 

    在 `domain.dao` 包中創建 `UserInfoDAO` 類 

    在 `domain.dto` 包中創建 `UserDTO` 類, 繼承 `BaseDTO` 類 

### 1.6.4. 創建 MyBatis 數據訪問邏輯 

1. 創建 `BaseDAO` 接口 

    在 `dao` 包中創建接口

    ```
    package com.easy.base.dao;

    public interface BaseDAO {
        int saveObject();
        int updateObject();
        int removeObject();
    }
    ``` 

2. 創建 `UserMapper` 接口

    在 `dao.mapper` 包中創建接口 

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

3. 創建 `UserMapper` 接口對應的 xml 

    在 `resources/mappers` 文件夾創建 `UserMapper.xml` 

    - `<mapper>` 的 `namespace` 屬性的值是 `UserMapper` 的全限定名
    - `<resultMap>` 自動映射查詢結果, 可參閱[官方文檔](https://mybatis.org/mybatis-3/zh/sqlmap-xml.html#Auto-mapping),
    `id` 屬性的值是當前映射的名稱, `type` 屬性的值是要映射的類的全限定名 
    - `<id>` 和 `<result>` 的 `property` 屬性是指映射的類的屬性, `column` 屬性是指表的字段名稱(也可以是查詢語句的別名)
    - `<id>` 是指表的主鍵 
    - `<sql>` 是可被其他語句引用的可重用語句塊
    - `<insert>`, `<update>`, `<select>` 包含了 `id` 屬性, `id`的值, 要和 `UserMapper` 接口的方法名一致 
    - `#{property}` 是 `UserMapper` 接口的方法的參數變量的名稱, 如果參數是類類型, 則是對應類里的各個屬性名 
    - `<trim>` 動態拼接 SQL 語句, `prefix` 屬性是前綴, `suffixOverrides` 屬性是移除多餘的後綴, 其他屬性可參閱
    - `<if>` 條件判斷, `test` 屬性是判斷的條件
    [此博客](https://blog.csdn.net/weixin_34123613/article/details/93397418)
    - `<include>` 是引用 `<sql>` 的語句
    - `<where>` 可動態生成 where 條件的 SQL 語句 

### 1.6.5. 創建 service 
這裡會使用到工廠模式, [Java多態](https://www.zhihu.com/question/30082151?sort=created)的知識 

1. 創建 `BaseService` 接口
    
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
   
2. 實現 `BaseService` 接口 

    - 使用 `@Service` 註解 
    - 使用構造器方法注入依賴 

### 1.6.6. 對 `UserServiceImpl` 建立單元測試 

在 `src/test/java/com/wia/base` 目錄下創建 `ServiceTests` 類 

1. `@RunWith(SpringRunner.class)` 

    - 讓測試用例在 spring 容器環境中運行 
  
2. `@MapperScan` 

    - 掃描 MyBatis 的 mapper 接口類所在的包
    - 在編譯之後都生成相應的實現類 
  
3. `@ComponentScan` 

      - 掃描指定的包下所有的配置類(使用了 `@Controller`, `@Service`, `@Component`, `@Repository` 註解的類) 
      - 註冊到 spring 容器中

4. `@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)` 

      - `AutoConfigureTestDatabase` 註解: 因為使用了 `@MybatisTest`, 所以會替換 spring 的數據源配置為虛擬數據源 
      - `AutoConfigureTestDatabase.Replace.NONE` 表示: 不替換數據源配置 
  
5. 單元測試的 `insert`, `update`, `delete` 和事務都會回滾

完整代碼: 

### 1.6.7. 運行單元測試 
1. IntelliJ IDEA 

    - 在對應的測試方法左邊有一個綠色的箭頭, 點擊後, 選 `Run '{方法名}()'`, 或選 `Debug '{方法名}()'`即可運行 
    - 右鍵點擊方法名, 選 `Run '{方法名}()'`, 或選 `Debug '{方法名}()'` 

2. VSCode 

### 1.6.8. 創建 控制器 

1. 在 `controller` 包中創建 `UserController` 

    - `@Scope("session")` 表示控制器在每一個不同的 session 中都是不同的實例, 這個值需要 spring 是在 web 應用中
    - `@RestController` 表示控制器返回 JSON , XML 或其他文本, 而 `@Controller` 返回頁面, [二者區別](https://www.jianshu.com/p/c89a3550588a)
    - `@RequestMapping(value = "/Login", method = RequestMethod.GET)` 
      - 此註解可以寫在控制器類上和控制器的方法中
      - 寫在控制器上, 則請求控制器裡的方法, 都要在請求路徑中加上對應的值, 如請求 `UserController` 的 `login()` 方法時, URL 要寫成: `http://{ip}:{port}/User/Login`
      - `value` 表示映射值, 可以簡寫為: `@RequestMapping("/User")`
      - `method` 表示 `action` 的請求方式, 默認是 `GET`, 常用的有: `GET`, `POST`, `PUT`, `DELETE`

2. 在 `controller` 包中創建 `PageController` 

### 1.6.9. 測試控制器
#### 1.6.9.1. 使用 IDEA 的 `PostMan` 

### 1.6.10. 整合 `Spring Data Jpa` 

可以理解為 `.net` 中的 `EntityFramework` 框架, `Jpa` 可以將對象映射到數據庫, 可以不用重複編寫每個表的 `CRUD` 邏輯.

詳細教程可以看
[官方文檔](https://docs.spring.io/spring-data/jpa/docs/2.3.0.RELEASE/reference/html/#reference)

#### 1.6.10.1. 添加依賴 

#### 1.6.10.2. 配置 `application.yml` 
  
  - `spring.jpa.hibernate.ddl-auto` 可賦值如下
  
    - `create`: 運行程序會新建表, 結束程序會清空表數據 
    - `create-drop`: 運行程序會新建表, 結束程序會刪除表 
    - `update`: 運行程序如沒有表則新建表, 表內數據不清空, 只更新 
    - `valid`: 運行程序會校驗數據與數據庫的字段類型是否相同, 不同會報錯 
    
  - `spring.jpa.hibernate.naming.physical-strategy` 
  
    配置物理名稱命名策略, `PhysicalNamingStrategyStandardImpl` 是直接映射, 不做處理 
    
  - `spring.jpa,properties.hibernate.dialect` 設置 Hibernate 的數據庫方言(dialect) 

    設置方言是為了 Hibernate 可以根據數據庫來識別 SQL 語句的差異

    可設置的值參考[官方文檔](https://docs.jboss.org/hibernate/orm/5.4/javadocs/)
  
    如果在連接 SQL server 2008 或更老的版本的數據庫時候未配置方言, 在運行過程中會拋出下面的異常信息: 
    
    ```
    ...
    Caused by: org.hibernate.exception.SQLGrammarException: Unable to build DatabaseInformation
    ...
    Caused by: java.sql.SQLException: 無效的物件名稱 'INFORMATION_SCHEMA.SEQUENCES'
    ```
  
`application.yml` 設置: 

```
spring:
  jpa:
    database: sql_server
    show-sql: true
    hibernate:
      ddl-auto: none
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    properties:
      hibernate:
        format_sql: true
``` 

`application-dev.yml` 設置: 

```
spring:
  jpa:
    properties:
      hibernate:
        dialect: "org.hibernate.dialect.SQLServer2008Dialect"
```

`application-prd.yml` 設置: 

```
spring:
  jpa:
    properties:
      hibernate:
        dialect: "org.hibernate.dialect.SQLServer2012Dialect"
```

#### 1.6.10.3. 創建 `Entity` 類

  - 在 `domain.entity` 創建類 `SYS_USERINFO` 
  - 添加 `@Data`, `@NoArgsConstructor`, `@Entity`, `@Table` 註解
  - 在主鍵的屬性上使用 `@Id` 註解
  - 在屬性中使用 `@Column` 註解, 指定持久屬性或字段的映射列, 如果未指定任何列註釋, 則使用默認值, 可閱讀[官方文檔](https://docs.oracle.com/javaee/7/api/index.html?javax/persistence/Column.html)
  , 這裡只羅列了這個例子中用到的屬性 
    
    - `name`: 字段名稱(非必要設置)
    - `unique`: 字段是否為唯一鍵, 默認值是 `false` 
    - `nullable`: 字段是否為空, 默認值是 `true`
    - `length`: 字段的長度
    - `columnDefinition`: 字段的類型 
    
#### 1.6.10.4. 創建 `repository` 

1. 在 `com/wia/base/dao/jpa` 創建 `UserRepository.java` 接口 

2. 接口繼承 `JpaRepository<T, String>` 接口 

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

  這些方法都可以直接調用, 若要自定義新的方法, 則在 `UserRepository` 接口中添加即可 
  
  假設要自定義查詢方法, 方法名的命名規則如下 
  
  [官方文檔](https://docs.spring.io/spring-data/jpa/docs/2.3.0.RELEASE/reference/html/#jpa.query-methods)羅列的方法名關鍵字的清單 
  
  這裡只展示一部分, 條件包括 `=`, `<>`, `>`, `>=`, `<`, `<=`, `AND`, `OR`, `LIKE`, `IS NULL`, `IS NOT NULL`, `ORDER BY` 


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



#### 1.6.10.5. 擴展 `UserServiceImpl.java` 的 `listObjectFactory` 工廠方法 

#### 1.6.10.6. 單元測試 

1. 單元測試類的註解 把 `@MybatisTest` 改成 `@SpringBootTest` 

    因為 `@MybatisTest` 儘支持 MyBatis 的測試, 沒有集成 jpa 的相關環境 
  
#### 1.6.10.7. 多條件動態查詢 

可參閲下面兩篇文章（待驗證）

1. [Spring-Data-JPA criteria 查询](https://www.jianshu.com/p/0939cec7e207)
2. [Spring-Data-JPA 动态查询黑科技](https://www.jianshu.com/p/dbdf04070243)

### 1.6.11. 整合 Spring session 

#### 1.6.11.1. 安装redis 
 
##### 1.6.11.1.1. 下载redis 

##### 1.6.11.1.2. 安装redis 
1. Linux环境 

2. Windows环境 

    - [下载链接](https://github.com/tporadowski/redis/releases) 
    - 解壓縮包, 並將目錄重命名為 `redis`
    - 在目錄中運行 cmd 命令: `.\redis-server.exe redis.windows.conf`(不要關閉此cmd窗口)
    
##### 1.6.11.1.3. 測試 
1. Linux環境 

2. Windows環境 

    - 在 `redis` 目錄中運行 cmd 命令: `.\redis-cli.exe -h 127.0.0.1 -p 6379`
    - 設置鍵值對: `set myKey abc`
    - 獲取鍵值對: `get myKey`

#### 1.6.11.2. 添加依賴 

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

下載依賴: `mvn dependency:copy-dependencies` 

重新打包: `mvn clean package`

#### 1.6.11.3. 配置`application.yml` 

1. Spring Boot 的配置 

```
spring.session.store-type=redis # Session store type.
server.servlet.session.timeout= # Session timeout. If a duration suffix is not specified, seconds is used.
spring.session.redis.flush-mode=on_save # Sessions flush mode.
spring.session.redis.namespace=spring:session # Namespace for keys used to store sessions.
``` 

2. Redis 連接配置 

```
spring.redis.host=localhost # Redis server host.
spring.redis.password= # Login password of the redis server.
spring.redis.port=6379 # Redis server port.
spring.redis.database=0 # Redis server port.
```

#### 1.6.11.4. 使用 Spring session 

##### 1.6.11.4.1. 在控制器中創建登錄/獲取用戶/注銷的方法

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

##### 1.6.11.4.2. 測試及驗證 

1. postman 中調用控制器的登錄方法 
2. 在 `redis` 目錄中運行 cmd 命令: `.\redis-cli.exe -h 127.0.0.1 -p 6379`
3. 執行 `keys '*'` 命令, 可看到 `spring:session` 相關的 key 
4. postman 中調用控制器的獲取用戶方法,可看到返回的用戶信息 
5. 執行 `del {keys}` 命令,其中, `keys`是`3.`中執行結果的前綴`spring:session:sessions:{...}`的key
6. postman 中調用控制器的獲取用戶方法,此時返回的用戶信息為null

### 1.6.12. lombok
#### 1.6.12.1. 官方文檔
[鏈接](https://projectlombok.org/features/all)

# 2. 異常處理
## 2.1. IDEA 開發環境中, 修改了 html, 瀏覽器中訪問的 html 仍是修改前的版本 
### 2.1.1. 問題原因: 
1. maven 打包的文件還是修改前的文件 
2. IDEA 自身的毛病 

### 2.1.2. 解決辦法: 
1. 針對上述的原因1, 每次啟動項目前, 都執行一次 maven 打包指令 `mvn clean package`
2. 重啟 IDEA
3. 清除 IDEA 的設置緩存: `File -> Invalidate caches / Restart -> Invalidate / Restart` 

## 2.2. 單元測試的異常
### 2.2.1. 依賴注入失敗
1. 編譯器DEBUG日誌 

```
java.lang.IllegalStateException: Failed to load ApplicationContext
...
Caused by: 
  org.springframework.beans.factory.UnsatisfiedDependencyException: 
    Error creating bean with name '{類名}' defined in file [類文件路徑]:
      Unsatisfied dependency expressed through constructor parameter 1; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException:
        No qualifying bean of type '{類全路徑名}' available:
          expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
``` 

2. 解決思路 

  - 排查 `@ComponentScan` 是否包含了用到的包, 如果是 `@ComponentScan("com.easy.base.*")` 那麼, spring會掃描 `base` 下註解為 `@Service`, `@Repository`, `@Component` 類, 如果是 `@ComponentScan("com.easy.base.service.*")` 那麼只會掃描 `service` 包裡的註解為 `@Service`, `@Repository`, `@Component` 的類