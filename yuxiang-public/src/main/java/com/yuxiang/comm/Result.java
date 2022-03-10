package com.yuxiang.comm;

/**
 * 统一对外通用包装类
 * @author xw
 * @date 2021/10/22 17:07
 */
public class Result<T> extends BaseObject{

    private String respCode = ReturnCodeEnum.FAIL.getCode();
    private String respDesc = ReturnCodeEnum.FAIL.getDesc();
    private T respData;

    public Result() {
    }

    public Result(String respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public Result(String respCode, String respDesc, T respData) {
        this.respCode = respCode;
        this.respDesc = respDesc;
        this.respData = respData;
    }

    public static <T> Result<T> ok() {
        return new Result<>(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getDesc(), null);
    }

    public static <T> Result<T> ok(T t) {
        return new Result<>(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getDesc(), t);
    }

    public static <T> Result<T> fail() {
        return new Result<>(ReturnCodeEnum.FAIL.getCode(), ReturnCodeEnum.FAIL.getDesc());
    }

    public static <T> Result<T> fail(ReturnCodeEnum returnCodeEnum) {
        return new Result<>(returnCodeEnum.getCode(), returnCodeEnum.getDesc());
    }

    public static <T> Result<T> fail(String respDesc) {
        return new Result<>(ReturnCodeEnum.FAIL.getCode(), respDesc);
    }

    public static <T> Result<T> fail(String respCode, String respDesc) {
        return new Result<>(respCode, respDesc);
    }

    public static <T> Result<T> newInstance(String respCode, String respDesc, T respData) {
        return new Result<>(respCode, respDesc, respData);
    }

    public boolean isSuccess() {
        return ReturnCodeEnum.SUCCESS.getCode().equals(respCode);
    }


    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public T getRespData() {
        return respData;
    }

    public void setRespData(T respData) {
        this.respData = respData;
    }

}
