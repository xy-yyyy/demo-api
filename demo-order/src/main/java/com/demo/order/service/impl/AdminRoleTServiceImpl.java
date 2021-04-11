package com.demo.order.service.impl;


import com.demo.order.entity.AdminRoleT;
import com.demo.order.mapper.AdminRoleTMapper;
import com.demo.order.service.AdminRoleTService;
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
