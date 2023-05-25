-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: quiz_pratice
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `quiz_resultanswer`
--

DROP TABLE IF EXISTS `quiz_resultanswer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz_resultanswer` (
  `id_resans` int NOT NULL AUTO_INCREMENT,
  `id_result` int DEFAULT NULL,
  `id_question` int DEFAULT NULL,
  `id_answer` int DEFAULT NULL,
  PRIMARY KEY (`id_resans`),
  KEY `id_result` (`id_result`),
  KEY `id_question` (`id_question`),
  KEY `id_answer` (`id_answer`),
  CONSTRAINT `quiz_resultanswer_ibfk_1` FOREIGN KEY (`id_result`) REFERENCES `quiz_result` (`id_result`),
  CONSTRAINT `quiz_resultanswer_ibfk_2` FOREIGN KEY (`id_question`) REFERENCES `quiz_question` (`id_question`),
  CONSTRAINT `quiz_resultanswer_ibfk_3` FOREIGN KEY (`id_answer`) REFERENCES `quiz_answer` (`id_answer`)
) ENGINE=InnoDB AUTO_INCREMENT=353 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_resultanswer`
--

LOCK TABLES `quiz_resultanswer` WRITE;
/*!40000 ALTER TABLE `quiz_resultanswer` DISABLE KEYS */;
INSERT INTO `quiz_resultanswer` VALUES (338,6,1,1),(339,6,2,7),(340,6,3,11),(341,6,4,15),(342,6,5,17),(343,7,1,1),(344,8,1,1),(345,8,2,7),(346,8,3,12),(347,9,1,1),(348,10,1,1),(349,11,75,213),(350,11,76,219),(351,12,77,221),(352,12,78,226);
/*!40000 ALTER TABLE `quiz_resultanswer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-14 20:55:02
