package com.demo.basic.pojo.adminRoleT;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 14:21 2020/8/27
 */
@ApiModel(value = "角色添加参数", description = "角色添加参数")
@Data
public class AdminRoleTAddParam {

    @ApiModelProperty(name = "roleName", value = "角色名")
    private String roleName;
    @ApiModelProperty(name = "roleDescription", value = "简介")
    private String roleDescription;
    @ApiModelProperty(name = "status", value = "状态\\n0:禁用\\n1:启用")
    private Integer status;
}
