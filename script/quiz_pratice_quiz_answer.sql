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
-- Table structure for table `quiz_answer`
--

DROP TABLE IF EXISTS `quiz_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz_answer` (
  `id_answer` int NOT NULL AUTO_INCREMENT,
  `id_question` int DEFAULT NULL,
  `content_answer` varchar(500) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `explaination` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_answer`),
  KEY `id_question` (`id_question`),
  CONSTRAINT `quiz_answer_ibfk_1` FOREIGN KEY (`id_question`) REFERENCES `quiz_question` (`id_question`)
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_answer`
--

LOCK TABLES `quiz_answer` WRITE;
/*!40000 ALTER TABLE `quiz_answer` DISABLE KEYS */;
INSERT INTO `quiz_answer` VALUES (1,1,'A.8',1,NULL),(2,1,'B.11',0,NULL),(3,1,'C.9',0,NULL),(4,1,'D.10',0,NULL),(5,2,'A.83433',0,NULL),(6,2,'B.82443',0,NULL),(7,2,'C.83543',1,NULL),(8,2,'D.82543',0,NULL),(9,3,'A.3',0,NULL),(10,3,'B.5',0,NULL),(11,3,'C.4',1,NULL),(12,3,'D.5',0,NULL),(13,4,'A.1000',0,NULL),(14,4,'B.1234',0,NULL),(15,4,'C.2007',1,NULL),(16,4,'D.100',0,NULL),(17,5,'A.94',0,NULL),(18,5,'B.940',0,NULL),(19,5,'C.904',1,NULL),(20,5,'D.9004',0,NULL),(21,6,'A.36',0,NULL),(22,6,'B.20',0,NULL),(23,6,'C.65',1,NULL),(24,6,'D.45',0,NULL),(77,7,'A.24',1,NULL),(78,7,'B.30',0,NULL),(79,7,'C.18',0,NULL),(80,7,'D.12',0,NULL),(81,8,'A.440',1,NULL),(82,8,'B.44',0,NULL),(83,8,'C.404',0,NULL),(84,8,'D.444',0,NULL),(85,9,'A.720',1,NULL),(86,9,'B.640',0,NULL),(87,9,'C.800',0,NULL),(88,9,'D.900',0,NULL),(89,10,'A.8700',0,NULL),(90,10,'B.6700',0,NULL),(91,10,'C.7600',0,NULL),(92,10,'D.7700',1,NULL),(93,11,'A. Thứ 4',0,NULL),(94,11,'B. Thứ 6',0,NULL),(95,11,'C.Thứ 5',0,NULL),(96,11,'D. Thứ 7',1,NULL),(97,12,'A.1011',0,NULL),(98,12,'B.1001',0,NULL),(99,12,'C.1000',1,NULL),(100,12,'D.1111',0,NULL),(101,13,'A.20',0,NULL),(102,13,'B.16',1,NULL),(103,13,'C.12',0,NULL),(104,13,'D.10',0,NULL),(105,14,'A.2007',0,NULL),(106,14,'B.2009',1,NULL),(107,14,'C.2017',0,NULL),(108,14,'D.2005',0,NULL),(109,15,'A.8',0,NULL),(110,15,'B.10',1,NULL),(111,15,'C.12',0,NULL),(112,15,'D.22',0,NULL),(113,16,'A.33',0,NULL),(114,16,'B.35',0,NULL),(115,16,'C.34',1,NULL),(116,16,'D.25',0,NULL),(117,17,'A. a:1=a',1,NULL),(118,17,'B. b:1=1',0,NULL),(119,17,'C. a:0=0',0,NULL),(120,17,'D. 1:b=b',0,NULL),(121,18,'A.9899',1,NULL),(122,18,'B.9999',0,NULL),(123,18,'C.9888',0,NULL),(124,18,'D.8888',0,NULL),(125,19,'A. 8 bạn, còn thừa 1 viên',0,NULL),(126,19,'B. 7 bạn, còn thừa 1 viên',1,NULL),(127,19,'C. 7 bạn',0,NULL),(128,19,'D. 8 bạn ',0,NULL),(129,20,'A. 29',1,NULL),(130,20,'B. 32',0,NULL),(131,20,'C. 30',0,NULL),(132,20,'D. 28',0,NULL),(133,21,'A. play',0,NULL),(134,21,'B. Plays',0,NULL),(135,21,'C. Playing',1,NULL),(136,21,'D. to playing',0,NULL),(137,22,'A. in',1,NULL),(138,22,'B. at',0,NULL),(139,22,'C. to',0,NULL),(140,22,'D. on',0,NULL),(141,57,'A. many',0,NULL),(142,57,'B. often',1,NULL),(143,57,'C. long',0,NULL),(144,57,'D. far',0,NULL),(145,58,'A. one',0,NULL),(146,58,'B. one time',0,NULL),(147,58,'C. once',1,NULL),(148,58,'D. once time',0,NULL),(149,59,'A. does',0,NULL),(150,59,'B. is',0,NULL),(151,59,'C. goes',1,NULL),(152,59,'D. plays',0,NULL),(153,60,'A. does',1,NULL),(154,60,'B. do',0,NULL),(155,60,'C is',0,NULL),(156,60,'D. why',0,NULL),(157,61,'A. go',0,NULL),(158,61,'B. to go',0,NULL),(159,61,'C. To going',0,NULL),(160,61,'D. going',1,NULL),(161,62,'A. what',1,NULL),(162,62,'B. who',0,NULL),(163,62,'C. which',0,NULL),(164,62,'D. when',0,NULL),(165,63,'A. like',0,NULL),(166,63,'B. likes',1,NULL),(167,63,'C. liking',0,NULL),(168,63,'D. to like',0,NULL),(169,64,'A. He plays table tennis',1,NULL),(170,64,'B. he is playing table tennis',0,NULL),(171,64,'C. He is going to play table tennis',0,NULL),(172,64,'D. yes , he does',0,NULL),(173,65,'A. come',0,NULL),(174,65,'B. stay',0,NULL),(175,65,'C. look',0,NULL),(176,65,'D. visit',1,NULL),(177,66,'A. hours',0,NULL),(178,66,'B. weeks',0,NULL),(179,66,'C. days',1,NULL),(180,66,'D. years',0,NULL),(181,67,'A. is',0,NULL),(182,67,'B. would',1,NULL),(183,67,'C. do',0,NULL),(184,67,'D. does',0,NULL),(185,68,'A. like',0,NULL),(186,68,'B. is like',0,NULL),(187,68,'C. likes',1,NULL),(188,68,'D. would',0,NULL),(189,69,'A. hungry',0,NULL),(190,69,'B. tired',0,NULL),(191,69,'C. thirsty',1,NULL),(192,69,'D. cold',0,NULL),(193,70,'A. do',1,NULL),(194,70,'B. go',0,NULL),(195,70,'C. like',0,NULL),(196,70,'D. are',0,NULL),(197,71,'A. many',0,NULL),(198,71,'B. much',0,NULL),(199,71,'C. often',1,NULL),(200,71,'D. old',0,NULL),(201,72,'A. play',0,NULL),(202,72,'B. playing',1,NULL),(203,72,'C. watch',0,NULL),(204,72,'D. watches',0,NULL),(205,73,'A. Who',0,NULL),(206,73,'B. What',0,NULL),(207,73,'C. How',0,NULL),(208,73,'D. Which',1,NULL),(209,74,'A. spring',0,NULL),(210,74,'B. winter',0,NULL),(211,74,'C. summer',1,NULL),(212,74,'D. Fall',0,NULL),(213,75,'2',0,NULL),(214,75,'3',0,NULL),(215,75,'4',1,NULL),(216,75,'5',0,NULL),(217,76,'a',0,NULL),(218,76,'v',0,NULL),(219,76,'b',1,NULL),(220,76,'s',0,NULL),(221,77,'2',0,NULL),(222,77,'4',0,NULL),(223,77,'5',1,NULL),(224,77,'7',0,NULL),(225,78,'B',0,NULL),(226,78,'C',1,NULL),(227,78,'D',0,NULL),(228,78,'E',0,NULL);
/*!40000 ALTER TABLE `quiz_answer` ENABLE KEYS */;
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
