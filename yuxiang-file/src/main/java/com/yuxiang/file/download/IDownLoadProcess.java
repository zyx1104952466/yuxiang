package com.yuxiang.file.download;

import com.yuxiang.entity.DownCenter;

/**
 * @ClassName IDownLoadProcess
 * @Description 文件下载
 * @Author zhangyux
 * @Date 2022/02/24
 * @Version 1.0
 **/
public interface IDownLoadProcess {

	/**
	 * 处理下载任务
	 * @param downCenter
	 */
	public void download(DownCenter downCenter) ;
}
