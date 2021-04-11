package com.demo.basic.security.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sunYF
 * @Description:无效token 异常重写
 * @Date: Create in 11:51 2020/11/20
 */
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint
{

		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
												 AuthenticationException authException) throws ServletException {
				Map<String, Object> map = new HashMap<String, Object>();
				Throwable cause = authException.getCause();
				if(cause instanceof InvalidTokenException) {
						map.put("code", 401);//401
						map.put("msg", "无效的token");
				}else{
						map.put("code", 401);
						map.put("msg", "访问此资源需要完全的身份验证");
				}
				map.put("data", authException.getMessage());
				map.put("success", false);
				map.put("path", request.getServletPath());
				map.put("timestamp", String.valueOf(System.currentTimeMillis()));
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				try {
						ObjectMapper mapper = new ObjectMapper();
						mapper.writeValue(response.getOutputStream(), map);
				} catch (Exception e) {
						throw new ServletException();
				}
		}
}