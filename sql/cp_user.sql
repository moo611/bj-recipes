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

 Date: 23/03/2025 14:46:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cp_user
-- ----------------------------
DROP TABLE IF EXISTS `cp_user`;
CREATE TABLE `cp_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '0用户1管理员',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cp_user
-- ----------------------------
INSERT INTO `cp_user` VALUES (1, 'admin', '$2a$10$uM/OHFz6tA4pAnjf4P3fiec/eBaFjzRKaVkR.4Ne2Mytejg9iDtp6', '管理员', '0', '0', '2025-03-13 13:53:05', NULL, NULL, NULL);
INSERT INTO `cp_user` VALUES (2, 'user1', '$2a$10$GqFYZdi.zyyMnMky.p9imeSlLIMMAmar.vOJ8k47LpIYGJjewfB4u', '用户11111', '1', '0', '2025-03-13 14:28:03', NULL, '2025-03-23 13:22:46', NULL);
INSERT INTO `cp_user` VALUES (3, 'user2', '$2a$10$dco8wC4M9S32rEwQZ9m9nuqgaIrpRp88ZTIMF0H1xHsSYBjQCqTai', '用户2', '1', '0', '2025-03-21 14:47:41', NULL, NULL, NULL);
INSERT INTO `cp_user` VALUES (4, 'user3', '$2a$10$ozjjdendncsW5bPcOYBfT.9J8qmD9eSrJLLCEiTCoUN1lT2dXz3sa', '用户3', '1', '0', '2025-03-21 15:05:16', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
