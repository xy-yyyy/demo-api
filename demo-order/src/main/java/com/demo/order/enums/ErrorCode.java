package com.demo.order.enums;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 15:17 2020/8/27
 */
public enum ErrorCode {
    SUCCESS(200,"SUCCESS"),
    ERROR_PARAM_NULL(500, "参数不能为空"),
    ERROR_IDCODE_NULL(500, "主键不能为空"),
    ERROR_DB_EXCEPTION(500, "数据库操作失败");

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(int key) {
        for (ErrorCode c : ErrorCode.values()) {
            if (c.getCode() == key) {
                return c.msg;
            }
        }
        return null;
    }
}
