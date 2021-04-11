package com.demo.basic.enums.moldtype;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 15:48 2020/8/27
 */
public enum StatusEnum {
    FORBIDDEN("FORBIDDEN", 0, "禁用"),
    START_USING("START_USING", 1, "启用");
    private String codeName;
    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    StatusEnum(String codeName, int code, String name) {
        this.codeName = codeName;
        this.code = code;
        this.name = name;
    }

    public static StatusEnum getName(int code) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.getCode() == code) {
                return c;
            }
        }
        return null;
    }
}
