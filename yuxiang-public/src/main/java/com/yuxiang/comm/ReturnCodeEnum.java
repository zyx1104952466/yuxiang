package com.yuxiang.comm;

/**
 * 返回码枚举
 * @author xw
 * @date 2021/10/22 17:09
 */
public enum ReturnCodeEnum {

    /** 00~99：系统级返回码 */
    SUCCESS("00", "操作成功"),
    FAIL("01", "操作失败"),
    PARAM_MISS("20", "参数缺少"),
    PARAM_ERR("21", "参数错误"),
    SYSTEM_ERR("99", "系统错误");

    private final String code;

    private final String desc;

    ReturnCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
