package com.demo.user.service;

import com.demo.user.entity.AdminRolePermissionT;

import java.util.List;

public interface AdminRolePermissionTService{




    AdminRolePermissionT selectByPrimaryKey(String id);

    List<String> selectPermissionTIdList(List<String> roleTIdList);
}

