package com.yuxiang.file.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhangyux
 * @Description 启动时加载缓存
 * @version 1.0
 * @date 2022/2/24 10:25
 */
@Component
@Order(value = 2)
public class LoadCacheRunner implements CommandLineRunner {

    public static final Logger logger = LoggerFactory.getLogger(LoadCacheRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("加载缓存");
    }
}
