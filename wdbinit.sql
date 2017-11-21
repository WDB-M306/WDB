START TRANSACTION;

CREATE Database wdb;
use wdb;
-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Page`
--

CREATE TABLE `Page` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255),
  `content` varchar(255),
  `tags` int(11),
  `attachment` varchar(255),
  `authorId` int(11)
);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Tag`
--

CREATE TABLE `Tag` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `label` varchar(255),
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
  `active` tinyint(1)
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
