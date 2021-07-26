package com.demo.user.controller;

import com.demo.common.vo.ResultCode;
import com.demo.common.vo.ResultPojo;
import com.demo.user.service.AdminUserTService;
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
@Api(tags = {"user相关接口"})
@RequestMapping("/user")
@RestController
@Slf4j
public class TestController {
		/**
		 * 测试资源1
		 */

		@GetMapping("/p/p1")
		@PreAuthorize("hasAnyAuthority('p1')")
		//@PreAuthorize("hasAnyAuthority('p1','p2')")
		public String p1() {
				return "资源1";
		}

		/**
		 * 测试资源2
		 */
		@GetMapping("/p/p2")
		public String p2() {
				return "资源2";
		}

		@GetMapping("/p/p3")
		@PreAuthorize("hasAnyAuthority('p3')")
		//@PreAuthorize("hasAnyAuthority('p1','p2')")
		public String p3() {
				return "资源3";
		}
}
