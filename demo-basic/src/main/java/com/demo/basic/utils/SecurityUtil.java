package com.demo.basic.utils;

import com.demo.basic.security.pojo.securityT.SelfUserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Description:
 * @Author: sunYF
 * @Date: 2021/7/8 16:46
 */
public class SecurityUtil {
    public static SelfUserEntity getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (null != context) {
            Authentication authentication = context.getAuthentication();
            if (null != authentication) {
                Object principal = authentication.getPrincipal();
                if (null != principal) {
                   if(principal instanceof SelfUserEntity){
                       return (SelfUserEntity) principal;
                   }else{
                       return null;
                   }
                }

            }
        }
        return null;
    }

}
