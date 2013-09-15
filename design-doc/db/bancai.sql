-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 01 月 17 日 19:54
-- 服务器版本: 5.5.28
-- PHP 版本: 5.3.10-1ubuntu3.4

--
-- 数据库: `bancai`
--

-- --------------------------------------------------------

--
-- 表的结构 `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `reserve` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `admin_group` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `administrator`
--

INSERT INTO `administrator` (`id`, `name`, `password`, `reserve`, `admin_group`) VALUES
(1, 'jianjiaosun@163.com', 'bea2278e35da0c7262cd133ef9d172a8', NULL, 0),
(2, 'liuzf05@126.com', '7bc39802d368477658824444632a35ef', NULL, 0),
(3, 'zhyanjiang@126.com', '062dc9a3f2e23650cdc426159138e443', NULL, 0);

-- --------------------------------------------------------

--
-- 表的结构 `advertise_enterprise`
--

CREATE TABLE IF NOT EXISTS `advertise_enterprise` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ÒµÎñÎÞ¹ØÖ÷¼ü',
  `enterprise_id` int(11) DEFAULT NULL COMMENT 'Íâ¼ü',
  `purchase_id` int(11) DEFAULT NULL COMMENT 'Íâ¼ü',
  `reserved` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL COMMENT 'package中的area',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'order中的start_time',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'order中的end_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `advertise_product`
--

CREATE TABLE IF NOT EXISTS `advertise_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ÒµÎñÎÞ¹ØÖ÷¼ü',
  `product_id` int(11) DEFAULT NULL COMMENT 'Íâ¼ü',
  `purchase_id` int(11) DEFAULT NULL COMMENT 'Íâ¼ü',
  `reserved` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL COMMENT 'package中的category',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'order中的start_time',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'order中的end_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '种类名称，例如旋切机等',
  `property1` varchar(255) DEFAULT NULL COMMENT '属性',
  `property2` varchar(255) DEFAULT NULL COMMENT '属性',
  `property3` varchar(255) DEFAULT NULL COMMENT '属性',
  `property4` varchar(255) DEFAULT NULL COMMENT '属性',
  `property5` varchar(255) DEFAULT NULL COMMENT '属性',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品种类' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务无关主键',
  `resource` int(11) DEFAULT NULL COMMENT '外键',
  `content` varchar(255) DEFAULT NULL COMMENT '点评内容',
  `reserved` varchar(255) DEFAULT NULL COMMENT '预留字段，以备后用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `display_enterprise`
--

CREATE TABLE IF NOT EXISTS `display_enterprise` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ÒµÎñÎÞ¹ØÖ÷¼ü',
  `enterprise_id` int(11) DEFAULT NULL COMMENT 'Íâ¼ü',
  `purchase_id` int(11) DEFAULT NULL COMMENT 'Íâ¼ü',
  `reserved` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL COMMENT 'package中的area',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'order中的start_time',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'order中的end_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `display_product`
--

CREATE TABLE IF NOT EXISTS `display_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ÒµÎñÎÞ¹ØÖ÷¼ü',
  `product_id` int(11) DEFAULT NULL COMMENT 'Íâ¼ü',
  `purchase_id` int(11) DEFAULT NULL COMMENT 'Íâ¼ü',
  `reserved` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL COMMENT 'package中的category',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'order中的start_time',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'order中的end_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `enterprise`
--

CREATE TABLE IF NOT EXISTS `enterprise` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务无关主键',
  `name` varchar(255) DEFAULT NULL COMMENT '企业名称',
  `introduction` varchar(255) DEFAULT NULL COMMENT '公司简介',
  `logo` varchar(255) DEFAULT NULL COMMENT '企业logo',
  `province` varchar(255) DEFAULT NULL COMMENT '所在省',
  `city` varchar(255) DEFAULT NULL COMMENT '所在市',
  `county` varchar(255) DEFAULT NULL COMMENT '所在县',
  `town` varchar(255) DEFAULT NULL COMMENT '所在镇',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `scale` int(11) DEFAULT NULL COMMENT '公司规模，刚开始可能不用',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `pic_num` int(11) DEFAULT NULL COMMENT '可上传最大图片数',
  `reserved` varchar(255) DEFAULT NULL COMMENT '预留字段，以备后用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `enterprise_picture`
--

CREATE TABLE IF NOT EXISTS `enterprise_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ÒµÎñÎÞ¹ØÖ÷¼ü',
  `enterprise_id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL COMMENT 'Í¼Æ¬µØÖ·',
  `reserved` varchar(255) DEFAULT NULL COMMENT 'Ô¤Áô×Ö¶Î£¬ÒÔ±¸ºóÓÃ',
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `package`
--

CREATE TABLE IF NOT EXISTS `package` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务无关主键',
  `name` varchar(255) DEFAULT NULL COMMENT '套餐名',
  `time` int(1) DEFAULT '0' COMMENT '套餐持续时间',
  `price` double DEFAULT NULL COMMENT '套餐价格',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '套餐有效期开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '套餐有效期结束时间',
  `status` int(11) DEFAULT NULL COMMENT '套餐当前状态',
  `reserved` varchar(255) DEFAULT NULL COMMENT '预留字段，以备后用',
  `product_category` varchar(255) DEFAULT NULL,
  `ad_num` int(11) DEFAULT NULL COMMENT '首页广告区个数',
  `display_product_num` int(11) DEFAULT NULL COMMENT '产品栏展示个数',
  `display_enterprise_num` int(11) DEFAULT NULL COMMENT '企业栏展示个数',
  `enterprise_area` varchar(255) DEFAULT NULL COMMENT '地区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `phone`
--

CREATE TABLE IF NOT EXISTS `phone` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `contacter` varchar(255) DEFAULT NULL COMMENT '联系人姓名',
  `type` enum('office','mobile') DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `user` int(11) DEFAULT NULL COMMENT '外键指向user表',
  `enterprise` int(11) DEFAULT NULL COMMENT '外键，指向企业表',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务无关主键',
  `name` varchar(255) NOT NULL,
  `enterprise` int(11) DEFAULT NULL COMMENT '外键',
  `favourite` int(11) DEFAULT NULL COMMENT '收藏次数',
  `hits` int(11) DEFAULT NULL COMMENT '点击次数',
  `score` int(11) DEFAULT NULL COMMENT '评分',
  `introduction` varchar(255) DEFAULT NULL COMMENT '该产品简介',
  `icon` varchar(255) DEFAULT NULL COMMENT '资源图片',
  `reserved` varchar(255) DEFAULT NULL COMMENT '预留字段，以备后用',
  `category` varchar(255) NOT NULL COMMENT '大类，例如板材、机械',
  `detail` varchar(255) NOT NULL COMMENT '小类，例如板材的胶合板、三合板，机械的旋切机、切片机等',
  `property1` varchar(255) DEFAULT NULL,
  `property2` varchar(255) DEFAULT NULL,
  `property3` varchar(255) DEFAULT NULL,
  `property4` varchar(255) DEFAULT NULL,
  `property5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `product_picture`
--

CREATE TABLE IF NOT EXISTS `product_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务无关主键',
  `product_id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `reserved` varchar(255) DEFAULT NULL COMMENT '预留字段，以备后用',
  `status` int(11) DEFAULT NULL COMMENT '1代表是封面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `purchase`
--

CREATE TABLE IF NOT EXISTS `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise` int(11) NOT NULL DEFAULT '0' COMMENT '外键',
  `package` int(11) NOT NULL DEFAULT '0' COMMENT '外键',
  `amount` double NOT NULL DEFAULT '0' COMMENT '充值金额',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '充值时间',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '套餐生效时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '套餐过期时间',
  `valid` enum('valid','invalid') NOT NULL DEFAULT 'valid' COMMENT 'valid为无效，invalid为有效',
  `reserved` varchar(255) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务无关主键',
  `email` varchar(255) DEFAULT NULL COMMENT '注册邮件,同时也是登入用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码，Md5存储',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `name` varchar(255) DEFAULT NULL,
  `gender` enum('male','female','secret') DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `qq` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `enterprise` int(11) DEFAULT '-1' COMMENT '外键',
  `login_times` int(11) DEFAULT '0' COMMENT '登陆次数',
  `last_login` double DEFAULT '0' COMMENT '最后登陆时间',
  `reserved` varchar(255) DEFAULT NULL COMMENT '预留字段，以备后用',
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_activation`
--

CREATE TABLE IF NOT EXISTS `user_activation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `time` bigint(32) NOT NULL,
  `counts` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_enterprise_favourite`
--

CREATE TABLE IF NOT EXISTS `user_enterprise_favourite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL COMMENT '外键，指向user表',
  `enterprise` int(11) DEFAULT NULL COMMENT '外键，指向企业表',
  `time` varchar(255) DEFAULT NULL COMMENT '收藏时间',
  `reserved` varchar(255) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏企业表' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user_product_favourite`
--

CREATE TABLE IF NOT EXISTS `user_product_favourite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL COMMENT '外键，指向user表',
  `product` int(11) DEFAULT NULL COMMENT '外键，指向产品表',
  `time` varchar(255) DEFAULT NULL COMMENT '收藏时间',
  `reserved` varchar(255) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏产品表' AUTO_INCREMENT=1 ;
