/*
Navicat MySQL Data Transfer

Source Server         : tandingbo
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : tb

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-10-11 13:56:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_safety_sign
-- ----------------------------
DROP TABLE IF EXISTS `sys_safety_sign`;
CREATE TABLE `sys_safety_sign` (
  `unid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'unid',
  `uuid` varchar(30) NOT NULL COMMENT 'uuid',
  `session_key` varchar(255) NOT NULL COMMENT '基于http调用Open API时所需要的访问授权码',
  `session_secret` varchar(255) NOT NULL COMMENT '基于http调用Open API时计算参数签名用的签名密钥',
  `access_token` varchar(50) DEFAULT NULL COMMENT '基于https调用Open API时所需要的访问授权码',
  `expired_time` varchar(255) DEFAULT NULL COMMENT '过期时间戳',
  PRIMARY KEY (`unid`),
  UNIQUE KEY `index_uuid` (`uuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_safety_sign
-- ----------------------------
