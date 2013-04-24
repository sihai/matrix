--
-- Current Database: `igo`
--
DROP DATABASE IF EXISTS `igo`;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `igo` /*!40100 DEFAULT CHARACTER SET utf8 */;

GRANT ALL PRIVILEGES ON igo.* TO 'igo'@'localhost' IDENTIFIED BY '378206';

USE `igo`;

UPDATE category_ass SET shop_name = '华源大药房旗舰店' WHERE shop_name = '01-华源大药房';
UPDATE category_ass SET shop_name = '立方大药房旗舰店' WHERE shop_name = '28-立方大药房';
UPDATE category_ass SET shop_name = '万泽大药房旗舰店' WHERE shop_name = '29-万泽大药房';
UPDATE category_ass SET shop_name = '新兴大药房旗舰店' WHERE shop_name = '30-新兴大药房';
UPDATE category_ass SET shop_name = '百洋健康大药房旗舰店' WHERE shop_name = '31-百洋健康大药房';
UPDATE category_ass SET shop_name = '仁博大药房旗舰店' WHERE shop_name = '32-仁博大药房';
UPDATE category_ass SET shop_name = '复美大药房旗舰店' WHERE shop_name = '33-复美大药房';
UPDATE category_ass SET shop_name = '德生堂大药房旗舰店' WHERE shop_name = '03-德生堂大药房';
UPDATE category_ass SET shop_name = '华佗大药房旗舰店' WHERE shop_name = '04-华佗大药房';
UPDATE category_ass SET shop_name = '海王星辰大药房旗舰店' WHERE shop_name = '05-海王星辰大药房';
UPDATE category_ass SET shop_name = '亚洲大药房旗舰店' WHERE shop_name = '06-亚洲大药房';
UPDATE category_ass SET shop_name = '健民大药房旗舰店' WHERE shop_name = '07-健民大药房';
UPDATE category_ass SET shop_name = '健客大药房旗舰店' WHERE shop_name = '08-健客大药房';
UPDATE category_ass SET shop_name = '上海大药房旗舰店' WHERE shop_name = '09-上海大药房';
UPDATE category_ass SET shop_name = '吉大夫大药房旗舰店' WHERE shop_name = '10-吉大夫大药房';
UPDATE category_ass SET shop_name = '昂生大药房旗舰店' WHERE shop_name = '11-昂生大药房';
UPDATE category_ass SET shop_name = '开心人大药房旗舰店' WHERE shop_name = '12-开心人大药房';
UPDATE category_ass SET shop_name = '康之家大药房旗舰店' WHERE shop_name = '13-康之家大药房';
UPDATE category_ass SET shop_name = '天士力大药房旗舰店' WHERE shop_name = '14-天士力大药房';
UPDATE category_ass SET shop_name = '康众之家大药房旗舰店' WHERE shop_name = '15-康众之家大药房';
UPDATE category_ass SET shop_name = '惠好大药房旗舰店' WHERE shop_name = '16-惠好大药房';
UPDATE category_ass SET shop_name = '壹号大药房旗舰店' WHERE shop_name = '17-壹号大药房';
UPDATE category_ass SET shop_name = '和平大药房旗舰店' WHERE shop_name = '18-和平大药房';
UPDATE category_ass SET shop_name = '九洲大药房旗舰店' WHERE shop_name = '19-九洲大药房';
UPDATE category_ass SET shop_name = '嘉定大药房旗舰店' WHERE shop_name = '20-嘉定大药房';
UPDATE category_ass SET shop_name = '乡亲大药房旗舰店' WHERE shop_name = '21-乡亲大药房';
UPDATE category_ass SET shop_name = '京卫大药房旗舰店' WHERE shop_name = '22-京卫大药房';
UPDATE category_ass SET shop_name = '先声再康大药房旗舰店' WHERE shop_name = '23-先声再康大药房';
UPDATE category_ass SET shop_name = '同一大药房旗舰店' WHERE shop_name = '24-同一大药房';
UPDATE category_ass SET shop_name = '百济新特大药房旗舰店' WHERE shop_name = '25-百济新特大药房';
UPDATE category_ass SET shop_name = '上元堂大药房旗舰店' WHERE shop_name = '26-上元堂大药房';
UPDATE category_ass SET shop_name = '康爱多大药房旗舰店' WHERE shop_name = '27-康爱多大药房';
UPDATE category_ass SET shop_name = '健之佳大药房旗舰店' WHERE shop_name = '34-健之佳大药房';
UPDATE category_ass SET shop_name = '华氏大药房旗舰店' WHERE shop_name = '35-华氏大药房';
UPDATE category_ass SET shop_name = '存仁堂大药房旗舰店' WHERE shop_name = '36-存仁堂大药房';
UPDATE category_ass SET shop_name = '彩虹大药房旗舰店' WHERE shop_name = '37-彩虹大药房';
UPDATE category_ass SET shop_name = '德威治大药房旗舰店' WHERE shop_name = '38-德威治大药房';
UPDATE category_ass SET shop_name = '金象大药房旗舰店' WHERE shop_name = '39-金象大药房';
UPDATE category_ass SET shop_name = '云南白药大药房旗舰店' WHERE shop_name = '40-云南白药大药房';
UPDATE category_ass SET shop_name = '人民同泰大药房旗舰店' WHERE shop_name = '41-人民同泰大药房';
UPDATE category_ass SET shop_name = '二元堂大药房旗舰店' WHERE shop_name = '42-二元堂大药房';
UPDATE category_ass SET shop_name = '医保中洋大药房旗舰店' WHERE shop_name = '43-医保中洋大药房';
UPDATE category_ass SET shop_name = '四明大药房旗舰店' WHERE shop_name = '44-四明大药房';
UPDATE category_ass SET shop_name = '漱玉平民大药房旗舰店' WHERE shop_name = '46-漱玉平民大药房';
UPDATE category_ass SET shop_name = '天健国药堂大药房旗舰店' WHERE shop_name = '47-天健国药堂大药房';

SET foreign_key_checks = 0;
SET foreign_key_checks = 1;
--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE user (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(64) NOT NULL,
	email VARCHAR(64) NOT NULL,
	password VARCHAR(64) NOT NULL,
	logo_url VARCHAR(1024),
	status INT NOT NULL,
	`from` INT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE(`name`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE category (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	description VARCHAR(1024) NOT NULL,
	keywords VARCHAR(2048),
	status INT NOT NULL,
	rank INT NOT NULL,
	parent BIGINT(22),
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `category_parent` FOREIGN KEY (`parent`) REFERENCES `category`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `brand`
--
DROP TABLE IF EXISTS `brand`;
CREATE TABLE brand (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	logo_url VARCHAR(1024),
	company_name VARCHAR(128), 
	company_url VARCHAR(1024),
	status INT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE(name)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `product`
--
DROP TABLE IF EXISTS `product`;
CREATE TABLE product (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	logo_url VARCHAR(1024),
	brand BIGINT(22), 
	category BIGINT(22),
	status INT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `product_category` FOREIGN KEY (`category`) REFERENCES `category`(`id`),
	CONSTRAINT `product_brand` FOREIGN KEY (`brand`) REFERENCES `brand`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `property_group`
--
DROP TABLE IF EXISTS `property_group`;
CREATE TABLE property_group (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	type INT NOT NULL,
	owner BIGINT(22) NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE(type, owner, name)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `property`
--
DROP TABLE IF EXISTS `property`;
CREATE TABLE property (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	`key` VARCHAR(128) NOT NULL,
	`value` VARCHAR(1024) NOT NULL,
	value_type INT NOT NULL,
	`group` BIGINT NOT NULL,
	type INT NOT NULL,
	owner BIGINT(22) NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `property_group` FOREIGN KEY (`group`) REFERENCES `property_group`(`id`),
	UNIQUE(type, owner, `group`, `key`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `shop`
--
DROP TABLE IF EXISTS `shop`;
CREATE TABLE shop (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	shop_id VARCHAR(64) NOT NULL,
	name VARCHAR(128) NOT NULL,
	seller_name VARCHAR(128),
	description VARCHAR(1024),
	logo_url VARCHAR(1024),
	detail_url VARCHAR(1024) NOT NULL,
	payways VARCHAR(128),
	distribute_ways VARCHAR(128),
	location VARCHAR(64),
	is_recommend TINYINT NOT NULL,
	rank BIGINT(22) NOT NULL,
	status INT NOT NULL,
	shop_score BIGINT(22),
	platform INT NOT NULL,
	license VARCHAR(32),
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `shop_score`
--
DROP TABLE IF EXISTS `shop_score`;
CREATE TABLE shop_score (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	shop BIGINT(22) NOT NULL,
	item_score INT,
	service_score INT,
	delivery_score INT,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `shop_score_shop` FOREIGN KEY (`shop`) REFERENCES `shop`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `shop_product`
--
DROP TABLE IF EXISTS `shop_product`;
CREATE TABLE shop_product (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	shop BIGINT(22) NOT NULL,
	product BIGINT(22) NOT NULL,
	rank BIGINT(22) NOT NULL,
	status INT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE(shop, product),
	CONSTRAINT `shop` FOREIGN KEY (`shop`) REFERENCES `shop`(`id`),
	CONSTRAINT `product` FOREIGN KEY (`product`) REFERENCES `product`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `item`
--
DROP TABLE IF EXISTS `item`;
CREATE TABLE item (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	price DOUBLE NOT NULL,
	detail_url VARCHAR(1024) NOT NULL,
	logo_url VARCHAR(1024) NOT NULL,
	brand BIGINT(22),
	product BIGINT(22),
	tmp_product BIGINT(22),
	category BIGINT(22),
	number BIGINT(22),
	sale_count_pre_month BIGINT(22),
	freight_fee_payer SMALLINT NOT NULL,
	post_fee DOUBLE,
	express_fee DOUBLE,
	ems_fee DOUBLE,
	has_discount TINYINT,
	has_invoice TINYINT,
	has_warranty TINYINT,
	is_second_kill TINYINT,
	is_sell_promise TINYINT,
	gifts VARCHAR(1024),
	item_id VARCHAR(64) NOT NULL,
	platform INT NOT NULL,
	promotion VARCHAR(1024),
	location VARCHAR(128),
	shop BIGINT(22) NOT NULL,
	status INT NOT NULL,
	score DOUBLE,
	comment_count INT,
	is_recommended TINYINT NOT NULL,
	recommend_reason VARCHAR(1024),
	favorable_comment_count BIGINT(22),
	medium_comment_count BIGINT(22),
	poor_comment_count BIGINT(22),
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `item_product` FOREIGN KEY (`product`) REFERENCES `product`(`id`),
	CONSTRAINT `item_category` FOREIGN KEY (`category`) REFERENCES `category`(`id`),
	CONSTRAINT `item_shop` FOREIGN KEY (`shop`) REFERENCES `shop`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `comment`
--
DROP TABLE IF EXISTS `comment`;
CREATE TABLE comment (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	publisher VARCHAR(128),
	score DOUBLE,
	content VARCHAR(2048) NOT NULL,
	type INT NOT NULL,
	owner BIGINT(22) NOT NULL,
	publish_time DATETIME NOT NULL,
	is_buy TINYINT,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;
CREATE index comment_owner_type_index ON comment(owner, type);

--
-- Table structure for table `picture`
--
DROP TABLE IF EXISTS `picture`;
CREATE TABLE picture (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	title VARCHAR(128) NOT NULL,
	url VARCHAR(1024) NOT NULL,
	type INT NOT NULL,
	owner BIGINT(22) NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE(type, owner)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `trace_log`
--
DROP TABLE IF EXISTS trace_log;
CREATE TABLE trace_log (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	uuid BIGINT(22) NOT NULL,
	user_id BIGINT(22),
	user_name VARCHAR(64),
	remote_ip VARCHAR(32),
	referer_url VARCHAR(1024),
	click_url VARCHAR(1024),
	item_id BIGINT(22),
	shop_id BIGINT(22),
	web_site_id BIGINT(22),
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id)
) ENGINE = MYISAM DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `item_trace_log`
--
DROP TABLE IF EXISTS item_trace_log;
CREATE TABLE item_trace_log (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	uuid BIGINT(22) NOT NULL,
	user_id BIGINT(22),
	user_name VARCHAR(64),
	remote_ip VARCHAR(32),
	item_id BIGINT(22),
	item_name VARCHAR(128),
	item_price DOUBLE,
	shop_id BIGINT(22),
	shop_name VARCHAR(128),
	platform INT,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id)
) ENGINE = MYISAM DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `shop_trace_log`
--
DROP TABLE IF EXISTS shop_trace_log;
CREATE TABLE shop_trace_log (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	uuid BIGINT(22) NOT NULL,
	user_id BIGINT(22),
	user_name VARCHAR(64),
	remote_ip VARCHAR(32),
	shop_id BIGINT(22),
	shop_name VARCHAR(128),
	platform INT,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id)
) ENGINE = MYISAM DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `web_site_trace_log`
--
DROP TABLE IF EXISTS web_site_trace_log;
CREATE TABLE web_site_trace_log (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	uuid BIGINT(22) NOT NULL,
	user_id BIGINT(22),
	user_name VARCHAR(64),
	remote_ip VARCHAR(32),
	web_site_id BIGINT(22),
	web_site_name VARCHAR(128),
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id)
) ENGINE = MYISAM DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `website`
--
DROP TABLE IF EXISTS web_site;
CREATE TABLE web_site (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(64) NOT NULL,
	site_url VARCHAR(1204) NOT NULL,
	logo VARCHAR(1024) NOT NULL,
	type INT NOT NULL,
	rank BIGINT NULL,
	view_count BIGINT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `activity`
--
DROP TABLE IF EXISTS activity;
CREATE TABLE activity (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(64) NOT NULL,
	logo_url VARCHAR(1204) NOT NULL,
	url VARCHAR(1024) NOT NULL,
	rank BIGINT NULL,
	start_time DATETIME NOT NULL,
	end_time DATETIME NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `promotion_activity`
--
DROP TABLE IF EXISTS promotion_activity;
CREATE TABLE promotion_activity (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(64) NOT NULL,
	logo_url VARCHAR(1204) NOT NULL,
	url VARCHAR(1024) NOT NULL,
	rank BIGINT NULL,
	start_time DATETIME NOT NULL,
	end_time DATETIME NOT NULL,
	shop BIGINT(22) NOT NULL,
	category BIGINT(22) NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT `promotion_activity_shop` FOREIGN KEY (`shop`) REFERENCES `shop`(`id`),
	CONSTRAINT `promotion_activity_category` FOREIGN KEY (`category`) REFERENCES `category`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `shop_category`
--
DROP TABLE IF EXISTS shop_category;
CREATE TABLE shop_category (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	shop BIGINT(22) NOT NULL,
	category BIGINT(22) NOT NULL,
	rank BIGINT(22) NOT NULL,
	status INT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id),
	UNIQUE(shop, category),
	CONSTRAINT `shop_category_shop` FOREIGN KEY (`shop`) REFERENCES `shop`(`id`),
	CONSTRAINT `shop_category_category` FOREIGN KEY (`category`) REFERENCES `category`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `brand_category`
--
DROP TABLE IF EXISTS brand_category;
CREATE TABLE brand_category (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	brand BIGINT(22) NOT NULL,
	category BIGINT(22) NOT NULL,
	rank BIGINT(22) NOT NULL,
	status INT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id),
	UNIQUE(brand, category),
	CONSTRAINT `brand_category_brand` FOREIGN KEY (`brand`) REFERENCES `brand`(`id`),
	CONSTRAINT `brand_category_category` FOREIGN KEY (`category`) REFERENCES `category`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `brand_product`
--
DROP TABLE IF EXISTS brand_product;
CREATE TABLE brand_product (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	brand BIGINT(22) NOT NULL,
	product BIGINT(22) NOT NULL,
	rank BIGINT(22) NOT NULL,
	status INT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id),
	UNIQUE(brand, product),
	CONSTRAINT `brand_product_brand` FOREIGN KEY (`brand`) REFERENCES `brand`(`id`),
	CONSTRAINT `brand_product_product` FOREIGN KEY (`product`) REFERENCES `product`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `matrix_sequence`
--
DROP TABLE IF EXISTS matrix_sequence;
CREATE TABLE matrix_sequence (
	sequence_name VARCHAR(32) NOT NULL,
	sequence_value BIGINT(22) NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (sequence_name)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- uuid
--
INSERT INTO matrix_sequence (
	sequence_name,
	sequence_value,
	gmt_modified
) VALUES (
	'uuid',
	'0',
	now()
);


--
-- root category
--
INSERT INTO category (
	id,
	name,
	description,
	keywords,
	status,
	rank,
	parent,
	is_deleted,
	gmt_create,
	gmt_modified
) VALUES (
	null,
	'root',
	'root',
	null,
	0,
	0,
	null,
	0,
	now(),
	now()
);
mysqlbinlog –stop-date=’2013-04-22 02:15:00′ /var/lib/mysql/mysql-bin.000001  | mysql -u root -p378206 -S/var/lib/mysql/mysql.sock
--
-- Table structure for table `category_ass`
--
DROP TABLE IF EXISTS category_ass;
CREATE TABLE category_ass (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	out_category_id BIGINT(22),
	out_category_name VARCHAR(128),
	platform INT NOT NULL,
	shop_name VARCHAR(128),
	inner_category_id BIGINT(22) NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT `category_ass_inner_category` FOREIGN KEY (`inner_category_id`) REFERENCES `category`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;


--
-- Table structure for table `product_ass`
--
DROP TABLE IF EXISTS product_ass;
CREATE TABLE product_ass (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	out_product_id BIGINT(22),
	out_product_name VARCHAR(128),
	platform INT NOT NULL,
	shop_name VARCHAR(128),
	inner_product_id BIGINT(22) NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT `product_ass_inner_product` FOREIGN KEY (`inner_product_id`) REFERENCES `product`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;

--
-- Table structure for table `tmp_product`
--
DROP TABLE IF EXISTS tmp_product;
CREATE TABLE tmp_product (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	out_product_id BIGINT(22) NOT NULL,
	out_product_name VARCHAR(128) NOT NULL,
	logo_url VARCHAR(1024),
	out_category_id BIGINT(22),
	out_category_name VARCHAR(128),
	description VARCHAR(25000),
	property VARCHAR(4096),
	platform INT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;