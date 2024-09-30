# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 11.5.2-MariaDB-ubu2404)
# Database: how_s_the_restroom
# Generation Time: 2024-09-30 13:02:34 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table comment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comment_code` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `board_code` int(11) NOT NULL,
  `restroom_pwd` varchar(200) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `ins_dt` date DEFAULT NULL,
  PRIMARY KEY (`comment_code`,`user_id`,`board_code`),
  KEY `FK_user_TO_comment_1` (`user_id`),
  KEY `FK_restroom_TO_comment_1` (`board_code`),
  CONSTRAINT `FK_restroom_TO_comment_1` FOREIGN KEY (`board_code`) REFERENCES `restroom` (`code`),
  CONSTRAINT `FK_user_TO_comment_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;



# Dump of table main_category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `main_category`;

CREATE TABLE `main_category` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

LOCK TABLES `main_category` WRITE;
/*!40000 ALTER TABLE `main_category` DISABLE KEYS */;

INSERT INTO `main_category` (`code`, `name`)
VALUES
	(1,'공중화장실표준데이터'),
	(2,'프랜차이즈'),
	(3,'수기입력');

/*!40000 ALTER TABLE `main_category` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table restroom
# ------------------------------------------------------------

DROP TABLE IF EXISTS `restroom`;

CREATE TABLE `restroom` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `sub_category_code` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `adress` varchar(200) DEFAULT NULL,
  `start_time` varchar(200) DEFAULT NULL,
  `end_time` varchar(200) DEFAULT NULL,
  `unisex_yn` varchar(10) DEFAULT NULL COMMENT 'Y: 공용\nN: 각각',
  `public_yn` varchar(10) DEFAULT NULL COMMENT 'Y: 공용\nN: 개인',
  `restroom_pwd` varchar(200) DEFAULT NULL,
  `rmk` varchar(2000) DEFAULT NULL,
  `ins_dt` date DEFAULT NULL,
  PRIMARY KEY (`code`,`sub_category_code`),
  KEY `FK_sub_category_TO_restroom_1` (`sub_category_code`),
  CONSTRAINT `FK_sub_category_TO_restroom_1` FOREIGN KEY (`sub_category_code`) REFERENCES `sub_category` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;



# Dump of table sub_category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sub_category`;

CREATE TABLE `sub_category` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `main_category_code` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`code`,`main_category_code`),
  KEY `FK_main_category_TO_sub_category_1` (`main_category_code`),
  CONSTRAINT `FK_main_category_TO_sub_category_1` FOREIGN KEY (`main_category_code`) REFERENCES `main_category` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;

INSERT INTO `sub_category` (`code`, `main_category_code`, `name`)
VALUES
	(1,1,'서울'),
	(2,1,'부산'),
	(3,1,'대구'),
	(4,1,'인천'),
	(5,1,'광주'),
	(6,1,'대전'),
	(7,1,'울산'),
	(8,1,'세종'),
	(9,1,'경기도'),
	(10,1,'강원도'),
	(11,1,'충청북도'),
	(12,1,'충청남도'),
	(13,1,'전라북도'),
	(14,1,'전라남도'),
	(15,1,'경상북도'),
	(16,1,'경상남도'),
	(17,1,'제주도'),
	(18,2,'스타벅스'),
	(19,3,'기타');

/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `pwd` varchar(100) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
