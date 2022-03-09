package com.yuxiang.entity;

import java.io.Serializable;
import java.util.Date;

public class BatchTaskCenter implements Serializable {
    private String id;

    private String taskName;

    private String buildStatus;

    private String taskType;

    private String creatorName;

    private Date createTime;

    private Date updateTime;

    private String batchSid;

    private String remark;

    private String params;

    public BatchTaskCenter(String id, String taskName, String buildStatus, String taskType, String creatorName, Date createTime, Date updateTime, String batchSid, String remark, String params) {
        this.id = id;
        this.taskName = taskName;
        this.buildStatus = buildStatus;
        this.taskType = taskType;
        this.creatorName = creatorName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.batchSid = batchSid;
        this.remark = remark;
        this.params = params;
    }

    public BatchTaskCenter() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getBuildStatus() {
        return buildStatus;
    }

    public void setBuildStatus(String buildStatus) {
        this.buildStatus = buildStatus == null ? null : buildStatus.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBatchSid() {
        return batchSid;
    }

    public void setBatchSid(String batchSid) {
        this.batchSid = batchSid == null ? null : batchSid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
}
