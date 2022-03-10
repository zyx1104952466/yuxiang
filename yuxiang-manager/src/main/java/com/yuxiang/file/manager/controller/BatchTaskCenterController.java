package com.yuxiang.file.manager.controller;

import com.yuxiang.file.comm.ListResult;
import com.yuxiang.file.dto.BatchTaskCenterDto;
import com.yuxiang.file.page.Pager;
import com.yuxiang.file.page.Paginater;
import com.yuxiang.file.remote.iface.IBatchTaskCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/3/10 10:15
 */
@RestController
@RequestMapping("/batchTaskCenter")
public class BatchTaskCenterController {

    @Autowired
    IBatchTaskCenter batchTaskCenterServer;

    @RequestMapping("ajaxData")
    public Object findPage(int page, int rows, BatchTaskCenterDto dto) {
        Pager pager = new Pager();
        pager.setPageSize(rows);
        pager.setPageNumber(page);
        Paginater paginater = batchTaskCenterServer.findPager(dto, pager);
        return new ListResult(paginater.getData(), paginater.getMaxRowCount());
    }
}
