/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50556
Source Host           : 127.0.0.1:3306
Source Database       : cm

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-03-27 05:02:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `acc_date` date DEFAULT NULL,
  `acc_description` varchar(100) NOT NULL,
  `acc_spend` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `FK6io95m3dn9xycpy1ig26rre9j` (`user_id`),
  CONSTRAINT `FK6io95m3dn9xycpy1ig26rre9j` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES ('1', '2018-03-24', '一桶羽毛球', '12', '1');
INSERT INTO `t_account` VALUES ('2', '2018-02-16', '一包方便面', '3', '1');
INSERT INTO `t_account` VALUES ('3', '2018-03-28', '一台电脑', '66', '2');

-- ----------------------------
-- Table structure for t_bedroom
-- ----------------------------
DROP TABLE IF EXISTS `t_bedroom`;
CREATE TABLE `t_bedroom` (
  `bed_id` int(11) NOT NULL AUTO_INCREMENT,
  `bed_name` varchar(30) NOT NULL,
  `headuser_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`bed_id`),
  KEY `FKpye2089f03wpqpc6mfe1hih2j` (`headuser_id`),
  CONSTRAINT `FKpye2089f03wpqpc6mfe1hih2j` FOREIGN KEY (`headuser_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bedroom
-- ----------------------------
INSERT INTO `t_bedroom` VALUES ('1', '魔仙堡', '1');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `co_id` int(11) NOT NULL AUTO_INCREMENT,
  `co_begin_week` varchar(30) DEFAULT NULL,
  `co_end_week` varchar(30) DEFAULT NULL,
  `co_name` varchar(50) NOT NULL,
  `co_room` varchar(50) DEFAULT NULL,
  `co_teacher` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`co_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('1', '1', '8', '数据结构', '东1201', '李老师');
INSERT INTO `t_course` VALUES ('2', '1', '8', '经济学', '东2303', '王老师');

-- ----------------------------
-- Table structure for t_course_schedule
-- ----------------------------
DROP TABLE IF EXISTS `t_course_schedule`;
CREATE TABLE `t_course_schedule` (
  `cs_id` int(11) NOT NULL AUTO_INCREMENT,
  `cs_now_day` varchar(30) DEFAULT NULL,
  `cs_now_week` varchar(30) DEFAULT NULL,
  `cs_course1` int(11) DEFAULT NULL,
  `cs_course2` int(11) DEFAULT NULL,
  `cs_course3` int(11) DEFAULT NULL,
  `cs_course4` int(11) DEFAULT NULL,
  `cs_course5` int(11) DEFAULT NULL,
  `cs_course6` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cs_id`),
  KEY `FKkxy9x3kr4kwal8j8yihia9ppn` (`cs_course1`),
  KEY `FK5yat1rv29d370nsor8yxk5g4h` (`cs_course2`),
  KEY `FKjx00ni5nt7ig05bi89nnokljy` (`cs_course3`),
  KEY `FKphmhy5u0pr898dxe3ioj92hpg` (`cs_course4`),
  KEY `FKdsfks2gqvvliu6mxa4lshy740` (`cs_course5`),
  KEY `FKp1v0u1c2f6mgcpfi22g10a1qv` (`cs_course6`),
  KEY `FK3lb51370tdgjylpqdali57r5p` (`u_id`),
  CONSTRAINT `FK3lb51370tdgjylpqdali57r5p` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`user_id`),
  CONSTRAINT `FK5yat1rv29d370nsor8yxk5g4h` FOREIGN KEY (`cs_course2`) REFERENCES `t_course` (`co_id`),
  CONSTRAINT `FKdsfks2gqvvliu6mxa4lshy740` FOREIGN KEY (`cs_course5`) REFERENCES `t_course` (`co_id`),
  CONSTRAINT `FKjx00ni5nt7ig05bi89nnokljy` FOREIGN KEY (`cs_course3`) REFERENCES `t_course` (`co_id`),
  CONSTRAINT `FKkxy9x3kr4kwal8j8yihia9ppn` FOREIGN KEY (`cs_course1`) REFERENCES `t_course` (`co_id`),
  CONSTRAINT `FKp1v0u1c2f6mgcpfi22g10a1qv` FOREIGN KEY (`cs_course6`) REFERENCES `t_course` (`co_id`),
  CONSTRAINT `FKphmhy5u0pr898dxe3ioj92hpg` FOREIGN KEY (`cs_course4`) REFERENCES `t_course` (`co_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course_schedule
-- ----------------------------
INSERT INTO `t_course_schedule` VALUES ('1', '星期一', '第五周', '1', null, null, null, null, null, '1');
INSERT INTO `t_course_schedule` VALUES ('2', '星期二', '第五周', null, '2', null, null, null, null, '1');

-- ----------------------------
-- Table structure for t_mem
-- ----------------------------
DROP TABLE IF EXISTS `t_mem`;
CREATE TABLE `t_mem` (
  `mem_id` int(11) NOT NULL AUTO_INCREMENT,
  `mem_alert_date` date DEFAULT NULL,
  `mem_create_date` date DEFAULT NULL,
  `mem_description` varchar(100) NOT NULL,
  `mem_status` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`mem_id`),
  KEY `FKrmhcxlbvbl4aif34ff5f2i380` (`user_id`),
  CONSTRAINT `FKrmhcxlbvbl4aif34ff5f2i380` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mem
-- ----------------------------
INSERT INTO `t_mem` VALUES ('1', '2018-03-24', '2018-03-22', '这个东西会在24号提示', '1', '1');
INSERT INTO `t_mem` VALUES ('2', '2018-03-28', '2018-03-23', '这个东西28号提醒', '1', '1');
INSERT INTO `t_mem` VALUES ('3', '2018-03-26', '2018-03-20', '26号提醒', '1', '1');
INSERT INTO `t_mem` VALUES ('4', '2018-03-26', '2018-03-21', '26号提醒2', '1', '1');
INSERT INTO `t_mem` VALUES ('5', '2018-03-28', null, '测试一下添加操作', null, '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `bed_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKkp4lves12j61fai8gjoewoab0` (`bed_id`),
  CONSTRAINT `FKkp4lves12j61fai8gjoewoab0` FOREIGN KEY (`bed_id`) REFERENCES `t_bedroom` (`bed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '魔仙女王', '999', '1');
INSERT INTO `t_user` VALUES ('2', '陶文龙', '666', '1');
