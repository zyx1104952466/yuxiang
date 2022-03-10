package com.yuxiang.server.batch.remoteserver;

import com.yuxiang.remote.iface.batch.IBatchTaskCenterBatch;
import com.yuxiang.server.batch.service.BatchTaskCenterService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:49
 */
@DubboService(version = "1.0.0",timeout = 30000, interfaceClass = IBatchTaskCenterBatch.class)
public class BatchTaskCenterServer implements IBatchTaskCenterBatch {

    @Autowired
    BatchTaskCenterService batchTaskCenterService;

}
