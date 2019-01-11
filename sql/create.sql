CREATE TABLE `t_test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `mem` varchar(64) DEFAULT NULL,
  `create_by_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
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

CREATE TABLE `t_blog_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者ID',
  `article_title` varchar(100) DEFAULT NULL COMMENT '标题',
  `article_type` varchar(20) DEFAULT NULL COMMENT '文章类型',
  `language_type` varchar(30) DEFAULT NULL COMMENT '技术语言类型',
  `article_mem` varchar(200) DEFAULT NULL COMMENT '简介',
  `content_url` varchar(200) DEFAULT NULL COMMENT '文章内容地址',
  `img_url_min` varchar(200) DEFAULT NULL COMMENT '小图片地址',
  `img_url_max` varchar(200) DEFAULT NULL COMMENT '大图片地址',
  `content_keys` varchar(200) DEFAULT NULL COMMENT '文章关键字',
  `github_url` varchar(200) DEFAULT NULL COMMENT '开源地址',
  `comment_count` bigint(20) DEFAULT NULL COMMENT '评论总数',
  `read_count` bigint(20) DEFAULT NULL COMMENT '阅读总数',
  `practice_count` bigint(20) DEFAULT NULL COMMENT '实践总数',
  `delete_flag` char(1) DEFAULT '1' COMMENT '数据状态1正常 0 删除',
  `show_position` varchar(10) DEFAULT NULL COMMENT '显示位置 0默认1候选2精选',
  `status` varchar(10) DEFAULT NULL COMMENT '状态0新建1发布2审核通过3审核不通过4系统删除',
  `create_by_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='文章';
CREATE TABLE `t_blog_series` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `series_title` varchar(100) DEFAULT NULL COMMENT '标题',
  `series_mem` varchar(200) DEFAULT NULL COMMENT '简介',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者ID',
  `status` varchar(10) DEFAULT NULL COMMENT '状态0新建1发布2审核通过3审核不通过4系统删除',
  `series_type` varchar(20) DEFAULT NULL COMMENT '系列类别',
  `delete_flag` char(1) DEFAULT NULL COMMENT '数据状态1正常0删除',
  `create_by_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章系列';
