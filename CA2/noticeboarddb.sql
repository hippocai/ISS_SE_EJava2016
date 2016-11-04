/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50016
Source Host           : localhost:3306
Source Database       : noticeboarddb

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2016-11-04 21:08:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `group_name` varchar(100) NOT NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`group_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES ('ManagerGroup', 'ManagerGroup');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` bigint(20) NOT NULL auto_increment,
  `date_time` bigint(20) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `userFr` (`user_name`),
  CONSTRAINT `userFr` FOREIGN KEY (`user_name`) REFERENCES `users` (`user_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('23', '1478252528275', 'test', 'For Sale', 'only 600 dollars\r\nContact 86731497', 'New Apple Watch3');
INSERT INTO `note` VALUES ('24', '1478252682454', 'test', 'Jobs', 'At Marina Bay Sands\r\nContact 86731498', 'Finding Cookers');
INSERT INTO `note` VALUES ('25', '1478252711204', 'test', 'Tuition', 'Teach Chinese Phd Degree', 'Chinese Teacher');
INSERT INTO `note` VALUES ('26', '1478253453852', 'test', 'Social', '19 years old', 'Find Girl Friend');
INSERT INTO `note` VALUES ('27', '1478253471038', 'test', 'Social', '29 years old', 'Finding Boy Friend');
INSERT INTO `note` VALUES ('37', '1478254611436', 'test', 'All', 'Haha', 'test1');
INSERT INTO `note` VALUES ('38', '1478254620229', 'test', 'All', 'Haha', 'test2');
INSERT INTO `note` VALUES ('39', '1478254631686', 'test', 'All', 'Haha', 'test3');
INSERT INTO `note` VALUES ('40', '1478254641131', 'test', 'All', 'Haha', 'test4');
INSERT INTO `note` VALUES ('41', '1478254969217', 'test', 'All', 'Haha', 'test5');
INSERT INTO `note` VALUES ('42', '1478255765371', 'test', 'For Sale', '555', 'test6');
INSERT INTO `note` VALUES ('43', '1478264715260', 'test', 'Tuition', 'dfgdfg', 'test7');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `password` varchar(128) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  PRIMARY KEY  (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'hippo');
INSERT INTO `users` VALUES ('f148389d080cfe85952998a8a367e2f7eaf35f2d72d2599a5b0412fe4094d65c', 'steve');
INSERT INTO `users` VALUES ('8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92', 'test');

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `user_name` varchar(100) NOT NULL,
  `group_name` varchar(100) NOT NULL,
  PRIMARY KEY  (`user_name`,`group_name`),
  KEY `group_fr` (`group_name`),
  CONSTRAINT `user_fr` FOREIGN KEY (`user_name`) REFERENCES `users` (`user_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `group_fr` FOREIGN KEY (`group_name`) REFERENCES `groups` (`group_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES ('hippo', 'ManagerGroup');
INSERT INTO `user_group` VALUES ('steve', 'ManagerGroup');
INSERT INTO `user_group` VALUES ('test', 'ManagerGroup');
SET FOREIGN_KEY_CHECKS=1;
