--
-- Current Database: `igo`
--
DROP DATABASE IF EXISTS `igo`;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `igo` /*!40100 DEFAULT CHARACTER SET utf8 */;

GRANT ALL PRIVILEGES ON igo.* TO 'igo'@'localhost' IDENTIFIED BY '378206';

USE `igo`;

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
	CONSTRAINT `inner_category_id_category` FOREIGN KEY (`inner_category_id`) REFERENCES `category`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;