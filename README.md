# 宇翔系统
> - 现分为四大块功能：文件处理中心、前端管理中心、后端服务中心、定时任务处理中心
> - 文件处理中心： 处理批量文件
> - 流程管理中心： 流程跳转处理
> - 后端服务中心： 提供后台接口服务（dubbo接口），连接数据库（mybatis），自动生成代码，集成分页处理插件
> - 定时任务处理中心： 处理定时任务（xxl-job）
> - 前端UI： 维护前端页面


## 代码结构
> - yuxiang-admin:前端页面管理中心
> - yuxiang-common:公共处理工具包
> - yuxiang-file:文件处理中心
> - yuxiang-manager:流程跳转处理中心
> - yuxiang-pool-job:定时任务处理中心
> - yuxiang-public:提供实体类、接口
> - yuxiang-server:后端服务中心

### 技术选型

#### 后端技术

| 技术                 | 说明                | 官网                                           |
| -------------------- | ------------------- | ---------------------------------------------- |
| SpringBoot           | 容器+MVC框架        | https://spring.io/projects/spring-boot         |
| MyBatis              | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatisGenerator     | 数据层代码生成      | http://www.mybatis.org/generator/index.html    |
| Dubbo                | RPC框架            | http://dubbo.apache.org/zh/                    |
| xxl-job              | 分布式任务调度框架  | https://www.xuxueli.com/index.html             |
| zookeeper            | 分布式应用程序协调服务  | https://zookeeper.apache.org/             |
