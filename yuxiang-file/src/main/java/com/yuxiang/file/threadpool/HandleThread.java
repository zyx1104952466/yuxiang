package com.yuxiang.file.threadpool;

import com.yuxiang.constant.GeneralConstant;
import com.yuxiang.file.download.IDownLoadProcess;
import com.yuxiang.entity.DownCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: HandleThread
 * @Description: 任务处理实例化处理类
 * @Author： zhangyux
 * @Date 2022年02月24日 下午14:03:34
 */
public class HandleThread implements Runnable {

    public static final Logger logger = LoggerFactory.getLogger(HandleThread.class);

    private DownCenter downCenter;

    public HandleThread(DownCenter downCenter) {
        this.downCenter = downCenter;
    }

    @Override
	public void run() {
        try {
            if (GeneralConstant.TASK_TYPE_D.equals(downCenter.getTasktype())) {
                this.download(downCenter);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void download(DownCenter downCenter) {
        IDownLoadProcess process;
        try {
            String moduleClassName = downCenter.getModuleClassName();
            logger.info("moduleClassName:" + moduleClassName);
            process = (IDownLoadProcess) Class.forName("com.yuxiang.download.task." + moduleClassName + "Export").newInstance();
            logger.info("process:--" + process);
            process.download(downCenter);
        } catch (Exception e) {
            logger.error("处理下载记录出错---任务ID[" + downCenter.getId() + "]:" + e, e);
        }
    }
}
