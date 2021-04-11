package com.demo.basic.service.impl;


import com.demo.basic.entity.AdminRoleT;
import com.demo.basic.mapper.AdminRoleTMapper;
import com.demo.basic.service.AdminRoleTService;
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
