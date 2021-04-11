package com.demo.user.service;


import com.demo.user.security.pojo.login.PermissionTDubboPojo;

import java.util.List;

public interface AdminPermissionTService{
/**

SELECT permission FROM admin_permission_t WHERE id IN(
        SELECT admin_permission_t_id FROM admin_role_permission_t WHERE admin_role_t_id IN(
                SELECT id FROM admin_role_t WHERE id IN (
                        SELECT admin_role_t_id FROM admin_user_role_t WHERE admin_user_t_id =#{}
                        )
        )

)

*/

    List<PermissionTDubboPojo> selectAllByUserId(String id);
}

