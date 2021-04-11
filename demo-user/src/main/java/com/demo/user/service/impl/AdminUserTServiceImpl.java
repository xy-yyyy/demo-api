package com.demo.user.service.impl;

import com.demo.user.entity.AdminUserT;
import com.demo.user.mapper.AdminUserTMapper;
import com.demo.user.security.pojo.login.AdminUserTDubboPojo;
import com.demo.user.service.AdminUserTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
@Slf4j
public class AdminUserTServiceImpl implements AdminUserTService {

    @Autowired
    private AdminUserTMapper adminUserTMapper;
    @Override
    public AdminUserTDubboPojo selectUserByName(String loginName) {
        AdminUserT adminUserT = new AdminUserT();
        adminUserT.setLoginName(loginName);
        adminUserT.setRemoved(Boolean.FALSE);
        Example example = new Example(AdminUserT.class);
        example.createCriteria().andEqualTo(adminUserT);
        AdminUserT param = adminUserTMapper.selectOneByExample(example);
        AdminUserTDubboPojo pojo=new AdminUserTDubboPojo();
        if(null!=param){
            BeanUtils.copyProperties(param,pojo);
        }
        return pojo;
    }

}
