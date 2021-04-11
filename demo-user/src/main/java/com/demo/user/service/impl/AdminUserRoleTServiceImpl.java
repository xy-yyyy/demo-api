package com.demo.user.service.impl;

import com.demo.user.entity.AdminUserRoleT;
import com.demo.user.mapper.AdminUserRoleTMapper;
import com.demo.user.service.AdminUserRoleTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdminUserRoleTServiceImpl implements AdminUserRoleTService {

    @Autowired
    private AdminUserRoleTMapper adminUserRoleTMapper;




    @Override
    public List<String> selectRoleTIdList(String userId) {
        Example adminUserRoleTExample = new Example(AdminUserRoleT.class);
        AdminUserRoleT adminUserRoleT = new AdminUserRoleT();
        adminUserRoleT.setRemoved(Boolean.FALSE);
        adminUserRoleT.setAdminUserTId(userId);
        return adminUserRoleTMapper.selectByExample(adminUserRoleTExample).stream()
                .map(x -> {
                    String roleTId = x.getAdminRoleTId();
                    return roleTId;
                }).collect(Collectors.toList());
    }
}
