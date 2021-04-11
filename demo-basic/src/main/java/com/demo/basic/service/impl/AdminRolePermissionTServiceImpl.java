package com.demo.basic.service.impl;


import com.demo.basic.entity.AdminRolePermissionT;
import com.demo.basic.mapper.AdminRolePermissionTMapper;
import com.demo.basic.service.AdminRolePermissionTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdminRolePermissionTServiceImpl implements AdminRolePermissionTService {

    @Autowired
    private AdminRolePermissionTMapper adminRolePermissionTMapper;



    @Override
    public AdminRolePermissionT selectByPrimaryKey(String id) {

        AdminRolePermissionT adminRolePermissionT=new AdminRolePermissionT();
        adminRolePermissionT.setId(id);
        adminRolePermissionT.setRemoved(Boolean.FALSE);
        Example example=new Example(AdminRolePermissionT.class);
        example.createCriteria().andEqualTo(adminRolePermissionT);
        return  adminRolePermissionTMapper.selectOneByExample(example);
    }

    @Override
    public List<String> selectPermissionTIdList(List<String> roleTIdList) {

        Example rolePermissionTExample = new Example(AdminRolePermissionT.class);
        AdminRolePermissionT adminRolePermissionT = new AdminRolePermissionT();
        adminRolePermissionT.setRemoved(Boolean.FALSE);
        rolePermissionTExample.createCriteria().andEqualTo(adminRolePermissionT);
        Example.Criteria cri2=rolePermissionTExample.createCriteria().andIn("adminRoleTId", roleTIdList);
        rolePermissionTExample.and(cri2);

        return adminRolePermissionTMapper.selectByExample(rolePermissionTExample).stream()
                .map(x -> {
                    String permissionTId =x.getAdminPermissionTId();
                    return permissionTId;
                }).collect(Collectors.toList());
    }
}

