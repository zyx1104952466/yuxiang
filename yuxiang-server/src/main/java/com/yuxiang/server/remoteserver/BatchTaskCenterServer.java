package com.yuxiang.server.remoteserver;

import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.entity.DownCenter;
import com.yuxiang.exception.BizException;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;
import com.yuxiang.remote.iface.IBatchTaskCenter;
import com.yuxiang.server.service.BatchTaskCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:49
 */
@Service
public class BatchTaskCenterServer implements IBatchTaskCenter {

    @Autowired
    BatchTaskCenterService batchTaskCenterService;

    @Override
    public Paginater findPager(BatchTaskCenter bean, Pager pager) throws BizException {
        return null;
    }

    @Override
    public BatchTaskCenter getBatchTaskCenterById(Long id) throws BizException {
        return null;
    }

    @Override
    public void delete(BatchTaskCenter bean) throws BizException {

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

    @Override
    public List<BatchTaskCenter> getListByBatchTaskCenter(BatchTaskCenter bean) throws BizException {
        return null;
    }

    @Override
    public List<BatchTaskCenter> getListByNameAndStatus(String taskName, String buildSts) throws BizException {
        return null;
    }
}
