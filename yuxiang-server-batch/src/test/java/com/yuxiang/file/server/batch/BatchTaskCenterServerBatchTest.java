package com.yuxiang.file.server.batch;

import com.yuxiang.remote.iface.search.IBatchTaskCenterSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/28 10:13
 */
public class BatchTaskCenterServerBatchTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BatchTaskCenterServerBatchTest.class);

    @Resource
    private IBatchTaskCenterSearch batchTaskCenterServerBatch;
}
