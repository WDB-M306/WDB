-- phpMyAdmin SQL Dump
-- version 4.8.0-dev
-- https://www.phpmyadmin.net/
--
-- Host: 192.168.30.23
-- Erstellungszeit: 14. Nov 2017 um 10:08
-- Server-Version: 8.0.2-dmr
-- PHP-Version: 7.0.19-1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `wdb`
--
CREATE Database wdb;
use wdb;
-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Page`
--

CREATE TABLE `Page` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255),
  `contentLink` varchar(255),
  `tags` int(11),
  `attatchementLink` varchar(255),
  `authorId` int(11)
);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Tag`
--

CREATE TABLE `Tag` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `entries` varchar(255)
);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `User`
--

CREATE TABLE `User` (
  `id` int(11) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255) UNIQUE,
  `password` varchar(255),
  `deactivated` tinyint(1)
);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `Page`
--
ALTER TABLE `Page`
  ADD KEY `fk_tags` (`tags`),
  ADD KEY `fk_user` (`authorId`);


--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `Page`
--
ALTER TABLE `Page`
  ADD CONSTRAINT `fk_tags` FOREIGN KEY (`tags`) REFERENCES `Tag` (`id`),
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`authorId`) REFERENCES `User` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
