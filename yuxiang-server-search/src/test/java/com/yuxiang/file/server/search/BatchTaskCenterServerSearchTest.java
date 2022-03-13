package com.yuxiang.file.server.search;

import com.alibaba.fastjson.JSON;
import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.remote.iface.search.IBatchTaskCenterSearch;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;
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

    @Test
    public void findById() {
        logger.info("start");
        BatchTaskCenter batchTaskCenter = batchTaskCenterServerSearch.findById("1");
        logger.info(JSON.toJSONString(batchTaskCenter));
        logger.info("end");
    }
}
