CREATE TABLE `t_test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `mem` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
#作者表
CREATE TABLE `t_author_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `muuid` varchar(64) DEFAULT NULL COMMENT '用户唯一ID',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(64) DEFAULT NULL COMMENT '密码',
  `kh_name` varchar(64) DEFAULT NULL COMMENT '武侠昵称',
  `kh_uuid` varchar(30) DEFAULT NULL COMMENT '武侠id',
  `real_name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `code_type` varchar(20) DEFAULT NULL COMMENT '身份类型',
  `code_no` varchar(30) DEFAULT NULL COMMENT '身份证码',
  `author_follow_count` bigint(20) DEFAULT NULL COMMENT '作者关注我数量',
  `my_follow_count` bigint(20) DEFAULT NULL COMMENT '我关注的作者数量',
  `status` varchar(10) DEFAULT NULL COMMENT '状态 0冻结 1正常',
  `create_by_id` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by_id` bigint(20) DEFAULT NULL COMMENT '修改ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作者表';