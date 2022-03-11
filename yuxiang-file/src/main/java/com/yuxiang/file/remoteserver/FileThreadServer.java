package com.yuxiang.file.remoteserver;

import com.yuxiang.exception.BizException;
import com.yuxiang.file.server.ThreadServer;
import com.yuxiang.remote.iface.file.IFileThreadServer;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:49
 */
@DubboService(version = "1.0.0",timeout = 30000, interfaceClass = IFileThreadServer.class)
public class FileThreadServer implements IFileThreadServer {

    ThreadServer threadServer = new ThreadServer();

    @Override
    public void doProcess() throws BizException {
        threadServer.doProcess();
    }
}
