/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.20-log : Database - wego_data
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wego_data` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wego_data`;

/*Table structure for table `payacct` */

CREATE TABLE `payacct` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `acct` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT '0' COMMENT '支付类型 0支付宝；1微信；2银行卡',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `payacct` */

/*Table structure for table `user_info` */

CREATE TABLE `user_info` (
  `uId` int(32) NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `headImage` varchar(80) DEFAULT NULL COMMENT '头像图片地址',
  `authenticated` int(8) DEFAULT '0' COMMENT '是否认证 0，未认证；1，已认证',
  `usertoken` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`uId`,`name`,`headImage`,`authenticated`,`usertoken`,`password`) values 
(1,'Tom','1231231',454545,'456465dd','123456'),
(2,'Tom','1231231',454545,'456465dd','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
