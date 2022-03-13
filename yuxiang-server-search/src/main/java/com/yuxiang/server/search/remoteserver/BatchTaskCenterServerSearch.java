package com.yuxiang.server.search.remoteserver;

import com.yuxiang.dto.BatchTaskCenterDto;
import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.exception.BizException;
import com.yuxiang.remote.iface.search.IBatchTaskCenterSearch;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;
import com.yuxiang.server.search.service.BatchTaskCenterService;
import io.netty.util.internal.PlatformDependent;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:49
 */
@DubboService(version = "1.0.0",timeout = 30000, interfaceClass = IBatchTaskCenterSearch.class)
public class BatchTaskCenterServerSearch implements IBatchTaskCenterSearch {

    @Autowired
    BatchTaskCenterService batchTaskCenterService;

    @Override
    public Paginater findPager(BatchTaskCenterDto bean, Pager pager) throws BizException {

        Field field = ReflectionUtils.findField(PlatformDependent.class, "DIRECT_MEMORY_COUNTER");
        field.setAccessible(true);
        try {
            AtomicLong directMemoryCounter = (AtomicLong) field.get(PlatformDependent.class);
            System.out.println("server DIRECT_MEMORY_COUNTER: " + directMemoryCounter.get()/1024);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field field1 = ReflectionUtils.findField(PlatformDependent.class, "DIRECT_MEMORY_LIMIT");
        field1.setAccessible(true);
        try {
            Long directMemoryLimit = (Long) field1.get(PlatformDependent.class);
            System.out.println("server DIRECT_MEMORY_LIMIT: " + directMemoryLimit/1024);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return batchTaskCenterService.findPager(bean, pager);
    }

    @Override
    public BatchTaskCenter findById(String id) throws BizException {
        return batchTaskCenterService.findById(id);
    }

}
