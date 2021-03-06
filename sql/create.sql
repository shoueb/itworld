#数据库参考设计https://www.cnblogs.com/aaron-leb/p/5706176.html
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
  `img_url` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `favor_count` bigint(20) DEFAULT NULL COMMENT '用户收获喜欢数',
  `writen_count` bigint(20) DEFAULT NULL COMMENT '已写字数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作者表';

CREATE TABLE `t_blog_series` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `series_title` varchar(100) DEFAULT NULL COMMENT '标题',
  `series_mem` varchar(200) DEFAULT NULL COMMENT '简介',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者ID',
  `status` varchar(10) DEFAULT NULL COMMENT '状态0新建1发布2审核通过3审核不通过4系统删除',
  `series_type` varchar(20) DEFAULT NULL COMMENT '系列类别0散文1系列文章2解决方案3优秀开源',
  `delete_flag` char(1) DEFAULT NULL COMMENT '数据状态1正常0删除',
  `create_by_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章系列';
CREATE TABLE `t_task_main` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `task_name` varchar(100) DEFAULT NULL COMMENT '任务名称',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者ID',
  `author_user_name` varchar(64) DEFAULT NULL COMMENT '作者用户名',
  `author_realname` varchar(64) DEFAULT NULL COMMENT '作者真实姓名',
  `author_kh_name` varchar(64) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `project_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `board_id` bigint(20) DEFAULT NULL COMMENT '看板ID',
  `board_name` varchar(100) DEFAULT NULL COMMENT '看板名称',
  `task_mem` varchar(300) DEFAULT NULL COMMENT '描述',
  `attachment_defualt_url` varchar(200) DEFAULT NULL COMMENT '默认附件地址',
  `task_start` datetime DEFAULT NULL COMMENT '任务开始',
  `task_end` datetime DEFAULT NULL COMMENT '任务结束',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '上级任务 0为最顶任务',
  `priority` int(4) DEFAULT NULL COMMENT '优先级',
  `status` varchar(10) DEFAULT NULL COMMENT '任务状态',
  `is_warning` char(1) DEFAULT NULL COMMENT '是否开启提醒 1提醒 0不提醒',
  `warning_count` int(4) DEFAULT NULL COMMENT '告警几次',
  `create_by_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by_id` bigint(20) DEFAULT NULL COMMENT '修改者ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务主体';
CREATE TABLE `t_blog_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` varchar(64) DEFAULT NULL COMMENT 'UUID编码',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者ID',
  `article_title` varchar(100) DEFAULT NULL COMMENT '标题',
  `article_series_id` bigint(20) DEFAULT NULL COMMENT '系列ID',
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
  `show_home` varchar(10) DEFAULT NULL COMMENT '是否在首页显示 1是0否',
  `editor_recommend` varchar(10) DEFAULT NULL COMMENT '编辑推荐  1是0否',
  `status` varchar(10) DEFAULT NULL COMMENT '状态0新建1发布2审核通过3审核不通过4系统删除',
  `create_by_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客';

CREATE TABLE `t_blog_article_hot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` varchar(64) DEFAULT NULL COMMENT 'UUID编码',
  `author_id` bigint(20) DEFAULT NULL COMMENT '作者ID',
  `article_title` varchar(100) DEFAULT NULL COMMENT '标题',
  `article_series_id` bigint(20) DEFAULT NULL COMMENT '系列ID',
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
  `show_home` varchar(10) DEFAULT NULL COMMENT '是否在首页显示 1是0否',
  `editor_recommend` varchar(10) DEFAULT NULL COMMENT '编辑推荐  1是0否',
  `status` varchar(10) DEFAULT NULL COMMENT '状态0新建1发布2审核通过3审核不通过4系统删除',
  `create_by_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `content` text COMMENT '文章内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='热门文章';


CREATE TABLE `t_blog_article_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `article_id` bigint(20) NOT NULL COMMENT '文章id',
  `content` varchar(400) COMMENT '评论内容',
  `delete_flag` char(1) DEFAULT NULL COMMENT '数据状态1正常 0 删除',
  `status` varchar(10) DEFAULT NULL COMMENT '状态0新建1发布2审核通过3审核不通过4系统删除',
  `create_by_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `favor_count` bigint(20) DEFAULT NULL COMMENT '收获点赞数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT '评论';


