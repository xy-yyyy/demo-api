package com.demo.order.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sunYF
 * @Description: 权限不足异常类重写
 * @Date: Create in 11:52 2020/11/20
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

		@Override
		public void handle(HttpServletRequest request, HttpServletResponse response,
											 AccessDeniedException accessDeniedException)
						throws IOException, ServletException {
				response.setContentType("application/json;charset=UTF-8");
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("code", 401);//401
				map.put("msg", "权限不足");
				map.put("data", accessDeniedException.getMessage());
				map.put("success", false);
				map.put("path", request.getServletPath());
				map.put("timestamp", String.valueOf(System.currentTimeMillis()));
				ObjectMapper mapper = new ObjectMapper();
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write(mapper.writeValueAsString(map));
		}
}