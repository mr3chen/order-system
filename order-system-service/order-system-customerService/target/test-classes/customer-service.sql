drop table if exists t_user_info;

CREATE TABLE t_user_info (
	user_id INT (11) NOT NULL AUTO_INCREMENT,
	user_name CHAR (20) NOT NULL COMMENT '用户姓名，限制长度不能超过10个中文',
	user_sex INT (5) NULL COMMENT '用户性别(0:未知，1：男，2：女)',
	user_phone CHAR (11) NOT NULL COMMENT '用户手机号码',
	create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册时间',
	salt CHAR (10) NOT NULL COMMENT '用户密码加密盐值',
	PASSWORD VARCHAR (255) NOT NULL COMMENT '用户密码，md5加密',
	account VARCHAR (100) NOT NULL COMMENT '用户账号',
	PRIMARY KEY (`user_id`),
	KEY `idx_user_phone` (`user_phone`) USING BTREE,
	KEY `idx_account` (`account`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户基本信息';