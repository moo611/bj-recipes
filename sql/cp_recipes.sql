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

 Date: 13/03/2025 14:35:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cp_recipes
-- ----------------------------
DROP TABLE IF EXISTS `cp_recipes`;
CREATE TABLE `cp_recipes`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cuisine_id` int NULL DEFAULT NULL COMMENT '菜系id',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '0、待审核1、已审核2、已拒绝',
  `source` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '0、管理员1、用户',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标识',
  `create_time` datetime NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜谱表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cp_recipes
-- ----------------------------
INSERT INTO `cp_recipes` VALUES (1, '宫保鸡丁', '经典川菜，酸甜口味', 'https://ssyttest.oss-cn-hangzhou.aliyuncs.com/avatar/397bbb0a-9254-4578-9b15-a922e0bb2557_gbjd.jpg', 1, '0', '0', '0', '2025-03-13 14:11:18', NULL, NULL, NULL);
INSERT INTO `cp_recipes` VALUES (2, '番茄炒蛋', '家常菜，简单易做', 'https://ssyttest.oss-cn-hangzhou.aliyuncs.com/avatar/d2dee454-61f9-454c-830c-86a16cc8f99a_fqcd.jpg', 2, '0', '0', '0', '2025-03-13 14:13:27', NULL, NULL, NULL);
INSERT INTO `cp_recipes` VALUES (3, '红烧肉', '经典中式菜肴，肥而不腻', 'https://ssyttest.oss-cn-hangzhou.aliyuncs.com/avatar/d6144554-70ac-4555-ae8b-7b85cd0abf46_hsr.jpg', 1, '0', '0', '0', '2025-03-13 14:13:55', NULL, NULL, NULL);
INSERT INTO `cp_recipes` VALUES (4, '麻婆豆腐', '麻辣鲜香，川菜代表', 'https://ssyttest.oss-cn-hangzhou.aliyuncs.com/avatar/438ea705-150e-4aa1-92fb-2ea42ea7effb_mpdf.jpg', 1, '2', '0', '0', '2025-03-13 14:14:21', NULL, '2025-03-13 14:26:56', NULL);
INSERT INTO `cp_recipes` VALUES (5, '清蒸鲈鱼', '清淡健康，适合家庭聚餐', 'https://ssyttest.oss-cn-hangzhou.aliyuncs.com/avatar/37fbe145-723d-4be2-8092-33d7317e73bb_qzly.jpg', 3, '0', '0', '0', '2025-03-13 14:14:40', NULL, NULL, NULL);
INSERT INTO `cp_recipes` VALUES (6, '肠粉', '', 'https://ssyttest.oss-cn-hangzhou.aliyuncs.com/avatar/257a233d-f83a-43e0-a9e4-6bca3216db3d_cf.jpg', 3, '1', '0', '0', '2025-03-13 14:14:57', NULL, '2025-03-13 14:26:48', NULL);

SET FOREIGN_KEY_CHECKS = 1;
