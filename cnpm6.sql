CREATE DATABASE  IF NOT EXISTS `cnpm` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cnpm`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cnpm
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblbill`
--

DROP TABLE IF EXISTS `tblbill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblbill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` float DEFAULT NULL,
  `paymentType` varchar(45) DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `tblContract_id` int(11) NOT NULL,
  `tblStaff_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`tblContract_id`,`tblStaff_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tblBill_tblContract1_idx` (`tblContract_id`),
  KEY `fk_tblBill_tblStaff1_idx` (`tblStaff_id`),
  CONSTRAINT `fk_tblBill_tblContract1` FOREIGN KEY (`tblContract_id`) REFERENCES `tblcontract` (`id`),
  CONSTRAINT `fk_tblBill_tblStaff1` FOREIGN KEY (`tblStaff_id`) REFERENCES `tblstaff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbill`
--

LOCK TABLES `tblbill` WRITE;
/*!40000 ALTER TABLE `tblbill` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblbill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbookedcar`
--

DROP TABLE IF EXISTS `tblbookedcar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblbookedcar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receivedDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `totalprice` float DEFAULT NULL,
  `penAmount` float DEFAULT NULL,
  `tblCar_id` int(11) NOT NULL,
  `tblContract_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`tblCar_id`,`tblContract_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tblBookedCar_tblCar1_idx` (`tblCar_id`),
  KEY `fk_tblBookedCar_tblContract1_idx` (`tblContract_id`),
  CONSTRAINT `fk_tblBookedCar_tblCar1` FOREIGN KEY (`tblCar_id`) REFERENCES `tblcar` (`id`),
  CONSTRAINT `fk_tblBookedCar_tblContract1` FOREIGN KEY (`tblContract_id`) REFERENCES `tblcontract` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbookedcar`
--

LOCK TABLES `tblbookedcar` WRITE;
/*!40000 ALTER TABLE `tblbookedcar` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblbookedcar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcar`
--

DROP TABLE IF EXISTS `tblcar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `desc` varchar(45) DEFAULT NULL,
  `reg_plate` varchar(9) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `tblCarType_id` int(11) NOT NULL,
  `tblCarClassification_id` int(11) NOT NULL,
  `tblStore_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`tblCarType_id`,`tblCarClassification_id`,`tblStore_id`),
  UNIQUE KEY `reg_plate_UNIQUE` (`reg_plate`),
  KEY `fk_tblCar_tblCarType_idx` (`tblCarType_id`),
  KEY `fk_tblCar_tblCarClassification1_idx` (`tblCarClassification_id`),
  KEY `fk_tblCar_tblStore1_idx` (`tblStore_id`),
  CONSTRAINT `fk_tblCar_tblCarClassification1` FOREIGN KEY (`tblCarClassification_id`) REFERENCES `tblcarclassification` (`id`),
  CONSTRAINT `fk_tblCar_tblCarType` FOREIGN KEY (`tblCarType_id`) REFERENCES `tblcartype` (`id`),
  CONSTRAINT `fk_tblCar_tblStore1` FOREIGN KEY (`tblStore_id`) REFERENCES `tblstore` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcar`
--

LOCK TABLES `tblcar` WRITE;
/*!40000 ALTER TABLE `tblcar` DISABLE KEYS */;
INSERT INTO `tblcar` VALUES (1,'KIA Morning',1000,'Free','kia','30B14004','KIA',1,1,1),(2,'KIA Rio',1200,'Free','kia','30B14005','KIA',1,1,1);
/*!40000 ALTER TABLE `tblcar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcarclassification`
--

DROP TABLE IF EXISTS `tblcarclassification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcarclassification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcarclassification`
--

LOCK TABLES `tblcarclassification` WRITE;
/*!40000 ALTER TABLE `tblcarclassification` DISABLE KEYS */;
INSERT INTO `tblcarclassification` VALUES (1,'A','Lớp giá rẻ'),(2,'B','Lớp tiện ích'),(3,'C','Xe gia đình'),(4,'D','Xe gia đình cao cấp'),(5,'E','Xe cao cấp'),(6,'F','Luxury');
/*!40000 ALTER TABLE `tblcarclassification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcartype`
--

DROP TABLE IF EXISTS `tblcartype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcartype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcartype`
--

LOCK TABLES `tblcartype` WRITE;
/*!40000 ALTER TABLE `tblcartype` DISABLE KEYS */;
INSERT INTO `tblcartype` VALUES (1,'Sedan','sedan'),(2,'HatchBack','hatchback'),(3,'SUV','SUV'),(4,'Sport','sport');
/*!40000 ALTER TABLE `tblcartype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblclient`
--

DROP TABLE IF EXISTS `tblclient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblclient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `cccd` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `license` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cccd_UNIQUE` (`cccd`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblclient`
--

LOCK TABLES `tblclient` WRITE;
/*!40000 ALTER TABLE `tblclient` DISABLE KEYS */;
INSERT INTO `tblclient` VALUES (1,'hung','1','2','3','B','VIP'),(2,'hung 2','234','Gia lam','0963063105','B','VIP'),(3,'DUC','12345454','Ha dong','12312312','B2','VIP'),(4,'Nam','123123','Tran','1231231','B3','SVIP');
/*!40000 ALTER TABLE `tblclient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcontract`
--

DROP TABLE IF EXISTS `tblcontract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcontract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookingDate` date DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `tblStaff_id` int(11) NOT NULL,
  `tblClient_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`tblStaff_id`,`tblClient_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tblContract_tblClient1_idx` (`tblClient_id`),
  KEY `fk_tblContract_tblStaff1_idx` (`tblStaff_id`),
  CONSTRAINT `fk_tblContract_tblClient1` FOREIGN KEY (`tblClient_id`) REFERENCES `tblclient` (`id`),
  CONSTRAINT `fk_tblContract_tblStaff1` FOREIGN KEY (`tblStaff_id`) REFERENCES `tblstaff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcontract`
--

LOCK TABLES `tblcontract` WRITE;
/*!40000 ALTER TABLE `tblcontract` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblcontract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcontractwarrant`
--

DROP TABLE IF EXISTS `tblcontractwarrant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcontractwarrant` (
  `checkin` date DEFAULT NULL,
  `checkout` date DEFAULT NULL,
  `tblWarrant_id` int(11) NOT NULL,
  `tblContract_id` int(11) NOT NULL,
  PRIMARY KEY (`tblWarrant_id`,`tblContract_id`),
  KEY `fk_tblContractWarrant_tblContract1_idx` (`tblContract_id`),
  CONSTRAINT `fk_tblContractWarrant_tblContract1` FOREIGN KEY (`tblContract_id`) REFERENCES `tblcontract` (`id`),
  CONSTRAINT `fk_tblContractWarrant_tblWarrant1` FOREIGN KEY (`tblWarrant_id`) REFERENCES `tblwarrant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcontractwarrant`
--

LOCK TABLES `tblcontractwarrant` WRITE;
/*!40000 ALTER TABLE `tblcontractwarrant` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblcontractwarrant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbldamagecatalog`
--

DROP TABLE IF EXISTS `tbldamagecatalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbldamagecatalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `fee` varchar(45) DEFAULT NULL,
  `desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `desc_UNIQUE` (`desc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbldamagecatalog`
--

LOCK TABLES `tbldamagecatalog` WRITE;
/*!40000 ALTER TABLE `tbldamagecatalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbldamagecatalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblpenalty`
--

DROP TABLE IF EXISTS `tblpenalty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpenalty` (
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `tblBookedCar_id` int(11) NOT NULL,
  `tblDamageCatalog_id` int(11) NOT NULL,
  PRIMARY KEY (`tblBookedCar_id`,`tblDamageCatalog_id`),
  KEY `fk_tblPenalty_tblDamageCatalog1_idx` (`tblDamageCatalog_id`),
  CONSTRAINT `fk_tblPenalty_tblBookedCar1` FOREIGN KEY (`tblBookedCar_id`) REFERENCES `tblbookedcar` (`id`),
  CONSTRAINT `fk_tblPenalty_tblDamageCatalog1` FOREIGN KEY (`tblDamageCatalog_id`) REFERENCES `tbldamagecatalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblpenalty`
--

LOCK TABLES `tblpenalty` WRITE;
/*!40000 ALTER TABLE `tblpenalty` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblpenalty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblstaff`
--

DROP TABLE IF EXISTS `tblstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblstaff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `tblStore_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`tblStore_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_tblStaff_tblStore1_idx` (`tblStore_id`),
  CONSTRAINT `fk_tblStaff_tblStore1` FOREIGN KEY (`tblStore_id`) REFERENCES `tblstore` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblstaff`
--

LOCK TABLES `tblstaff` WRITE;
/*!40000 ALTER TABLE `tblstaff` DISABLE KEYS */;
INSERT INTO `tblstaff` VALUES (1,'Nguyen Duc Hung','0963063105','nishalab','123456','Receptionist','Xuan Duc',1);
/*!40000 ALTER TABLE `tblstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblstore`
--

DROP TABLE IF EXISTS `tblstore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblstore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `adddress` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `adddress_UNIQUE` (`adddress`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblstore`
--

LOCK TABLES `tblstore` WRITE;
/*!40000 ALTER TABLE `tblstore` DISABLE KEYS */;
INSERT INTO `tblstore` VALUES (1,'Garage Gia Lam','Gia Lam','0963063105','Garage dau tien');
/*!40000 ALTER TABLE `tblstore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblwarrant`
--

DROP TABLE IF EXISTS `tblwarrant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblwarrant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  `desc` varchar(45) DEFAULT NULL,
  `tblClient_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`tblClient_id`),
  UNIQUE KEY `desc_UNIQUE` (`desc`),
  KEY `fk_tblWarrant_tblClient1_idx` (`tblClient_id`),
  CONSTRAINT `fk_tblWarrant_tblClient1` FOREIGN KEY (`tblClient_id`) REFERENCES `tblclient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblwarrant`
--

LOCK TABLES `tblwarrant` WRITE;
/*!40000 ALTER TABLE `tblwarrant` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblwarrant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cnpm'
--

--
-- Dumping routines for database 'cnpm'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-25 16:33:16
