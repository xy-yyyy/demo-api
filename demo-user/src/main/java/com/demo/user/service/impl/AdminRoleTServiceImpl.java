package com.demo.user.service.impl;


import com.demo.user.entity.AdminRoleT;
import com.demo.user.mapper.AdminRoleTMapper;
import com.demo.user.service.AdminRoleTService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminRoleTServiceImpl implements AdminRoleTService {

    @Resource
    private AdminRoleTMapper adminRoleTMapper;

    @Override
    public AdminRoleT selectByPrimaryKey(String id) {
        return adminRoleTMapper.selectByPrimaryKey(id);
    }



}
