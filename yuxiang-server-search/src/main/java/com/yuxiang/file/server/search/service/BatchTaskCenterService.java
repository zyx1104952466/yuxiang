package com.yuxiang.file.server.search.service;

import com.github.pagehelper.PageHelper;
import com.yuxiang.file.dto.BatchTaskCenterDto;
import com.yuxiang.file.page.Pager;
import com.yuxiang.file.page.Paginater;
import com.yuxiang.file.server.search.dao.BatchTaskCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:51
 */
@Service
public class BatchTaskCenterService {

    @Autowired
    BatchTaskCenterMapper batchTaskCenterMapper;

    public Paginater findPager(BatchTaskCenterDto bean, Pager pager) {
        // 查询总笔数
        Long count = batchTaskCenterMapper.count(bean);
        // 组装分页对象
        Paginater paginater = new Paginater(count, pager.getPageNumber());
        PageHelper.startPage((int) pager.getPageNumber(), pager.getPageSize());
        // 执行分页查询
        List resultList = batchTaskCenterMapper.findPager(bean);
        // 设置返回数据对象
        paginater.setData(resultList);
        return paginater;
    }
}
