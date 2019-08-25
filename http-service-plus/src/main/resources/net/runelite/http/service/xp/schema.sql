-- MySQL dump 10.16  Distrib 10.2.18-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: xptracker
-- ------------------------------------------------------
-- Server version       10.2.18-MariaDB

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
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `tracked_since` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_updated` timestamp NOT NULL DEFAULT current_timestamp(),
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `xp`
--

DROP TABLE IF EXISTS `xp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT current_timestamp(),
  `player` int(11) NOT NULL,
  `attack_xp` int(11) NOT NULL,
  `defence_xp` int(11) NOT NULL,
  `strength_xp` int(11) NOT NULL,
  `hitpoints_xp` int(11) NOT NULL,
  `ranged_xp` int(11) NOT NULL,
  `prayer_xp` int(11) NOT NULL,
  `magic_xp` int(11) NOT NULL,
  `cooking_xp` int(11) NOT NULL,
  `woodcutting_xp` int(11) NOT NULL,
  `fletching_xp` int(11) NOT NULL,
  `fishing_xp` int(11) NOT NULL,
  `firemaking_xp` int(11) NOT NULL,
  `crafting_xp` int(11) NOT NULL,
  `smithing_xp` int(11) NOT NULL,
  `mining_xp` int(11) NOT NULL,
  `herblore_xp` int(11) NOT NULL,
  `agility_xp` int(11) NOT NULL,
  `thieving_xp` int(11) NOT NULL,
  `slayer_xp` int(11) NOT NULL,
  `farming_xp` int(11) NOT NULL,
  `runecraft_xp` int(11) NOT NULL,
  `hunter_xp` int(11) NOT NULL,
  `construction_xp` int(11) NOT NULL,
  `overall_xp` int(11) GENERATED ALWAYS AS (`attack_xp` + `defence_xp` + `strength_xp` + `hitpoints_xp` + `ranged_xp` + `prayer_xp` + `magic_xp` + `cooking_xp` + `woodcutting_xp` + `fletching_xp` + `fishing_xp` + `firemaking_xp` + `crafting_xp` + `smithing_xp` + `mining_xp` + `herblore_xp` + `agility_xp` + `thieving_xp` + `slayer_xp` + `farming_xp` + `runecraft_xp` + `hunter_xp` + `construction_xp`) VIRTUAL,
  `attack_level` int(11) GENERATED ALWAYS AS (level_for_xp(`attack_xp` AS `attack_xp`)) VIRTUAL,
  `defence_level` int(11) GENERATED ALWAYS AS (level_for_xp(`defence_xp` AS `defence_xp`)) VIRTUAL,
  `strength_level` int(11) GENERATED ALWAYS AS (level_for_xp(`strength_xp` AS `strength_xp`)) VIRTUAL,
  `hitpoints_level` int(11) GENERATED ALWAYS AS (level_for_xp(`hitpoints_xp` AS `hitpoints_xp`)) VIRTUAL,
  `ranged_level` int(11) GENERATED ALWAYS AS (level_for_xp(`ranged_xp` AS `ranged_xp`)) VIRTUAL,
  `prayer_level` int(11) GENERATED ALWAYS AS (level_for_xp(`prayer_xp` AS `prayer_xp`)) VIRTUAL,
  `magic_level` int(11) GENERATED ALWAYS AS (level_for_xp(`magic_xp` AS `magic_xp`)) VIRTUAL,
  `cooking_level` int(11) GENERATED ALWAYS AS (level_for_xp(`cooking_xp` AS `cooking_xp`)) VIRTUAL,
  `woodcutting_level` int(11) GENERATED ALWAYS AS (level_for_xp(`woodcutting_xp` AS `woodcutting_xp`)) VIRTUAL,
  `fletching_level` int(11) GENERATED ALWAYS AS (level_for_xp(`fletching_xp` AS `fletching_xp`)) VIRTUAL,
  `fishing_level` int(11) GENERATED ALWAYS AS (level_for_xp(`fishing_xp` AS `fishing_xp`)) VIRTUAL,
  `firemaking_level` int(11) GENERATED ALWAYS AS (level_for_xp(`firemaking_xp` AS `firemaking_xp`)) VIRTUAL,
  `crafting_level` int(11) GENERATED ALWAYS AS (level_for_xp(`crafting_xp` AS `crafting_xp`)) VIRTUAL,
  `smithing_level` int(11) GENERATED ALWAYS AS (level_for_xp(`smithing_xp` AS `smithing_xp`)) VIRTUAL,
  `mining_level` int(11) GENERATED ALWAYS AS (level_for_xp(`mining_xp` AS `mining_xp`)) VIRTUAL,
  `herblore_level` int(11) GENERATED ALWAYS AS (level_for_xp(`herblore_xp` AS `herblore_xp`)) VIRTUAL,
  `agility_level` int(11) GENERATED ALWAYS AS (level_for_xp(`agility_xp` AS `agility_xp`)) VIRTUAL,
  `thieving_level` int(11) GENERATED ALWAYS AS (level_for_xp(`thieving_xp` AS `thieving_xp`)) VIRTUAL,
  `slayer_level` int(11) GENERATED ALWAYS AS (level_for_xp(`slayer_xp` AS `slayer_xp`)) VIRTUAL,
  `farming_level` int(11) GENERATED ALWAYS AS (level_for_xp(`farming_xp` AS `farming_xp`)) VIRTUAL,
  `runecraft_level` int(11) GENERATED ALWAYS AS (level_for_xp(`runecraft_xp` AS `runecraft_xp`)) VIRTUAL,
  `hunter_level` int(11) GENERATED ALWAYS AS (level_for_xp(`hunter_xp` AS `hunter_xp`)) VIRTUAL,
  `construction_level` int(11) GENERATED ALWAYS AS (level_for_xp(`construction_xp` AS `construction_xp`)) VIRTUAL,
  `overall_level` int(11) GENERATED ALWAYS AS (`attack_level` + `defence_level` + `strength_level` + `hitpoints_level` + `ranged_level` + `prayer_level` + `magic_level` + `cooking_level` + `woodcutting_level` + `fletching_level` + `fishing_level` + `firemaking_level` + `crafting_level` + `smithing_level` + `mining_level` + `herblore_level` + `agility_level` + `thieving_level` + `slayer_level` + `farming_level` + `runecraft_level` + `hunter_level` + `construction_level`) VIRTUAL,
  `attack_rank` int(11) NOT NULL,
  `defence_rank` int(11) NOT NULL,
  `strength_rank` int(11) NOT NULL,
  `hitpoints_rank` int(11) NOT NULL,
  `ranged_rank` int(11) NOT NULL,
  `prayer_rank` int(11) NOT NULL,
  `magic_rank` int(11) NOT NULL,
  `cooking_rank` int(11) NOT NULL,
  `woodcutting_rank` int(11) NOT NULL,
  `fletching_rank` int(11) NOT NULL,
  `fishing_rank` int(11) NOT NULL,
  `firemaking_rank` int(11) NOT NULL,
  `crafting_rank` int(11) NOT NULL,
  `smithing_rank` int(11) NOT NULL,
  `mining_rank` int(11) NOT NULL,
  `herblore_rank` int(11) NOT NULL,
  `agility_rank` int(11) NOT NULL,
  `thieving_rank` int(11) NOT NULL,
  `slayer_rank` int(11) NOT NULL,
  `farming_rank` int(11) NOT NULL,
  `runecraft_rank` int(11) NOT NULL,
  `hunter_rank` int(11) NOT NULL,
  `construction_rank` int(11) NOT NULL,
  `overall_rank` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `player_time` (`player`,`time`),
  KEY `idx_time` (`time`),
  CONSTRAINT `fk_player` FOREIGN KEY (`player`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-15 21:01:17