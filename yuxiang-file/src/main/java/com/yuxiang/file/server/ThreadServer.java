package com.yuxiang.file.server;

import com.yuxiang.entity.DownCenter;
import com.yuxiang.file.threadpool.ThreadPoolExecutorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
/**
 * @ClassName ThreadServer
 * @Description 任务调度处理类
 * @Author zhangyux
 * @Date 2022/02/24
 * @Version 1.0
 **/
public class ThreadServer {

    public static final Logger logger = LoggerFactory.getLogger(ThreadServer.class);

    public void doProcess() {
        Long taskId = 0L;
        try {
            DownCenter downCenter;
            // 判断任务是否关闭
            int activeNum = ThreadPoolExecutorManager.getActiveCount();

            // 根据线程池执行能力获取抓取任务数
            int idle = ThreadPoolExecutorManager.getIdleNum();
            logger.info("当前线程池空余线程数：" + idle);
            if (0 >= idle) {
                logger.info("当前线程池有" + activeNum + "任务在执行，已经没有空余线程，等待下次轮询");
                return;
            }
            // 获取指定数量的任务明细，并更新状态为处理中
            List<DownCenter> list = null; //iDownCenter.updateDownloadTaskList(idle);

            if (null != list && list.size() > 0) {
                logger.info("需处理的下载记录共【" + list.size() + "】条");

                for (int i = 0; i < list.size(); i++) {
                    downCenter = list.get(i);
                    logger.info("ThreadServer的downcenter：" + com.alibaba.fastjson.JSONArray.toJSONString(downCenter));
                    taskId = downCenter.getId();
                    logger.info("系统处理任务：[" + downCenter.getSysId() + "," + downCenter.getSysName()
                            + "]----处理类[" + downCenter.getModuleClassName() + "]" + ",任务ID[" + downCenter.getId() + "]");
                    downCenter.setUpdateTime(new Date());
                    ThreadPoolExecutorManager.download(downCenter);
                }
            } else {
                logger.info("需处理的下载记录共【0】条");
            }
        } catch (Exception e) {
            logger.error("处理下载记录出错---任务ID[" + taskId + "]:" + e.getMessage(), e);
        } catch (Throwable e) {
            logger.error("处理下载记录出错---任务ID[" + taskId + "]:" + e.getMessage(), e);
        }
    }
}
