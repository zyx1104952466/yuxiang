package com.yuxiang.file.comm;

/**
 * @Author: cw
 * @Date: 2021-11-4 10:39
 * @ClassName: ListResult
 * @Description: 列表结果
 */
public class ListResult<T> extends Result<T> {
    private T rows;
    private Long total;

    public ListResult() {
    }

    public ListResult(T rows, Long total) {
        this.setTotal(total);
        this.setRespCode(ReturnCodeEnum.SUCCESS.getCode());
        this.setRespDesc(ReturnCodeEnum.SUCCESS.getDesc());
        this.setRespData(rows);
    }

    @Override
    public void setRespData(T respData) {
        super.setRespData(respData);
        this.rows = respData;
    }

    public T getRows() {
        return rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
