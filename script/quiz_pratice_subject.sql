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
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id_subject` int NOT NULL AUTO_INCREMENT,
  `id_user` int DEFAULT NULL,
  `name_subject` varchar(50) DEFAULT NULL,
  `description_subject` varchar(1000) DEFAULT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `id_subcate` int DEFAULT NULL,
  `grade` int DEFAULT NULL,
  PRIMARY KEY (`id_subject`),
  KEY `id_user` (`id_user`),
  KEY `id_subcate` (`id_subcate`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`id_subcate`) REFERENCES `subjectcategory` (`id_subcate`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,1,'Math 10','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.\r Whatever you do, do it slowly, do not rush, rush, do it irresponsibly, but do it properly and decisively with all your heart. You have to get used to this trait: never do anything but do it for free, reluctantly, carelessly and have to do it a second time.\r A highly cultured person is someone whose soul is very broad, can tolerate all different opinions, does not have prejudices or one-sided thoughts, and always sees all sides and opposites of things. life. Therefore, in order to have a high and wide soul, you must have at least a broad education in all aspects, including both east and west, ancient needles. He who firmly believes that he alone holds the absolute truth has no generous tolerance. Especially not being a profound psychologist.Trust in yourself!','math.png',1,10),(2,1,'English 11','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','english.png',1,11),(3,2,'History 12','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','history.png',3,12),(4,3,'Literature 10','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','literature.png',3,10),(5,2,'Geography 11','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','geography.png',2,11),(6,1,'Physic 12','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','physic.png',1,12),(7,2,'Chemistry 10','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','chemistry.png',1,10),(8,2,'Biology 11','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','biology.png',2,11),(13,1,'Math 11','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','math.png',1,11),(14,1,'Math 12','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','math.png',1,12),(15,2,'History 10','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','history.png',3,10),(16,2,'History 11','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','history.png',3,11),(17,3,'Literature 11','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','literature.png',3,11),(18,3,'Literature 12','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','literature.png',3,12),(19,2,'Geography 10','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','geography.png',2,10),(20,2,'Geography 12','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','geography.png',2,12),(21,1,'Physic 11','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','physic.png',1,11),(22,1,'Physic 10','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','physic.png',1,10),(23,2,'Chemistry 11','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','chemistry.png',1,11),(24,2,'Chemistry 12','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','chemistry.png',1,12),(25,2,'Biology 10','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','biology.png',2,10),(26,2,'Biology 12','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','biology.png',2,12),(27,1,'English 10','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','english.png',1,10),(28,1,'English 12','Writing good writing is very difficult and not everyone can do it, but if it\'s not so bad, anyone can do it, as long as you know how to avoid writing in clichés and know what to say directly. long time.','english.png',1,12);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-14 20:55:04
