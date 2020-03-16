/*
Navicat MySQL Data Transfer

Source Server         : liu
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : redis

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2020-03-16 10:08:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for red_package
-- ----------------------------
DROP TABLE IF EXISTS `red_package`;
CREATE TABLE `red_package` (
  `package_id` varchar(255) NOT NULL,
  `package_name` varchar(255) NOT NULL,
  `package_value` decimal(10,0) NOT NULL,
  `package_status` varchar(255) NOT NULL,
  `valid_time` longtext,
  `exprie_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of red_package
-- ----------------------------
INSERT INTO `red_package` VALUES ('c4eb5166-eb1c-44cc-beeb-c2f330d97694', '红包test2', '2', 'outtime', '1', '2020-03-16 10:06:44', '2020-03-16 10:05:44', '2020-03-16 10:07:01');
INSERT INTO `red_package` VALUES ('d264cc18-2844-43ba-9e7e-9a5b86eb4e60', '红包test', '2', 'outtime', '1', '2020-03-16 10:06:44', '2020-03-16 10:05:44', '2020-03-16 10:07:01');
INSERT INTO `red_package` VALUES ('dde1819e-b9c5-4c92-bcb9-968782475ece', '红包test', '2', 'outtime', '1', '2020-03-13 18:41:19', '2020-03-13 18:40:19', '2020-03-13 18:41:27');
