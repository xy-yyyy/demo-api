package com.demo.order.service.impl;

import com.demo.order.entity.AdminUserT;
import com.demo.order.mapper.AdminUserTMapper;
import com.demo.order.pojo.adminUserT.AdminUserTAddParam;
import com.demo.order.pojo.adminUserT.AdminUserTPojo;
import com.demo.order.security.pojo.login.AdminUserTDubboPojo;
import com.demo.order.service.AdminUserTService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.Set;

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

    @Override
    public AdminUserTPojo selectAll() {
        AdminUserT adminUserT = adminUserTMapper.selectAll().get(1);
        AdminUserTPojo adminUserTPojo=new AdminUserTPojo();
        BeanUtils.copyProperties(adminUserT, adminUserTPojo);
        return adminUserTPojo;

    }

    @Override
    public AdminUserTPojo addAdminUser(AdminUserTAddParam param) {
        if(StringUtils.isEmpty(param.getLoginName())){
            throw new NullPointerException("1111");
        }
        AdminUserT adminUserT=new AdminUserT();
        BeanUtils.copyProperties(param,adminUserT);
        adminUserT.setId("111");
        adminUserT.setRemoved(Boolean.FALSE);
        int insert = adminUserTMapper.insert(adminUserT);
        return null;
    }

    @Override
    public Set<String> selectPerByUserId(String userId) {
        //获取权限
        Set<String> set=new HashSet<>();
        set.add("o1");
        set.add("o2");
        return set;
    }

}
