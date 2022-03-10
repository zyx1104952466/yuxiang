package com.yuxiang.manager.controller;

import com.yuxiang.comm.ListResult;
import com.yuxiang.dto.BatchTaskCenterDto;
import com.yuxiang.page.Pager;
import com.yuxiang.page.Paginater;
import com.yuxiang.remote.iface.IBatchTaskCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
