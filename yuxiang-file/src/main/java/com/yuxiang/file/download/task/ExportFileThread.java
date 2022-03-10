package com.yuxiang.file.download.task;

import com.yuxiang.file.download.AbstractGenerateFileTemplate;
import com.yuxiang.entity.DownCenter;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
/**
 * @ClassName ExportReportUrmtminfAESPThread
 * @Description 处理文件生成
 * @Author zhangyux
 * @Date 2022/2/24 10:34
 * @Version 1.0
 **/
public class ExportFileThread extends AbstractGenerateFileTemplate {

    public static final Logger logger = LoggerFactory.getLogger(ExportFileThread.class);

    private static final String SPLT = ",";
    private static final String FILE_END= "\r\n";
    private static final String DIRECTORY_NAME = "ReportUrmtminfAESP";

    public ExportFileThread(DownCenter center) {
        super(center);
        this.fileNamePre = center.getFileName().replace(".txt", "");
    }

    @Override
    protected void fileInfoInit() {

        // txt文件保存目录所在路径
        txtDirectoryPath = txtDirectoryPath + File.separator + DIRECTORY_NAME + fileNamePre.replace(".txt", "") + File.separator + creDt + File.separator;
        // 压缩包文件名
        fileNameZip = DIRECTORY_NAME + "_" + creDt + "_"  + fileNamePre;
        // 文件名前缀
        fileNamePre = "UrmtminfAESP_" + fileNamePre;
        // 任务信息
        taskInfo = "连通商户报备信息";
    }

    @Override
    protected Paginater getPaginater(Pager pager) {
        return null;
    }

    /**
     * 组装文件明细内容
     * @param object 商户信息
     * @param buffer 用于保存明细内容
     * @return Boolean
     */
    @Override
    protected boolean buildFileInfo(Object object, StringBuilder buffer,StringBuilder errBuffer) {
        return true;
    }
}
