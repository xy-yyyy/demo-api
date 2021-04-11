package com.demo.order.pojo.adminPermissionT;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 19:09 2020/11/13
 */
@Data
public class AdminPermissionTPojo {
		private String id;
		private String permission;
		private String description;
		private String action;
		private String createId;
		private LocalDateTime createTime;
		private String updateId;
		private LocalDateTime updateTime;
		private Integer version;
		private Boolean removed;
}
