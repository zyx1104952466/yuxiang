package com.yuxiang.file.download.task;

import com.yuxiang.file.download.AbstractGenerateFileTemplate;
import com.yuxiang.file.download.IDownLoadProcess;
import com.yuxiang.file.entity.DownCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @ClassName ReportFileExport
 * @Description 处理文件生成
 * @Author zhangyux
 * @Date 2022/2/24 10:34
 * @Version 1.0
 **/
public class ReportFileExport implements IDownLoadProcess {

    public static final Logger logger = LoggerFactory.getLogger(ReportFileExport.class);

    @Override
    public void download(DownCenter downCenter) {
        try {
            AbstractGenerateFileTemplate thread = new ExportFileThread(downCenter);
            thread.process();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
