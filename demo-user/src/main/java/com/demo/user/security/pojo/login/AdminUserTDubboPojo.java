package com.demo.user.security.pojo.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 10:52 2020/11/16
 */
@Data
public class AdminUserTDubboPojo implements Serializable {


		private String id;

		private String loginName;

		private String password;

		private String nickName;

		private String realName;

		private String phone;

		private String email;

		private String remark;

		private Boolean locked;

}
