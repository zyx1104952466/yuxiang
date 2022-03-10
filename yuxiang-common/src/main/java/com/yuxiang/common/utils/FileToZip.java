package com.yuxiang.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName FileToZip
 * @Description 文件打包处理类
 * @Author zhangyux
 * @Date 2022/02/24
 * @Version 1.0
 **/
public final class FileToZip {

    public static final Logger logger = LoggerFactory.getLogger(FileToZip.class);

    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param sourceFilePath :待压缩的文件路径
     * @param zipFilePath    :压缩后存放路径
     * @param fileName       :压缩后文件的名称
     * @return boolean
     */
    public static boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
        boolean flag = false;
            File sourceFile = new File(sourceFilePath);
        File zipFile = new File(zipFilePath + File.separator + fileName + ".zip");

        if (!sourceFile.exists() || zipFile.exists()) {
            logger.info("待压缩的文件目录：" + sourceFilePath + "不存在.");
        } else {
            if (zipFile.exists()) {
                logger.info(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
            } else {
                try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)))) {

                    File[] sourceFiles = sourceFile.listFiles();
                    if (null == sourceFiles || sourceFiles.length < 1) {
                        logger.info("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                    } else {
                        byte[] bufs = new byte[1024 * 10];
                        for (File file : sourceFiles) {
                            //创建ZIP实体，并添加进压缩包
                            if (file.getPath().contains(".zip")) {
                                logger.info("zip 不打包");
                                continue;
                            }
                            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file), 1024 * 10)) {
                                ZipEntry zipEntry = new ZipEntry(file.getName());
                                zos.putNextEntry(zipEntry);
                                int read;
                                while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                                    zos.write(bufs, 0, read);
                                }
                            } catch (IOException e) {
                                logger.error(e.getMessage());
                                throw e;
                            }
                        }
                        flag = true;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }
}
