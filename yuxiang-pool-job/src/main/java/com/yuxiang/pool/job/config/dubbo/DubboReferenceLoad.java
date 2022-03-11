package com.yuxiang.pool.job.config.dubbo;

import com.yuxiang.remote.iface.search.IBatchTaskCenterSearch;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/3/10 10:32
 */
@Configuration
public class DubboReferenceLoad {

    @DubboReference(version = "1.0.0", protocol = "dubbo", timeout = 30000, check = false)
    IBatchTaskCenterSearch batchTaskCenterSearch;

}
