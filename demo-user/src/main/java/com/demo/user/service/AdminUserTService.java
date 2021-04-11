package com.demo.user.service;


import com.demo.user.entity.AdminUserT;
import com.demo.user.security.pojo.login.AdminUserTDubboPojo;

public interface AdminUserTService{


    AdminUserTDubboPojo selectUserByName(String loginName);
}
