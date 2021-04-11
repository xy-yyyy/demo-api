package com.demo.order.controller;

import com.demo.order.pojo.adminUserT.AdminUserTAddParam;
import com.demo.order.service.AdminUserTService;
import com.demo.order.utils.GsonUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 14:01 2020/11/30
 */
@Api(tags = {"demo-order相关接口"})
@RequestMapping("/order")
@RestController
@Slf4j
public class TestController {
@Autowired
AdminUserTService adminUserTService;


		@GetMapping("/testHandlers")
		public Object testHandlers(){

				return adminUserTService.selectAll();
		}

		@PostMapping("/testHandlers2")
		public Object testHandlers2(@RequestBody  AdminUserTAddParam param){
				return adminUserTService.addAdminUser(param);
		}


		/**
		 * 测试资源1
		 */

		@GetMapping("/o/o1")
		@PreAuthorize("hasAnyAuthority('1')")
		//@PreAuthorize("hasAnyAuthority('p1','p2')")
		public String o1() {
				return "资源1";
		}

		/**
		 * 测试资源2
		 */
		@GetMapping("/o/o2")
		public String o2() {
				return "资源2";
		}

		@GetMapping("/o/o3")
		@PreAuthorize("hasAnyAuthority('3')")
		//@PreAuthorize("hasAnyAuthority('p1','p2')")
		public String o3() {
				return "资源3";
		}
}
