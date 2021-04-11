package com.demo.basic.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Table(name = "`admin_user_role_t`")
public class AdminUserRoleT {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role_t.id
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role_t.admin_user_t_id
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String adminUserTId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role_t.admin_role_t_id
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String adminRoleTId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role_t.create_id
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String createId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role_t.create_time
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role_t.update_id
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String updateId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role_t.update_time
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role_t.version
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private Integer version;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_user_role_t.removed
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private Boolean removed;
}