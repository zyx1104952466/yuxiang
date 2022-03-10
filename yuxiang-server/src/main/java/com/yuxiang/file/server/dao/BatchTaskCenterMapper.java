package com.yuxiang.file.server.dao;

import com.yuxiang.file.dto.BatchTaskCenterDto;
import com.yuxiang.file.entity.BatchTaskCenter;

import java.util.List;

public interface BatchTaskCenterMapper {
    int insert(BatchTaskCenter record);

    int insertSelective(BatchTaskCenter record);

    void delete(String id);

    Long count(BatchTaskCenterDto bean);

    List findPager(BatchTaskCenterDto bean);
}
