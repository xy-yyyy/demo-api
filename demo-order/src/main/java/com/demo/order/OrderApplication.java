package com.demo.order;
/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 10:52 2020/8/27
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.demo.order.mapper")
@EnableFeignClients
public class OrderApplication {
		public static void main(String[] args) {
				SpringApplication.run(OrderApplication.class, args);
		}




}
