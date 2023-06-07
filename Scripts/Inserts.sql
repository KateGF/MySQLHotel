-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: kt
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `amenity`
--

DROP TABLE IF EXISTS `amenity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amenity` (
  `IDAMENITY` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `IDHOTEL` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDAMENITY`),
  UNIQUE KEY `PK_AMENITY_ID` (`IDAMENITY`),
  KEY `FK_IDHOTEL_AMENITY` (`IDHOTEL`),
  CONSTRAINT `FK_IDHOTEL_AMENITY` FOREIGN KEY (`IDHOTEL`) REFERENCES `hotel` (`IDHOTEL`),
  CONSTRAINT `NAME_AMENITY_NN` CHECK ((`NAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenity`
--

LOCK TABLES `amenity` WRITE;
/*!40000 ALTER TABLE `amenity` DISABLE KEYS */;
INSERT INTO `amenity` VALUES (4,'Seaview',NULL,NULL,NULL,NULL,NULL),(5,'Balcony',NULL,NULL,NULL,NULL,NULL),(6,'Bathtub',NULL,NULL,NULL,NULL,NULL),(10,'Seaview',NULL,NULL,NULL,NULL,NULL),(11,'Balcony',NULL,NULL,NULL,NULL,NULL),(12,'Bathtub',NULL,NULL,NULL,NULL,NULL),(13,'Gym',7,NULL,NULL,NULL,NULL),(14,'Spa',8,NULL,NULL,NULL,NULL),(15,'Pool',NULL,NULL,NULL,NULL,NULL),(16,'Seaview',NULL,NULL,NULL,NULL,NULL),(17,'Balcony',NULL,NULL,NULL,NULL,NULL),(18,'Bathtub',NULL,NULL,NULL,NULL,NULL),(19,'Seaview',13,'2023-05-18 00:00:00','KT','2023-05-18 00:00:00','KT'),(22,'Bathtub',13,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(23,'Seaview',16,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(25,'Gym',13,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(26,'Balcony',13,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT');
/*!40000 ALTER TABLE `amenity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amenityxroom`
--

DROP TABLE IF EXISTS `amenityxroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amenityxroom` (
  `IDAMENITYXROOM` int NOT NULL,
  `IDAMENITY` int DEFAULT NULL,
  `IDROOM` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDAMENITYXROOM`),
  UNIQUE KEY `PK_AMENITYXROOM_ID` (`IDAMENITYXROOM`),
  KEY `FK_IDAMENITY_AMENITYXROOM` (`IDAMENITY`),
  KEY `FK_IDROOM_AMENITYXROOM` (`IDROOM`),
  CONSTRAINT `FK_IDAMENITY_AMENITYXROOM` FOREIGN KEY (`IDAMENITY`) REFERENCES `amenity` (`IDAMENITY`),
  CONSTRAINT `FK_IDROOM_AMENITYXROOM` FOREIGN KEY (`IDROOM`) REFERENCES `room` (`IDROOM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenityxroom`
--

LOCK TABLES `amenityxroom` WRITE;
/*!40000 ALTER TABLE `amenityxroom` DISABLE KEYS */;
INSERT INTO `amenityxroom` VALUES (1,5,3,NULL,NULL,NULL,NULL),(2,5,3,NULL,NULL,NULL,NULL),(3,6,4,NULL,NULL,NULL,NULL),(4,10,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `amenityxroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `amenityxroomview`
--

DROP TABLE IF EXISTS `amenityxroomview`;
/*!50001 DROP VIEW IF EXISTS `amenityxroomview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `amenityxroomview` AS SELECT 
 1 AS `IDAMENITY`,
 1 AS `IDROOM`,
 1 AS `NAME`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `canton`
--

DROP TABLE IF EXISTS `canton`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canton` (
  `IDCANTON` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `IDSTATE` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDCANTON`),
  UNIQUE KEY `PK_CANTON_ID` (`IDCANTON`),
  KEY `FK_IDSTATE_CANTON` (`IDSTATE`),
  CONSTRAINT `FK_IDSTATE_CANTON` FOREIGN KEY (`IDSTATE`) REFERENCES `state` (`IDSTATE`),
  CONSTRAINT `NAME_CANTON_NN` CHECK ((`NAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canton`
--

LOCK TABLES `canton` WRITE;
/*!40000 ALTER TABLE `canton` DISABLE KEYS */;
INSERT INTO `canton` VALUES (4,'Montes de Oca',5,NULL,NULL,NULL,NULL),(5,'San Carlos',6,NULL,NULL,NULL,NULL),(6,'Para¿so',7,NULL,NULL,NULL,NULL),(7,'Montes de Oca',5,NULL,NULL,NULL,NULL),(8,'San Carlos',6,NULL,NULL,NULL,NULL),(9,'Paraiso',7,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `canton` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `IDCOUNTRY` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDCOUNTRY`),
  UNIQUE KEY `PK_COUNTRY_ID` (`IDCOUNTRY`),
  CONSTRAINT `NAME_COUNTRY_NN` CHECK ((`NAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Costa Rica',NULL,NULL,NULL,NULL),(2,'Nicaragua',NULL,NULL,NULL,NULL),(3,'Brasil',NULL,NULL,NULL,NULL),(4,'Costa Rica',NULL,NULL,NULL,NULL),(5,'Nicaragua',NULL,NULL,NULL,NULL),(6,'Brasil',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `IDDISCOUNT` int NOT NULL,
  `EXPIREDATE` datetime DEFAULT NULL,
  `CODE` varchar(35) DEFAULT NULL,
  `PERCENTAGE` decimal(5,2) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDDISCOUNT`),
  UNIQUE KEY `CODEUNIQUE` (`CODE`),
  UNIQUE KEY `PK_DISCOUNT_ID` (`IDDISCOUNT`),
  CONSTRAINT `CODE_DISCOUNT_NN` CHECK ((`CODE` is not null)),
  CONSTRAINT `EXPIREDATE_DISCOUNT_NN` CHECK ((`EXPIREDATE` is not null)),
  CONSTRAINT `PERCENTAGE_DISCOUNT_NN` CHECK ((`PERCENTAGE` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,'2023-05-30 00:00:00','EOTM',15.00,NULL,NULL,NULL,NULL),(2,'1995-05-11 00:00:00','D15C0UNT',10.00,NULL,NULL,NULL,NULL),(4,'2023-06-02 00:00:00','MIDY',5.00,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district` (
  `IDDISTRICT` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `IDCANTON` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDDISTRICT`),
  UNIQUE KEY `PK_DISCTRICT_ID` (`IDDISTRICT`),
  KEY `FK_IDCANTON_DISTRICT` (`IDCANTON`),
  CONSTRAINT `FK_IDCANTON_DISTRICT` FOREIGN KEY (`IDCANTON`) REFERENCES `canton` (`IDCANTON`),
  CONSTRAINT `NAME_DISTRICT_NN` CHECK ((`NAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (4,'Sabanilla',4,NULL,NULL,NULL,NULL),(5,'Fortuna',5,NULL,NULL,NULL,NULL),(6,'Orosi',6,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email` (
  `IDEMAIL` int NOT NULL,
  `ELECTRONICMAIL` varchar(35) DEFAULT NULL,
  `IDUSER` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDEMAIL`),
  UNIQUE KEY `PK_EMAIL_ID` (`IDEMAIL`),
  KEY `FK_IDUSER_EMAIL` (`IDUSER`),
  CONSTRAINT `FK_IDUSER_EMAIL` FOREIGN KEY (`IDUSER`) REFERENCES `users` (`IDUSER`),
  CONSTRAINT `ELECTRONICMAIL_EMAIL_NN` CHECK ((`ELECTRONICMAIL` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (4,'carlos01@gmail.com',7,NULL,NULL,NULL,NULL),(5,'emi90@gmail.com',12,NULL,NULL,NULL,NULL),(6,'andre14@gmail.com',14,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite` (
  `IDFAVORITE` int NOT NULL,
  `IDUSER` int DEFAULT NULL,
  `IDHOTEL` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDFAVORITE`),
  UNIQUE KEY `PK_FAVORITE_ID` (`IDFAVORITE`),
  KEY `FK_IDHOTEL_FAVORITE` (`IDHOTEL`),
  KEY `FK_IDUSER_FAVORITE` (`IDUSER`),
  CONSTRAINT `FK_IDHOTEL_FAVORITE` FOREIGN KEY (`IDHOTEL`) REFERENCES `hotel` (`IDHOTEL`),
  CONSTRAINT `FK_IDUSER_FAVORITE` FOREIGN KEY (`IDUSER`) REFERENCES `users` (`IDUSER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `IDFEEDBACK` int NOT NULL,
  `COMMMENT` varchar(35) DEFAULT NULL,
  `IDRESERVATION` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDFEEDBACK`),
  UNIQUE KEY `PK_FEEDBACK_ID` (`IDFEEDBACK`),
  KEY `FK_IDRESERVATION_FEEDBACK` (`IDRESERVATION`),
  CONSTRAINT `FK_IDRESERVATION_FEEDBACK` FOREIGN KEY (`IDRESERVATION`) REFERENCES `reservation` (`IDRESERVATION`),
  CONSTRAINT `COMMENT_FEEDBACK_NN` CHECK ((`COMMMENT` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `IDGENDER` int NOT NULL,
  `TYPE` varchar(35) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDGENDER`),
  UNIQUE KEY `PK_GENDER_ID` (`IDGENDER`),
  CONSTRAINT `TYPE_GENDER_NN` CHECK ((`Type` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (3,'Masculino',NULL,NULL,NULL,NULL),(4,'Femenino',NULL,NULL,NULL,NULL),(5,'Otro',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `IDHOTEL` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `REGISTERDATE` datetime DEFAULT NULL,
  `IDDISTRICT` int DEFAULT NULL,
  `IDCLASIFICATION` int DEFAULT NULL,
  `IDDISCOUNT` int DEFAULT NULL,
  `CREATIONUSERS` varchar(10) DEFAULT NULL,
  `MODUSERS` varchar(10) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`IDHOTEL`),
  UNIQUE KEY `PK_HOTEL_ID` (`IDHOTEL`),
  KEY `FK_IDCLASIFICATION_HOTEL` (`IDCLASIFICATION`),
  KEY `FK_IDDISCOUNT_HOTEL` (`IDDISCOUNT`),
  KEY `FK_IDDISTRICT_HOTEL` (`IDDISTRICT`),
  CONSTRAINT `FK_IDCLASIFICATION_HOTEL` FOREIGN KEY (`IDCLASIFICATION`) REFERENCES `hotelclasification` (`IDHOTELCLASIFICATION`),
  CONSTRAINT `FK_IDDISCOUNT_HOTEL` FOREIGN KEY (`IDDISCOUNT`) REFERENCES `discount` (`IDDISCOUNT`),
  CONSTRAINT `FK_IDDISTRICT_HOTEL` FOREIGN KEY (`IDDISTRICT`) REFERENCES `district` (`IDDISTRICT`),
  CONSTRAINT `NAME_HOTEL_NN` CHECK ((`NAME` is not null)),
  CONSTRAINT `REGISTERDATE_HOTEL_NN` CHECK ((`REGISTERDATE` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (7,'Kibi Kibi','2023-05-11 00:00:00',5,2,1,NULL,NULL,NULL,NULL),(8,'Kibi Kibi','2023-05-11 00:00:00',5,2,1,NULL,NULL,NULL,NULL),(9,'Arenal Secret Garden','2023-05-12 00:00:00',6,3,1,NULL,NULL,NULL,NULL),(13,'Casa Bartzis','2015-10-09 00:00:00',4,2,1,NULL,NULL,NULL,NULL),(15,'Kat Hotel','2023-05-12 00:00:00',6,1,2,'KT','KT','2023-05-19 00:00:00','2023-05-19 00:00:00'),(16,'Guanabana','2023-05-12 00:00:00',6,1,2,'KT','KT','2023-05-19 00:00:00','2023-05-19 00:00:00'),(17,'Hello','2023-05-10 00:00:00',6,1,2,'KT','KT','2023-05-19 00:00:00','2023-05-19 00:00:00'),(19,'Luz','2023-05-20 00:00:00',6,1,2,'KT','KT','2023-05-19 00:00:00','2023-05-19 00:00:00');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotelclasification`
--

DROP TABLE IF EXISTS `hotelclasification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotelclasification` (
  `IDHOTELCLASIFICATION` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDHOTELCLASIFICATION`),
  UNIQUE KEY `PK_HOTELCLASIFICATION_ID` (`IDHOTELCLASIFICATION`),
  CONSTRAINT `NAME_HOTELCLASIFICATION_NN` CHECK ((`NAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotelclasification`
--

LOCK TABLES `hotelclasification` WRITE;
/*!40000 ALTER TABLE `hotelclasification` DISABLE KEYS */;
INSERT INTO `hotelclasification` VALUES (1,'5',NULL,NULL,NULL,NULL),(2,'4',NULL,NULL,NULL,NULL),(3,'3',NULL,NULL,NULL,NULL),(4,'2',NULL,NULL,NULL,NULL),(5,'1',NULL,NULL,NULL,NULL),(6,'5',NULL,NULL,NULL,NULL),(7,'4',NULL,NULL,NULL,NULL),(8,'3',NULL,NULL,NULL,NULL),(9,'2',NULL,NULL,NULL,NULL),(10,'1',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hotelclasification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idtype`
--

DROP TABLE IF EXISTS `idtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `idtype` (
  `IDIDTYPE` int NOT NULL,
  `MASK` varchar(35) DEFAULT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDIDTYPE`),
  UNIQUE KEY `PK_IDTYPE_ID` (`IDIDTYPE`),
  CONSTRAINT `NAME_IDTYPE_NN` CHECK ((`NAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idtype`
--

LOCK TABLES `idtype` WRITE;
/*!40000 ALTER TABLE `idtype` DISABLE KEYS */;
INSERT INTO `idtype` VALUES (6,'XX-XXXX-XXXX','Cedula Fisica',NULL,NULL,NULL,NULL),(7,'X-XXX-XXXXXX','Cedula Juridica',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `idtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nationality`
--

DROP TABLE IF EXISTS `nationality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nationality` (
  `IDNATIONALITY` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDNATIONALITY`),
  UNIQUE KEY `PK_NATIONALITY_ID` (`IDNATIONALITY`),
  CONSTRAINT `NAME_NATIONALITY_NN` CHECK ((`NAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nationality`
--

LOCK TABLES `nationality` WRITE;
/*!40000 ALTER TABLE `nationality` DISABLE KEYS */;
INSERT INTO `nationality` VALUES (1,'Costarricense',NULL,NULL,NULL,NULL),(2,'Estadounidense',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `nationality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter`
--

DROP TABLE IF EXISTS `parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parameter` (
  `IDPARAMETER` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `VALUE` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDPARAMETER`),
  UNIQUE KEY `PK_PARAMETER_ID` (`IDPARAMETER`),
  CONSTRAINT `NAME_PARAMETER_NN` CHECK ((`NAME` is not null)),
  CONSTRAINT `VALUE_PARAMETER_NN` CHECK ((`Value` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter`
--

LOCK TABLES `parameter` WRITE;
/*!40000 ALTER TABLE `parameter` DISABLE KEYS */;
INSERT INTO `parameter` VALUES (1,'IVA',13,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmethod`
--

DROP TABLE IF EXISTS `paymentmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymentmethod` (
  `IDPAYMENTMETHOD` int NOT NULL,
  `NAMEPAYMENTMETHOD` varchar(35) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDPAYMENTMETHOD`),
  UNIQUE KEY `PK_PAYMENTMETHOD_ID` (`IDPAYMENTMETHOD`),
  CONSTRAINT `NAME_PAYMENTMETHOD_NN` CHECK ((`NAMEPAYMENTMETHOD` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmethod`
--

LOCK TABLES `paymentmethod` WRITE;
/*!40000 ALTER TABLE `paymentmethod` DISABLE KEYS */;
INSERT INTO `paymentmethod` VALUES (1,'Visa',NULL,NULL,NULL,NULL),(2,'MasterCard',NULL,NULL,NULL,NULL),(3,'American Express',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `paymentmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmethodxhotel`
--

DROP TABLE IF EXISTS `paymentmethodxhotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymentmethodxhotel` (
  `IDPAYMENTMETHODXHOTEL` int NOT NULL,
  `IDPAYMENTMETHOD` int DEFAULT NULL,
  `IDHOTEL` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDPAYMENTMETHODXHOTEL`),
  UNIQUE KEY `PK_PAYMENTMETHODXHOTEL_ID` (`IDPAYMENTMETHODXHOTEL`),
  KEY `FK_IDHOTEL_PAYMENTMXHOTEL` (`IDHOTEL`),
  KEY `FK_IDPAYMENTM_PAYMENTMXHOTEL` (`IDPAYMENTMETHOD`),
  CONSTRAINT `FK_IDHOTEL_PAYMENTMXHOTEL` FOREIGN KEY (`IDHOTEL`) REFERENCES `hotel` (`IDHOTEL`),
  CONSTRAINT `FK_IDPAYMENTM_PAYMENTMXHOTEL` FOREIGN KEY (`IDPAYMENTMETHOD`) REFERENCES `paymentmethod` (`IDPAYMENTMETHOD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmethodxhotel`
--

LOCK TABLES `paymentmethodxhotel` WRITE;
/*!40000 ALTER TABLE `paymentmethodxhotel` DISABLE KEYS */;
INSERT INTO `paymentmethodxhotel` VALUES (1,1,7,NULL,NULL,NULL,NULL),(2,2,8,NULL,NULL,NULL,NULL),(3,3,9,NULL,NULL,NULL,NULL),(4,1,13,NULL,NULL,NULL,NULL),(5,2,7,NULL,NULL,NULL,NULL),(6,1,8,NULL,NULL,NULL,NULL),(7,2,9,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `paymentmethodxhotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penalty`
--

DROP TABLE IF EXISTS `penalty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `penalty` (
  `IDPENALTY` int NOT NULL,
  `DAYS` varchar(35) DEFAULT NULL,
  `TIME` smallint DEFAULT NULL,
  `MONEY` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDPENALTY`),
  UNIQUE KEY `PK_PENALTY_ID` (`IDPENALTY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penalty`
--

LOCK TABLES `penalty` WRITE;
/*!40000 ALTER TABLE `penalty` DISABLE KEYS */;
INSERT INTO `penalty` VALUES (1,'2',NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,15000,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `penalty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonenumber`
--

DROP TABLE IF EXISTS `phonenumber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phonenumber` (
  `IDPHONENUMBER` int NOT NULL,
  `PHONENUMBER` bigint DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDPHONENUMBER`),
  UNIQUE KEY `PK_PHONENUMBER_ID` (`IDPHONENUMBER`),
  CONSTRAINT `NUMBER_PHONENUMBER_NN` CHECK ((`PHONENUMBER` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonenumber`
--

LOCK TABLES `phonenumber` WRITE;
/*!40000 ALTER TABLE `phonenumber` DISABLE KEYS */;
INSERT INTO `phonenumber` VALUES (1,12589637,NULL,NULL,NULL,NULL),(2,26489571,NULL,NULL,NULL,NULL),(3,34698052,NULL,NULL,NULL,NULL),(4,12589637,NULL,NULL,NULL,NULL),(5,26489571,NULL,NULL,NULL,NULL),(6,34698052,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `phonenumber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photo` (
  `IDPHOTO` int NOT NULL,
  `PICTURE` varchar(200) DEFAULT NULL,
  `IDHOTEL` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDPHOTO`),
  UNIQUE KEY `PK_PHOTO_ID` (`IDPHOTO`),
  KEY `FK_IDHOTEL_PHOTO` (`IDHOTEL`),
  CONSTRAINT `FK_IDHOTEL_PHOTO` FOREIGN KEY (`IDHOTEL`) REFERENCES `hotel` (`IDHOTEL`),
  CONSTRAINT `PICTURE_PHOTO_NN` CHECK ((`PICTURE` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `IDRESERVATION` int NOT NULL,
  `IDUSER` int DEFAULT NULL,
  `IDPAYMENT` int DEFAULT NULL,
  `IDPENALTY` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDRESERVATION`),
  UNIQUE KEY `PK_RESERVATION_ID` (`IDRESERVATION`),
  KEY `FK_IDPAYMENT_RESERVATION` (`IDPAYMENT`),
  KEY `FK_IDPENALTY_RESERVATION` (`IDPENALTY`),
  KEY `FK_IDUSER_RESERVATION` (`IDUSER`),
  CONSTRAINT `FK_IDPAYMENT_RESERVATION` FOREIGN KEY (`IDPAYMENT`) REFERENCES `paymentmethod` (`IDPAYMENTMETHOD`),
  CONSTRAINT `FK_IDPENALTY_RESERVATION` FOREIGN KEY (`IDPENALTY`) REFERENCES `penalty` (`IDPENALTY`),
  CONSTRAINT `FK_IDUSER_RESERVATION` FOREIGN KEY (`IDUSER`) REFERENCES `users` (`IDUSER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (3,7,1,NULL,NULL,NULL,NULL,NULL),(4,10,1,1,NULL,NULL,NULL,NULL),(5,10,1,1,NULL,NULL,NULL,NULL),(6,10,2,NULL,NULL,NULL,NULL,NULL),(8,10,1,1,'2023-05-18 00:00:00','KT','2023-05-18 00:00:00','KT'),(9,10,1,1,'2023-05-18 00:00:00','KT','2023-05-18 00:00:00','KT'),(10,10,1,1,'2023-05-18 00:00:00','KT','2023-05-18 00:00:00','KT'),(16,10,1,1,'2023-05-18 00:00:00','KT','2023-05-18 00:00:00','KT'),(17,10,1,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(18,10,1,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(20,27,1,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(21,10,1,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(22,10,1,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservationxroom`
--

DROP TABLE IF EXISTS `reservationxroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservationxroom` (
  `IDRESERVATIONXROOM` int NOT NULL,
  `ADMINPRICE` decimal(10,2) DEFAULT NULL,
  `CHECKIN` datetime DEFAULT NULL,
  `CHECKOUT` datetime DEFAULT NULL,
  `IDRESERVATION` int DEFAULT NULL,
  `IDROOM` int DEFAULT NULL,
  `IDDISCOUNT` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDRESERVATIONXROOM`),
  UNIQUE KEY `PK_RESERVATIONXROOM_ID` (`IDRESERVATIONXROOM`),
  KEY `FK_IDDISCOUNT_RESERVXROOM` (`IDDISCOUNT`),
  KEY `FK_IDRESERVATION_RESERVXROOM` (`IDRESERVATION`),
  KEY `FK_IDROOM_RESERVXROOM` (`IDROOM`),
  CONSTRAINT `FK_IDDISCOUNT_RESERVXROOM` FOREIGN KEY (`IDDISCOUNT`) REFERENCES `discount` (`IDDISCOUNT`),
  CONSTRAINT `FK_IDRESERVATION_RESERVXROOM` FOREIGN KEY (`IDRESERVATION`) REFERENCES `reservation` (`IDRESERVATION`),
  CONSTRAINT `FK_IDROOM_RESERVXROOM` FOREIGN KEY (`IDROOM`) REFERENCES `room` (`IDROOM`),
  CONSTRAINT `ADMINPRICE_RESERVATIONXROOM_NN` CHECK ((`ADMINPRICE` is not null)),
  CONSTRAINT `CHECKIN_RESERVATIONXROOM_NN` CHECK ((`CHECKIN` is not null)),
  CONSTRAINT `CHECKOUT_RESERVATIONXROOM_NN` CHECK ((`CHECKOUT` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservationxroom`
--

LOCK TABLES `reservationxroom` WRITE;
/*!40000 ALTER TABLE `reservationxroom` DISABLE KEYS */;
INSERT INTO `reservationxroom` VALUES (1,55000.00,'2023-03-05 00:00:00','2023-05-10 00:00:00',3,3,1,NULL,NULL,NULL,NULL),(11,55000.00,'2023-05-26 00:00:00','2023-05-11 00:00:00',16,3,1,'2023-05-18 00:00:00','KT','2023-05-18 00:00:00','KT'),(12,25000.00,'2023-05-12 00:00:00','2023-05-11 00:00:00',17,7,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(13,100000.00,'2023-05-11 00:00:00','2023-05-03 00:00:00',18,8,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(15,55000.00,'2023-05-02 00:00:00','2023-05-04 00:00:00',20,3,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(16,100000.00,'2023-05-03 00:00:00','2023-05-05 00:00:00',21,8,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(17,80000.00,'2023-05-07 00:00:00','2023-05-03 00:00:00',22,9,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT');
/*!40000 ALTER TABLE `reservationxroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `IDREVIEW` int NOT NULL,
  `STAR` tinyint DEFAULT NULL,
  `IDRESERVATION` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDREVIEW`),
  UNIQUE KEY `PK_REVIEW_ID` (`IDREVIEW`),
  KEY `FK_IDRESERVATION_REVIEW` (`IDRESERVATION`),
  CONSTRAINT `FK_IDRESERVATION_REVIEW` FOREIGN KEY (`IDRESERVATION`) REFERENCES `reservation` (`IDRESERVATION`),
  CONSTRAINT `STAR_REVIEW_NN` CHECK ((`STAR` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (0,4,17,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(1,3,18,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(2,5,3,NULL,NULL,NULL,NULL),(3,4,4,NULL,NULL,NULL,NULL),(4,3,4,NULL,NULL,NULL,NULL),(5,4,4,NULL,NULL,NULL,NULL),(6,4,5,NULL,NULL,NULL,NULL),(7,3,5,NULL,NULL,NULL,NULL),(8,4,5,NULL,NULL,NULL,NULL),(9,4,6,NULL,NULL,NULL,NULL),(10,2,6,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `IDROOM` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `CAPACITY` tinyint DEFAULT NULL,
  `RECOMMENDEDPRICE` decimal(10,2) DEFAULT NULL,
  `IDHOTEL` int DEFAULT NULL,
  `IDROOMCATEGORY` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDROOM`),
  UNIQUE KEY `PK_ROOM_ID` (`IDROOM`),
  KEY `FK_IDHOTEL_ROOM` (`IDHOTEL`),
  KEY `FK_IDROOMCATEGORY_ROOM` (`IDROOMCATEGORY`),
  CONSTRAINT `FK_IDHOTEL_ROOM` FOREIGN KEY (`IDHOTEL`) REFERENCES `hotel` (`IDHOTEL`),
  CONSTRAINT `FK_IDROOMCATEGORY_ROOM` FOREIGN KEY (`IDROOMCATEGORY`) REFERENCES `roomcategory` (`IDROOMCATEGORY`),
  CONSTRAINT `CAPACITY_ROOM_NN` CHECK ((`CAPACITY` is not null)),
  CONSTRAINT `NAME_ROOM_NN` CHECK ((`NAME` is not null)),
  CONSTRAINT `RECOMMENDEDPRICE_ROOM_NN` CHECK ((`RECOMMENDEDPRICE` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (3,'Arenal',2,55000.00,9,1,NULL,NULL,NULL,NULL),(4,'Chollin',2,75000.00,13,2,NULL,NULL,NULL,NULL),(6,'Caoba',3,40000.00,7,1,'2023-05-18 00:00:00','KT','2023-05-18 00:00:00','KT'),(7,'AXD',1,25000.00,13,1,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(8,'Piña',4,100000.00,16,3,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(9,'Cazadora',4,80000.00,13,2,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(10,'Velero',4,48000.00,13,2,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(11,'Libelula',4,54000.00,13,2,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomcategory`
--

DROP TABLE IF EXISTS `roomcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomcategory` (
  `IDROOMCATEGORY` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDROOMCATEGORY`),
  UNIQUE KEY `PK_ROOMCATEGORY_ID` (`IDROOMCATEGORY`),
  CONSTRAINT `NAME_ROOMCATEGORY_NN` CHECK ((`NAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomcategory`
--

LOCK TABLES `roomcategory` WRITE;
/*!40000 ALTER TABLE `roomcategory` DISABLE KEYS */;
INSERT INTO `roomcategory` VALUES (1,'Estandar',NULL,NULL,NULL,NULL),(2,'Superior',NULL,NULL,NULL,NULL),(3,'Deluxe',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `roomcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `IDSTATE` int NOT NULL,
  `NAME` varchar(35) DEFAULT NULL,
  `IDCOUNTRY` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDSTATE`),
  UNIQUE KEY `PK_STATE_ID` (`IDSTATE`),
  KEY `FK_IDCOUNTRY_STATE` (`IDCOUNTRY`),
  CONSTRAINT `FK_IDCOUNTRY_STATE` FOREIGN KEY (`IDCOUNTRY`) REFERENCES `country` (`IDCOUNTRY`),
  CONSTRAINT `NAME_STATE_NN` CHECK ((`NAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (5,'San Jose',1,NULL,NULL,NULL,NULL),(6,'Alajuela',1,NULL,NULL,NULL,NULL),(7,'Cartago',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `IDUSER` int NOT NULL,
  `PHOTO` varchar(200) DEFAULT NULL,
  `IDENTIFICATIONCARD` varchar(35) DEFAULT NULL,
  `FIRSTNAME` varchar(35) DEFAULT NULL,
  `MIDDLENAME` varchar(35) DEFAULT NULL,
  `LASTNAME` varchar(35) DEFAULT NULL,
  `SECONDSURNAME` varchar(35) DEFAULT NULL,
  `USERNAME` varchar(35) DEFAULT NULL,
  `PASSWORD` varchar(35) DEFAULT NULL,
  `BIRTHDATE` datetime DEFAULT NULL,
  `IDDISTRICT` int DEFAULT NULL,
  `IDTYPE` int DEFAULT NULL,
  `IDGENDER` int DEFAULT NULL,
  `IDUSERTYPE` int DEFAULT NULL,
  `IDHOTELADMIN` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDUSER`),
  UNIQUE KEY `PK_USER_ID` (`IDUSER`),
  KEY `FK_IDDISTRICT_USER` (`IDDISTRICT`),
  KEY `FK_IDGENDER_USER` (`IDGENDER`),
  KEY `FK_IDHOTELADMIN_USER` (`IDHOTELADMIN`),
  KEY `FK_IDTYPE_USER` (`IDTYPE`),
  KEY `FK_IDUSERTYPE_USER` (`IDUSERTYPE`),
  CONSTRAINT `FK_IDDISTRICT_USER` FOREIGN KEY (`IDDISTRICT`) REFERENCES `district` (`IDDISTRICT`),
  CONSTRAINT `FK_IDGENDER_USER` FOREIGN KEY (`IDGENDER`) REFERENCES `gender` (`IDGENDER`),
  CONSTRAINT `FK_IDHOTELADMIN_USER` FOREIGN KEY (`IDHOTELADMIN`) REFERENCES `hotel` (`IDHOTEL`),
  CONSTRAINT `FK_IDTYPE_USER` FOREIGN KEY (`IDTYPE`) REFERENCES `idtype` (`IDIDTYPE`),
  CONSTRAINT `FK_IDUSERTYPE_USER` FOREIGN KEY (`IDUSERTYPE`) REFERENCES `usertype` (`IDUSERTYPE`),
  CONSTRAINT `BIRTHDATE_USER_NN` CHECK ((`BIRTHDATE` is not null)),
  CONSTRAINT `FIRSTNAME_USER_NN` CHECK ((`FIRSTNAME` is not null)),
  CONSTRAINT `IDENTIFICATIONCARD_USER_NN` CHECK ((`IDENTIFICATIONCARD` is not null)),
  CONSTRAINT `LASTNAME_USER_NN` CHECK ((`LASTNAME` is not null)),
  CONSTRAINT `PASSWORD_USER_NN` CHECK ((`PASSWORD` is not null)),
  CONSTRAINT `USERNAME_USER_NN` CHECK ((`USERNAME` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (7,NULL,'1-1234-5678','Carlos','Andr¿s','Santana','Mata','cartana01','mata1234','1995-05-11 00:00:00',5,6,3,3,NULL,NULL,NULL,NULL,NULL),(8,NULL,'1-1825-0665','Luis','Alejandro','Barreda','Acevedo','luisale06','luisale','2001-06-10 00:00:00',4,7,4,1,NULL,NULL,NULL,NULL,NULL),(9,NULL,'1-1825-0665','Luis','Alejandro','Barreda','Acevedo','luisale06','luisale','2001-06-10 00:00:00',4,7,4,1,NULL,NULL,NULL,NULL,NULL),(10,NULL,'3-4567-0231','Katerine','Marcela','Guzman','Flores','kat02','kat','1997-11-29 00:00:00',6,6,3,2,NULL,NULL,NULL,NULL,NULL),(12,NULL,'3-6548-1203','Emilia',NULL,'Carrero','Bermudez','emi190','emil90','2002-05-10 00:00:00',5,6,3,3,NULL,NULL,NULL,NULL,NULL),(14,NULL,'2-5431-8279','Andrea','Maria','Mora','Castro','andre','Mora14','2005-07-15 00:00:00',4,7,3,3,NULL,NULL,NULL,NULL,NULL),(15,NULL,'1-1234-5678','Carlos','Andres','Santana','Mata','cartana01','mata1234','1995-05-11 00:00:00',5,6,3,3,NULL,NULL,NULL,NULL,NULL),(22,'jujuju','12345','Maria','Alejandra','moya','rojas','hola','1234','2023-05-13 00:00:00',4,7,3,1,9,NULL,NULL,NULL,NULL),(23,'jujuju','12345','Pepe','Alfonso','Aguilar','Fonseca','bobo','1234','2023-05-13 00:00:00',4,7,3,1,9,NULL,NULL,NULL,NULL),(24,NULL,'986545565','Amanda','Sofia','Rojas','Leiva','Amanda','rojas1234','2023-05-19 00:00:00',4,7,3,1,9,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(25,NULL,'986545565','Amanda','Sofia','Rojas','Leiva','Amanda','rojas1234','2023-05-19 00:00:00',4,7,3,1,9,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(26,NULL,'305060241','Lucia','Brenda','Rojas','Torres','torres','torres','2023-05-19 00:00:00',4,7,3,1,9,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT'),(27,NULL,'305060241','Lucia','Brenda','Rojas','Torres','torres','torres','2023-05-19 00:00:00',4,7,3,1,9,'2023-05-19 00:00:00','KT','2023-05-19 00:00:00','KT');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertype` (
  `IDUSERTYPE` int NOT NULL,
  `DESCRIPTION` varchar(35) DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDUSERTYPE`),
  UNIQUE KEY `PK_USERTYPE_ID` (`IDUSERTYPE`),
  CONSTRAINT `DESCRIPTION_USERTYPE_NN` CHECK ((`DESCRIPTION` is not null))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'Master',NULL,NULL,NULL,NULL),(2,'Administrador',NULL,NULL,NULL,NULL),(3,'Cliente',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userxnationality`
--

DROP TABLE IF EXISTS `userxnationality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userxnationality` (
  `IDUSERXNATIONALITY` int NOT NULL,
  `IDUSER` int DEFAULT NULL,
  `IDNATIONALITY` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDUSERXNATIONALITY`),
  UNIQUE KEY `PK_USERXNATIONALITY_ID` (`IDUSERXNATIONALITY`),
  KEY `FK_IDUSER_USERXNAT` (`IDUSER`),
  KEY `FK_IDNATIONALITY_USERXNAT` (`IDNATIONALITY`),
  CONSTRAINT `FK_IDNATIONALITY_USERXNAT` FOREIGN KEY (`IDNATIONALITY`) REFERENCES `nationality` (`IDNATIONALITY`),
  CONSTRAINT `FK_IDUSER_USERXNAT` FOREIGN KEY (`IDUSER`) REFERENCES `users` (`IDUSER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userxnationality`
--

LOCK TABLES `userxnationality` WRITE;
/*!40000 ALTER TABLE `userxnationality` DISABLE KEYS */;
INSERT INTO `userxnationality` VALUES (6,7,1,NULL,NULL,NULL,NULL),(7,8,2,NULL,NULL,NULL,NULL),(8,9,1,NULL,NULL,NULL,NULL),(9,10,2,NULL,NULL,NULL,NULL),(11,7,1,NULL,NULL,NULL,NULL),(12,8,2,NULL,NULL,NULL,NULL),(13,9,1,NULL,NULL,NULL,NULL),(14,10,2,NULL,NULL,NULL,NULL),(16,7,1,NULL,NULL,NULL,NULL),(17,8,2,NULL,NULL,NULL,NULL),(18,9,1,NULL,NULL,NULL,NULL),(19,10,2,NULL,NULL,NULL,NULL),(21,8,2,NULL,NULL,NULL,NULL),(22,9,1,NULL,NULL,NULL,NULL),(23,10,2,NULL,NULL,NULL,NULL),(24,12,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `userxnationality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userxphonenumber`
--

DROP TABLE IF EXISTS `userxphonenumber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userxphonenumber` (
  `IDUSERXPHONENUMBER` int NOT NULL,
  `IDUSER` int DEFAULT NULL,
  `IDPHONENUMBER` int DEFAULT NULL,
  `CREATIONDATE` datetime DEFAULT NULL,
  `CREATIONUSER` varchar(10) DEFAULT NULL,
  `MODDATE` datetime DEFAULT NULL,
  `MODUSER` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDUSERXPHONENUMBER`),
  UNIQUE KEY `PK_USERXPHONENUMBER_ID` (`IDUSERXPHONENUMBER`),
  KEY `FK_IDPHONENUMBER_USERXPHONE` (`IDPHONENUMBER`),
  KEY `FK_IDUSER_USERXPHONE` (`IDUSER`),
  CONSTRAINT `FK_IDPHONENUMBER_USERXPHONE` FOREIGN KEY (`IDPHONENUMBER`) REFERENCES `phonenumber` (`IDPHONENUMBER`),
  CONSTRAINT `FK_IDUSER_USERXPHONE` FOREIGN KEY (`IDUSER`) REFERENCES `users` (`IDUSER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userxphonenumber`
--

LOCK TABLES `userxphonenumber` WRITE;
/*!40000 ALTER TABLE `userxphonenumber` DISABLE KEYS */;
INSERT INTO `userxphonenumber` VALUES (8,7,1,NULL,NULL,NULL,NULL),(9,8,2,NULL,NULL,NULL,NULL),(10,9,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `userxphonenumber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `viewallusersinfo`
--

DROP TABLE IF EXISTS `viewallusersinfo`;
/*!50001 DROP VIEW IF EXISTS `viewallusersinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `viewallusersinfo` AS SELECT 
 1 AS `IDUSER`,
 1 AS `USERNAME`,
 1 AS `PASSWORD`,
 1 AS `FIRSTNAME`,
 1 AS `NAME`,
 1 AS `IDTYPE`,
 1 AS `GENDER`,
 1 AS `IDUSERTYPE`,
 1 AS `IDUSERTYPEDESC`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `viewhotelinfo`
--

DROP TABLE IF EXISTS `viewhotelinfo`;
/*!50001 DROP VIEW IF EXISTS `viewhotelinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `viewhotelinfo` AS SELECT 
 1 AS `IDHOTEL`,
 1 AS `NAME`,
 1 AS `IDDISCOUNT`,
 1 AS `IDDISTRICT`,
 1 AS `DISCOUNT`,
 1 AS `DISTRICT`,
 1 AS `CANTON`,
 1 AS `STATE`,
 1 AS `COUNTRY`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `viewreservation`
--

DROP TABLE IF EXISTS `viewreservation`;
/*!50001 DROP VIEW IF EXISTS `viewreservation`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `viewreservation` AS SELECT 
 1 AS `IDUSER`,
 1 AS `IDRESERVATION`,
 1 AS `ADMINPRICE`,
 1 AS `FIRSTNAME`,
 1 AS `ROOM`,
 1 AS `IDROOM`,
 1 AS `CAPACITY`,
 1 AS `NAMEPAYMENTMETHOD`,
 1 AS `ROOMCATEGORY`,
 1 AS `IDHOTEL`,
 1 AS `HOTELNAME`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `viewreviewshotel`
--

DROP TABLE IF EXISTS `viewreviewshotel`;
/*!50001 DROP VIEW IF EXISTS `viewreviewshotel`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `viewreviewshotel` AS SELECT 
 1 AS `HOTELNAME`,
 1 AS `IDHOTEL`,
 1 AS `ROOMNAME`,
 1 AS `CHECKIN`,
 1 AS `CHECKOUT`,
 1 AS `IDRESERVATION`,
 1 AS `FIRSTNAME`,
 1 AS `LASTNAME`,
 1 AS `STAR`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `viewroomshotel`
--

DROP TABLE IF EXISTS `viewroomshotel`;
/*!50001 DROP VIEW IF EXISTS `viewroomshotel`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `viewroomshotel` AS SELECT 
 1 AS `HOTELNAME`,
 1 AS `IDHOTEL`,
 1 AS `ROOMNAME`,
 1 AS `CAPACITY`,
 1 AS `RECOMMENDEDPRICE`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `amenityxroomview`
--

/*!50001 DROP VIEW IF EXISTS `amenityxroomview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `amenityxroomview` (`IDAMENITY`,`IDROOM`,`NAME`) AS select `amenity`.`IDAMENITY` AS `idamenity`,`amenityxroom`.`IDROOM` AS `idroom`,`amenity`.`NAME` AS `name` from (`amenityxroom` join `amenity` on((`amenity`.`IDAMENITY` = `amenityxroom`.`IDAMENITY`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `viewallusersinfo`
--

/*!50001 DROP VIEW IF EXISTS `viewallusersinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `viewallusersinfo` (`IDUSER`,`USERNAME`,`PASSWORD`,`FIRSTNAME`,`NAME`,`IDTYPE`,`GENDER`,`IDUSERTYPE`,`IDUSERTYPEDESC`) AS select `users`.`IDUSER` AS `idUser`,`users`.`USERNAME` AS `username`,`users`.`PASSWORD` AS `password`,`users`.`FIRSTNAME` AS `firstName`,`district`.`NAME` AS `name`,`idtype`.`NAME` AS `idType`,`gender`.`TYPE` AS `gender`,`usertype`.`IDUSERTYPE` AS `idUserType`,`usertype`.`DESCRIPTION` AS `idUserTypeDesc` from ((((`users` join `district` on((`users`.`IDDISTRICT` = `district`.`IDDISTRICT`))) join `idtype` on((`users`.`IDTYPE` = `idtype`.`IDIDTYPE`))) join `gender` on((`users`.`IDGENDER` = `gender`.`IDGENDER`))) join `usertype` on((`users`.`IDUSERTYPE` = `usertype`.`IDUSERTYPE`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `viewhotelinfo`
--

/*!50001 DROP VIEW IF EXISTS `viewhotelinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `viewhotelinfo` (`IDHOTEL`,`NAME`,`IDDISCOUNT`,`IDDISTRICT`,`DISCOUNT`,`DISTRICT`,`CANTON`,`STATE`,`COUNTRY`) AS select `hotel`.`IDHOTEL` AS `idhotel`,`hotel`.`NAME` AS `name`,`hotel`.`IDDISCOUNT` AS `iddiscount`,`hotel`.`IDDISTRICT` AS `iddistrict`,`discount`.`PERCENTAGE` AS `discount`,`district`.`NAME` AS `District`,`canton`.`NAME` AS `Canton`,`state`.`NAME` AS `state`,`country`.`NAME` AS `country` from ((((((`hotel` join `hotelclasification` on((`hotelclasification`.`IDHOTELCLASIFICATION` = `hotel`.`IDCLASIFICATION`))) join `discount` on((`discount`.`IDDISCOUNT` = `hotel`.`IDDISCOUNT`))) join `district` on((`district`.`IDDISTRICT` = `hotel`.`IDDISTRICT`))) join `canton` on((`canton`.`IDCANTON` = `district`.`IDCANTON`))) join `state` on((`state`.`IDSTATE` = `canton`.`IDSTATE`))) join `country` on((`country`.`IDCOUNTRY` = `state`.`IDCOUNTRY`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `viewreservation`
--

/*!50001 DROP VIEW IF EXISTS `viewreservation`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `viewreservation` (`IDUSER`,`IDRESERVATION`,`ADMINPRICE`,`FIRSTNAME`,`ROOM`,`IDROOM`,`CAPACITY`,`NAMEPAYMENTMETHOD`,`ROOMCATEGORY`,`IDHOTEL`,`HOTELNAME`) AS select `users`.`IDUSER` AS `idUser`,`reservation`.`IDRESERVATION` AS `idReservation`,`reservationxroom`.`ADMINPRICE` AS `adminprice`,`users`.`FIRSTNAME` AS `firstName`,`room`.`NAME` AS `Room`,`room`.`IDROOM` AS `idroom`,`room`.`CAPACITY` AS `capacity`,`paymentmethod`.`NAMEPAYMENTMETHOD` AS `namepaymentmethod`,`roomcategory`.`NAME` AS `roomcategory`,`hotel`.`IDHOTEL` AS `idHotel`,`hotel`.`NAME` AS `hotelName` from ((((((`reservation` join `reservationxroom` on((`reservation`.`IDRESERVATION` = `reservationxroom`.`IDRESERVATION`))) join `users` on((`reservation`.`IDUSER` = `users`.`IDUSER`))) join `room` on((`reservationxroom`.`IDROOM` = `room`.`IDROOM`))) join `hotel` on((`room`.`IDHOTEL` = `hotel`.`IDHOTEL`))) join `roomcategory` on((`room`.`IDROOMCATEGORY` = `roomcategory`.`IDROOMCATEGORY`))) join `paymentmethod` on((`reservation`.`IDPAYMENT` = `paymentmethod`.`IDPAYMENTMETHOD`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `viewreviewshotel`
--

/*!50001 DROP VIEW IF EXISTS `viewreviewshotel`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `viewreviewshotel` (`HOTELNAME`,`IDHOTEL`,`ROOMNAME`,`CHECKIN`,`CHECKOUT`,`IDRESERVATION`,`FIRSTNAME`,`LASTNAME`,`STAR`) AS select `h`.`NAME` AS `HOTELNAME`,`h`.`IDHOTEL` AS `idHotel`,`ro`.`NAME` AS `ROOMNAME`,`rxr`.`CHECKIN` AS `CheckIn`,`rxr`.`CHECKOUT` AS `CheckOut`,`re`.`IDRESERVATION` AS `idReservation`,`u`.`FIRSTNAME` AS `FirstName`,`u`.`LASTNAME` AS `LastName`,`rev`.`STAR` AS `Star` from (((((`hotel` `h` join `room` `ro` on((`h`.`IDHOTEL` = `ro`.`IDHOTEL`))) join `reservationxroom` `rxr` on((`ro`.`IDROOM` = `rxr`.`IDROOM`))) join `reservation` `re` on((`rxr`.`IDRESERVATION` = `re`.`IDRESERVATION`))) join `users` `u` on((`re`.`IDUSER` = `u`.`IDUSER`))) join `review` `rev` on((`re`.`IDRESERVATION` = `rev`.`IDRESERVATION`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `viewroomshotel`
--

/*!50001 DROP VIEW IF EXISTS `viewroomshotel`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `viewroomshotel` (`HOTELNAME`,`IDHOTEL`,`ROOMNAME`,`CAPACITY`,`RECOMMENDEDPRICE`) AS select `h`.`NAME` AS `HOTELNAME`,`h`.`IDHOTEL` AS `idHotel`,`ro`.`NAME` AS `ROOMNAME`,`ro`.`CAPACITY` AS `Capacity`,`ro`.`RECOMMENDEDPRICE` AS `RecommendedPrice` from (`hotel` `h` join `room` `ro` on((`h`.`IDHOTEL` = `ro`.`IDHOTEL`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-24 19:01:44
