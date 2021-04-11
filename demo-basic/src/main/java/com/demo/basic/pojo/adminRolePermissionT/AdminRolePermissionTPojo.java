package com.demo.basic.pojo.adminRolePermissionT;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 19:13 2020/11/13
 */
@Data
public class AdminRolePermissionTPojo {
		private String id;
		private String adminRoleTId;
		private String adminPermissionTId;
		private String createId;
		private LocalDateTime createTime;
		private String updateId;
		private LocalDateTime updateTime;
		private Integer version;
		private Boolean removed;
}
