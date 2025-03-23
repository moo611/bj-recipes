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

 Date: 23/03/2025 14:46:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cp_cuisines
-- ----------------------------
DROP TABLE IF EXISTS `cp_cuisines`;
CREATE TABLE `cp_cuisines`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cp_cuisines
-- ----------------------------
INSERT INTO `cp_cuisines` VALUES (1, '川菜', '以麻辣著称，口味浓郁', '0', '2025-03-13 14:01:58', NULL, NULL, NULL);
INSERT INTO `cp_cuisines` VALUES (2, '家常菜	', '简单易做，适合日常家庭餐	', '0', '2025-03-13 14:02:13', NULL, NULL, NULL);
INSERT INTO `cp_cuisines` VALUES (3, '粤菜', '清淡鲜美，注重食材原味', '0', '2025-03-13 14:02:22', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
