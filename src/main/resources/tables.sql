CREATE DATABASE IF NOT EXISTS `ds0` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
 `order_id` bigint(20) NOT NULL,
 `order_no` varchar(24) DEFAULT '',
 `order_status` varchar(32) DEFAULT '',
 `good_name` varchar(100) DEFAULT '',
 `buyer` varchar(50) NOT NULL DEFAULT '' COMMENT '用户',
 `create_time` datetime DEFAULT NULL ,
 PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';