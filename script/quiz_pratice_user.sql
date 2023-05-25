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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `name_user` varchar(100) DEFAULT NULL,
  `id_user` int NOT NULL AUTO_INCREMENT,
  `birthDate` date DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `id_role` int DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `id_role` (`id_role`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Le Son Hai',1,'0033-09-23','0969790938',1,1,'sonhai1411@gmail.com','Ha Noii ','1411',1),('Ngo Hong Thang',2,'2005-12-12','0969799956',1,1,'hongthang394@gmail.com','Quang Ninh','1234',1),('Nguyễn Thanh Long',3,'0006-08-23','0869517063',1,1,'sonbach317.hy@gmail.com','Ha Nam','1234',1),('Dư Lê Minh',8,'0025-06-25','0986303295',0,3,'sonbach3176.hy@gmail.com','Hung Yen','1234',0),('hophanamokee@gmail.com',14,'0006-06-30','0132465789',1,1,'hophanamokee@gmail.com','Khu 6 Phuong Phong Hai Thi xa Quang Yen Tinh Quang Ninh','1234',1),('Thang',15,'0034-06-30','0383053428',1,1,'thangnhhe163975@fpt.edu.vn','tran khat tran','123',1),('Thang That Tha',16,'0006-08-28','0132456689',0,1,'sonhai1411@gmail.com','QN','1234',1),('Thang That Tha',17,'0019-10-28','0123456788',1,1,'sonhai1411@gmail.com','Khu 6 Phuong Phong Hai Thi xa Quang Yen Tinh Quang Ninh','123456',1),('Thang That Tha',18,'0019-10-28','0969790938',1,1,'sonhai1421@gmail.com','Khu 6 Phuong Phong Hai Thi xa Quang Yen Tinh Quang Ninh','123456',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-14 20:55:03
