package com.demo.order.pojo.adminUserT;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 15:39 2020/11/12
 */
@ApiModel(value = "用户登录参数", description = "用户登录参数")
@Data
public class AdminUserTLoginParam {
		@ApiModelProperty(name = "loginName", value = "用户名")
		private String loginName;
		@ApiModelProperty(name = "password", value = "密码")
		private String password;
}
