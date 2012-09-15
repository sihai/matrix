--
-- Current Database: `igo`
--
DROP DATABASE IF EXISTS `igo`;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `igo` /*!40100 DEFAULT CHARACTER SET utf8 */;

GRANT ALL PRIVILEGES ON igo.* TO igo@''%' IDENTIFIED BY '378206';

USE `igo`;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE category (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	description VARCHAR(1024) NOT NULL,
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
-- Table structure for table `shop`
--
DROP TABLE IF EXISTS `shop`;
CREATE TABLE shop (
	id BIGINT(22) NOT NULL AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	detailURL VARCHAR(1024) NOT NULL,
	item_score INT,
	service_score INT,
	delivery_score INT,
	platform INT NOT NULL,
	PRIMARY KEY (`id`)
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
	category BIGINT(22),
	location VARCHAR(256),
	number BIGINT(22),
	stuff_status SMALLINT NOT NULL,
	freight_fee_payer SMALLINT NOT NULL,
	post_fee DOUBLE,
	express_fee DOUBLE,
	ems_fee DOUBLE,
	has_discount TINYINT,
	has_invoice TINYINT,
	has_warranty TINYINT,
	is_second_kill TINYINT,
	is_sell_promise TINYINT,
	is_xinpin TINYINT,
	item_id VARCHAR(64) NOT NULL,
	platform INT NOT NULL,
	shop BIGINT(22) NOT NULL,
	status INT NOT NULL,
	is_deleted TINYINT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `item_category` FOREIGN KEY (`category`) REFERENCES `category`(`id`),
	CONSTRAINT `item_shop` FOREIGN KEY (`shop`) REFERENCES `shop`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_bin;