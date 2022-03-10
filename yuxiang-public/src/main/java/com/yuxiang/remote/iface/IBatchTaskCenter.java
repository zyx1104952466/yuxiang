package com.yuxiang.remote.iface;

import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.exception.BizException;

import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:40
 */
public interface IBatchTaskCenter {

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

}
