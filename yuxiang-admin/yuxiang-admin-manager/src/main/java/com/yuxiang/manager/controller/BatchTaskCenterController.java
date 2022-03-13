package com.yuxiang.manager.controller;

import com.yuxiang.comm.ListResult;
import com.yuxiang.dto.BatchTaskCenterDto;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;
import com.yuxiang.remote.iface.search.IBatchTaskCenterSearch;
import io.netty.util.internal.PlatformDependent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/3/10 10:15
 */
@RestController
@RequestMapping("/batchTaskCenter")
public class BatchTaskCenterController {

    @Autowired
    IBatchTaskCenterSearch batchTaskCenterSearch;

    @RequestMapping("ajaxData")
    public Object findPage(int page, int rows, BatchTaskCenterDto dto) {

        Field field = ReflectionUtils.findField(PlatformDependent.class, "DIRECT_MEMORY_COUNTER");
        field.setAccessible(true);
        try {
            AtomicLong directMemoryCounter = (AtomicLong) field.get(PlatformDependent.class);
            System.out.println("manager DIRECT_MEMORY_COUNTER: " + directMemoryCounter.get()/1024);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field field1 = ReflectionUtils.findField(PlatformDependent.class, "DIRECT_MEMORY_LIMIT");
        field1.setAccessible(true);
        try {
            Long directMemoryLimit = (Long) field1.get(PlatformDependent.class);
            System.out.println("manager DIRECT_MEMORY_LIMIT: " + directMemoryLimit/1024);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Pager pager = new Pager();
        pager.setPageSize(rows);
        pager.setPageNumber(page);
        Paginater paginater = batchTaskCenterSearch.findPager(dto, pager);
        return new ListResult(paginater.getData(), paginater.getMaxRowCount());
    }
}
