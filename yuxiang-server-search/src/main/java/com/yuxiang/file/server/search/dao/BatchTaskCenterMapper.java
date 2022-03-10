package com.yuxiang.file.server.search.dao;

import com.yuxiang.file.dto.BatchTaskCenterDto;

import java.util.List;

public interface BatchTaskCenterMapper {

    Long count(BatchTaskCenterDto bean);

    List findPager(BatchTaskCenterDto bean);
}
