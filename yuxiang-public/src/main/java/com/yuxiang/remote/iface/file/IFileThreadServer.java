package com.yuxiang.remote.iface.file;

import com.yuxiang.exception.BizException;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/3/11 9:52
 */
public interface IFileThreadServer {

    public void doProcess() throws BizException;
}
