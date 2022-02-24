package com.yuxiang.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyStartupRunner
 * @Description TODO
 * @Author zhangyux
 * @Date 2022/02/23 17:04
 * @Version 1.0
 **/
@Component
@Order(value = 1)
public class MyStartupRunner implements CommandLineRunner {

    public static final Logger logger = LoggerFactory.getLogger(MyStartupRunner.class);

    @Override
    public void run(String... args) {
        logger.info("MyStartupRunner");
    }
}
