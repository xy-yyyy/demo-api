package com.demo.order.service;


import com.demo.order.security.pojo.login.PermissionTDubboPojo;

import java.util.List;

public interface AdminPermissionTService{


    List<PermissionTDubboPojo> selectAllByUserId(String id);
}

