package com.demo.user.pojo.adminemployeet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 12:56 2020/8/28
 */
@ApiModel(value = "员工信息添加参数", description = "员工信息添加参数")
@Data
public class AdminEmployeeTAddParam {
    @ApiModelProperty(name = "loginname", value = "员工登录名")
    private String loginname;
    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;
    @ApiModelProperty(name = "password", value = "密码")
    private String password;
    @ApiModelProperty(name = "realname", value = "真实姓名")
    private String realname;
    @ApiModelProperty(name = "gender", value = "性别，0为女，1为男")
    private Boolean gender;
    @ApiModelProperty(name = "status", value = "员工状态，0位入职中，1为已离职")
    private Integer status;
    @ApiModelProperty(name = "type", value = "0:后台账号,\\n1:企业账号")
    private String type;
    @ApiModelProperty(name = "phone", value = "手机号")
    private String phone;

}
