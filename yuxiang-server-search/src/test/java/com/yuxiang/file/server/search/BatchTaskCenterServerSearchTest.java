package com.yuxiang.file.server.search;

import com.alibaba.fastjson.JSON;
import com.yuxiang.file.remote.iface.search.IBatchTaskCenterSearch;
import com.yuxiang.file.page.Pager;
import com.yuxiang.file.page.Paginater;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/28 10:13
 */
public class BatchTaskCenterServerSearchTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BatchTaskCenterServerSearchTest.class);

    @Resource
    private IBatchTaskCenterSearch batchTaskCenterServerSearch;

    @Test
    public void findPager() {
        logger.info("start");
        Paginater paginater = batchTaskCenterServerSearch.findPager(null, new Pager(1, 10));
        System.out.println(JSON.toJSONString(paginater.getData()));
        logger.info(JSON.toJSONString(paginater.getData()));
        logger.info("end");
    }
}
