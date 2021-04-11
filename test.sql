/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 30/11/2020 13:49:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_permission_t
-- ----------------------------
DROP TABLE IF EXISTS `admin_permission_t`;
CREATE TABLE `admin_permission_t`  (
  `id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `permission` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限编号',
  `description` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限描述',
  `action` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '对应的动作:增删改查等',
  `create_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `version` int NOT NULL DEFAULT 1 COMMENT '版本',
  `removed` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '权限资源列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_permission_t
-- ----------------------------
INSERT INTO `admin_permission_t` VALUES ('1', '1', '1', '1', '1', '2020-11-17 20:19:57', '1', '2020-11-17 20:20:00', 1, 0);

-- ----------------------------
-- Table structure for admin_role_permission_t
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_permission_t`;
CREATE TABLE `admin_role_permission_t`  (
  `id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `admin_role_t_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `admin_permission_t_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `create_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `version` int NOT NULL DEFAULT 1 COMMENT '版本',
  `removed` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色关联权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_permission_t
-- ----------------------------
INSERT INTO `admin_role_permission_t` VALUES ('1', '1', '1', '1', '2020-11-17 19:48:22', '1', '2020-11-17 19:48:25', 1, 0);

-- ----------------------------
-- Table structure for admin_role_t
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_t`;
CREATE TABLE `admin_role_t`  (
  `id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `key` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色的关键字',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色名',
  `create_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `version` int NOT NULL DEFAULT 1 COMMENT '版本',
  `removed` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_t
-- ----------------------------
INSERT INTO `admin_role_t` VALUES ('1', 'ROLE_USER', '普通用户', '1', '2020-11-13 12:00:00', '1', '2020-11-13 12:00:00', 1, 0);
INSERT INTO `admin_role_t` VALUES ('2', 'ROLE_ADMIN', '管理员', '1', '2020-11-13 12:00:00', '1', '2020-11-13 12:00:00', 1, 0);
INSERT INTO `admin_role_t` VALUES ('3', 'ROLE_FINANCE', '财务人员', '1', '2020-11-13 12:00:00', '1', '2020-11-13 12:00:00', 1, 0);

-- ----------------------------
-- Table structure for admin_user_role_t
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role_t`;
CREATE TABLE `admin_user_role_t`  (
  `id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `admin_user_t_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `admin_role_t_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `create_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `version` int NOT NULL DEFAULT 1 COMMENT '版本',
  `removed` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户关联角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_role_t
-- ----------------------------
INSERT INTO `admin_user_role_t` VALUES ('1', '1', '1', '1', '2020-11-17 19:47:29', '1', '2020-11-17 19:47:32', 1, 0);
INSERT INTO `admin_user_role_t` VALUES ('2', '2', '2', '2', '2020-11-17 19:47:42', '1', '2020-11-17 19:47:45', 1, 0);
INSERT INTO `admin_user_role_t` VALUES ('3', '3', '3', '3', '2020-11-06 19:47:54', '1', '2020-11-17 19:47:56', 1, 0);

-- ----------------------------
-- Table structure for admin_user_t
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_t`;
CREATE TABLE `admin_user_t`  (
  `id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `login_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮箱',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `locked` tinyint(1) NULL DEFAULT NULL COMMENT '锁定\n锁定:true\n正常:false',
  `create_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建人ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `version` int NOT NULL DEFAULT 1 COMMENT '版本',
  `removed` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `login_name_UNIQUE`(`login_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '后台用户管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_t
-- ----------------------------
INSERT INTO `admin_user_t` VALUES ('1', 'user', '1', '1', '1', '11', '1', '1', 1, '1', '2020-11-11 17:34:17', '1', '2020-11-11 17:34:20', 1, 0);
INSERT INTO `admin_user_t` VALUES ('2', 'admin', '$2a$10$AwCwCjjcoXvWEqKhjgGacOv4GmxB5H8S6mGOZ0bLtQQhfTHDQ73gi', '1231231', '1231231', '1231231', '1231231', '1231231', 0, '1', '2020-11-11 19:05:37', '1', '2020-11-11 19:05:42', 1, 0);
INSERT INTO `admin_user_t` VALUES ('3', 'user1', '$2a$10$mc3MCUUmzOTfB1FVcWjuneXNH9yn038WB9bR5iNsDb6h5.IzW.Fq2', '1232132', '12312', '12312312', '123123', '1', 1, '1', '2020-11-16 18:55:34', '1', '2020-11-16 18:55:38', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
