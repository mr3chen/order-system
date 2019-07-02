create table t_product_info 
(
   product_id           int(11)                       NOT NULL AUTO_INCREMENT,
   product_name         varchar(100)                  NOT NULL COMMENT '产品名字',
   price                decimal(20,2)                   NOT NULL COMMENT '产品价格',
   inventory            bigint                         NOT NULL COMMENT '产品库存',
   status               tinyint(5)                     null COMMENT '状态(-1:删除，1：上架，2：下架)',
   create_date          timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建产品时间',
   update_date          timestamp                      null COMMENT '更新产品时间',
   PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品基础信息表';


create table t_product_img 
(
   product_img_id       varchar(100)                   not null,
   product_id           varchar(100)                  not null,
   img_url              varchar(100)                   not null,
   constraint PK_T_PRODUCT_IMG primary key clustered (product_img_id)
) ENGINE=InnoDB COMMENT='产品图片表';



create table t_product_stock_tcc
(
   product_stock_tcc_id           int(11)                         NOT NULL AUTO_INCREMENT,
	 create_time TIMESTAMP NOT NULL COMMENT 'tcc创建时间',
	 update_time TIMESTAMP NOT NULL COMMENT 'tcc更新时间',
	 delete_time TIMESTAMP NOT NULL COMMENT 'tcc删除时间',
	 expire_time TIMESTAMP NOT NULL COMMENT 'tcc过期时间',
	 status int(5) NOT NULL COMMENT 'tcc状态',
	 stack BIGINT(11) NOT NULL COMMENT '扣除库存数量',
	 product_id int(11) NOT NULL COMMENT '产品id',
   PRIMARY KEY (`product_stock_tcc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 COMMENT='订单tcc记录表';

