CREATE TABLE t_order_info (
	order_id INT (11) NOT NULL AUTO_INCREMENT,
	create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
	STATUS INT (5) NOT NULL COMMENT '订单状态(-1:取消，1:已发货，2：待发货，3：正在配送，4：交易完成)',
	user_id INT (11) NOT NULL COMMENT '用户id',
	user_name CHAR (11) NOT NULL COMMENT '用户姓名',
	order_no VARCHAR (100) NOT NULL COMMENT '订单号',
	pay_status INT (5) NOT NULL COMMENT '支付状态(-1:未支付，1：已支付)',
	amount DECIMAL (20, 2) NOT NULL COMMENT '订单金额',
	PRIMARY KEY (`order_id`),
	KEY `idx_order_no` (`order_no`) USING BTREE,
	KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '订单记录表';


create table t_order_products 
(
   order_id               int(11)                        null,
   product_id             int(11)                        null
) ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '订单-产品关联表';



create table t_order_participant
(
   id           int(11)                         NOT NULL AUTO_INCREMENT,
	 create_time TIMESTAMP NOT NULL COMMENT 'tcc创建时间',
	 update_time TIMESTAMP NOT NULL COMMENT 'tcc更新时间',
	 delete_time TIMESTAMP NOT NULL COMMENT 'tcc删除时间',
	 expire_time TIMESTAMP NOT NULL COMMENT 'tcc过期时间',
	 uri VARCHAR(255) NOT NULL COMMENT 'url',
	 t_order_id int(11) NOT NULL COMMENT '订单id',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 COMMENT='订单tcc记录表';

