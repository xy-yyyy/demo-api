package com.demo.basic.security.filter;


import com.demo.basic.security.config.JWTConfig;
import com.demo.basic.security.pojo.securityT.SelfUserEntity;
import com.demo.basic.service.AdminUserTService;
import com.demo.basic.utils.GsonUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 11:03 2020/11/18
 */
@Component
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

		@Autowired
		AdminUserTService adminUserTService;

		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
																		FilterChain filterChain) throws ServletException, IOException {

				String tokenPre = request.getHeader("token");

				if (StringUtils.isNotBlank(tokenPre)) {

								String token = tokenPre.replace(JWTConfig.tokenPrefix, "");
								Claims claims = Jwts.parser()
												.setSigningKey(JWTConfig.secret)
												.parseClaimsJws(token)
												.getBody();
								log.info("claims,{}", claims);
								String username = claims.getSubject();
								if (!StringUtils.isEmpty(username)) {
										Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
										String authority = claims.get("authorities").toString();
										if (!StringUtils.isEmpty(authority)) {
												Set<Object> authorityMap = GsonUtils.fromJson(authority, Set.class);
												for (Object author : authorityMap) {
														Map author1 = (Map) author;
														String authority1 = author1.get("authority").toString();
														if (!StringUtils.isEmpty(authority1)) {
																authorities.add(new SimpleGrantedAuthority(authority1));
														}
												}
										}
										SelfUserEntity selfUserEntity = new SelfUserEntity();
										selfUserEntity.setUserId(adminUserTService.selectUserByName(username).getId());
										selfUserEntity.setUsername(claims.getSubject());
										selfUserEntity.setAuthorities(authorities);
										UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
														selfUserEntity,
														null,
														authorities);
										SecurityContextHolder.getContext().setAuthentication(authenticationToken);
								}
								filterChain.doFilter(request, response);


				} else {
						filterChain.doFilter(request, response);
				}
		}
}
