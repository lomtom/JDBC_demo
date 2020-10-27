/*
 Navicat Premium Data Transfer

 Source Server         : mysql-localhost-3308
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3308
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 27/10/2020 17:36:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('lomtom', '123456');

SET FOREIGN_KEY_CHECKS = 1;
