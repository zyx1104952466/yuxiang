package com.yuxiang.server.batch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/3/10 15:21
 */
@SpringBootApplication
@MapperScan("com.yuxiang.server.batch.dao")
public class ServerBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerBatchApplication.class, args);
    }
}
