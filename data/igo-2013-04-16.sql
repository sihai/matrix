-- MySQL dump 10.13  Distrib 5.5.28, for Linux (i686)
--
-- Host: 127.0.0.1    Database: igo
-- ------------------------------------------------------
-- Server version	5.5.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `igo`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `igo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `igo`;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `logo_url` varchar(1204) COLLATE utf8_bin NOT NULL,
  `url` varchar(1024) COLLATE utf8_bin NOT NULL,
  `rank` bigint(20) DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `logo_url` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `company_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `company_url` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1073 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand_category`
--

DROP TABLE IF EXISTS `brand_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand_category` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `brand` bigint(22) NOT NULL,
  `category` bigint(22) NOT NULL,
  `rank` bigint(22) NOT NULL,
  `status` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `brand` (`brand`,`category`),
  KEY `brand_category_category` (`category`),
  CONSTRAINT `brand_category_brand` FOREIGN KEY (`brand`) REFERENCES `brand` (`id`),
  CONSTRAINT `brand_category_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand_category`
--

LOCK TABLES `brand_category` WRITE;
/*!40000 ALTER TABLE `brand_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand_product`
--

DROP TABLE IF EXISTS `brand_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand_product` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `brand` bigint(22) NOT NULL,
  `product` bigint(22) NOT NULL,
  `rank` bigint(22) NOT NULL,
  `status` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `brand` (`brand`,`product`),
  KEY `brand_product_product` (`product`),
  CONSTRAINT `brand_product_brand` FOREIGN KEY (`brand`) REFERENCES `brand` (`id`),
  CONSTRAINT `brand_product_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand_product`
--

LOCK TABLES `brand_product` WRITE;
/*!40000 ALTER TABLE `brand_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `description` varchar(1024) COLLATE utf8_bin NOT NULL,
  `keywords` varchar(2048) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) NOT NULL,
  `rank` int(11) NOT NULL,
  `parent` bigint(22) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_parent` (`parent`),
  CONSTRAINT `category_parent` FOREIGN KEY (`parent`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'root','root',NULL,0,0,NULL,0,'2013-04-15 14:12:46','2013-04-15 14:12:46'),(2,'医疗器械','医疗器械',NULL,0,0,1,0,'2013-04-15 14:13:05','2013-04-15 14:13:05'),(3,'健康生活','家庭必备',NULL,0,0,2,0,'2013-04-15 14:13:39','2013-04-15 14:23:11'),(4,'家庭必备','康复用品',NULL,0,1,2,0,'2013-04-15 14:14:32','2013-04-15 14:23:04'),(5,'康复用品','健康生活',NULL,0,1,2,0,'2013-04-15 14:14:42','2013-04-15 16:51:11'),(6,'创伤处理(product:0,shop:0.item:0)','床上处理',NULL,0,0,4,0,'2013-04-15 14:15:11','2013-04-15 14:15:24'),(7,'口腔卫生','口腔卫生',NULL,0,1,4,0,'2013-04-15 14:15:59','2013-04-15 14:15:59'),(8,'消毒卫生','消毒卫生',NULL,0,2,4,0,'2013-04-15 14:17:07','2013-04-15 14:17:07'),(9,'药箱药盒','药箱药盒',NULL,0,2,4,0,'2013-04-15 14:17:13','2013-04-15 14:17:13'),(10,'晕车晕船(product:0,shop:0.item:0)','晕车晕船',NULL,0,2,4,0,'2013-04-15 14:17:18','2013-04-15 16:08:06'),(11,'体温相关','体温相关',NULL,0,2,4,0,'2013-04-15 14:17:33','2013-04-15 14:17:33'),(12,'家用医具','New node',NULL,0,6,4,0,'2013-04-15 14:17:40','2013-04-15 14:18:31'),(13,'检测器具(product:0,shop:0.item:0)','监测器具',NULL,0,6,4,0,'2013-04-15 14:17:49','2013-04-15 16:07:03'),(14,'其他用品','其他用品',NULL,0,8,4,0,'2013-04-15 14:18:40','2013-04-15 14:18:40'),(15,'助听设备','助听设备',NULL,0,0,5,0,'2013-04-15 14:19:23','2013-04-15 16:50:42'),(16,'皮肤健康','皮肤健康',NULL,0,0,5,0,'2013-04-15 14:19:32','2013-04-15 14:19:32'),(17,'眼科护理','眼科护理',NULL,0,0,5,0,'2013-04-15 14:19:36','2013-04-15 14:19:36'),(18,'鼻腔护理','鼻腔护理',NULL,0,3,5,0,'2013-04-15 14:19:46','2013-04-15 16:50:20'),(19,'护理器具','护理器具',NULL,0,3,5,0,'2013-04-15 14:19:57','2013-04-15 16:51:23'),(20,'养心降压','养心降压',NULL,0,3,5,0,'2013-04-15 14:20:05','2013-04-15 14:20:05'),(21,'血糖调节','血糖调节',NULL,0,6,5,0,'2013-04-15 14:20:39','2013-04-15 14:20:39'),(22,'颈部健康','颈部健康',NULL,0,6,5,0,'2013-04-15 14:20:56','2013-04-15 14:20:56'),(23,'上肢护理','上肢护理',NULL,0,6,5,0,'2013-04-15 14:21:02','2013-04-15 14:21:02'),(24,'腰髋保养','腰髋保养',NULL,0,6,5,0,'2013-04-15 14:21:09','2013-04-15 14:21:09'),(25,'腿脚护理','腿脚护理',NULL,0,6,5,0,'2013-04-15 14:21:14','2013-04-15 14:21:14'),(26,'肛肠保健','肛肠保健',NULL,0,6,5,0,'2013-04-15 14:21:20','2013-04-15 14:21:20'),(27,'贴膏喷剂','贴膏喷剂',NULL,0,6,5,0,'2013-04-15 14:21:31','2013-04-15 14:21:31'),(28,'健康睡眠','健康睡眠',NULL,0,0,3,0,'2013-04-15 14:24:40','2013-04-15 14:24:40'),(29,'按摩器具','按摩器具',NULL,0,1,3,0,'2013-04-15 14:42:21','2013-04-15 14:42:21'),(30,'制氧雾化','制氧雾化',NULL,0,1,3,0,'2013-04-15 14:42:30','2013-04-15 14:42:30'),(31,'中医用具','中医用具',NULL,0,1,3,0,'2013-04-15 14:42:36','2013-04-15 14:42:36'),(32,'光电磁疗','光电磁疗',NULL,0,1,3,0,'2013-04-15 14:42:44','2013-04-15 14:42:44'),(33,'婴幼儿童','婴幼儿童',NULL,0,1,3,0,'2013-04-15 14:42:53','2013-04-15 14:42:53'),(34,'老年生活','老年生活',NULL,0,1,3,0,'2013-04-15 14:43:02','2013-04-15 14:43:02'),(35,'助行用具','助行用具',NULL,0,1,3,0,'2013-04-15 14:43:13','2013-04-15 14:43:13'),(36,'益智健身','益智健身',NULL,0,1,3,0,'2013-04-15 14:43:20','2013-04-15 14:43:20'),(37,'男性健康','男性健康',NULL,0,1,3,0,'2013-04-15 14:43:27','2013-04-15 14:43:27'),(38,'女性护理','女性护理',NULL,0,1,3,0,'2013-04-15 14:43:32','2013-04-15 14:43:32'),(39,'美容瘦身','美容瘦身',NULL,0,1,3,0,'2013-04-15 14:43:39','2013-04-15 14:43:39'),(40,'足部保健','足部保健',NULL,0,1,3,0,'2013-04-15 14:43:44','2013-04-15 14:43:44'),(41,'耳塞','耳塞',NULL,0,0,28,0,'2013-04-15 14:44:12','2013-04-15 14:44:12'),(42,'眼罩','眼罩',NULL,0,1,28,0,'2013-04-15 14:44:22','2013-04-15 14:44:22'),(43,'止鼾','止鼾',NULL,0,1,28,0,'2013-04-15 14:44:27','2013-04-15 14:44:27'),(44,'失眠助眠','失眠助眠',NULL,0,1,28,0,'2013-04-15 14:44:32','2013-04-15 14:44:32'),(45,'睡枕','睡枕',NULL,0,1,28,0,'2013-04-15 14:44:48','2013-04-15 14:44:48'),(46,'其他','其他',NULL,0,1,28,0,'2013-04-15 14:44:51','2013-04-15 14:44:51'),(47,'按摩推拿','按摩推拿',NULL,0,0,29,0,'2013-04-15 14:45:11','2013-04-15 14:45:11'),(48,'通经活络','通经活络',NULL,0,0,29,0,'2013-04-15 14:45:26','2013-04-15 14:45:26'),(49,'其他','其他',NULL,0,2,29,0,'2013-04-15 15:25:07','2013-04-15 15:25:07'),(50,'制氧机','制氧机',NULL,0,0,30,0,'2013-04-15 15:51:48','2013-04-15 15:51:48'),(51,'呼吸机','呼吸机',NULL,0,0,30,0,'2013-04-15 15:51:57','2013-04-15 15:51:57'),(52,'供氧辅助','供氧辅助',NULL,0,0,30,0,'2013-04-15 15:52:09','2013-04-15 15:52:09'),(53,'雾化器','雾化器',NULL,0,0,30,0,'2013-04-15 15:52:15','2013-04-15 15:52:15'),(54,'净化器','净化器',NULL,0,0,30,0,'2013-04-15 15:52:21','2013-04-15 15:52:21'),(55,'其他','其他',NULL,0,0,30,0,'2013-04-15 15:52:26','2013-04-15 15:52:26'),(56,'针灸','针灸',NULL,0,0,31,0,'2013-04-15 15:52:40','2013-04-15 15:52:40'),(57,'把关','把关',NULL,0,0,31,0,'2013-04-15 15:52:43','2013-04-15 15:52:43'),(58,'刮痧','刮痧',NULL,0,0,31,0,'2013-04-15 15:52:48','2013-04-15 15:52:48'),(59,'砭石','砭石',NULL,0,0,31,0,'2013-04-15 15:52:51','2013-04-15 15:52:51'),(60,'艾灸','艾灸',NULL,0,0,31,0,'2013-04-15 15:52:55','2013-04-15 15:52:55'),(61,'其他','其他',NULL,0,0,31,0,'2013-04-15 15:52:58','2013-04-15 15:52:58'),(62,'电磁治疗','电磁治疗',NULL,0,0,32,0,'2013-04-15 15:53:09','2013-04-15 15:53:09'),(63,'神灯','神灯',NULL,0,0,32,0,'2013-04-15 15:53:13','2013-04-15 15:53:13'),(64,'经络经穴治疗','经络经穴治疗',NULL,0,0,32,0,'2013-04-15 15:53:27','2013-04-15 15:53:27'),(65,'红外频谱治疗','红外频谱治疗',NULL,0,0,32,0,'2013-04-15 15:53:39','2013-04-15 15:53:39'),(66,'激光微波治疗','激光微波治疗',NULL,0,0,32,0,'2013-04-15 15:53:46','2013-04-15 15:53:46'),(67,'紫外线治疗','紫外线治疗',NULL,0,5,32,0,'2013-04-15 15:53:56','2013-04-15 15:53:56'),(68,'其他','其他',NULL,0,5,32,0,'2013-04-15 15:54:03','2013-04-15 15:54:03'),(69,'胎心仪','胎心仪',NULL,0,0,33,0,'2013-04-15 15:54:14','2013-04-15 15:54:14'),(70,'胎儿用品','胎儿用品',NULL,0,0,33,0,'2013-04-15 15:54:19','2013-04-15 15:54:19'),(71,'婴幼用品','婴幼用品',NULL,0,2,33,0,'2013-04-15 15:55:10','2013-04-15 15:55:10'),(72,'少儿用品','少儿用品',NULL,0,2,33,0,'2013-04-15 15:55:16','2013-04-15 15:55:16'),(73,'青春期','青春期',NULL,0,2,33,0,'2013-04-15 15:55:21','2013-04-15 15:55:21'),(74,'其他','其他',NULL,0,2,33,0,'2013-04-15 15:55:24','2013-04-15 15:55:24'),(75,'老年通信用品','老年通信用品',NULL,0,0,34,0,'2013-04-15 15:55:47','2013-04-15 15:55:47'),(76,'保健梳','保荐书',NULL,0,0,34,0,'2013-04-15 15:55:53','2013-04-15 15:56:07'),(77,'老年首饰','老年首饰',NULL,0,2,34,0,'2013-04-15 15:56:54','2013-04-15 15:56:54'),(78,'散步音响','散步音响',NULL,0,2,34,0,'2013-04-15 15:57:02','2013-04-15 15:57:02'),(79,'提菜器','提菜器',NULL,0,2,34,0,'2013-04-15 15:57:15','2013-04-15 15:57:15'),(80,'针线','针线',NULL,0,2,34,0,'2013-04-15 15:57:20','2013-04-15 15:57:20'),(81,'阅读','阅读',NULL,0,2,34,0,'2013-04-15 15:57:24','2013-04-15 15:57:24'),(82,'烟嘴','烟嘴',NULL,0,2,34,0,'2013-04-15 15:57:28','2013-04-15 15:57:28'),(83,'其他','其他',NULL,0,2,34,0,'2013-04-15 15:57:32','2013-04-15 15:57:32'),(84,'拐杖','拐杖',NULL,0,0,35,0,'2013-04-15 15:58:20','2013-04-15 15:58:20'),(85,'轮椅','轮椅',NULL,0,0,35,0,'2013-04-15 15:58:24','2013-04-15 15:58:24'),(86,'站立架','站立架',NULL,0,0,35,0,'2013-04-15 15:58:29','2013-04-15 15:58:29'),(87,'代步爬楼','代步爬楼',NULL,0,0,35,0,'2013-04-15 15:58:40','2013-04-15 15:58:40'),(88,'治疗车','治疗车',NULL,0,0,35,0,'2013-04-15 15:58:48','2013-04-15 15:58:48'),(89,'其他','其他',NULL,0,0,35,0,'2013-04-15 15:58:51','2013-04-15 15:58:51'),(90,'益智玩具','益智玩具',NULL,0,0,36,0,'2013-04-15 15:59:05','2013-04-15 15:59:05'),(91,'健身运动','健身运动',NULL,0,1,36,0,'2013-04-15 16:01:12','2013-04-15 16:01:12'),(92,'其他','其他',NULL,0,1,36,0,'2013-04-15 16:01:16','2013-04-15 16:01:16'),(93,'前列腺','前列腺',NULL,0,0,37,0,'2013-04-15 16:01:33','2013-04-15 16:01:33'),(94,'性功能','性功能',NULL,0,0,37,0,'2013-04-15 16:01:37','2013-04-15 16:01:37'),(95,'男人用品','男人用品',NULL,0,0,37,0,'2013-04-15 16:01:43','2013-04-15 16:01:43'),(96,'其他','其他',NULL,0,0,37,0,'2013-04-15 16:01:46','2013-04-15 16:01:46'),(97,'洁阴','洁阴',NULL,0,0,38,0,'2013-04-15 16:02:05','2013-04-15 16:02:05'),(98,'经期','经期',NULL,0,0,38,0,'2013-04-15 16:02:10','2013-04-15 16:02:10'),(99,'孕期','孕期',NULL,0,0,38,0,'2013-04-15 16:02:15','2013-04-15 16:02:15'),(100,'女人用品','女人用品',NULL,0,0,38,0,'2013-04-15 16:02:20','2013-04-15 16:02:20'),(101,'其他','其他',NULL,0,0,38,0,'2013-04-15 16:02:24','2013-04-15 16:02:24'),(102,'美容嫩肤','美容嫩肤',NULL,0,0,39,0,'2013-04-15 16:03:24','2013-04-15 16:03:24'),(103,'祛疤','祛疤',NULL,0,0,39,0,'2013-04-15 16:03:29','2013-04-15 16:03:29'),(104,'减肥','减肥',NULL,0,0,39,0,'2013-04-15 16:03:34','2013-04-15 16:03:34'),(105,'美腿','美腿',NULL,0,0,39,0,'2013-04-15 16:03:38','2013-04-15 16:03:38'),(106,'其他','其他',NULL,0,0,39,0,'2013-04-15 16:03:41','2013-04-15 16:03:41'),(107,'脚气','New node',NULL,0,0,40,0,'2013-04-15 16:03:52','2013-04-15 16:04:09'),(108,'鞋垫','鞋垫',NULL,0,0,40,0,'2013-04-15 16:03:58','2013-04-15 16:03:58'),(109,'暖足护足','暖足护足',NULL,0,2,40,0,'2013-04-15 16:04:20','2013-04-15 16:04:20'),(110,'足浴足疗','足浴足疗',NULL,0,2,40,0,'2013-04-15 16:04:26','2013-04-15 16:04:26'),(111,'足部按摩','足部按摩',NULL,0,2,40,0,'2013-04-15 16:04:32','2013-04-15 16:04:32'),(112,'其他','其他',NULL,0,2,40,0,'2013-04-15 16:04:36','2013-04-15 16:04:36'),(113,'电源','电源',NULL,0,0,14,0,'2013-04-15 16:05:14','2013-04-15 16:05:14'),(114,'指甲刀','指甲刀',NULL,0,0,14,0,'2013-04-15 16:05:21','2013-04-15 16:05:21'),(115,'修脚','修脚',NULL,0,0,14,0,'2013-04-15 16:05:27','2013-04-15 16:05:27'),(116,'注射输液','注射输液',NULL,0,0,12,0,'2013-04-15 16:05:41','2013-04-15 16:05:41'),(117,'治疗床车','治疗床车',NULL,0,0,12,0,'2013-04-15 16:05:55','2013-04-15 16:05:55'),(118,'照明器具','照明器具',NULL,0,0,12,0,'2013-04-15 16:06:02','2013-04-15 16:06:02'),(119,'常用工具','常用工具',NULL,0,0,12,0,'2013-04-15 16:06:09','2013-04-15 16:06:09'),(120,'其他','其他',NULL,0,0,12,0,'2013-04-15 16:06:12','2013-04-15 16:06:12'),(121,'脂肪测量','脂肪测量',NULL,0,0,13,0,'2013-04-15 16:07:20','2013-04-15 16:07:20'),(122,'听诊器','听诊器',NULL,0,0,13,0,'2013-04-15 16:07:25','2013-04-15 16:07:25'),(123,'体重秤','体重秤',NULL,0,0,13,0,'2013-04-15 16:07:31','2013-04-15 16:07:31'),(124,'计步器','计步器',NULL,0,0,13,0,'2013-04-15 16:07:36','2013-04-15 16:07:36'),(125,'诊断盒','诊断盒',NULL,0,0,13,0,'2013-04-15 16:07:41','2013-04-15 16:07:41'),(126,'卡路里计','卡路里及',NULL,0,0,13,0,'2013-04-15 16:07:46','2013-04-15 16:08:13'),(127,'其他','其他',NULL,0,6,13,0,'2013-04-15 16:08:17','2013-04-15 16:08:17'),(128,'湿巾纸巾','湿巾纸巾',NULL,0,0,8,0,'2013-04-15 16:08:41','2013-04-15 16:08:41'),(129,'消毒清洁','消毒清洁',NULL,0,0,8,0,'2013-04-15 16:08:48','2013-04-15 16:08:48'),(130,'驱蚊杀虫','驱蚊杀虫',NULL,0,0,8,0,'2013-04-15 16:08:56','2013-04-15 16:08:56'),(131,'衣帽口罩','衣帽口罩',NULL,0,0,8,0,'2013-04-15 16:09:06','2013-04-15 16:09:06'),(132,'其他','其他',NULL,0,0,8,0,'2013-04-15 16:09:11','2013-04-15 16:09:11'),(133,'药箱','药箱',NULL,0,0,9,0,'2013-04-15 16:09:25','2013-04-15 16:09:25'),(134,'广口瓶','广口瓶',NULL,0,0,9,0,'2013-04-15 16:09:32','2013-04-15 16:09:32'),(135,'药盒','药盒',NULL,0,0,9,0,'2013-04-15 16:09:41','2013-04-15 16:09:41'),(136,'煎药','煎药',NULL,0,0,9,0,'2013-04-15 16:09:46','2013-04-15 16:09:46'),(137,'其他','其他',NULL,0,0,9,0,'2013-04-15 16:09:50','2013-04-15 16:09:50'),(138,'晕车','晕车',NULL,0,0,10,0,'2013-04-15 16:10:03','2013-04-15 16:10:03'),(139,'晕船','晕船',NULL,0,0,10,0,'2013-04-15 16:10:07','2013-04-15 16:10:07'),(140,'晕机','晕机',NULL,0,0,10,0,'2013-04-15 16:10:11','2013-04-15 16:10:11'),(141,'其他','其他',NULL,0,0,10,0,'2013-04-15 16:10:16','2013-04-15 16:10:16'),(142,'温度计','温度计',NULL,0,0,11,0,'2013-04-15 16:10:29','2013-04-15 16:10:29'),(143,'退热冷敷','退热冷敷',NULL,0,0,11,0,'2013-04-15 16:10:36','2013-04-15 16:10:36'),(144,'加热热敷','加热热敷',NULL,0,0,11,0,'2013-04-15 16:10:42','2013-04-15 16:10:42'),(145,'其他','其他',NULL,0,0,11,0,'2013-04-15 16:10:46','2013-04-15 16:10:46'),(146,'漱口','漱口',NULL,0,0,7,0,'2013-04-15 16:11:12','2013-04-15 16:11:12'),(147,'牙齿清洁','牙齿清洁',NULL,0,0,7,0,'2013-04-15 16:11:21','2013-04-15 16:11:21'),(148,'口腔溃疡','口腔溃疡',NULL,0,0,7,0,'2013-04-15 16:11:27','2013-04-15 16:11:27'),(149,'唇舌','唇舌',NULL,0,0,7,0,'2013-04-15 16:11:32','2013-04-15 16:11:32'),(150,'牙痛','牙痛',NULL,0,0,7,0,'2013-04-15 16:11:38','2013-04-15 16:11:38'),(151,'假牙','假牙',NULL,0,0,7,0,'2013-04-15 16:11:43','2013-04-15 16:11:43'),(152,'戒烟','戒烟',NULL,0,0,7,0,'2013-04-15 16:11:47','2013-04-15 16:11:47'),(153,'其他','其他',NULL,0,0,7,0,'2013-04-15 16:11:51','2013-04-15 16:11:51'),(154,'急救止血','急救止血',NULL,0,0,6,0,'2013-04-15 16:12:10','2013-04-15 16:12:10'),(155,'创可贴','创可贴',NULL,0,0,6,0,'2013-04-15 16:12:18','2013-04-15 16:12:18'),(156,'痛可贴','痛可贴',NULL,0,0,6,0,'2013-04-15 16:12:24','2013-04-15 16:12:24'),(157,'创疡贴','溃疡贴',NULL,0,0,6,0,'2013-04-15 16:12:28','2013-04-15 16:12:55'),(158,'包扎敷料','包扎敷料',NULL,0,4,6,0,'2013-04-15 16:13:05','2013-04-15 16:13:05'),(159,'其他','其他',NULL,0,4,6,0,'2013-04-15 16:13:09','2013-04-15 16:13:09'),(160,'血糖仪','血糖仪',NULL,0,0,21,0,'2013-04-15 16:13:39','2013-04-15 16:13:39'),(161,'血糖试纸','血糖试纸',NULL,0,0,21,0,'2013-04-15 16:13:47','2013-04-15 16:13:47'),(162,'尿糖试纸','尿糖试纸',NULL,0,0,21,0,'2013-04-15 16:13:54','2013-04-15 16:13:54'),(163,'胰岛素','胰岛素',NULL,0,0,21,0,'2013-04-15 16:13:59','2013-04-15 16:13:59'),(164,'葡萄糖','葡萄糖',NULL,0,0,21,0,'2013-04-15 16:14:03','2013-04-15 16:14:03'),(165,'注射用具','注射用具',NULL,0,0,21,0,'2013-04-15 16:14:10','2013-04-15 16:14:10'),(166,'胆固醇','胆固醇',NULL,0,0,21,0,'2013-04-15 16:14:19','2013-04-15 16:14:19'),(167,'其他','其他',NULL,0,0,21,0,'2013-04-15 16:14:23','2013-04-15 16:14:23'),(168,'保健枕','保健枕',NULL,0,0,22,0,'2013-04-15 16:14:37','2013-04-15 16:14:37'),(169,'颈椎护具','颈椎护具',NULL,0,0,22,0,'2013-04-15 16:14:43','2013-04-15 16:14:43'),(170,'灸贴贴膏(product:0,shop:0.item:0)','灸贴贴膏',NULL,0,0,22,0,'2013-04-15 16:14:59','2013-04-15 16:15:19'),(171,'按摩器具','按摩器具',NULL,0,3,22,0,'2013-04-15 16:15:27','2013-04-15 16:15:27'),(172,'其他','其他',NULL,0,3,22,0,'2013-04-15 16:15:31','2013-04-15 16:15:31'),(173,'护肩','护肩',NULL,0,0,23,0,'2013-04-15 16:16:04','2013-04-15 16:16:04'),(174,'护腕','护腕',NULL,0,0,23,0,'2013-04-15 16:16:09','2013-04-15 16:16:09'),(175,'护肘','护肘',NULL,0,0,23,0,'2013-04-15 16:16:13','2013-04-15 16:16:13'),(176,'护掌','护掌',NULL,0,0,23,0,'2013-04-15 16:16:19','2013-04-15 16:16:19'),(177,'护臂','护臂',NULL,0,0,23,0,'2013-04-15 16:16:25','2013-04-15 16:16:25'),(178,'灸贴贴膏','灸贴贴膏】',NULL,0,0,23,0,'2013-04-15 16:16:29','2013-04-15 16:16:37'),(179,'其他','其他',NULL,0,6,23,0,'2013-04-15 16:16:41','2013-04-15 16:16:41'),(180,'护腰','护腰',NULL,0,0,24,0,'2013-04-15 16:16:53','2013-04-15 16:16:53'),(181,'护髋','护髋',NULL,0,0,24,0,'2013-04-15 16:17:01','2013-04-15 16:17:01'),(182,'护胃','护胃',NULL,0,0,24,0,'2013-04-15 16:17:08','2013-04-15 16:17:08'),(183,'疝气带','疝气带',NULL,0,0,24,0,'2013-04-15 16:17:13','2013-04-15 16:17:13'),(184,'灸贴贴膏','灸贴贴膏',NULL,0,0,24,0,'2013-04-15 16:17:17','2013-04-15 16:17:17'),(185,'其他','其他',NULL,0,0,24,0,'2013-04-15 16:17:24','2013-04-15 16:17:24'),(186,'护踝','护踝',NULL,0,0,25,0,'2013-04-15 16:17:34','2013-04-15 16:17:34'),(187,'护腿','护腿',NULL,0,0,25,0,'2013-04-15 16:17:38','2013-04-15 16:17:38'),(188,'护膝','护膝',NULL,0,0,25,0,'2013-04-15 16:17:43','2013-04-15 16:17:43'),(189,'特制袜','特质袜',NULL,0,0,25,0,'2013-04-15 16:17:50','2013-04-15 16:18:09'),(190,'灸贴贴膏','灸贴贴膏',NULL,0,4,25,0,'2013-04-15 16:18:19','2013-04-15 16:18:19'),(191,'步行训练','步行训练',NULL,0,4,25,0,'2013-04-15 16:18:26','2013-04-15 16:18:26'),(192,'其他','其他',NULL,0,4,25,0,'2013-04-15 16:18:30','2013-04-15 16:18:30'),(193,'痔疮','痔疮',NULL,0,0,26,0,'2013-04-15 16:18:47','2013-04-15 16:18:47'),(194,'便秘','便秘',NULL,0,0,26,0,'2013-04-15 16:18:51','2013-04-15 16:18:51'),(195,'肛肠清洁','肛肠清洁',NULL,0,0,26,0,'2013-04-15 16:18:56','2013-04-15 16:18:56'),(196,'其他','其他',NULL,0,0,26,0,'2013-04-15 16:19:00','2013-04-15 16:19:00'),(197,'止痛灸贴','止痛灸贴',NULL,0,0,27,0,'2013-04-15 16:19:23','2013-04-15 16:19:23'),(198,'跌打损伤贴','跌打损伤贴',NULL,0,0,27,0,'2013-04-15 16:19:31','2013-04-15 16:19:31'),(199,'咳喘灸贴','咳喘灸贴贴膏',NULL,0,0,27,0,'2013-04-15 16:19:37','2013-04-15 16:19:53'),(200,'止泻灸贴','止泻灸贴',NULL,0,3,27,0,'2013-04-15 16:20:25','2013-04-15 16:20:25'),(201,'风湿灸贴','风湿灸贴',NULL,0,3,27,0,'2013-04-15 16:20:32','2013-04-15 16:20:32'),(202,'突出灸贴','突出灸贴',NULL,0,3,27,0,'2013-04-15 16:20:37','2013-04-15 16:20:37'),(203,'增生灸贴','增生灸贴',NULL,0,3,27,0,'2013-04-15 16:20:42','2013-04-15 16:20:42'),(204,'关节灸贴','关节灸贴',NULL,0,3,27,0,'2013-04-15 16:20:48','2013-04-15 16:20:48'),(205,'保健灸贴','保健灸贴',NULL,0,3,27,0,'2013-04-15 16:20:52','2013-04-15 16:20:52'),(206,'其他','其他',NULL,0,3,27,0,'2013-04-15 16:20:55','2013-04-15 16:20:55'),(207,'鼻塞','鼻塞',NULL,0,0,18,0,'2013-04-15 16:21:13','2013-04-15 16:21:13'),(208,'鼻炎','鼻炎',NULL,0,0,18,0,'2013-04-15 16:21:17','2013-04-15 16:21:17'),(209,'鼻腔清洗','鼻腔清洗',NULL,0,0,18,0,'2013-04-15 16:21:26','2013-04-15 16:21:26'),(210,'鼻鼾','鼻鼾',NULL,0,0,18,0,'2013-04-15 16:21:47','2013-04-15 16:21:47'),(211,'其他','其他',NULL,0,0,18,0,'2013-04-15 16:21:50','2013-04-15 16:21:50'),(212,'大小便','大小便',NULL,0,0,19,0,'2013-04-15 16:22:06','2013-04-15 16:22:06'),(213,'床垫坐垫','床垫坐垫',NULL,0,0,19,0,'2013-04-15 16:22:20','2013-04-15 16:22:20'),(214,'上肢康复','上肢康复',NULL,0,0,19,0,'2013-04-15 16:22:29','2013-04-15 16:22:29'),(215,'下肢康复','下肢康复',NULL,0,0,19,0,'2013-04-15 16:22:37','2013-04-15 16:22:37'),(216,'护理床椅','护理床椅',NULL,0,0,19,0,'2013-04-15 16:22:51','2013-04-15 16:22:51'),(217,'洗浴用具','洗浴用具',NULL,0,0,19,0,'2013-04-15 16:23:04','2013-04-15 16:23:04'),(218,'呼救装备','呼救装备',NULL,0,0,19,0,'2013-04-15 16:23:11','2013-04-15 16:23:11'),(219,'其他','其他',NULL,0,0,19,0,'2013-04-15 16:23:15','2013-04-15 16:23:15'),(220,'血压计','血压计',NULL,0,0,20,0,'2013-04-15 16:23:27','2013-04-15 16:23:27'),(221,'血氧仪','血氧仪',NULL,0,0,20,0,'2013-04-15 16:23:32','2013-04-15 16:23:32'),(222,'强心卡','强心卡',NULL,0,0,20,0,'2013-04-15 16:23:37','2013-04-15 16:23:37'),(223,'血压调节','血压调节',NULL,0,0,20,0,'2013-04-15 16:23:42','2013-04-15 16:23:42'),(224,'脉搏计','脉搏计',NULL,0,0,20,0,'2013-04-15 16:23:47','2013-04-15 16:23:47'),(225,'心电仪','心电仪',NULL,0,0,20,0,'2013-04-15 16:23:58','2013-04-15 16:23:58'),(226,'心率仪','心率仪',NULL,0,0,20,0,'2013-04-15 16:24:05','2013-04-15 16:24:05'),(227,'其他','其他',NULL,0,0,20,0,'2013-04-15 16:24:13','2013-04-15 16:24:13'),(228,'助听器','助听器',NULL,0,0,15,0,'2013-04-15 16:24:29','2013-04-15 16:24:29'),(229,'干燥器','干燥器',NULL,0,0,15,0,'2013-04-15 16:24:33','2013-04-15 16:24:33'),(230,'声音放大器','声音放大器',NULL,0,0,15,0,'2013-04-15 16:24:40','2013-04-15 16:24:40'),(231,'耳腔清洗','耳腔清洗',NULL,0,3,15,0,'2013-04-15 16:25:28','2013-04-15 16:25:28'),(232,'其他','其他',NULL,0,3,15,0,'2013-04-15 16:25:32','2013-04-15 16:25:32'),(233,'浸泡剂','浸泡剂',NULL,0,0,16,0,'2013-04-15 16:26:14','2013-04-15 16:26:14'),(234,'白癜风','白癜风',NULL,0,0,16,0,'2013-04-15 16:26:20','2013-04-15 16:26:20'),(235,'灰指甲','灰指甲',NULL,0,0,16,0,'2013-04-15 16:26:27','2013-04-15 16:26:27'),(236,'狐臭','狐臭',NULL,0,0,16,0,'2013-04-15 16:26:32','2013-04-15 16:26:32'),(237,'疮廯鸡眼','疮廯鸡眼',NULL,0,0,16,0,'2013-04-15 16:26:42','2013-04-15 16:26:42'),(238,'过敏瘙痒','过敏瘙痒',NULL,0,0,16,0,'2013-04-15 16:26:52','2013-04-15 16:26:52'),(239,'其他','其他',NULL,0,0,16,0,'2013-04-15 16:26:55','2013-04-15 16:26:55'),(240,'近视','近视',NULL,0,0,17,0,'2013-04-15 16:27:12','2013-04-15 16:27:12'),(241,'弱视','弱视',NULL,0,0,17,0,'2013-04-15 16:27:16','2013-04-15 16:27:16'),(242,'散光','散光',NULL,0,0,17,0,'2013-04-15 16:27:23','2013-04-15 16:27:23'),(243,'色盲','色盲',NULL,0,0,17,0,'2013-04-15 16:27:29','2013-04-15 16:27:29'),(244,'白内障','白内障',NULL,0,0,17,0,'2013-04-15 16:27:38','2013-04-15 16:27:38'),(245,'护眼舒眼','护眼舒眼',NULL,0,0,17,0,'2013-04-15 16:27:57','2013-04-15 16:27:57'),(246,'其他','其他',NULL,0,0,17,0,'2013-04-15 16:28:04','2013-04-15 16:28:04');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_ass`
--

DROP TABLE IF EXISTS `category_ass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_ass` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `out_category_id` bigint(22) DEFAULT NULL,
  `out_category_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `platform` int(11) NOT NULL,
  `shop_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `inner_category_id` bigint(22) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `inner_category_id_category` (`inner_category_id`),
  CONSTRAINT `inner_category_id_category` FOREIGN KEY (`inner_category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_ass`
--

LOCK TABLES `category_ass` WRITE;
/*!40000 ALTER TABLE `category_ass` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_ass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `publisher` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `score` double DEFAULT NULL,
  `content` varchar(2048) COLLATE utf8_bin NOT NULL,
  `type` int(11) NOT NULL,
  `owner` bigint(22) NOT NULL,
  `publish_time` datetime NOT NULL,
  `is_buy` tinyint(4) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `comment_owner_type_index` (`owner`,`type`)
) ENGINE=InnoDB AUTO_INCREMENT=64208 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `price` double NOT NULL,
  `detail_url` varchar(1024) COLLATE utf8_bin NOT NULL,
  `logo_url` varchar(1024) COLLATE utf8_bin NOT NULL,
  `category` bigint(22) DEFAULT NULL,
  `location` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `number` bigint(22) DEFAULT NULL,
  `stuff_status` smallint(6) NOT NULL,
  `freight_fee_payer` smallint(6) NOT NULL,
  `post_fee` double DEFAULT NULL,
  `express_fee` double DEFAULT NULL,
  `ems_fee` double DEFAULT NULL,
  `has_discount` tinyint(4) DEFAULT NULL,
  `has_invoice` tinyint(4) DEFAULT NULL,
  `has_warranty` tinyint(4) DEFAULT NULL,
  `is_second_kill` tinyint(4) DEFAULT NULL,
  `is_sell_promise` tinyint(4) DEFAULT NULL,
  `is_xinpin` tinyint(4) DEFAULT NULL,
  `item_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `platform` int(11) NOT NULL,
  `shop` bigint(22) NOT NULL,
  `status` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `sale_count` bigint(22) DEFAULT NULL,
  `gifts` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `product` bigint(22) DEFAULT NULL,
  `five_start_count` bigint(22) DEFAULT NULL,
  `four_start_count` bigint(22) DEFAULT NULL,
  `second_start_count` bigint(22) DEFAULT NULL,
  `one_start_count` bigint(22) DEFAULT NULL,
  `three_start_count` bigint(22) DEFAULT NULL,
  `brand` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_category` (`category`),
  KEY `item_shop` (`shop`),
  CONSTRAINT `item_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `item_shop` FOREIGN KEY (`shop`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144822 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_trace_log`
--

DROP TABLE IF EXISTS `item_trace_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_trace_log` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(22) NOT NULL,
  `user_id` bigint(22) DEFAULT NULL,
  `user_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `remote_ip` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `item_id` bigint(22) DEFAULT NULL,
  `item_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `item_price` double DEFAULT NULL,
  `shop_id` bigint(22) DEFAULT NULL,
  `shop_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `platform` int(11) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_trace_log`
--

LOCK TABLES `item_trace_log` WRITE;
/*!40000 ALTER TABLE `item_trace_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_trace_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matrix_sequence`
--

DROP TABLE IF EXISTS `matrix_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matrix_sequence` (
  `sequence_name` varchar(32) COLLATE utf8_bin NOT NULL,
  `sequence_value` bigint(22) NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matrix_sequence`
--

LOCK TABLES `matrix_sequence` WRITE;
/*!40000 ALTER TABLE `matrix_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `matrix_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) COLLATE utf8_bin NOT NULL,
  `url` varchar(1024) COLLATE utf8_bin NOT NULL,
  `type` int(11) NOT NULL,
  `owner` bigint(22) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`,`owner`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `logo_url` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `brand` bigint(22) DEFAULT NULL,
  `category` bigint(22) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_category` (`category`),
  KEY `product_brand` (`brand`),
  CONSTRAINT `product_brand` FOREIGN KEY (`brand`) REFERENCES `brand` (`id`),
  CONSTRAINT `product_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion_activity`
--

DROP TABLE IF EXISTS `promotion_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion_activity` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `logo_url` varchar(1204) COLLATE utf8_bin NOT NULL,
  `url` varchar(1024) COLLATE utf8_bin NOT NULL,
  `rank` bigint(20) DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `shop` bigint(22) NOT NULL,
  `category` bigint(22) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `promotion_activity_shop` (`shop`),
  KEY `promotion_activity_category` (`category`),
  CONSTRAINT `promotion_activity_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `promotion_activity_shop` FOREIGN KEY (`shop`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion_activity`
--

LOCK TABLES `promotion_activity` WRITE;
/*!40000 ALTER TABLE `promotion_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotion_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `key` varchar(128) COLLATE utf8_bin NOT NULL,
  `value` varchar(1024) COLLATE utf8_bin NOT NULL,
  `value_type` int(11) NOT NULL,
  `group` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `owner` bigint(22) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`,`owner`,`group`,`key`),
  KEY `property_group` (`group`),
  CONSTRAINT `property_group` FOREIGN KEY (`group`) REFERENCES `property_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property_group`
--

DROP TABLE IF EXISTS `property_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property_group` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `type` int(11) NOT NULL,
  `owner` bigint(22) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`,`owner`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property_group`
--

LOCK TABLES `property_group` WRITE;
/*!40000 ALTER TABLE `property_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `property_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `shop_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `platform` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `seller_name` varchar(128) COLLATE utf8_bin NOT NULL,
  `description` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `bulletin` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `logo_url` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `detail_url` varchar(1024) COLLATE utf8_bin NOT NULL,
  `category` bigint(22) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `shop_score` bigint(22) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `is_recommend` tinyint(4) NOT NULL,
  `rank` bigint(22) NOT NULL,
  `payways` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `distribute_ways` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13836 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_category`
--

DROP TABLE IF EXISTS `shop_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_category` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `shop` bigint(22) NOT NULL,
  `category` bigint(22) NOT NULL,
  `rank` bigint(22) NOT NULL,
  `status` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `shop` (`shop`,`category`),
  KEY `shop_category_category` (`category`),
  CONSTRAINT `shop_category_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `shop_category_shop` FOREIGN KEY (`shop`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_category`
--

LOCK TABLES `shop_category` WRITE;
/*!40000 ALTER TABLE `shop_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_product`
--

DROP TABLE IF EXISTS `shop_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_product` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `shop` bigint(22) NOT NULL,
  `product` bigint(22) NOT NULL,
  `rank` bigint(22) NOT NULL,
  `status` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `shop` (`shop`,`product`),
  KEY `product` (`product`),
  CONSTRAINT `product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `shop` FOREIGN KEY (`shop`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_product`
--

LOCK TABLES `shop_product` WRITE;
/*!40000 ALTER TABLE `shop_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_score`
--

DROP TABLE IF EXISTS `shop_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_score` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `shop` bigint(22) NOT NULL,
  `item_score` int(11) DEFAULT NULL,
  `service_score` int(11) DEFAULT NULL,
  `delivery_score` int(11) DEFAULT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shop_score_shop` (`shop`),
  CONSTRAINT `shop_score_shop` FOREIGN KEY (`shop`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_score`
--

LOCK TABLES `shop_score` WRITE;
/*!40000 ALTER TABLE `shop_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_trace_log`
--

DROP TABLE IF EXISTS `shop_trace_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop_trace_log` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(22) NOT NULL,
  `user_id` bigint(22) DEFAULT NULL,
  `user_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `remote_ip` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `shop_id` bigint(22) DEFAULT NULL,
  `shop_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `platform` int(11) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_trace_log`
--

LOCK TABLES `shop_trace_log` WRITE;
/*!40000 ALTER TABLE `shop_trace_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_trace_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trace_log`
--

DROP TABLE IF EXISTS `trace_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trace_log` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(22) NOT NULL,
  `user_id` bigint(22) DEFAULT NULL,
  `user_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `remote_ip` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `referer_url` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `click_url` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `item_id` bigint(22) DEFAULT NULL,
  `shop_id` bigint(22) DEFAULT NULL,
  `web_site_id` bigint(22) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=488 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trace_log`
--

LOCK TABLES `trace_log` WRITE;
/*!40000 ALTER TABLE `trace_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `trace_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `email` varchar(64) COLLATE utf8_bin NOT NULL,
  `password` varchar(64) COLLATE utf8_bin NOT NULL,
  `logo_url` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) NOT NULL,
  `from` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_site`
--

DROP TABLE IF EXISTS `web_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `web_site` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `site_url` varchar(1204) COLLATE utf8_bin NOT NULL,
  `logo` varchar(1024) COLLATE utf8_bin NOT NULL,
  `type` int(11) NOT NULL,
  `rank` bigint(20) DEFAULT NULL,
  `view_count` bigint(20) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_site`
--

LOCK TABLES `web_site` WRITE;
/*!40000 ALTER TABLE `web_site` DISABLE KEYS */;
/*!40000 ALTER TABLE `web_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_site_trace_log`
--

DROP TABLE IF EXISTS `web_site_trace_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `web_site_trace_log` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `uuid` bigint(22) NOT NULL,
  `user_id` bigint(22) DEFAULT NULL,
  `user_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `remote_ip` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `web_site_id` bigint(22) DEFAULT NULL,
  `web_site_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_site_trace_log`
--

LOCK TABLES `web_site_trace_log` WRITE;
/*!40000 ALTER TABLE `web_site_trace_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `web_site_trace_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-15 17:55:25
