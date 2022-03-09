package com.yuxiang.server.dao;

import com.yuxiang.dto.BatchTaskCenterDto;
import com.yuxiang.entity.BatchTaskCenter;

import java.util.List;

public interface BatchTaskCenterMapper {
    int insert(BatchTaskCenter record);

    int insertSelective(BatchTaskCenter record);

    void delete(String id);

    Long count(BatchTaskCenterDto bean);

    List findPager(BatchTaskCenterDto bean);
}
