package com.yuxiang.remote.iface;

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
public interface IDownCenter {

    /**
     * 分页查询任务
     * @param bean
     * @param pager
     * @return
     * @throws BizException
     */
    public Paginater findPager(DownCenter bean, Pager pager) throws BizException;

    /**
     * 根据主键获取任务
     * @param id
     * @return
     * @throws BizException
     */
    public DownCenter getDownCenterById(Long id) throws BizException;

    /**
     * 按对象删除任务
     * @param bean
     * @throws BizException
     */
    public void delete(DownCenter bean) throws BizException;

    /**
     * 保存任务
     * @param bean
     * @return
     * @throws BizException
     */
    public Long save(DownCenter bean) throws BizException;

    /**
     * 更新任务
     * @param bean
     * @throws BizException
     */
    public void update(DownCenter bean) throws BizException;

    /**
     * 获取上传任务执行列表
     * @param fetchNum 抓取记录条数
     * @return
     */
    public List<DownCenter> updateUploadTaskList(int fetchNum) throws BizException;

    /**
     * 获取下载任务执行列表
     * @param fetchNum 抓取记录条数
     * @return
     */
    public List<DownCenter> updateDownloadTaskList(int fetchNum) throws BizException;

    /**
     * 根据对象获取任务集合
     * @param bean
     * @return
     * @throws BizException
     */
    public List<DownCenter> getListByDownCenter(DownCenter bean) throws BizException;

    /**
     * 获取未处理完成的任务列表
     * @param taskName
     * @param buildSts
     * @return
     * @throws BizException
     */
    public List<DownCenter> getListByNameAndStatus(String taskName,String buildSts) throws BizException;
}
