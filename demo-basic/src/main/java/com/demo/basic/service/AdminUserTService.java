package com.demo.basic.service;


import com.demo.basic.security.pojo.login.AdminUserTDubboPojo;

public interface AdminUserTService{


    AdminUserTDubboPojo selectUserByName(String loginName);
}
