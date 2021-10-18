CREATE DATABASE  IF NOT EXISTS `librarydatabase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `librarydatabase`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: librarydatabase
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Table structure for table `tbl_bookdetails`
--

DROP TABLE IF EXISTS `tbl_bookdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_bookdetails` (
  `col_BookId` int(6) NOT NULL AUTO_INCREMENT,
  `col_BookTitle` varchar(50) NOT NULL,
  `col_BookAuthor` varchar(45) NOT NULL,
  `col_BookWriter` varchar(45) NOT NULL,
  `col_BookPublisher` varchar(50) DEFAULT NULL,
  `col_BookIsbn` varchar(13) DEFAULT NULL,
  `col_BookType` enum('Fiction','Non-fiction') DEFAULT NULL,
  `col_BookImg` varchar(45) NOT NULL DEFAULT 'Book',
  PRIMARY KEY (`col_BookId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_bookdetails`
--

LOCK TABLES `tbl_bookdetails` WRITE;
/*!40000 ALTER TABLE `tbl_bookdetails` DISABLE KEYS */;
INSERT INTO `tbl_bookdetails` VALUES (6,'WhiteLies','Lisa','Ayami','WhiteK','344-33-444-34','Fiction','Book'),(7,'Black sea','Retrun','Tyrome','Niger Media','3444-338-83-4','Fiction','Book'),(9,'501st Journal','Rex','Kix','Republic Media','555-555-555-5','Non-fiction','Book'),(11,'A4Tech','Gruth','Thruth','Root Tech Media','34-44-23-2334','Non-fiction','Book'),(12,'BeeHiveFive','Joseph','Heckler','Five Media','2334-344-2-54','Non-fiction','Book'),(14,'Hellfire','Baldwin','Gramp','Jack Media','1234-56-978-9','Fiction','Book'),(15,'Grand Plan','Sheev','Ganj','Empire Media','3445-233-22-3','Fiction','Book'),(16,'Rock Art','Kevin','Ash','Metal Media','230-43-23-666','Non-fiction','Book'),(18,'Addition and Substraction','Manny','Lother','Math Media','933-678-23-55','Non-fiction','Book'),(20,'BrunoHash','Grue','Bronze','Light Media','233-23-422-33','Non-fiction','Book'),(25,'The ape','George','Lackey','LG Media','34-333-11-3-9','Fiction','Book'),(26,'DataLost','Herbert','Janet','TechI Media','34-3-444-33-9','Fiction','Book'),(27,'The space','DrHusk','Justin Fook','GSpace Media','344-33-77-5-5','Non-fiction','Book'),(28,'asdasd','asdasd','sadasd','sadad','32423432','Non-fiction','Book'),(29,'TestBook1','sass','Writher','dasdasda','34234234234','Non-fiction','a1wkBNKe_700w_0.jpg'),(30,'dasda','asddas','dasdasd','asd','3242342','Fiction','D:PicturesKawaiidesu6992751_1440593710.png'),(31,'test','das','das','343','234234','Fiction','null'),(32,'Test','asdasd','asdasd','asdasd','234234','Fiction','6992751_1440593710.png');
/*!40000 ALTER TABLE `tbl_bookdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_bookgenre`
--

DROP TABLE IF EXISTS `tbl_bookgenre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_bookgenre` (
  `col_BookId` int(6) NOT NULL AUTO_INCREMENT,
  `col_BookGenre` varchar(50) NOT NULL,
  PRIMARY KEY (`col_BookId`),
  KEY `col_BookId_idx` (`col_BookId`),
  CONSTRAINT `col_BookIdGenre` FOREIGN KEY (`col_BookId`) REFERENCES `tbl_bookdetails` (`col_BookId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_bookgenre`
--

LOCK TABLES `tbl_bookgenre` WRITE;
/*!40000 ALTER TABLE `tbl_bookgenre` DISABLE KEYS */;
INSERT INTO `tbl_bookgenre` VALUES (6,'Horror'),(7,'Action and adventure'),(9,'Journal'),(11,'Art'),(12,'Guide'),(14,'Action and adventure'),(15,'Action and adventure'),(16,'Art'),(18,'Textbook'),(20,'Memoir'),(25,'Alternate history'),(26,'Science fiction'),(27,'Journal'),(28,'Autobiography'),(29,'Autobiography'),(30,'Action and adventure'),(31,'Action and adventure'),(32,'Action and adventure');
/*!40000 ALTER TABLE `tbl_bookgenre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_bookquantity`
--

DROP TABLE IF EXISTS `tbl_bookquantity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_bookquantity` (
  `col_BookId` int(6) NOT NULL AUTO_INCREMENT,
  `col_BookQuantity` int(5) NOT NULL DEFAULT '1',
  PRIMARY KEY (`col_BookId`),
  KEY `col_BookIdQuantity_idx` (`col_BookId`),
  CONSTRAINT `col_BookIdQuantity` FOREIGN KEY (`col_BookId`) REFERENCES `tbl_bookdetails` (`col_BookId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_bookquantity`
--

LOCK TABLES `tbl_bookquantity` WRITE;
/*!40000 ALTER TABLE `tbl_bookquantity` DISABLE KEYS */;
INSERT INTO `tbl_bookquantity` VALUES (6,81),(7,12),(9,35),(11,85),(12,70),(14,57),(15,74),(16,35),(18,40),(20,76),(25,45),(26,67),(27,80),(28,34),(29,32),(30,23),(31,34),(32,23);
/*!40000 ALTER TABLE `tbl_bookquantity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_borrowedbooks`
--

DROP TABLE IF EXISTS `tbl_borrowedbooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_borrowedbooks` (
  `col_BorrowId` int(6) NOT NULL AUTO_INCREMENT,
  `col_BookId` int(6) NOT NULL,
  `col_MemberId` int(5) NOT NULL,
  `col_BookQuantity` int(2) unsigned zerofill NOT NULL DEFAULT '01',
  PRIMARY KEY (`col_BorrowId`,`col_MemberId`,`col_BookId`),
  KEY `col_BookIdBorrow_idx` (`col_BookId`),
  KEY `col_MemberIdBorrow_idx` (`col_MemberId`),
  CONSTRAINT `col_BookIdBorrow` FOREIGN KEY (`col_BookId`) REFERENCES `tbl_bookdetails` (`col_BookId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `col_MemberIdBorrow` FOREIGN KEY (`col_MemberId`) REFERENCES `tbl_memberdetails` (`col_MemberId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_borrowedbooks`
--

LOCK TABLES `tbl_borrowedbooks` WRITE;
/*!40000 ALTER TABLE `tbl_borrowedbooks` DISABLE KEYS */;
INSERT INTO `tbl_borrowedbooks` VALUES (2,7,3,01),(5,9,3,01),(8,11,3,01),(10,11,2,20),(11,14,1,12),(13,15,1,13),(14,12,1,08),(15,18,9,05),(16,16,10,05),(17,7,9,05),(18,27,3,05),(19,27,8,02),(20,29,10,02);
/*!40000 ALTER TABLE `tbl_borrowedbooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_membercontacts`
--

DROP TABLE IF EXISTS `tbl_membercontacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_membercontacts` (
  `col_MemberId` int(5) NOT NULL AUTO_INCREMENT,
  `col_MemberContactNo` varchar(45) NOT NULL,
  PRIMARY KEY (`col_MemberId`),
  KEY `col_BookId_idx` (`col_MemberId`),
  CONSTRAINT `col_MemberIdContact` FOREIGN KEY (`col_MemberId`) REFERENCES `tbl_memberdetails` (`col_MemberId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_membercontacts`
--

LOCK TABLES `tbl_membercontacts` WRITE;
/*!40000 ALTER TABLE `tbl_membercontacts` DISABLE KEYS */;
INSERT INTO `tbl_membercontacts` VALUES (1,'09344343'),(2,'444-333'),(3,'6116'),(6,'92727'),(8,'9747932444343'),(9,'0947367467'),(10,'639171002082');
/*!40000 ALTER TABLE `tbl_membercontacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_memberdetails`
--

DROP TABLE IF EXISTS `tbl_memberdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_memberdetails` (
  `col_MemberId` int(5) NOT NULL AUTO_INCREMENT,
  `col_MemberFirstName` varchar(50) NOT NULL,
  `col_MemberMiddleName` varchar(50) NOT NULL,
  `col_MemberLastName` varchar(50) NOT NULL,
  `col_MemberSex` enum('Male','Female') NOT NULL,
  `col_MemberBirthDate` date DEFAULT NULL,
  `col_MemberAddress` varchar(11) NOT NULL,
  `col_MemberEmail` varchar(254) NOT NULL,
  `col_MemberImg` varchar(45) NOT NULL DEFAULT 'Member',
  PRIMARY KEY (`col_MemberId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_memberdetails`
--

LOCK TABLES `tbl_memberdetails` WRITE;
/*!40000 ALTER TABLE `tbl_memberdetails` DISABLE KEYS */;
INSERT INTO `tbl_memberdetails` VALUES (1,'John','Smith','Doe','Male','1960-05-13','Sesame St','john@doe.com','Member'),(2,'Jane','Smith','Doe','Male','1963-04-23','Same St','jane@doe.com','Member'),(3,'Kix','Trooper','Republic','Male','1999-07-04','Kamino','cloning@kam.com','Member'),(6,'John','Black','Prick','Male','1980-04-06','Trash City','JohnnyPrick@gmail.com','f2a5120f5ddd11e42154144b5e399737_480.jpg'),(8,'Lexus','Dammos','Zuchious','Male','1930-04-04','Dark vil','lexus@darknet.com','-1991625598.jpg'),(9,'Umaru','Chan','Domo','Female','2000-03-01','Shiba','umaru@anime.net','15193512_3555831214.jpg'),(10,'Kahn','Cliff','Clifford','Male','1990-03-02','CliffDeath','kahnclifford@gmail.com','Capture.PNG');
/*!40000 ALTER TABLE `tbl_memberdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-04 12:59:19
