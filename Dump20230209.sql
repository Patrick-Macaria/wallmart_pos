CREATE DATABASE  IF NOT EXISTS `wallmart` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `wallmart`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: wallmart
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `EmployeePhoto` varchar(100) NOT NULL,
  `EmployeeNumber` int NOT NULL,
  `JobTitle` varchar(100) NOT NULL,
  `Id_No` int NOT NULL,
  `FirstName` varchar(100) NOT NULL,
  `LastNmae` varchar(100) NOT NULL,
  `Surname` varchar(100) NOT NULL,
  `HomeAddress` varchar(100) NOT NULL,
  `EmailAddress` varchar(100) NOT NULL,
  `Phone_number` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `onlinecustomer`
--

DROP TABLE IF EXISTS `onlinecustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `onlinecustomer` (
  `OrderNumber` int NOT NULL,
  `EmailAdderess` varchar(100) NOT NULL,
  `HomeAddress` varchar(100) NOT NULL,
  `PhoneNumber` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `onlinecustomer`
--

LOCK TABLES `onlinecustomer` WRITE;
/*!40000 ALTER TABLE `onlinecustomer` DISABLE KEYS */;
/*!40000 ALTER TABLE `onlinecustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `OrderNumber` int NOT NULL,
  `PlacedTo` varchar(100) NOT NULL,
  `DatePlaced` varchar(30) NOT NULL,
  `PlacedBy` varchar(100) NOT NULL,
  `DateDeliverd` varchar(30) NOT NULL,
  `TimeDeliverd` varchar(20) NOT NULL,
  `MFD` varchar(30) NOT NULL,
  `EXD` varchar(30) NOT NULL,
  `DeliveredBy` varchar(100) NOT NULL,
  `ReceivedBy` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodicalemployees`
--

DROP TABLE IF EXISTS `periodicalemployees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodicalemployees` (
  `EmployeePhoto` varchar(100) NOT NULL,
  `EmployeeNumber` int NOT NULL,
  `JobTitle` varchar(100) NOT NULL,
  `Id_No` int NOT NULL,
  `FirstName` varchar(100) NOT NULL,
  `LastNmae` varchar(100) NOT NULL,
  `Surname` varchar(100) NOT NULL,
  `HomeAddress` varchar(100) NOT NULL,
  `EmailAddress` varchar(100) NOT NULL,
  `Phone_number` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodicalemployees`
--

LOCK TABLES `periodicalemployees` WRITE;
/*!40000 ALTER TABLE `periodicalemployees` DISABLE KEYS */;
/*!40000 ALTER TABLE `periodicalemployees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_photo` varchar(100) DEFAULT NULL,
  `product_code` int DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `quantity_in_stock` varchar(100) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('',5,'X-Box','-2','48000'),('',2,'Ps','22','54000'),('',4,'Prado','57','15000'),('',6,'Powerbank Lenovo','68','2200'),('',11,'MacBook','0','200000');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shippers`
--

DROP TABLE IF EXISTS `shippers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shippers` (
  `ProductShipped` varchar(100) NOT NULL,
  `ShippersName` varchar(100) NOT NULL,
  `ShippersAddress` varchar(100) NOT NULL,
  `ShippersEmailAddress` varchar(100) NOT NULL,
  `ShippersContacts` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shippers`
--

LOCK TABLES `shippers` WRITE;
/*!40000 ALTER TABLE `shippers` DISABLE KEYS */;
/*!40000 ALTER TABLE `shippers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `empId` int NOT NULL AUTO_INCREMENT,
  `empPin` int NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `emailAddress` varchar(100) DEFAULT NULL,
  `physicalAddress` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(30) DEFAULT NULL,
  `empStatus` varchar(50) NOT NULL,
  `empPhoto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,2222,'wall','mart',NULL,NULL,NULL,'Cashier',NULL),(3,3333,'christie','saverin',NULL,NULL,NULL,'Cashier',NULL),(4,4444,'alice','elliot',NULL,NULL,NULL,'Cashier',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-09 10:10:15
