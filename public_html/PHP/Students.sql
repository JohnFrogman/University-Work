-- MySQL dump 10.13  Distrib 5.5.38, for Linux (i686)
--
-- Host: mysql    Database: m4ah
-- ------------------------------------------------------
-- Server version	5.5.38

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
-- Table structure for table `Students`
--

DROP TABLE IF EXISTS `Students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Students` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(48) DEFAULT NULL,
  `l_name` varchar(48) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `email` varchar(48) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `gr` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Students`
--

LOCK TABLES `Students` WRITE;
/*!40000 ALTER TABLE `Students` DISABLE KEYS */;
INSERT INTO `Students` VALUES (1,'Alexander','Hayes',200650746,'A.hayes2@liverpool.ac.uk','2014-12-15',1),(2,'John','Doe',200650747,'JohnDoe@liv.ac.uk','2014-12-15',4),(3,'Maija','MeikÃ¤lÃ¤inen',200650748,'Maija@liv.ac.uk','2014-12-15',4),(4,'Pierre','Machin',200650745,'Pierre@france.fr','2014-12-15',4),(5,'Moishe','Zugmir',200650744,'Moishe@liv.ac.uk','2014-12-15',4),(6,'Nantoka','Hoge',200650743,'Hoge@liv.ac.uk','2014-12-15',4),(7,'Kari','Nordmann',200650741,'Nordmann@liv.ac.uk','2014-12-15',4),(8,'Vasily','Pupkin',200650740,'Pupkin@liv.ac.uk','2014-12-15',4),(9,'Maria','Svensson',200640746,'Svensson@liv.ac.uk','2014-12-15',4);
/*!40000 ALTER TABLE `Students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-15 13:56:52
