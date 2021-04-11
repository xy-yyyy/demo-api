package com.demo.user.service.impl;

import com.demo.user.entity.AdminPermissionT;
import com.demo.user.mapper.AdminPermissionTMapper;
import com.demo.user.security.pojo.login.PermissionTDubboPojo;
import com.demo.user.service.AdminPermissionTService;
import com.demo.user.service.AdminRolePermissionTService;
import com.demo.user.service.AdminUserRoleTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdminPermissionTServiceImpl implements AdminPermissionTService {

    @Autowired
    AdminUserRoleTService adminUserRoleTService;
    @Autowired
    AdminRolePermissionTService adminRolePermissionTService;
    @Autowired
    private AdminPermissionTMapper adminPermissionTMapper;
    @Override
    public List<PermissionTDubboPojo> selectAllByUserId(String userId) {
        List<String> roleTIdList =	adminUserRoleTService.selectRoleTIdList(userId);
        List<String> permissionTIdList = 	adminRolePermissionTService.selectPermissionTIdList(roleTIdList);
        Example permissionTExample = new Example(AdminPermissionT.class);
        AdminPermissionT adminPermissionT = new AdminPermissionT();
        adminPermissionT.setRemoved(Boolean.FALSE);
        permissionTExample.createCriteria().andEqualTo(adminPermissionT);
        Example.Criteria cri3=permissionTExample.createCriteria().andIn("id", permissionTIdList);
        permissionTExample.and(cri3);
        return adminPermissionTMapper.selectByExample(permissionTExample)
                .stream()
                .map(x->{
                    PermissionTDubboPojo adminPermissionTDubboPojo=new PermissionTDubboPojo();
                    BeanUtils.copyProperties(x,adminPermissionTDubboPojo);
                    return adminPermissionTDubboPojo;
                }).collect(Collectors.toList());
    }
}

