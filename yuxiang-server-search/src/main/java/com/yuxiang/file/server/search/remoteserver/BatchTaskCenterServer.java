package com.yuxiang.file.server.search.remoteserver;

import com.yuxiang.file.dto.BatchTaskCenterDto;
import com.yuxiang.file.entity.BatchTaskCenter;
import com.yuxiang.file.exception.BizException;
import com.yuxiang.file.remote.iface.search.IBatchTaskCenterSearch;
import com.yuxiang.file.page.Pager;
import com.yuxiang.file.page.Paginater;
import com.yuxiang.file.server.search.service.BatchTaskCenterService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:49
 */
@DubboService(version = "1.0.0",timeout = 30000, interfaceClass = IBatchTaskCenterSearch.class)
public class BatchTaskCenterServer implements IBatchTaskCenterSearch {

    @Autowired
    BatchTaskCenterService batchTaskCenterService;

    @Override
    public Paginater findPager(BatchTaskCenterDto bean, Pager pager) throws BizException {
        return batchTaskCenterService.findPager(bean, pager);
    }

    @Override
    public BatchTaskCenter getBatchTaskCenterById(Long id) throws BizException {
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
