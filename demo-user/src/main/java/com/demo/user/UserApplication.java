package com.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 10:52 2020/8/27
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages ="com.demo.user.mapper")
@EnableFeignClients
public class UserApplication {
		public static void main(String[] args) {
				SpringApplication.run(UserApplication.class, args);
		}


}
