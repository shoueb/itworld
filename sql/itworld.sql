/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : itworld

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-01-31 16:55:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_author_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_author_user`;
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
  `img_url` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `favor_count` bigint(20) DEFAULT NULL COMMENT '用户收获喜欢数',
  `writen_count` bigint(20) DEFAULT NULL COMMENT '已写字数',
  `create_by_id` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by_id` bigint(20) DEFAULT NULL COMMENT '修改ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='作者表';

-- ----------------------------
-- Records of t_author_user
-- ----------------------------
INSERT INTO `t_author_user` VALUES ('1', '123', 'admin1', 'abcbbfaea4e618fa7f88cb6b47c6969c', '青刀一锋', '123', '12312', null, null, '12', '12', '12', '/assets/images/avatars/avatar-1.png', '1', '12', null, null, null, null);

-- ----------------------------
-- Table structure for `t_blog_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_article`;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blog_article
-- ----------------------------
INSERT INTO `t_blog_article` VALUES ('1', '123', '1', 'MyBatis入门', '1', '1', '11', '1', '1', '1', null, '撒的发生,sdfasf,是打发我是电饭锅地方', null, '12', '123', '123', '1', '1', '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `t_blog_article_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_article_comment`;
CREATE TABLE `t_blog_article_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author_id` bigint(20) NOT NULL COMMENT '作者ID',
  `article_id` bigint(20) NOT NULL COMMENT '文章ID',
  `content` varchar(400) DEFAULT NULL COMMENT '评论内容',
  `delete_flag` char(1) DEFAULT NULL COMMENT '数据状态1正常 0 删除',
  `status` varchar(10) DEFAULT NULL COMMENT '状态0新建1发布2审核通过3审核不通过4系统删除',
  `favor_count` bigint(20) DEFAULT NULL COMMENT '收获点赞数',
  `create_by_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Records of t_blog_article_comment
-- ----------------------------
INSERT INTO `t_blog_article_comment` VALUES ('1', '1', '1', 'MyBatis入门评论OK', '1', '1', '1', '1', '2019-01-31 16:52:25', '1', '2019-01-31 16:52:30');

-- ----------------------------
-- Table structure for `t_blog_article_context`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_article_context`;
CREATE TABLE `t_blog_article_context` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) NOT NULL COMMENT '博客ID',
  `content` text COMMENT '博客内容',
  `ismarkdown` varchar(10) DEFAULT '1' COMMENT '是否为markdown编辑1是0不是',
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blog_article_context
-- ----------------------------
INSERT INTO `t_blog_article_context` VALUES ('1', '1', '### 返回结果\r\n```json\r\n <resultMap id=\"BaseResultMap\" type=\"com.goods.model.ServiceGoodsBase\" >\r\n    <id column=\"sid\" property=\"sid\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"service_name\" property=\"serviceName\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"service_district\" property=\"serviceDistrict\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"longitude\" property=\"longitude\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"latitude\" property=\"latitude\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"address\" property=\"address\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"service_fee\" property=\"serviceFee\" jdbcType=\"DOUBLE\" />\r\n    <result column=\"service_price\" property=\"servicePrice\" jdbcType=\"DOUBLE\" />\r\n    <result column=\"service_unit\" property=\"serviceUnit\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"user_service_type_id\" property=\"userServiceTypeId\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"service_type\" property=\"serviceType\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"release_time\" property=\"releaseTime\" jdbcType=\"VARCHAR\" />\r\n    <result column=\"create_time\" property=\"createTime\" jdbcType=\"TIMESTAMP\" />\r\n </resultMap>\r\n```\r\n\r\n', '1');

-- ----------------------------
-- Table structure for `t_blog_article_hot`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_article_hot`;
CREATE TABLE `t_blog_article_hot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` varchar(64) DEFAULT NULL COMMENT '文章UUID编码',
  `article_id` bigint(20) DEFAULT NULL COMMENT '文章ID',
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='热门文章';

-- ----------------------------
-- Records of t_blog_article_hot
-- ----------------------------
INSERT INTO `t_blog_article_hot` VALUES ('1', '1231', '1', '1', '司法地方', '1', null, 'java', '在 \"CAP理论与MongoDB一致性、可用性的一些思考\" 一文中提到，MongoDB提供了一些选项，如Read Preference、Read Concern、Write Concern，对MongoDB的一致性、可用性、可靠性（durability）、性能会有较大的影响', null, 'assets/images/avatars/avatar-1.png', null, '12312,123123,124', null, '100', '12', '21', '1', '2', '1', '1', null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('2', '23', '2', '1', '对方感受到过', '1', null, 'java', '将jar包发布到Maven中央仓库( \"Maven Central Repository\" )，这样所有的Java开发者都可以使用Maven直接导入依赖，例如 \"fundebug java\" ： 但是，Maven中央仓库并不支持直接发布jar包。我们需要将jar包发布到一些指定的第三方Maven仓库', null, 'assets/images/avatars/avatar-2.png', null, '12312,123123,124', null, '123', '123', '23343', '1', '2', '1', '1', null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('3', '12', '3', '1', '的是否还是', '1', null, 'java', 'Java集合类主要由两个根接口Collection和Map派生出来的，Collection派生出了三个子接口：List、Set、Queue（Java5新增的队列）， 因此Java集合大致也可分成List、Set、Queue、Map四种接口体系，（注意：Map不是Collection的子接口）', null, 'assets/images/avatars/avatar-3.png', null, '12312,123123,124', null, '124', '12345', '7443', '1', '2', '1', '1', null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('4', '312', '4', '1', '鸡飞狗叫改好', '1', null, 'java', '目录 \"Spring系列之IOC的原理及手动实现\" \"Spring系列之DI的原理及手动实现\" \"Spring系列之AOP的原理及手动实现\" \"Spring系列之手写注解与配置文件的解析\" 引言 在前面的几个章节中我们已经简单的完成了一个简易版的spring，已经包括容器，依赖注入，AOP和配置文件', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '3434', '353', '457567', '1', '1', '1', '0', null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('5', '12', '5', '1', '2134', '1', null, 'java', '123', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '3', '5', '12312', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('6', '3123', '6', '1', '12', '1', null, 'java', '1', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '64', '34', '31', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('7', '1', '7', '1', '34', '1', null, 'java', '23', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '567', '5', '4', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('8', '23', '8', '1', '12', '1', null, 'java', '12', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '4', '3', '35', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('9', '1', '9', '1', '34132', '1', null, 'java', '3', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '7586', '345', '43', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('10', '12', null, '1', '451', '1', null, 'java', '12', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '79', '5', '5', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('11', '3231', null, '1', '234', '1', null, 'java', '4', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '67', '4', '3', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('12', '1', null, '1', '12', '1', null, 'java', '12', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '89', '4', '5', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('13', '234', null, '1', '341', '1', null, 'java', '4', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '78', '6', '34', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('14', '23', null, '1', '23412354123', '1', null, 'java', '12', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '7', '9', '5678', '1', '1', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('15', '5', null, '1', '41', '1', null, 'java', '41', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '80', '76', '56', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('16', '2', null, '1', '234', '1', null, 'java', '24', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '89', '8', '7', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('17', '35', null, '1', '12', '1', null, 'java', '12', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '0', '65', '56', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('18', '2', null, '1', '34', '1', null, 'java', '4', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '89', '7', '7', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('19', '35', null, '1', '123', '1', null, 'java', '24', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '0', '645', '567', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('20', '2', null, '1', '41', '1', null, 'java', '41', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '89', '5', '5', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('21', '35', null, '1', '23', '1', null, 'java', '12', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '0', '64', '67', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('22', '23', null, '1', '412', '1', null, 'java', '1', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '89', '54', '5', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('23', '5', null, '1', '34', '1', null, 'java', '1', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '8', '4', '67', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('24', '23', null, '1', '12', '1', null, 'java', '24', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '9', '23', '5', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('25', '52', null, '1', '34', '1', null, 'java', '1', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '8', '34', '686', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('26', '3', null, '1', '123', '1', null, 'java', '4', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '9', '2', '8', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('27', '52', null, '1', '41', '1', null, '.net', '1', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '8', '234', '7', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('28', '35', null, '1', '234', '1', null, 'java', '42', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '90', '89', '9769', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('29', '23', null, '1', '12', '1', null, 'java', '1', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '89', '0', '8', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('30', '52', null, '1', '34', '1', null, 'java', '24', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '8', '89', '79', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('31', '5', null, '1', '123', '1', null, 'java', '12', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '989', '90', '7', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('32', '235', null, '1', '41', '1', null, 'java', '4', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '89', '8', '89', '1', '2', '1', null, null, null, null, null, null);
INSERT INTO `t_blog_article_hot` VALUES ('33', '235', null, '1', '234', '1', null, 'java', '124', null, 'assets/images/avatars/avatar-4.png', null, '12312,123123,124', null, '890', '890', '78', '1', '1', '1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_blog_series`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_series`;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文章系列';

-- ----------------------------
-- Records of t_blog_series
-- ----------------------------
INSERT INTO `t_blog_series` VALUES ('1', 'Java', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_task_main`
-- ----------------------------
DROP TABLE IF EXISTS `t_task_main`;
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

-- ----------------------------
-- Records of t_task_main
-- ----------------------------

-- ----------------------------
-- Table structure for `t_test`
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES ('1', 'sdsd0', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('2', 'sdsd1', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('3', 'sdsd2', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('4', 'sdsd3', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('5', 'sdsd4', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('6', 'sdsd5', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('7', 'sdsd6', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('8', 'sdsd7', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('9', 'sdsd8', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('10', 'sdsd9', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('11', 'sdsd10', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('12', 'sdsd11', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('13', 'sdsd12', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('14', 'sdsd13', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('15', 'sdsd14', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('16', 'sdsd15', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('17', 'sdsd16', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('18', 'sdsd17', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('19', 'sdsd18', null, null, null, null, null, null);
INSERT INTO `t_test` VALUES ('20', 'sdsd19', null, null, null, null, null, null);
