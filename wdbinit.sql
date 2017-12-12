START TRANSACTION;

CREATE Database wdb;
use wdb;
-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `DataPage`
--

CREATE TABLE `page` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255),
  `content` varchar(255),
  `author_id` int(11)
);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `DataTag`
--

CREATE TABLE `tag` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255)
);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `User`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255) UNIQUE,
  `password` varchar(255),
  `active` tinyint(1),
  `last_changed` DATETIME on update CURRENT_TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE `page_tags` (
  `tag_id` INT(11) NOT NULL,
  `page_id` INT(11) NOT NULL,
  PRIMARY KEY (`tag_id`, `page_id`),
  CONSTRAINT `FK_Tag` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`),
  CONSTRAINT `FK_Page` FOREIGN KEY (`page_id`) REFERENCES `page` (`id`)
);
--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `DataPage`
--
ALTER TABLE `page`
  ADD KEY `fk_user` (`author_id`);

ALTER TABLE `page`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`);
COMMIT;