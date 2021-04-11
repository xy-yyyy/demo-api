package com.demo.order.service;


import com.demo.order.entity.AdminUserT;
import com.demo.order.pojo.adminUserT.AdminUserTAddParam;
import com.demo.order.pojo.adminUserT.AdminUserTPojo;
import com.demo.order.security.pojo.login.AdminUserTDubboPojo;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface AdminUserTService{


    AdminUserTDubboPojo selectUserByName(String loginName);


    AdminUserTPojo selectAll();

		AdminUserTPojo addAdminUser(AdminUserTAddParam param);
}
