package com.demo.order.service.impl;


import com.demo.order.entity.AdminPermissionT;
import com.demo.order.mapper.AdminPermissionTMapper;
import com.demo.order.security.pojo.login.PermissionTDubboPojo;
import com.demo.order.service.AdminPermissionTService;
import com.demo.order.service.AdminRolePermissionTService;
import com.demo.order.service.AdminUserRoleTService;
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
    // @GlobalTransactional(timeoutMills =300000,name = "test-global-transactional",rollbackFor = Exception.class)
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

