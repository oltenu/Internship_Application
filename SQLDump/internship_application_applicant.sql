CREATE DATABASE  IF NOT EXISTS `internship_application` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `internship_application`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: internship_application
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicant` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address_line_1` varchar(255) DEFAULT NULL,
  `address_line_2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `employer_id` bigint DEFAULT NULL,
  `job_listing_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmid4fqrhl8k0pcv0a3fqg9bmm` (`employer_id`),
  KEY `FKr9q3o8ug6kk71sc25xg10tk7o` (`job_listing_id`),
  CONSTRAINT `FKmid4fqrhl8k0pcv0a3fqg9bmm` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`id`),
  CONSTRAINT `FKr9q3o8ug6kk71sc25xg10tk7o` FOREIGN KEY (`job_listing_id`) REFERENCES `job_listing` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant`
--

LOCK TABLES `applicant` WRITE;
/*!40000 ALTER TABLE `applicant` DISABLE KEYS */;
INSERT INTO `applicant` VALUES (1,'Strada Libertatii, Nr. 1',NULL,'Bucuresti','Romania','popion@gmail.com','Ion','Popescu','0712345678',NULL,1,1),(2,'Strada Unirii, Nr. 14',NULL,'Orsova','Romania','mar@yahoo.com','Marius','Ionescu','0712345678',NULL,1,1),(3,'Strada Florilor, Nr. 5',NULL,'Oradea','Romania','angela@gmail.com','Angela','Marinescu','0712345678',NULL,1,1),(4,'Hemingway Street, Nr. 87',NULL,'London','UK','lenon@gmail.com','John','Lenon','0712345678',NULL,1,1),(5,'Strada Marinei, Nr. 33',NULL,'Iasi','Romania','moisee@domain.com','Ioana','Moise','0712345678',NULL,1,1),(6,'Washington Street, Nr. 49',NULL,'New York City','USA','geo@yahoo.com','George','Clooney','0712345678',NULL,1,2),(7,'Strada Cosbuc, Nr. 18',NULL,'Dej','Romania','claucn@gmail.com','Claudiu','Condurache','0712345678',NULL,1,2),(8,'Strada Eminescu, Nr. 11',NULL,'Baia Mare','Romania','popRadu@gmail.com','Radu','Pop','0712345678',NULL,1,2),(9,'Strada Minerilor, Nr. 90',NULL,'Baia Sprie','Romania','nazucarla@gmail.com','Carla','Nazu','0712345678',NULL,1,2),(10,'Villebois Mareuil, Nr. 67',NULL,'Rennes','Franta','anne@gmail.com','Anne','Gachou','0712345678',NULL,1,2),(11,'Strada Iuliu Maniu, Nr. 112',NULL,'Craiova','Romania','ratiu@gmail.com','Camelia','Ratiu','0712345678',NULL,2,3),(12,'Strada Garcea, Nr. 24',NULL,'Galati','Romania','patragheo@yahoo.com','Gheorghe','Patrascu','0712345678',NULL,2,3),(13,'Strada Eroilor, Nr. 51',NULL,'Timisoara','Romania','Bob@gmail.com','Maria','Bob','0712345678',NULL,2,3),(14,'Strada Regina Maria, Nr. 817',NULL,'Chisinau','Moldova','Marce@gmail.com','Marcel','Bud','0712345678',NULL,2,3),(15,'Strada Hans-Fischer, Nr. 20',NULL,'Munchen','Germania','cori@domain.com','Corina','Mole','0712345678',NULL,2,3),(16,'Strada Rebreanu, Nr. 19',NULL,'Gherla','Romania','pascu@yahoo.com','Samuel','Pascu','0712345678',NULL,2,4),(17,'Strada Cosbuc, Nr. 28',NULL,'Iasi','Romania','claucn@gmail.com','Alex','Nedea','0712345678',NULL,2,4),(18,'Strada Cetatii, Nr. 111',NULL,'Baia de Aries','Romania','Moga@gmail.com','Alexandra','Moga','0712345678',NULL,2,4),(19,'Strada Minerilor, Nr. 910',NULL,'Deva','Romania','luca@gmail.com','Luca','Breban','0712345678',NULL,2,4),(20,'Strada Eroilor, Nr. 77',NULL,'Cluj-Napoca','Romania','neagu@gmail.com','Narcisa','Neagu','0712345678',NULL,2,4);
/*!40000 ALTER TABLE `applicant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-12 21:37:14
