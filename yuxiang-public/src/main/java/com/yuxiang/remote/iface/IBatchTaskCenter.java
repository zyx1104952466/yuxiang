package com.yuxiang.remote.iface;

import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.entity.DownCenter;
import com.yuxiang.exception.BizException;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;

import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:40
 */
public interface IBatchTaskCenter {

    /**
     * 分页查询任务
     * @param bean
     * @param pager
     * @return
     * @throws BizException
     */
    public Paginater findPager(BatchTaskCenter bean, Pager pager) throws BizException;

    /**
     * 根据主键获取任务
     * @param id
     * @return
     * @throws BizException
     */
    public BatchTaskCenter getBatchTaskCenterById(Long id) throws BizException;

    /**
     * 按对象删除任务
     * @param bean
     * @throws BizException
     */
    public void delete(BatchTaskCenter bean) throws BizException;

    /**
     * 保存任务
     * @param bean
     * @return
     * @throws BizException
     */
    public int save(BatchTaskCenter bean) throws BizException;

    /**
     * 更新任务
     * @param bean
     * @throws BizException
     */
    public void update(BatchTaskCenter bean) throws BizException;

    /**
     * 获取上传任务执行列表
     * @param fetchNum 抓取记录条数
     * @return
     */
    public List<BatchTaskCenter> updateUploadTaskList(int fetchNum) throws BizException;

    /**
     * 获取下载任务执行列表
     * @param fetchNum 抓取记录条数
     * @return
     */
    public List<BatchTaskCenter> updateDownloadTaskList(int fetchNum) throws BizException;

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
    public List<BatchTaskCenter> getListByNameAndStatus(String taskName,String buildSts) throws BizException;
}
