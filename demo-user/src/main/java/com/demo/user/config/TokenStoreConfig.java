package com.demo.user.config;

import com.demo.user.security.config.JWTConfig;
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

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 19:47 2021/4/6
 */
@Configuration
public class TokenStoreConfig {
		@Autowired
		public JWTConfig jwtConfig;
		@Bean
		public JwtAccessTokenConverter accessTokenConverter() {
				JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
				converter.setSigningKey(JWTConfig.secret);
				return converter;
		}

		@Bean
		public TokenStore tokenStore() {
				return new JwtTokenStore(accessTokenConverter());
		}



		@Autowired
		@Qualifier("myClientDetailsService")
		private ClientDetailsService clientService;

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
