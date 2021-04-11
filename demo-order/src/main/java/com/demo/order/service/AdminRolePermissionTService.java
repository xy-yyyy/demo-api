package com.demo.order.service;


import com.demo.order.entity.AdminRolePermissionT;

import java.util.List;

public interface AdminRolePermissionTService{




    List<String> selectPermissionTIdList(List<String> roleTIdList);
}

