/*
Navicat MySQL Data Transfer

Source Server         : 本机测试数据库
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : fruits

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-04-24 17:04:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carpooling`
-- ----------------------------
DROP TABLE IF EXISTS `carpooling`;
CREATE TABLE `carpooling` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `car_pooling_name` varchar(255) DEFAULT '快乐拼车' COMMENT '拼车的名字',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` int(11) DEFAULT NULL,
  `start_site_id` int(11) DEFAULT NULL,
  `end_site_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `create_by` (`create_by`),
  KEY `start_site_id` (`start_site_id`),
  KEY `end_site_id` (`end_site_id`),
  CONSTRAINT `create_by` FOREIGN KEY (`create_by`) REFERENCES `user` (`id`),
  CONSTRAINT `end_site_id` FOREIGN KEY (`end_site_id`) REFERENCES `siteinfo` (`id`),
  CONSTRAINT `start_site_id` FOREIGN KEY (`start_site_id`) REFERENCES `siteinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carpooling
-- ----------------------------
INSERT INTO `carpooling` VALUES ('1', '快乐拼车', '2019-04-23 14:12:42', '19', '1', '2');
INSERT INTO `carpooling` VALUES ('4', 'shufengchela', '2019-04-23 16:23:56', '5', '1', '2');

-- ----------------------------
-- Table structure for `siteinfo`
-- ----------------------------
DROP TABLE IF EXISTS `siteinfo`;
CREATE TABLE `siteinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `site_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `longitude` float NOT NULL,
  `latitude` float NOT NULL,
  `is_available` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of siteinfo
-- ----------------------------
INSERT INTO `siteinfo` VALUES ('1', '花山站', '112121', '121212', '1');
INSERT INTO `siteinfo` VALUES ('2', '武汉火车站', '121212', '21212', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(45) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `community_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_type` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '123456', '万科花山', '2019-04-10 00:00:00', '创建者', '1');
INSERT INTO `user` VALUES ('2', '张21', '1212132', '连头', '2019-04-24 10:59:05', '老司机', '1');
INSERT INTO `user` VALUES ('3', '张三34', '21', '连头', '2019-04-24 10:59:07', '老司机', '1');
INSERT INTO `user` VALUES ('4', '张三53', '43434', '连头', '2019-04-24 10:59:08', '老司机', '1');
INSERT INTO `user` VALUES ('5', '王五qw', '1212', '碧桂园', '2019-04-24 10:59:11', '老司机', '1');
INSERT INTO `user` VALUES ('6', '张三asd', '1212143', '连头', '2019-04-24 10:59:12', '老司机', '1');
INSERT INTO `user` VALUES ('7', '找刘gtr', '12121', '连头', '2019-04-24 10:59:13', '老司机', '1');
INSERT INTO `user` VALUES ('19', 'zhangmengt', '123456', 'fff', '2019-04-24 10:59:14', 'www', '1');
INSERT INTO `user` VALUES ('20', 'zhangmeng4', '123456', 'fff', '2019-04-24 10:59:15', 'www', '1');
INSERT INTO `user` VALUES ('21', 'zhangmeng32', '123456', 'fff', '2019-04-24 10:59:15', 'www', '1');
INSERT INTO `user` VALUES ('22', 'zhangmeng2', '123456', 'fff', '2019-04-24 10:59:19', 'www', '1');

-- ----------------------------
-- Table structure for `usercarpooling`
-- ----------------------------
DROP TABLE IF EXISTS `usercarpooling`;
CREATE TABLE `usercarpooling` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carpooling_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `carpooling_id` (`carpooling_id`),
  CONSTRAINT `carpooling_id` FOREIGN KEY (`carpooling_id`) REFERENCES `carpooling` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usercarpooling
-- ----------------------------
INSERT INTO `usercarpooling` VALUES ('1', '1', '1');
INSERT INTO `usercarpooling` VALUES ('2', '1', '2');
INSERT INTO `usercarpooling` VALUES ('3', '1', '4');
