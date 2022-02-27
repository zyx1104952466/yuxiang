package com.yuxiang.server.dao;

import com.yuxiang.entity.BatchTaskCenter;

public interface BatchTaskCenterMapper {
    int insert(BatchTaskCenter record);

    int insertSelective(BatchTaskCenter record);
}