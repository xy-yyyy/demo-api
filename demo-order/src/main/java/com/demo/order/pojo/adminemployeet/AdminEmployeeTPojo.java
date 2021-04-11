package com.demo.order.pojo.adminemployeet;

import lombok.Data;

import java.util.Date;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 12:55 2020/8/28
 */
@Data
public class AdminEmployeeTPojo {
    private String id;

    private String loginname;

    private String email;

    private String password;

    private String realname;

    private Boolean gender;

    private Integer status;

    private String type;

    private String phone;

    private Boolean removed;

    private Date createTime;

    private Date updateTime;

}