/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : pet

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2016-03-06 23:36:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `code` varchar(32) NOT NULL,
  `orderCode` varchar(32) NOT NULL,
  `petCode` varchar(32) NOT NULL,
  `quantity` int(11) NOT NULL COMMENT '数量',
  `totlalPrice` bigint(20) NOT NULL COMMENT '总价',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单项';

-- ----------------------------
-- Records of order_item
-- ----------------------------

-- ----------------------------
-- Table structure for order_orders
-- ----------------------------
DROP TABLE IF EXISTS `order_orders`;
CREATE TABLE `order_orders` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `userCode` varchar(32) NOT NULL COMMENT '用户账号',
  `code` varchar(32) NOT NULL COMMENT '订单编号',
  `createTime` bigint(20) NOT NULL COMMENT '下单时间',
  `payTime` bigint(20) default NULL COMMENT '支付时间',
  `payType` int(11) default NULL COMMENT '支付类型',
  `sendTime` bigint(20) default NULL COMMENT '发货时间',
  `compleTime` bigint(20) default NULL COMMENT '完成时间',
  `deliveryType` int(11) default NULL COMMENT '配送方式',
  `deliveryTime` bigint(20) default NULL COMMENT '配送时间',
  `deliveryCode` varchar(32) default NULL COMMENT '收货人地址',
  `totalPrice` int(11) NOT NULL COMMENT '总价',
  `supplyCode` varchar(32) NOT NULL COMMENT '供应商编号',
  `description` varchar(255) default NULL COMMENT '描述',
  `status` int(11) NOT NULL COMMENT '订单状态',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order_orders
-- ----------------------------

-- ----------------------------
-- Table structure for pet_animal
-- ----------------------------
DROP TABLE IF EXISTS `pet_animal`;
CREATE TABLE `pet_animal` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `code` varchar(32) NOT NULL COMMENT '动物代码',
  `name` varchar(255) NOT NULL COMMENT '动物名称',
  `description` varchar(255) default NULL COMMENT '描述',
  `createTime` bigint(20) default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动物种类';

-- ----------------------------
-- Records of pet_animal
-- ----------------------------
INSERT INTO `pet_animal` VALUES ('1', 'a0b978161d6940599ce523db872f60f7', '狗', 'gggggggg', '1455197933329');
INSERT INTO `pet_animal` VALUES ('2', '3986e5ceca8841f5960583fb116ad7fc', '猫', '猫', '1455352935219');

-- ----------------------------
-- Table structure for pet_category
-- ----------------------------
DROP TABLE IF EXISTS `pet_category`;
CREATE TABLE `pet_category` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `code` varchar(32) NOT NULL COMMENT '分类code',
  `name` varchar(255) NOT NULL COMMENT '分类名',
  `animalCode` varchar(32) NOT NULL COMMENT '动物种类',
  `description` varchar(255) default NULL COMMENT '描述',
  `createTime` bigint(20) default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宠物分类';

-- ----------------------------
-- Records of pet_category
-- ----------------------------
INSERT INTO `pet_category` VALUES ('1', '2810fd905dbb4c2896d377ffa4d839db', '哈哈狗', 'a0b978161d6940599ce523db872f60f7', '哈哈狗', '1455435526888');
INSERT INTO `pet_category` VALUES ('2', '9c7b6940923240d2afdcb863522d2f80', '嗯嗯狗', 'a0b978161d6940599ce523db872f60f7', '嗯嗯狗', '1455435543753');
INSERT INTO `pet_category` VALUES ('3', 'c2f6068ec80b4fdab2f8cc1dfdffb3a6', '', 'a0b978161d6940599ce523db872f60f7', '', '1456545532784');

-- ----------------------------
-- Table structure for pet_pet
-- ----------------------------
DROP TABLE IF EXISTS `pet_pet`;
CREATE TABLE `pet_pet` (
  `id` bigint(20) NOT NULL auto_increment COMMENT 'id',
  `code` varchar(32) NOT NULL COMMENT '宠物编号',
  `name` varchar(32) NOT NULL COMMENT '宠物名',
  `image` varchar(255) default NULL COMMENT '宠物图片',
  `weight` int(11) NOT NULL COMMENT '重量',
  `life` int(11) NOT NULL COMMENT '寿命',
  `price` int(11) NOT NULL COMMENT '售价',
  `description` text COMMENT '描述',
  `createTime` bigint(20) default NULL COMMENT '创建时间',
  `categoryCode` varchar(32) NOT NULL COMMENT '宠物分类code',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宠物表';

-- ----------------------------
-- Records of pet_pet
-- ----------------------------
INSERT INTO `pet_pet` VALUES ('1', 'bbf84a486fcc49369aa25c30f9e111a2', '哈哈哈', '/upload/599259320677285699.jpg', '22', '22', '222', '11', '1455437132537', '2810fd905dbb4c2896d377ffa4d839db');
INSERT INTO `pet_pet` VALUES ('2', '84addd7a14ac4b98b9232d07fbf0aae9', 'hjjjj', '/upload/385816677136219234.jpg', '11', '11', '11', '11', '1455437308453', '2810fd905dbb4c2896d377ffa4d839db');
INSERT INTO `pet_pet` VALUES ('3', '252a39cbc075454bb9faf016342e633c', '11', '/upload/201681772586843559.jpg', '11', '11', '11', '<p>777777777777777</p>', '1456505474743', '2810fd905dbb4c2896d377ffa4d839db');
INSERT INTO `pet_pet` VALUES ('4', 'ebdf90a6821f4f17a075f983d07ebb5d', '888888', '/upload/201681772586843559.jpg,/upload/385816677136219234.jpg,/upload/599259320677285699.jpg', '888888', '888', '8888', '<p><img style=\"max-width:100%;\" src=\"55555555555555555\">888888888<br></p><p>噼噼啪啪</p><p style=\"text-align: center; \"><span style=\"background-color: rgb(255, 0, 0);\">7777777777777</span></p><p><br></p>', '1456505723021', '2810fd905dbb4c2896d377ffa4d839db');
INSERT INTO `pet_pet` VALUES ('5', 'dbbe9b4dd8a24c4d846bd087ed21a4e4', '777', '/upload/201681772586843559.jpg', '88888888', '8', '8', '<p><img src=\"/upload/7205534221138805.jpeg\" style=\"max-width: 100%; width: 601.2px; height: 800.1px;\" class=\"clicked\"><br></p><p><br></p>', '1456511948672', '2810fd905dbb4c2896d377ffa4d839db');
INSERT INTO `pet_pet` VALUES ('6', '2d254ad4ff6546c387001e417bdac028', '哈哈狗', '/upload/385816677136219234.jpg,/upload/201681772586843559.jpg,/upload/599259320677285699.jpg,/upload/welcome.jpg', '55', '4', '5630', '<p><img src=\"/upload/7205534221138805.jpeg\" style=\"max-width: 100%; width: 601.2px; height: 800.1px;\" class=\"clicked\"><br></p><p><br></p>', '1456665344858', '2810fd905dbb4c2896d377ffa4d839db');

-- ----------------------------
-- Table structure for pet_storehouse
-- ----------------------------
DROP TABLE IF EXISTS `pet_storehouse`;
CREATE TABLE `pet_storehouse` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `petCode` varchar(32) NOT NULL COMMENT '宠物编号',
  `supplierCode` varchar(32) NOT NULL COMMENT '供应商code',
  `quantity` int(11) NOT NULL COMMENT '库存量',
  `createTime` bigint(20) default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库';

-- ----------------------------
-- Records of pet_storehouse
-- ----------------------------

-- ----------------------------
-- Table structure for pet_supplier
-- ----------------------------
DROP TABLE IF EXISTS `pet_supplier`;
CREATE TABLE `pet_supplier` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `code` varchar(32) NOT NULL COMMENT '供应商code',
  `name` varchar(255) NOT NULL COMMENT '供应商名',
  `phone` varchar(11) default NULL COMMENT '电话',
  `address` varchar(255) default NULL COMMENT '厂址',
  `description` varchar(255) default NULL COMMENT '描述',
  `createTime` bigint(20) default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商表';

-- ----------------------------
-- Records of pet_supplier
-- ----------------------------

-- ----------------------------
-- Table structure for user_delivery
-- ----------------------------
DROP TABLE IF EXISTS `user_delivery`;
CREATE TABLE `user_delivery` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `code` varchar(32) NOT NULL COMMENT 'code',
  `userCode` varchar(32) NOT NULL COMMENT '用户code',
  `name` varchar(20) NOT NULL COMMENT '收货人',
  `province` varchar(64) NOT NULL COMMENT '省',
  `city` varchar(64) default NULL COMMENT '市',
  `area` varchar(64) default NULL COMMENT '区',
  `detail` varchar(100) NOT NULL COMMENT '详细地址',
  `phone` varchar(11) NOT NULL COMMENT '电话',
  `postCode` varchar(10) default NULL COMMENT '邮编',
  `isDefault` bit(1) default NULL COMMENT '是否为默认收货地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收货地址表';

-- ----------------------------
-- Records of user_delivery
-- ----------------------------
INSERT INTO `user_delivery` VALUES ('1', 'b92a140ce053479983c13f60ef085de0', '111', '444', '110000:北京市', '110100:市辖区', '110105:朝阳区', '4444', '444', '444', null);
INSERT INTO `user_delivery` VALUES ('2', 'c05e4e38ad4b4973b602cb1023630415', '111', '55555', '440000:广东省', '440100:广州市', '440184:从化市', '55555555', '555555555', '5555555', null);
INSERT INTO `user_delivery` VALUES ('3', '6cb7ef3103aa474592501c7db8062e91', '111', '55555', '440000:广东省', '440100:广州市', '440184:从化市', '55555555', '555555555', '5555555', null);
INSERT INTO `user_delivery` VALUES ('4', '4c8225712f7b4cea8870cc64c5c1445d', '111', '111', '440000:广东省', '440100:广州市', '440113:番禺区', '111111111', '11111', '1111', null);

-- ----------------------------
-- Table structure for user_user
-- ----------------------------
DROP TABLE IF EXISTS `user_user`;
CREATE TABLE `user_user` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `code` varchar(255) NOT NULL COMMENT '账号',
  `userName` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `phone` varchar(11) default NULL COMMENT '手机号',
  `createTime` bigint(20) default NULL COMMENT '创建时间',
  `salt` varchar(64) default NULL COMMENT '盐',
  `locked` int(11) NOT NULL default '0' COMMENT '是否锁定',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user_user
-- ----------------------------
INSERT INTO `user_user` VALUES ('1', '111', '111', '111', '111', null, null, '0');
