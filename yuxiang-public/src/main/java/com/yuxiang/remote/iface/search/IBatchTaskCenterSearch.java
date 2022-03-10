package com.yuxiang.remote.iface.search;

import com.yuxiang.dto.BatchTaskCenterDto;
import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.exception.BizException;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;

import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:40
 */
public interface IBatchTaskCenterSearch {

    /**
     * 分页查询任务
     * @param bean
     * @param pager
     * @return
     * @throws BizException
     */
    public Paginater findPager(BatchTaskCenterDto bean, Pager pager) throws BizException;

    /**
     * 根据主键获取任务
     * @param id
     * @return
     * @throws BizException
     */
    public BatchTaskCenter getBatchTaskCenterById(Long id) throws BizException;

    /**
     * 根据对象获取任务集合
     * @param bean
     * @return
     * @throws BizException
     */
    public List<BatchTaskCenter> getListByBatchTaskCenter(BatchTaskCenter bean) throws BizException;

    /**
     * 获取未处理完成的任务列表
     * @param taskName
     * @param buildSts
     * @return
     * @throws BizException
     */
    public List<BatchTaskCenter> getListByNameAndStatus(String taskName, String buildSts) throws BizException;
}
