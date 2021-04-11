package com.demo.order.pojo.adminUserRoleT;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 19:25 2020/11/13
 */
@Data
public class AdminUserRoleTPojo {

		private String id;

		private String adminUserTId;

		private String adminRoleTId;

		private String createId;

		private LocalDateTime createTime;

		private String updateId;

		private LocalDateTime updateTime;

		private Integer version;

		private Boolean removed;
}
