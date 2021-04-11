package com.demo.user.security.config;

import com.demo.user.security.exception.AuthExceptionEntryPoint;
import com.demo.user.security.handler.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 11:35 2020/11/18
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {
		@Autowired
		CustomAccessDeniedHandler customAccessDeniedHandler;
		@Autowired
		AuthExceptionEntryPoint authExceptionEntryPoint;
		@Autowired
		TokenStore tokenStore;
		@Override
		public void configure(ResourceServerSecurityConfigurer resource) throws Exception {

				resource.tokenStore(tokenStore).authenticationEntryPoint(authExceptionEntryPoint)
								.accessDeniedHandler(customAccessDeniedHandler);
		}
		@Override
		public void configure(HttpSecurity http) throws Exception {
				http.cors();
				http.csrf().disable().authorizeRequests()
								.antMatchers("/**")
								.permitAll()
								//.accessDecisionManager(customAccessDeniedHandler)
								.and()
								.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
								.and()
								.sessionManagement()
								.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
								.and()
								.authorizeRequests();
		}
		/**
		 * 密码加密工具
		 *
		 * @return
		 */
		@Bean
		public PasswordEncoder passwordEncoder() {
				return new BCryptPasswordEncoder();
		}

}
