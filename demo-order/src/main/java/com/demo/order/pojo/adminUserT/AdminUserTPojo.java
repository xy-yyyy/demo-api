package com.demo.order.pojo.adminUserT;

import com.demo.order.enums.moldtype.SexEnum;
import lombok.Data;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 10:52 2020/11/16
 */
@Data
public class AdminUserTPojo {


		private String id;

		private String loginName;

		private String password;

		private String nickName;
		private SexEnum sex;

		private String realName;

		private String phone;

		private String email;

		private String remark;

		private Boolean locked;

}
