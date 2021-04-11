package com.demo.order;
/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 10:52 2020/8/27
 */

import com.demo.order.security.config.JWTConfig;
import com.demo.order.security.utils.JWTTokenUtil;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.demo.order.mapper")
public class OrderApplication {
		public static void main(String[] args) {
				SpringApplication.run(OrderApplication.class, args);
		}




}
