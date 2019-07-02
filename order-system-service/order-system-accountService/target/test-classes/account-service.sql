drop table if exists t_user_info;

create table t_account
(
   account_id           int(11)                         NOT NULL AUTO_INCREMENT,
   balance              decimal(20,2)                 NOT NULL COMMENT '余额',
   user_id              int(11)                        NOT NULL COMMENT '用户id',
   status               int(5)                     NOT NULL COMMENT '账户状态(-1:冻结，1：正常),',
   PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户账户表';


create table t_user_banlance_tcc
(
   tuser_balance_tcc_id           int(11)                         NOT NULL AUTO_INCREMENT,
	 tuser_balance_tcc_create_time TIMESTAMP NOT NULL COMMENT 'tcc创建时间',
	 tuser_balance_tcc_update_time TIMESTAMP NOT NULL COMMENT 'tcc更新时间',
	 tuser_balance_tcc_delete_time TIMESTAMP NOT NULL COMMENT 'tcc删除时间',
	 tuser_balance_tcc_expire_time TIMESTAMP NOT NULL COMMENT 'tcc过期时间',
	 tuser_balance_tcc_status TINYINT(5) NOT NULL COMMENT 'tcc状态',
	 tuser_balance_tcc_amount BIGINT(11) NOT NULL COMMENT 'tcc回滚金额',
	 tuser_balance_tcc_t_user_id BIGINT(11) NOT NULL COMMENT 'tcc用户id',
   PRIMARY KEY (`tuser_balance_tcc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 COMMENT='账户tcc事物扣除用户余额';