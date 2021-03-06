package com.demo.order.security.config;

import com.demo.order.config.YmlAndPropertySourceFactory;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author sunYF
 * @Description JWT配置类
 * @Date 2020/11/15 20:55
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "jwt")
@PropertySource(value = {"classpath:config/tokenconfig.yml"},factory = YmlAndPropertySourceFactory.class)
public class JWTConfig {


		/**
		 * 密钥KEY
		 */
		public static String secret;
		/**
		 * TokenKey
		 */
		public static String tokenHeader;
		/**
		 * Token前缀字符
		 */
		public static String tokenPrefix;
		/**
		 * 过期时间
		 */
		public static Integer expiration;
		/**
		 * 不需要认证的接口
		 */
		public static String antMatchers;

		public void setSecret(String secret) {
				JWTConfig.secret = secret;
		}

		public void setTokenHeader(String tokenHeader) {
				JWTConfig.tokenHeader = tokenHeader;
		}

		public void setTokenPrefix(String tokenPrefix) {
				JWTConfig.tokenPrefix = tokenPrefix;
		}

		public void setExpiration(Integer expiration) {
				JWTConfig.expiration = expiration * 1000;
		}

		public void setAntMatchers(String antMatchers) {
				JWTConfig.antMatchers = antMatchers;
		}
}