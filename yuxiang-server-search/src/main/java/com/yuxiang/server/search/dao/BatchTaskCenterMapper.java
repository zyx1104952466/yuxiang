package com.yuxiang.server.search.dao;

import com.yuxiang.dto.BatchTaskCenterDto;
import com.yuxiang.entity.BatchTaskCenter;

import java.util.List;

public interface BatchTaskCenterMapper {

    Long count(BatchTaskCenterDto bean);

    List findPager(BatchTaskCenterDto bean);

    BatchTaskCenter findById(String id);
}
