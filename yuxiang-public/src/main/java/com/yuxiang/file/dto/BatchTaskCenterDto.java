package com.yuxiang.file.dto;

import com.yuxiang.file.entity.BatchTaskCenter;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/3/9 19:55
 */
public class BatchTaskCenterDto extends BatchTaskCenter {

    String createTimeStart;
    String createTimeEnd;

    public String getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
