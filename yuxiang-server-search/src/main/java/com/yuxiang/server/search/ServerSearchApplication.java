package com.yuxiang.server.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/3/10 15:21
 */
@SpringBootApplication
@MapperScan("com.yuxiang.server.search.dao")
public class ServerSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerSearchApplication.class, args);
    }
}
