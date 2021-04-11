package com.demo.user.enums;

/**
 * @Author sunYF
 * @Description TODO
 * @Date 2020/11/15 16:01
 */
public enum ResultCode {
    /* 成功 */
    SUCCESS(200, "成功"),
    /* 默认失败 */
    FAIL(999, "失败"),
    LOGIN_SUCCESS(200, "登录成功"),
    LOGOUT_SUCCESS(200, "退出成功"),
    /* 参数错误：1000～1999 */
    PARAM_NOT_VALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),
    /* 用户错误 */
    USER_NOT_LOGIN(2001, "用户未登录"),
    USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
    USER_CREDENTIALS_ERROR(2003, "密码错误"),
    USER_CREDENTIALS_EXPIRED(2004, "密码过期"),
    USER_CODE_ERROR(2003, "验证码错误"),
    USER_ACCOUNT_DISABLE(2005, "账号不可用"),
    USER_ACCOUNT_LOCKED(2006, "账号被锁定"),
    USER_ACCOUNT_NOT_EXIST(2007, "账号不存在"),
    USER_ACCOUNT_ALREADY_EXIST(2008, "账号已存在"),
    USER_ACCOUNT_USE_BY_OTHERS(2009, "账号下线"),
    /* 业务错误 */
    NO_PERMISSION(3001, "没有权限");
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
    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static String getMsg(int key) {
        for (ResultCode c : ResultCode.values()) {
            if (c.getCode() == key) {
                return c.msg;
            }
        }
        return null;
    }
}
