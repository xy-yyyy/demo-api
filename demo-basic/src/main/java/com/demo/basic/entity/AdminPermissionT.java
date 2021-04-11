package com.demo.basic.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Table(name = "`admin_permission_t`")
public class AdminPermissionT {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.id
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.permission
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String permission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.description
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.action
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String action;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.create_id
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String createId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.create_time
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.update_id
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private String updateId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.update_time
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.version
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private Integer version;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission_t.removed
     *
     * @mbg.generated Mon Nov 30 14:31:50 CST 2020
     */
    private Boolean removed;
}