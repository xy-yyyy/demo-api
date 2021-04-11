package com.demo.user.pojo.adminRoleT;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 14:22 2020/8/27
 */
@Data
@ApiModel(value = "角色查询参数", description = "角色查询参数")
public class AdminRoleTQueryParam {
    @ApiModelProperty(name = "id", value = "主键")
    private String id;
    @ApiModelProperty(name = "roleName", value = "角色名")
    private String roleName;
    @ApiModelProperty(name = "roleDescription", value = "简介")
    private String roleDescription;
    @ApiModelProperty(name = "status", value = "状态\\n0:禁用\\n1:启用")
    private Integer status;
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;
    @ApiModelProperty(name = "updateTime", value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(name = "pageNum", value = "页码")
    private Integer pageNum;
    @ApiModelProperty(name = "pageSize", value = "每页大小")
    private Integer pageSize;
}
