package com.yuxiang.file.download;

import com.alibaba.fastjson.JSON;
import com.yuxiang.file.constant.GeneralConstant;
import com.yuxiang.file.entity.DownCenter;
import com.yuxiang.file.page.Pager;
import com.yuxiang.file.page.Paginater;
import com.yuxiang.file.common.utils.FileToZip;
import com.yuxiang.file.common.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AbstractGenerateFileTemplate
 * @Description 处理文件生成
 * @Author zhangyux
 * @Date 2020/9/18 
 * @Version 1.0
 **/
public abstract class AbstractGenerateFileTemplate {

    public static final Logger logger = LoggerFactory.getLogger(AbstractGenerateFileTemplate.class);

    private DownCenter center;

    /**
     * 备注，用于记录文件处理情况
      */
    private String remark = "";
    /**
     * 用于临时保存文件的目录路径
     */
    protected String txtDirectoryPath = "";
    /**
     * 压缩后的文件包名
     */
    protected String fileNameZip = "";

    protected String creDt = "";
    protected String fileNamePre = "";
    protected String taskInfo = "";

    /**
     * 单个文件的最大明细数
     */
    private static final int MAX_TOTAL_TXT = 20000;
    /**
     * 单次分页查询的明细数
     */
    private static final int PAGER_SIZE = 1000;
    /**
     * 单个文件获取明细所需的最大分页查询次数（单个文件的最大明细数/单次分页查询的明细数，20000/1000=20）
     */
    private static final int MAX_PAGER_NUM = MAX_TOTAL_TXT / PAGER_SIZE;

    private int pageNumber = 0;

    private boolean fileFlag = false;

    private static final String CHARSET = "GBK";

    public AbstractGenerateFileTemplate(DownCenter center) {
        this.center = center;
    }

    public void process() {

        try {

            // 参数初始化
            logger.info("参数初始化");
            this.init();

            // 清理指定目录下的所有文件
            logger.info("清理指定目录下的所有文件");
            FileUtil.clearDirectory(txtDirectoryPath);

            // 生成文件
            logger.info("生成文件");
            this.createFileAll();

            // 进行文件压缩
            logger.info("进行文件压缩");
            this.fileToZip();

            // 上传文件
            logger.info("上传文件");
            this.uploadFile();

        } catch (Exception e) {
            String errorMsg = taskInfo + "文件生成异常："+ e.getMessage();
            logger.error(errorMsg, e);
            center.setBuildSts(GeneralConstant.BUILD_STS_2);
            remark = errorMsg;
        } finally {
            // 更新任务状态
            this.updateDownCenter();
            logger.info(taskInfo + "处理完成");
        }
    }

    private void init() {
        txtDirectoryPath = ""; //GlobalCache.getSystemCache("txtPath");
        logger.info("txtDirectoryPath:{}", txtDirectoryPath);
        this.fileInfoInit();
        logger.info("txtDirectoryPath:{}", txtDirectoryPath);
        logger.info("fileNameZip:{}", fileNameZip);
        logger.info("fileNamePre:{}", fileNamePre);
        logger.info("taskInfo:{}", taskInfo);
    }

    private void createFileAll() throws Exception {
        // 获取总笔数
        logger.info("获取总笔数");
        long maxNum = this.getMaxNum();
        // 根据总笔数及单个文件最大明细数计算出需生成的文件数
        long fileCount = (maxNum + MAX_TOTAL_TXT - 1) / MAX_TOTAL_TXT;
        // 初始化分页参数
        Pager pager = new Pager();
        pager.setPageNumber(pageNumber);
        pager.setPageSize(PAGER_SIZE);
        // 循环生成文件（生成max个txt文件）
        for (int i = 1; i <= fileCount; i++) {
            // 生成文件
            logger.info("总共【{}】个文件，开始生成第【{}】个文件", fileCount, i);
            remark = "总共【" + fileCount + "】个文件，开始生成第【" + i + "】个txt文件";
            this.updateDownCenter();
            this.createFile(this.getData(pager), i);
        }
        /*if (!fileFlag) {
            throw new BizException("无符合条件的明细，无需生成文件！");
        }*/
    }

    private void fileToZip() throws Exception {
        // 将生成的多个文件打成一个压缩包， 并上传压缩包至fastDFS分布式文件系统中，供后续进行下载
        logger.info("开始压缩文件，txtDirectoryPath:{}, fileNameZip:{}", txtDirectoryPath, fileNameZip);

        boolean flag = FileToZip.fileToZip(txtDirectoryPath, txtDirectoryPath, fileNameZip);
        if(!flag) {
            logger.error("生成压缩包文件失败");
            throw new Exception("生成压缩包文件失败");
        }
    }

    private List<Object> getData(Pager pager) {
        List<Object> txtList = new ArrayList<>();
        // 单个文件循环处理
        while (true) {
            pageNumber++;
            pager.setPageNumber(pageNumber);
            logger.info("pager:{}", JSON.toJSONString(pager));
            Paginater paginater = this.getPaginater(pager);
            List<Object> list = (List<Object>) paginater.getData();
            if (null == list || list.size() <= 0) {
                logger.info("返回结果为空");
                break;
            }
            txtList.addAll(list);
            // 判断是否达到单个文件最大明细数
            if (pageNumber % MAX_PAGER_NUM == 0) {
                logger.info("达到单个文件最大明细数");
                break;
            }
        }
        logger.info("txtList size:{}", txtList.size());
        return txtList;
    }

    private void createFile(List<Object> txtList, int i) {
        // 生成文件名
        String fileName = fileNamePre + creDt + "_" + i + ".txt";
        File file = new File(txtDirectoryPath + fileName);
        logger.info("开始生成文件，路径为：" + file.getPath());
        StringBuilder errBuffer = new StringBuilder();
        try (BufferedWriter bw =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream(file, true), CHARSET))) {
            for (Object object : txtList) {
                StringBuilder buffer = new StringBuilder();
                if (!this.buildFileInfo(object, buffer,errBuffer)) {
                    logger.error("组装文件明细异常");
                    continue;
                }
                fileFlag = true;
                bw.write(buffer.toString());
            }
            //错误回执
            if(errBuffer != null && errBuffer.length() > 0){
                String errFileName = fileNamePre + creDt + "_err" + ".txt";
                File errFile = new File(txtDirectoryPath + errFileName);
                try (BufferedWriter errBw =
                             new BufferedWriter(
                                     new OutputStreamWriter(
                                             new FileOutputStream(errFile, true), CHARSET))) {
                    errBw.write(errBuffer.toString());
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        if (fileFlag) {
            logger.info("文件生成完成，路径：{}", file.getPath());
        }
    }

    private void uploadFile() throws Exception {
        // 上传文件
        logger.info(taskInfo + "文件压缩成功, 开始上传文件至fastDFS");
        //上传FDS
        File file=new File(txtDirectoryPath + fileNameZip + ".zip");
        /*FileManager fm = new FileManager(ExportReportUrmtminfAESPThread.class.getResource("/").getPath() + File.separator
                + "conf" + File.separator + "fdfs_client.conf");*/
        String[] paths = null; //CatFileManagerUtils.uploadFile(file, "zip", fm);
//        String[] paths = fm.uploadFile(file, "zip");
        center.setDownUrl(paths[0]+","+paths[1]);
        center.setFileName(fileNameZip + ".zip");
        logger.info(taskInfo + "文件压缩完成|操作人:" + center.getCreatorId()
                + ",操作时间:" + center.getCreateTime() + ",下载路径:"
                + center.getDownUrl());
        logger.info("清理压缩包文件开始");
        try {
            file.delete();
            logger.info("清理压缩包文件完成");
        } catch (Exception e) {
            logger.error("清理压缩包文件异常:" + e.getMessage(), e);
        }
        center.setBuildSts(GeneralConstant.BUILD_STS_1);
        remark = taskInfo + fileNamePre + "文件生成完成";
        logger.info(taskInfo + fileNamePre + "文件生成完成");
    }

    protected long getMaxNum() throws Exception {
        // 获取符合条件的明细总笔数
        long maxNum = this.getPaginater(new Pager(1,1)).getMaxRowCount();
        if (maxNum <= 0) {
            logger.error("无符合条件的明细数据");
            throw new Exception("无符合条件的明细数据");
        } else {
            logger.info("符合条件总笔数为：{}", maxNum);
        }
        return maxNum;
    }

    private void updateDownCenter() {
        center.setUpdateTime(new Date());
        center.setRemark(remark.length() > 400 ? remark.substring(0, 400) : remark);
//        downCenter.update(center);
    }

    /**
     * 组装文件明细
     * @param object 源数据
     * @param buffer 保存组装后的明细
     * @param errBuffer
     * @return boolean
     */
    protected abstract boolean buildFileInfo(Object object, StringBuilder buffer,StringBuilder errBuffer);

    /**
     * 文件处理信息初始化
     */
    protected abstract void fileInfoInit();

    /**
     * 获取分页数据
     * @param pager 分页条件
     * @return
     */
    protected abstract Paginater getPaginater(Pager pager);
}
