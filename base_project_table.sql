/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : base

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 27/02/2021 17:34:50
*/
USE base;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `MenuUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `MenuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `MenuSort` int(0) NULL DEFAULT NULL,
  `MenuLevel` int(0) NULL DEFAULT NULL,
  `ParentID` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `Valid` bit(1) NULL DEFAULT b'1',
  `CreateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `CreateDt` datetime(6) NULL DEFAULT NULL,
  `UpdateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `UpdateDt` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `RoleCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `RoleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  'RoleSort' int(0) NULL DEFAULT NULL,
  `Valid` bit(1) NULL DEFAULT b'1',
  `CreateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `CreateDt` datetime(6) NULL DEFAULT NULL,
  `UpdateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `UpdateDt` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('0A601E7E736A11EB9BEC54EE759FD5E5', 'ROLE_ADMIN', '管理员', 1, b'1', 'admin', '2021-02-20 18:55:23.000000', 'admin', '2021-02-20 18:55:23.000000');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `MenuID` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `RoleCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `Valid` bit(1) NULL DEFAULT b'1',
  `CreateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `CreateDt` datetime(6) NULL DEFAULT NULL,
  `UpdateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `UpdateDt` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `UserAccount` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `Password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `Valid` bit(1) NULL DEFAULT b'1',
  `CreateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `CreateDt` datetime(6) NULL DEFAULT NULL,
  `UpdateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `UpdateDt` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('39247DF0736911EB9BEC54EE759FD5E5', 'admin', '管理员', 'admin', b'1', 'admin', '2021-02-20 18:48:53.000000', 'admin', '2021-02-20 18:48:53.000000');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `UserAccount` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `RoleCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `Valid` bit(1) NULL DEFAULT b'1',
  `CreateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `CreateDt` datetime(6) NULL DEFAULT NULL,
  `UpdateBy` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `UpdateDt` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('2A26B6C7736A11EB9BEC54EE759FD5E5', 'admin', 'ROLE_ADMIN', b'1', 'admin', '2021-02-20 18:56:08.000000', 'admin', '2021-02-20 18:56:08.000000');

SET FOREIGN_KEY_CHECKS = 1;
