package com.yuxiang.file.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 文件工具类
 * 
 * @author liudw
 * 
 */
public class FileUtil {
    
    public static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void clearDirectory(String directoryPath) {
        File fileMkdir = new File(directoryPath);
        if (fileMkdir.exists()) {
            logger.info("目录已存在");
            // 删除文件夹中旧文件
            File[] files = fileMkdir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.exists()) {
                        if (file.delete()) {
                            logger.info("文件【{}】删除成功", file.getPath());
                        }
                    }
                }
            } else {
                logger.info("目录下不存在文件，无需处理");
            }
        } else {
            logger.info("目录不存在，新建目录：" + fileMkdir.getPath());
            // 目录不存在则新建
            if (fileMkdir.mkdirs()) {
                logger.info("目录创建成功");
            }
        }
    }
}
