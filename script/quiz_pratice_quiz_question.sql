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
-- Table structure for table `quiz_question`
--

DROP TABLE IF EXISTS `quiz_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz_question` (
  `id_question` int NOT NULL AUTO_INCREMENT,
  `id_quiz` int DEFAULT NULL,
  `content_question` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_question`),
  KEY `id_quiz` (`id_quiz`),
  CONSTRAINT `quiz_question_ibfk_1` FOREIGN KEY (`id_quiz`) REFERENCES `quiz` (`id_quiz`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_question`
--

LOCK TABLES `quiz_question` WRITE;
/*!40000 ALTER TABLE `quiz_question` DISABLE KEYS */;
INSERT INTO `quiz_question` VALUES (1,1,'Cho dãy số liệu: 8; 1998; 195; 2007; 1000; 71 768; 9999; 17. Dãy trên có tất cả bao nhiêu số:'),(2,1,'Tổng của 47 856 và 35 687 là:'),(3,1,'Mai có 7 viên bi, Hồng có 15 viên bi. Hỏi Hồng phải cho Mai bao nhiêu viên bi để số bi của hai bạn bằng nhau.'),(4,1,'Trong các số dưới đây, số nào không thuộc dãy số: 1, 4, 7, 10, 13, ...'),(5,1,'9m 4cm= ... cm'),(6,1,'AB = 5cm, BD= 13cm. Diện tích hình chữ nhật ABDC là:'),(7,1,' Dùng 4 chữ số lẻ: 1, 3, 5, 7 để viết tất cả các số có 4 chữ số khác nhau thì viết được bao nhiêu số:'),(8,1,' 4m 4 dm = ................... cm. Số thích hợp điền vào chỗ chấm là'),(9,1,'Một người đi bộ trong 6 phút đi được 480 m. Hỏi trong 9 phút người đó đi được bao nhiêu m đường (Quãng đường trong mỗi phút đi đều như nhau)?'),(10,1,'Tìm x biết: 8462 - x = 762'),(11,1,'Hôm nay là thứ năm. Hỏi 100 ngày sau là thứ mấy trong tuần?'),(12,1,'Số nhỏ nhất có 4 chữ số là:'),(13,1,'Từ 5 chữ số: 1, 2, 3, 4, 0 có thể viết được bao nhiêu số có 2 chữ số khác nhau'),(14,1,'Số lẻ liền sau số 2007 là:'),(15,1,'Nhà em có 24 con gà. Số vịt nhiều hơn số gà là 2 con. Hỏi nhà em có bao nhiêu con vịt?'),(16,1,'Mẹ sinh con khi mẹ 25 tuổi. Hỏi khi con lên 9 tuổi thì mẹ bao nhiêu tuổi?'),(17,1,'Các phép tính dưới đây, phép tính nào là đúng:'),(18,1,'Hiệu của số lớn nhất có bốn chữ số và số nhỏ nhất có ba chữ số là:'),(19,1,'Em có 15 viên bi, em chia cho mỗi bạn 2 viên bi. Sau khi chia xong kết quả số bạn được chia là:'),(20,1,'Lớp trưởng chỉ huy cả lớp xếp hàng. Cả lớp xếp được 4 hàng, mỗi hàng có 7 bạn. Hỏi lớp đó có bao nhiêu học sinh?'),(21,2,'1. They are _______tennis'),(22,2,'2. What do you do _______your free time?'),(57,2,'3. How _______does she read ?'),(58,2,'4. We go to the zoo_______a month'),(59,2,'5. My mother _______jogging every morning'),(60,2,'6. _______he like spotrs ?'),(61,2,'7. What about _______by bike'),(62,2,'8. _______are you going to do tonight ?'),(63,2,'9. Mai _______cool weather'),(64,2,'10. Which sports does he play ?'),(65,2,'11. I am going to _______the Citadel'),(66,2,'12. How many _______are there in a week ?'),(67,2,'13. What _______ she like? She\'d like a glass of milk.'),(68,2,'14. My sister doesn\'t like fish.She _______ fruit,chocolate and vegetables.'),(69,2,'15. Is there anything to drink? I\'m _______.'),(70,2,'16. What do you _______ in your free time? I play soccer.'),(71,2,'17. How _______ do you brush your teeth? Twice a day.'),(72,2,'18. They are _______ football, now.'),(73,2,'19. _______ sports does your brother play? Badminton and swimming'),(74,2,'20. What\'s the weather like in the _______? It\'s hot.'),(75,3,'a hai dz'),(76,3,'vvv'),(77,4,'ASDASD'),(78,4,'ASDFDASDAS');
/*!40000 ALTER TABLE `quiz_question` ENABLE KEYS */;
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
