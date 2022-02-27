package com.yuxiang.server.service;

import com.yuxiang.entity.BatchTaskCenter;
import com.yuxiang.server.dao.BatchTaskCenterMapper;
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

    public int insert(BatchTaskCenter record){
        return batchTaskCenterMapper.insert(record);
    }

    public int insertSelective(BatchTaskCenter record){
        return batchTaskCenterMapper.insertSelective(record);
    }
}
