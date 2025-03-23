/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 23/03/2025 14:46:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cp_rating
-- ----------------------------
DROP TABLE IF EXISTS `cp_rating`;
CREATE TABLE `cp_rating`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `food_id` int NULL DEFAULT NULL,
  `rating` int NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cp_rating
-- ----------------------------
INSERT INTO `cp_rating` VALUES (1, 'user1', 6, 5, '0', '2025-03-21 14:39:55', NULL, NULL, NULL);
INSERT INTO `cp_rating` VALUES (2, 'user2', 6, 3, '0', '2025-03-21 15:05:29', NULL, NULL, NULL);
INSERT INTO `cp_rating` VALUES (3, 'user2', 3, 2, '0', '2025-03-21 15:05:32', NULL, NULL, NULL);
INSERT INTO `cp_rating` VALUES (4, 'user3', 2, 3, '0', '2025-03-21 15:05:46', NULL, NULL, NULL);
INSERT INTO `cp_rating` VALUES (5, 'user3', 1, 5, '0', '2025-03-21 15:05:48', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
