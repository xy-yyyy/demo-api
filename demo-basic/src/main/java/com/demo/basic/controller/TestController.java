package com.demo.basic.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 14:30 2020/8/27
 */
@Api(tags = {"demo-basic相关接口"})
@RequestMapping("/basic")
@RestController
@Slf4j
public class TestController {
		/**
		 * 测试资源1
		 */

		@GetMapping("/b/b1")
		@PreAuthorize("hasAnyAuthority('1')")
		//@PreAuthorize("hasAnyAuthority('p1','p2')")
		public String b1() {
				return "资源1";
		}

		/**
		 * 测试资源2
		 */
		@GetMapping("/b/b2")
		public String b2() {
				return "资源2";
		}

		@GetMapping("/b/b3")
		@PreAuthorize("hasAnyAuthority('3')")
		//@PreAuthorize("hasAnyAuthority('p1','p2')")
		public String b3() {
				return "资源3";
		}
}
