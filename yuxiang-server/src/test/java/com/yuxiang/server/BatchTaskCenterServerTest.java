package com.yuxiang.server;
import java.util.Date;

import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.remote.iface.IBatchTaskCenter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/28 10:13
 */
public class BatchTaskCenterServerTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BatchTaskCenterServerTest.class);

    @Resource
    private IBatchTaskCenter batchTaskCenterServer;

    @Test
    public void test01() {
        logger.info("start");
        BatchTaskCenter bean = new BatchTaskCenter();
        bean.setId("2");
        bean.setTaskName("test");
        bean.setBuildStatus("01");
        bean.setTaskType("D");
        bean.setCreatorName("zhangyux");
        bean.setCreateTime(new Date());
        bean.setBatchSid("123");
        bean.setRemark("123");
        bean.setParams("{}");


        batchTaskCenterServer.save(bean);
        logger.info("end");
    }
}
