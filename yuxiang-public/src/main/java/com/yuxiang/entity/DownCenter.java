package com.yuxiang.entity;

import java.util.Date;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/2/24 10:34
 */
public class DownCenter {

    private Long id;
    private Date createTime;
    private Date updateTime;
    private String creatorId;
    private String downUrl;
    /**
     * 任务状态：0-处理中，1-处理完成，2-处理失败，3-待处理
     */
    private String buildSts;
    private String remark;
    private String taskName;
    private String	upurl;
    private String	tasktype;
    private String	errremark;
    /**
     * 参数对象（JSON格式）
     */
    private String	prams;
    private String moduleClassName;
    private String creatorOrgNo;
    /**
     * 文件存储位置（0-共享磁盘；1-分布式文件系统）
     */
    private String saveType;
    /**
     * 清理标识（0-可清理，1-不可清理 2-清理失败）
     */
    private String cleanFlag;
    /**
     * 原文件名（上传功能必填）
     */
    private String fileName;
    /**
     * 错误代码（返回码）00-成功；50-超时；99-失败；
     */
    private String	errcode;
    /**
     * 子系统编号
     */
    private String sysId;
    /**
     * 业务系统名称：POSP运营系统；POSP报表系统；POSP风控系统；支付管理系统；清算管理系统；
     */
    private String sysName;
    /**
     * 通知业务系统地址
     */
    private String  notifyUrl;
    /**
     * 脱敏白名单字段
     */
    private Integer desensity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public String getBuildSts() {
        return buildSts;
    }

    public void setBuildSts(String buildSts) {
        this.buildSts = buildSts;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getUpurl() {
        return upurl;
    }

    public void setUpurl(String upurl) {
        this.upurl = upurl;
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype;
    }

    public String getErrremark() {
        return errremark;
    }

    public void setErrremark(String errremark) {
        this.errremark = errremark;
    }

    public String getPrams() {
        return prams;
    }

    public void setPrams(String prams) {
        this.prams = prams;
    }

    public String getModuleClassName() {
        return moduleClassName;
    }

    public void setModuleClassName(String moduleClassName) {
        this.moduleClassName = moduleClassName;
    }

    public String getCreatorOrgNo() {
        return creatorOrgNo;
    }

    public void setCreatorOrgNo(String creatorOrgNo) {
        this.creatorOrgNo = creatorOrgNo;
    }

    public String getSaveType() {
        return saveType;
    }

    public void setSaveType(String saveType) {
        this.saveType = saveType;
    }

    public String getCleanFlag() {
        return cleanFlag;
    }

    public void setCleanFlag(String cleanFlag) {
        this.cleanFlag = cleanFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Integer getDesensity() {
        return desensity;
    }

    public void setDesensity(Integer desensity) {
        this.desensity = desensity;
    }
}
