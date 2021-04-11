package com.demo.basic.service;



import com.demo.basic.entity.AdminRolePermissionT;

import java.util.List;

public interface AdminRolePermissionTService{




    AdminRolePermissionT selectByPrimaryKey(String id);

    List<String> selectPermissionTIdList(List<String> roleTIdList);
}

