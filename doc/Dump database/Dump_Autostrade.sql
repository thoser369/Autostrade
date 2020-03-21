CREATE DATABASE  IF NOT EXISTS `autostrade` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `autostrade`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: autostrade
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attraversare`
--

DROP TABLE IF EXISTS `attraversare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attraversare` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_utente` int(10) unsigned NOT NULL,
  `ID_casello_partenza` int(10) unsigned NOT NULL,
  `ID_casello_arrivo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_utente_attraversare` (`ID_utente`),
  KEY `ID_casello_attraversare_partenza` (`ID_casello_partenza`),
  KEY `ID_casello_attraversare_arrivo_idx` (`ID_casello_arrivo`),
  CONSTRAINT `ID_casello_attraversare_arrivo` FOREIGN KEY (`ID_casello_arrivo`) REFERENCES `casello` (`id`),
  CONSTRAINT `ID_casello_attraversare_partenza` FOREIGN KEY (`ID_casello_partenza`) REFERENCES `casello` (`id`),
  CONSTRAINT `ID_utente_attraversare` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attraversare`
--

LOCK TABLES `attraversare` WRITE;
/*!40000 ALTER TABLE `attraversare` DISABLE KEYS */;
INSERT INTO `attraversare` VALUES (1,2,35,33),(2,2,33,35),(3,2,35,35),(4,2,35,33),(5,12,30,29),(6,12,30,29),(7,2,29,28),(8,2,35,33),(9,2,35,33),(10,1,35,33),(11,1,35,33),(12,2,35,33),(13,2,35,33),(14,2,35,33),(15,2,35,33),(16,2,35,33),(17,2,35,33),(18,2,35,33),(19,2,35,33),(20,2,35,33),(21,2,35,33),(22,2,35,33);
/*!40000 ALTER TABLE `attraversare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autostrada`
--

DROP TABLE IF EXISTS `autostrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `autostrada` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `tariffa` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autostrada`
--

LOCK TABLES `autostrada` WRITE;
/*!40000 ALTER TABLE `autostrada` DISABLE KEYS */;
INSERT INTO `autostrada` VALUES (21,'A1',0.5),(22,'A2',0.1),(23,'A3',0.15),(24,'A4',0.2),(25,'A5',0.3);
/*!40000 ALTER TABLE `autostrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casello`
--

DROP TABLE IF EXISTS `casello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `casello` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_autostrada` int(10) unsigned NOT NULL,
  `nome` varchar(255) NOT NULL,
  `km` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `nome` (`nome`),
  KEY `ID_autostrada` (`ID_autostrada`),
  CONSTRAINT `ID_autostrada` FOREIGN KEY (`ID_autostrada`) REFERENCES `autostrada` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casello`
--

LOCK TABLES `casello` WRITE;
/*!40000 ALTER TABLE `casello` DISABLE KEYS */;
INSERT INTO `casello` VALUES (12,21,'Milano Sud',9),(13,21,'Parma',110),(14,21,'Modena Nord',157),(15,21,'Firenze',300),(16,21,'Napoli Nord',740),(17,22,'Barriera di Torino',13),(18,22,'Marene',35),(19,22,'Fossano',50),(20,22,'Niella Tanaro',71),(21,22,'Ceva',81),(22,23,'Ponticelli',5),(23,23,'Torre del Greco',13),(24,23,'Castellammare di Stabia',23),(25,23,'Angri',30),(26,23,'Nocera Nord',37),(27,24,'Torino Rondissone',24),(28,24,'Milano Est',138),(29,24,'Bergamo',172),(30,24,'Verona Est',290),(31,24,'Trieste Lisert',515),(32,25,'Torino Nord',4),(33,25,'Ivrea',40),(34,25,'Verres',70),(35,25,'Aosta',100),(36,25,'Aosta est',101);
/*!40000 ALTER TABLE `casello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_ambientale`
--

DROP TABLE IF EXISTS `classe_ambientale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classe_ambientale` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `tariffa` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_ambientale`
--

LOCK TABLES `classe_ambientale` WRITE;
/*!40000 ALTER TABLE `classe_ambientale` DISABLE KEYS */;
INSERT INTO `classe_ambientale` VALUES (1,'Euro 1',0.04),(2,'Euro 2',0.05),(3,'Euro 3',0.07),(4,'Euro 4',0.1),(5,'Euro 5',0.12),(6,'Euro 6',0.15);
/*!40000 ALTER TABLE `classe_ambientale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_veicolo`
--

DROP TABLE IF EXISTS `classe_veicolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classe_veicolo` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `tariffa` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_veicolo`
--

LOCK TABLES `classe_veicolo` WRITE;
/*!40000 ALTER TABLE `classe_veicolo` DISABLE KEYS */;
INSERT INTO `classe_veicolo` VALUES (1,'Classe A',0.06),(2,'Classe B',0.07),(3,'Classe 3',0.09),(4,'Classe 4',0.12),(5,'Classe 5',0.14);
/*!40000 ALTER TABLE `classe_veicolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gestione`
--

DROP TABLE IF EXISTS `gestione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gestione` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` enum('Classe Ambientale','Classe Unitaria') DEFAULT NULL,
  `Iva` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gestione`
--

LOCK TABLES `gestione` WRITE;
/*!40000 ALTER TABLE `gestione` DISABLE KEYS */;
INSERT INTO `gestione` VALUES (1,'Classe Ambientale',22);
/*!40000 ALTER TABLE `gestione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `percorrere`
--

DROP TABLE IF EXISTS `percorrere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `percorrere` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_utente` int(10) unsigned NOT NULL,
  `ID_autostrada` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_utente_percorrere` (`ID_utente`),
  KEY `ID_autostrada_percorrere` (`ID_autostrada`),
  CONSTRAINT `ID_autostrada_percorrere` FOREIGN KEY (`ID_autostrada`) REFERENCES `autostrada` (`id`),
  CONSTRAINT `ID_utente_percorrere` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `percorrere`
--

LOCK TABLES `percorrere` WRITE;
/*!40000 ALTER TABLE `percorrere` DISABLE KEYS */;
INSERT INTO `percorrere` VALUES (1,2,25),(2,2,25),(3,2,25),(4,2,25),(5,2,25),(6,12,24),(7,12,24),(8,2,24),(9,2,25),(10,2,25),(11,1,25),(12,1,25),(13,2,25),(14,2,25),(15,2,25),(16,2,25),(17,2,25),(18,2,25),(19,2,25),(20,2,25),(21,2,25),(22,2,25),(23,2,25);
/*!40000 ALTER TABLE `percorrere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipo` enum('amministratore','utente') DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'admin','admin','admin','admin','amministratore'),(2,'Mario','Rossi','mario','mr','utente'),(3,'Luigi','Bianchi','luigi','lb','utente'),(4,'Veronica','Gialli','veronica','vg','utente'),(5,'Eleonora','Verdi','eleonora','ev','utente'),(6,'Giovanni','Falocchi','giovanni','gf','utente'),(7,'Maria','Caccio','maria','mc','utente'),(8,'Stefano','Giudizio','stefgiud','stefgiud','utente'),(9,'Franca','Sotti','fraso','fraso','utente'),(10,'Francesco','Acqua','fra','francac','utente'),(11,'Francesca','Rocchi','fraroc','fraroc','utente'),(12,'Davide','Fedele','piefe','ciao1298','utente'),(13,'Giulia','Tovaglia','giuto','giuto','utente');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veicolo`
--

DROP TABLE IF EXISTS `veicolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `veicolo` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_utente` int(10) unsigned NOT NULL,
  `ID_classe_veicolo` int(10) unsigned NOT NULL,
  `ID_classe_ambientale` int(10) unsigned NOT NULL,
  `modello` varchar(255) NOT NULL,
  `marca` varchar(255) NOT NULL,
  `targa` varchar(255) NOT NULL,
  `peso` int(11) NOT NULL,
  `anno` int(11) NOT NULL,
  `altezza` varchar(255) DEFAULT NULL,
  `assi` enum('2','3','4','5 o piu') DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `targa` (`targa`),
  KEY `ID_utente` (`ID_utente`),
  KEY `ID_classe_veicolo` (`ID_classe_veicolo`),
  KEY `ID_classe_ambientale` (`ID_classe_ambientale`),
  CONSTRAINT `ID_classe_ambientale` FOREIGN KEY (`ID_classe_ambientale`) REFERENCES `classe_ambientale` (`id`),
  CONSTRAINT `ID_classe_veicolo` FOREIGN KEY (`ID_classe_veicolo`) REFERENCES `classe_veicolo` (`id`),
  CONSTRAINT `ID_utente` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veicolo`
--

LOCK TABLES `veicolo` WRITE;
/*!40000 ALTER TABLE `veicolo` DISABLE KEYS */;
INSERT INTO `veicolo` VALUES (1,3,3,5,'mod1','Citroen','AQ100AQ',250,2000,'145','3'),(2,2,1,6,'mod2','Audi','CR200RC',500,2000,'130','2'),(3,2,2,2,'mod3','Fiat','NB300BN',300,2001,'120','5 o piu'),(4,2,3,3,'mod4','Citroen','MM400MM',400,2002,'170','3'),(5,2,3,5,'mod5','Peugeot','QQ500QQ',500,2003,'155','3'),(6,3,2,2,'mod6','Ford','WW500WW',900,2000,'150','2'),(7,1,1,1,'mod7','Citroen','EE500EE',800,2003,'140','2'),(8,2,3,5,'mod8','Fiat','RR500RR',550,2001,'155','3'),(9,6,3,1,'mod9','Lancia','LL300LL',500,2000,'150','3'),(10,2,1,1,'mod10','Citroen','TT300TT',550,2004,'165','2'),(11,12,1,2,'mod11','Fiat','NN200NN',550,2000,'150','2');
/*!40000 ALTER TABLE `veicolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'autostrade'
--

--
-- Dumping routines for database 'autostrade'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-22  0:07:20
