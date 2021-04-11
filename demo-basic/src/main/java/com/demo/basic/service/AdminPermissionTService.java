package com.demo.basic.service;


import com.demo.basic.security.pojo.login.PermissionTDubboPojo;

import java.util.List;

public interface AdminPermissionTService{


    List<PermissionTDubboPojo> selectAllByUserId(String id);
}

