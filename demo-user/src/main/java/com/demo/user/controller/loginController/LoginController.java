package com.demo.user.controller.loginController;

import com.demo.common.vo.ResultPojo;
import com.demo.user.enums.ResultCode;
import com.demo.user.feign.FeignConsumerService;
import com.demo.user.security.config.JWTConfig;
import com.demo.user.security.pojo.login.AdminUserQueryParam;
import com.demo.user.security.pojo.login.AdminUserTDubboPojo;
import com.demo.user.security.utils.JWTTokenUtil;
import com.demo.user.service.AdminPermissionTService;
import com.demo.user.service.AdminUserTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: sunYF
 * @Description:
 * @Date: Create in 12:34 2020/11/30
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class LoginController {
@Autowired
    FeignConsumerService feignConsumerService;
    @Autowired
    AdminUserTService adminUserTService;
    @Autowired
    AdminPermissionTService adminPermissionTService;

    @PostMapping("/login")
    public ResultPojo login(@RequestBody AdminUserQueryParam param) {

        //String admin = BCrypt.hashpw("admin", BCrypt.gensalt());

        AdminUserTDubboPojo user = adminUserTService.selectUserByName(param.getUsername());
     
        if (user != null && BCrypt.checkpw(param.getPassword(), user.getPassword())) {
            //当前用户权限key
            Set<String> set = adminPermissionTService.selectAllByUserId(user.getId())
                    .stream()
                    .map(x -> {
                        return x.getPermission();
                    }).collect(Collectors.toSet());
//查询order服务权限
            ResultPojo resultPojo = feignConsumerService.hello(user.getId());

            if (null != resultPojo) {
                if (null != resultPojo.getObject()) {
                    if (null!=resultPojo.getObject()) {
                        List<String> oSet = (List<String>)resultPojo.getObject();
                       if(null!=oSet&&oSet.size()>0){
                           set.addAll(oSet.stream().collect(Collectors.toSet()));
                       }
                    }

                }
            }
            String[] keys = set.toArray(new String[set.size()]);
            UserDetails userDetails =
                    User.withUsername(user.getLoginName())
                            .password(user.getPassword())
                            .authorities(keys)
                            .build();
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities());
            String token = JWTTokenUtil.createAccessToken(userDetails);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return ResultPojo.builder().code(ResultCode.LOGIN_SUCCESS.getCode()).message(ResultCode.LOGIN_SUCCESS.getMsg())
                    .object(JWTConfig.tokenPrefix + token).build();
        }
        return ResultPojo.builder().code(ResultCode.USER_CREDENTIALS_ERROR.getCode()).message(ResultCode.USER_CREDENTIALS_ERROR.getMsg()).build();

    }

    @PostMapping("/logout")
    public ResultPojo loginout() {
        SecurityContextHolder.clearContext();

        return ResultPojo.builder().code(ResultCode.LOGOUT_SUCCESS.getCode()).message(ResultCode.LOGOUT_SUCCESS.getMsg()).build();


    }

}
