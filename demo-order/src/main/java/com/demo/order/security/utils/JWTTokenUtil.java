package com.demo.order.security.utils;

import com.alibaba.fastjson.JSON;
import com.demo.order.security.config.JWTConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

/**
 * @Author sunYF
 * @Description JWT工具类
 * @Date 2020/11/15 20:47
 */
@Slf4j
public class JWTTokenUtil {
    /**
     * 生成Token
     * @Author  sunYF
     * @Param  selfUserEntity 用户安全实体
     * @Return Token
     */
    public static String createAccessToken( UserDetails userDetails){
        // 登陆成功生成JWT
        String token = Jwts.builder()
                // 主题
                .setSubject(userDetails.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("sunYF")
                // 自定义属性 放入用户拥有权限
                .claim("authorities", JSON.toJSONString(userDetails.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS256, JWTConfig.secret)
                .compact();
        return token;
    }
}

