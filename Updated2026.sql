CREATE DATABASE  IF NOT EXISTS `librarydatabase` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `librarydatabase`;
-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: librarydatabase
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `tbl_accountlogin`
--

DROP TABLE IF EXISTS `tbl_accountlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_accountlogin` (
  `col_AccountId` int NOT NULL AUTO_INCREMENT,
  `col_AccountUsername` varchar(50) NOT NULL,
  `col_AccountPassword` varchar(255) NOT NULL,
  `col_AccountEmail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`col_AccountId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_accountlogin`
--

LOCK TABLES `tbl_accountlogin` WRITE;
/*!40000 ALTER TABLE `tbl_accountlogin` DISABLE KEYS */;
INSERT INTO `tbl_accountlogin` VALUES (1,'admin','yxZX4+h1QEACMUGZtF15FQ==','admin@libranix.com');
/*!40000 ALTER TABLE `tbl_accountlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_bookdetails`
--

DROP TABLE IF EXISTS `tbl_bookdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_bookdetails` (
  `col_BookId` int NOT NULL AUTO_INCREMENT,
  `col_BookTitle` varchar(50) NOT NULL,
  `col_BookAuthor` varchar(45) NOT NULL,
  `col_BookWriter` varchar(45) NOT NULL,
  `col_BookPublisher` varchar(50) DEFAULT NULL,
  `col_BookIsbn` varchar(13) DEFAULT NULL,
  `col_BookType` enum('Fiction','Non-fiction') DEFAULT NULL,
  `col_BookImg` varchar(45) NOT NULL DEFAULT 'Book',
  PRIMARY KEY (`col_BookId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_bookdetails`
--

LOCK TABLES `tbl_bookdetails` WRITE;
/*!40000 ALTER TABLE `tbl_bookdetails` DISABLE KEYS */;
INSERT INTO `tbl_bookdetails` VALUES (33,'Exit West','Mohsin Hamid','Mohsin Hamid','Reluctant','133-3444-3444','Fiction','exit.jpg');
/*!40000 ALTER TABLE `tbl_bookdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_bookgenre`
--

DROP TABLE IF EXISTS `tbl_bookgenre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_bookgenre` (
  `col_BookId` int NOT NULL AUTO_INCREMENT,
  `col_BookGenre` varchar(50) NOT NULL,
  PRIMARY KEY (`col_BookId`),
  KEY `col_BookId_idx` (`col_BookId`),
  CONSTRAINT `col_BookIdGenre` FOREIGN KEY (`col_BookId`) REFERENCES `tbl_bookdetails` (`col_BookId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_bookgenre`
--

LOCK TABLES `tbl_bookgenre` WRITE;
/*!40000 ALTER TABLE `tbl_bookgenre` DISABLE KEYS */;
INSERT INTO `tbl_bookgenre` VALUES (33,'Alternate history');
/*!40000 ALTER TABLE `tbl_bookgenre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_bookquantity`
--

DROP TABLE IF EXISTS `tbl_bookquantity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_bookquantity` (
  `col_BookId` int NOT NULL AUTO_INCREMENT,
  `col_BookQuantity` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`col_BookId`),
  KEY `col_BookIdQuantity_idx` (`col_BookId`),
  CONSTRAINT `col_BookIdQuantity` FOREIGN KEY (`col_BookId`) REFERENCES `tbl_bookdetails` (`col_BookId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_bookquantity`
--

LOCK TABLES `tbl_bookquantity` WRITE;
/*!40000 ALTER TABLE `tbl_bookquantity` DISABLE KEYS */;
INSERT INTO `tbl_bookquantity` VALUES (33,19);
/*!40000 ALTER TABLE `tbl_bookquantity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_borrowedbooks`
--

DROP TABLE IF EXISTS `tbl_borrowedbooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_borrowedbooks` (
  `col_BorrowId` int NOT NULL AUTO_INCREMENT,
  `col_BookId` int NOT NULL,
  `col_MemberId` int NOT NULL,
  `col_BookQuantity` int(2) unsigned zerofill NOT NULL DEFAULT '01',
  PRIMARY KEY (`col_BorrowId`,`col_MemberId`,`col_BookId`),
  KEY `col_BookIdBorrow_idx` (`col_BookId`),
  KEY `col_MemberIdBorrow_idx` (`col_MemberId`),
  CONSTRAINT `col_BookIdBorrow` FOREIGN KEY (`col_BookId`) REFERENCES `tbl_bookdetails` (`col_BookId`),
  CONSTRAINT `col_MemberIdBorrow` FOREIGN KEY (`col_MemberId`) REFERENCES `tbl_memberdetails` (`col_MemberId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_borrowedbooks`
--

LOCK TABLES `tbl_borrowedbooks` WRITE;
/*!40000 ALTER TABLE `tbl_borrowedbooks` DISABLE KEYS */;
INSERT INTO `tbl_borrowedbooks` VALUES (23,33,11,01);
/*!40000 ALTER TABLE `tbl_borrowedbooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_membercontacts`
--

DROP TABLE IF EXISTS `tbl_membercontacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_membercontacts` (
  `col_MemberId` int NOT NULL AUTO_INCREMENT,
  `col_MemberContactNo` varchar(45) NOT NULL,
  PRIMARY KEY (`col_MemberId`),
  KEY `col_BookId_idx` (`col_MemberId`),
  CONSTRAINT `col_MemberIdContact` FOREIGN KEY (`col_MemberId`) REFERENCES `tbl_memberdetails` (`col_MemberId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_membercontacts`
--

LOCK TABLES `tbl_membercontacts` WRITE;
/*!40000 ALTER TABLE `tbl_membercontacts` DISABLE KEYS */;
INSERT INTO `tbl_membercontacts` VALUES (11,'+1434023575');
/*!40000 ALTER TABLE `tbl_membercontacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_memberdetails`
--

DROP TABLE IF EXISTS `tbl_memberdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_memberdetails` (
  `col_MemberId` int NOT NULL AUTO_INCREMENT,
  `col_MemberFirstName` varchar(50) NOT NULL,
  `col_MemberMiddleName` varchar(50) NOT NULL,
  `col_MemberLastName` varchar(50) NOT NULL,
  `col_MemberSex` enum('Male','Female') NOT NULL,
  `col_MemberBirthDate` date DEFAULT NULL,
  `col_MemberAddress` varchar(11) NOT NULL,
  `col_MemberEmail` varchar(254) NOT NULL,
  `col_MemberImg` varchar(45) NOT NULL DEFAULT 'Member',
  PRIMARY KEY (`col_MemberId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_memberdetails`
--

LOCK TABLES `tbl_memberdetails` WRITE;
/*!40000 ALTER TABLE `tbl_memberdetails` DISABLE KEYS */;
INSERT INTO `tbl_memberdetails` VALUES (11,'Curtis','Johnson','Garand','Male','2003-01-03','Rald Street','curt@gmail.com','cur.jpg');
/*!40000 ALTER TABLE `tbl_memberdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'librarydatabase'
--

--
-- Dumping routines for database 'librarydatabase'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-07-22 18:14:59
