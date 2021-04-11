package com.demo.user.pojo.adminRoleT;

import lombok.Data;

import java.util.Date;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 14:20 2020/8/27
 */
@Data
public class AdminRoleTPojo {

    private String id;

    private String roleName;

    private String roleDescription;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
