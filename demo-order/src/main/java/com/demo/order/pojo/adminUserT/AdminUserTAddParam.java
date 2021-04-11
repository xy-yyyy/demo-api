package com.demo.order.pojo.adminUserT;

import com.demo.order.enums.moldtype.SexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 14:34 2021/2/28
 */
@ApiModel(value = "用户添加参数", description = "用户添加参数")
@Data
public class AdminUserTAddParam {
		@ApiModelProperty(name = "loginName", value = "用户名")
		private String loginName;
		@ApiModelProperty(name = "sex", value = "性别")
		private SexEnum sex;
}
