package com.yuxiang;

import com.yuxiang.server.ThreadServer;
import org.junit.Test;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:22
 */
public class ThreadServerTest {

    @Test
    public void process() {
        ThreadServer threadServer = new ThreadServer();
        threadServer.doProcess();
    }
}
