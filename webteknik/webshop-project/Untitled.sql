CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `Cart`
--

DROP TABLE IF EXISTS `Cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ih3l5x8jwr7lhtp37muvvrjm4` (`user_userid`),
  CONSTRAINT `FK_ih3l5x8jwr7lhtp37muvvrjm4` FOREIGN KEY (`user_userid`) REFERENCES `User` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cart`
--

LOCK TABLES `Cart` WRITE;
/*!40000 ALTER TABLE `Cart` DISABLE KEYS */;
INSERT INTO `Cart` VALUES (10,1),(5,2),(8,3);
/*!40000 ALTER TABLE `Cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (1,'Women'),(2,'Kids'),(3,'Clothes'),(4,'Men'),(5,'Book'),(6,'Film'),(7,'Sport');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `dateOrder` datetime DEFAULT NULL,
  `user_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `FK_fxhlxmopey41x3njxt2x9osph` (`user_userid`),
  CONSTRAINT `FK_fxhlxmopey41x3njxt2x9osph` FOREIGN KEY (`user_userid`) REFERENCES `User` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
INSERT INTO `Orders` VALUES (1,'2014-04-08 00:00:00',1),(2,'2014-04-01 00:00:00',1),(3,'2014-04-08 00:00:00',2),(4,'2014-04-08 00:00:00',3),(5,'2014-04-08 00:00:00',3),(6,'2014-04-01 00:00:00',1),(7,'2014-04-08 00:00:00',1);
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (1,'Blouse',300,1000),(2,'T-Shirt',300,500),(3,'Panty',100,400),(4,'Jeans',500,100),(5,'Short',200,10),(6,'Short-baby',200,300),(7,'T-Shirt Baby',200,100),(8,'Blouse baby',120,123),(9,'Short baby old',234,23);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProductQuantity`
--

DROP TABLE IF EXISTS `ProductQuantity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProductQuantity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qty` int(11) NOT NULL,
  `cart_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dq8soibje4b9dcpgamh3e5slh` (`cart_id`),
  KEY `FK_mspsv10skhibe7p8u89tb80j4` (`product_id`),
  CONSTRAINT `FK_dq8soibje4b9dcpgamh3e5slh` FOREIGN KEY (`cart_id`) REFERENCES `Cart` (`id`),
  CONSTRAINT `FK_mspsv10skhibe7p8u89tb80j4` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProductQuantity`
--

LOCK TABLES `ProductQuantity` WRITE;
/*!40000 ALTER TABLE `ProductQuantity` DISABLE KEYS */;
INSERT INTO `ProductQuantity` VALUES (8,34,5,1),(9,5,5,3),(13,29,8,1),(15,2,8,4),(20,7,10,3),(21,5,10,4);
/*!40000 ALTER TABLE `ProductQuantity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product_Category`
--

DROP TABLE IF EXISTS `Product_Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product_Category` (
  `products_id` int(11) NOT NULL,
  `categories_id` int(11) NOT NULL,
  KEY `FK_ra5s97oj9k024yvdmuwk15wa3` (`categories_id`),
  KEY `FK_r6rmk1pm27hxcln5b3hkmmsoe` (`products_id`),
  CONSTRAINT `FK_r6rmk1pm27hxcln5b3hkmmsoe` FOREIGN KEY (`products_id`) REFERENCES `Product` (`id`),
  CONSTRAINT `FK_ra5s97oj9k024yvdmuwk15wa3` FOREIGN KEY (`categories_id`) REFERENCES `Category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product_Category`
--

LOCK TABLES `Product_Category` WRITE;
/*!40000 ALTER TABLE `Product_Category` DISABLE KEYS */;
INSERT INTO `Product_Category` VALUES (1,1),(1,2),(1,3),(2,1),(2,3),(3,1),(4,1),(4,3),(5,3),(5,4),(6,2),(6,3),(7,2),(7,3),(8,2),(8,3),(9,2),(9,3);
/*!40000 ALTER TABLE `Product_Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProductsInOrder`
--

DROP TABLE IF EXISTS `ProductsInOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProductsInOrder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qty` int(11) NOT NULL,
  `order_orderId` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6kv0n718iof6s9cf8c0ql09v1` (`order_orderId`),
  KEY `FK_gf016re1q70ynm5fx4c65s5y7` (`product_id`),
  CONSTRAINT `FK_6kv0n718iof6s9cf8c0ql09v1` FOREIGN KEY (`order_orderId`) REFERENCES `Orders` (`orderId`),
  CONSTRAINT `FK_gf016re1q70ynm5fx4c65s5y7` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProductsInOrder`
--

LOCK TABLES `ProductsInOrder` WRITE;
/*!40000 ALTER TABLE `ProductsInOrder` DISABLE KEYS */;
INSERT INTO `ProductsInOrder` VALUES (1,30,1,1),(2,20,1,3),(3,1,1,4),(4,1,2,4),(5,20,3,3),(6,2,3,2),(7,20,4,6),(8,5,4,7),(9,20,5,1),(10,2,6,1),(11,23,6,8),(12,67,7,3),(13,50,7,1);
/*!40000 ALTER TABLE `ProductsInOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `stId` int(11) NOT NULL,
  PRIMARY KEY (`stId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL,
  `street_adress` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'liliana@hotmail.com','Liliana',NULL,'liliana',NULL,NULL,'Santiesteban',NULL),(2,'tati@hotmail.com','Tati',NULL,'tati',NULL,NULL,'Beltran',NULL),(3,'petri@hotmail.com','Petri',NULL,'petri',NULL,NULL,'Barrientos',NULL),(4,'raul@hotmail.com','Raul',NULL,'raul',NULL,NULL,'Cruz',NULL),(5,'maria@hotmail.com','Maria',NULL,'maria',NULL,NULL,'Barrientos',NULL),(6,'tomas@hotmail.com','Tomas',NULL,'tomas',NULL,NULL,'Santiesteban',NULL),(9,'admon@hotmail.com','admon',NULL,'admon',NULL,NULL,'admon',NULL),(10,'ramon@hotmail.com','Ramon',NULL,'ramon',NULL,NULL,'Santiesteban',NULL);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-09 13:16:31
