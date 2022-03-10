package com.yuxiang.file.server.batch.service;

import com.yuxiang.file.server.batch.dao.BatchTaskCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 14:51
 */
@Service
public class BatchTaskCenterService {

    @Autowired
    BatchTaskCenterMapper batchTaskCenterMapper;
}
