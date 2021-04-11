package com.demo.basic.security.pojo.login;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 19:09 2020/11/13
 */
@Data
public class PermissionTDubboPojo implements Serializable {
		private String id;
		private String permission;
		private String description;
		private String action;
}
