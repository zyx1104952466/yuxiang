package com.yuxiang.server.remoteserver;

import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.exception.BizException;
import com.yuxiang.remote.iface.IBatchTaskCenter;
import com.yuxiang.server.service.BatchTaskCenterService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:49
 */
@DubboService(version = "1.0.0",timeout = 30000, interfaceClass = IBatchTaskCenter.class)
public class BatchTaskCenterServer implements IBatchTaskCenter {

    @Autowired
    BatchTaskCenterService batchTaskCenterService;

    @Override
    public void delete(BatchTaskCenter bean) throws BizException {
        batchTaskCenterService.delete(bean.getId());
    }

    @Override
    public int save(BatchTaskCenter bean) throws BizException {
        return batchTaskCenterService.insert(bean);
    }

    @Override
    public void update(BatchTaskCenter bean) throws BizException {

    }

    @Override
    public List<BatchTaskCenter> updateUploadTaskList(int fetchNum) throws BizException {
        return null;
    }

    @Override
    public List<BatchTaskCenter> updateDownloadTaskList(int fetchNum) throws BizException {
        return null;
    }
}
