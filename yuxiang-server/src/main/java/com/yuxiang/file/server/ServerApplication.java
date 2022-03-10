package com.yuxiang.file.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ServerApplication
 * @Description TODO
 * @Author zhangyux
 * @Date 2022/2/27 10:29
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan("com.yuxiang.server.dao")
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
