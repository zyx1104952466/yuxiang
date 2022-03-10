package com.yuxiang.server.search.remoteserver;

import com.yuxiang.dto.BatchTaskCenterDto;
import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.exception.BizException;
import com.yuxiang.remote.iface.search.IBatchTaskCenterSearch;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;
import com.yuxiang.server.search.service.BatchTaskCenterService;
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
