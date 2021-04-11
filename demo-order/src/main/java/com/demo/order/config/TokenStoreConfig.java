package com.demo.order.config;

import com.demo.order.security.config.JWTConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;
import java.util.Collections;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 19:33 2021/4/6
 */
@Configuration
@Slf4j
public class TokenStoreConfig {

		@Autowired
		public JWTConfig jwtConfig;


		@Bean
		public JwtAccessTokenConverter accessTokenConverter() {
				JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
				log.info("{}", JWTConfig.secret);
				log.info("{}", JWTConfig.tokenPrefix);
				log.info("{}", JWTConfig.expiration);
				log.info("{}", JWTConfig.tokenHeader);
				converter.setSigningKey(JWTConfig.secret);
				return converter;
		}

		@Autowired
		@Qualifier("myClientDetailsService")
		private ClientDetailsService clientService;

		@Bean
		public TokenStore tokenStore() {
				return new JwtTokenStore(accessTokenConverter());
		}


		/**
		 * 配置令牌管理
		 */
		@Bean
		public AuthorizationServerTokenServices tokenService(ClientDetailsService clientDetailsService, TokenStore tokenStore
						, JwtAccessTokenConverter accessTokenConverter) {
				DefaultTokenServices service = new DefaultTokenServices();
				service.setClientDetailsService(clientDetailsService);
				service.setSupportRefreshToken(true);
				service.setTokenStore(tokenStore);
				TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
				tokenEnhancerChain.setTokenEnhancers(Collections.singletonList(accessTokenConverter));
				service.setTokenEnhancer(tokenEnhancerChain);
				return service;
		}

		/**
		 * 授权码存储方式
		 */

		@Bean
		public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
				return new JdbcAuthorizationCodeServices(dataSource);
		}

		@Bean
		public PasswordEncoder passwordEncoder() {
				return new BCryptPasswordEncoder();
		}

		@Bean("myClientDetailsService")
		public ClientDetailsService clientDetailsService(DataSource dataSource, PasswordEncoder passwordEncoder) {
				JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
				clientDetailsService.setPasswordEncoder(passwordEncoder);
				return clientDetailsService;
		}

}
