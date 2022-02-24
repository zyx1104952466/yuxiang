package com.yuxiang.server.remoteserver;

import com.yuxiang.entity.DownCenter;
import com.yuxiang.exception.BizException;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;
import com.yuxiang.remote.iface.IDownCenter;

import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:49
 */
public class DownCenterServer implements IDownCenter {
    @Override
    public Paginater findPager(DownCenter bean, Pager pager) throws BizException {
        return null;
    }

    @Override
    public DownCenter getDownCenterById(Long id) throws BizException {
        return null;
    }

    @Override
    public void delete(DownCenter bean) throws BizException {

    }

    @Override
    public Long save(DownCenter bean) throws BizException {
        return null;
    }

    @Override
    public void update(DownCenter bean) throws BizException {

    }

    @Override
    public List<DownCenter> updateUploadTaskList(int fetchNum) throws BizException {
        return null;
    }

    @Override
    public List<DownCenter> updateDownloadTaskList(int fetchNum) throws BizException {
        return null;
    }

    @Override
    public List<DownCenter> getListByDownCenter(DownCenter bean) throws BizException {
        return null;
    }

    @Override
    public List<DownCenter> getListByNameAndStatus(String taskName, String buildSts) throws BizException {
        return null;
    }
}
