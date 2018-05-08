CREATE DATABASE rapizz;
USE rapizz;

DROP TABLE IF EXISTS `assoc_pizzas_ingredients`;
CREATE TABLE IF NOT EXISTS `assoc_pizzas_ingredients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pizza` int(11) NOT NULL,
  `ingredient` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ingre` (`ingredient`),
  KEY `pizz` (`pizza`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `adresse` varchar(40) NOT NULL,
  `ville` varchar(20) NOT NULL,
  `solde` float NOT NULL,
  `nb_commandes` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `commandes`;
CREATE TABLE IF NOT EXISTS `commandes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client` int(11) NOT NULL,
  `pizza` int(11) NOT NULL,
  `taille` int(2) NOT NULL,
  `tarif` float NOT NULL,
  `date_commande` datetime NOT NULL,
  `livraison` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client` (`client`),
  KEY `pizza` (`pizza`),
  KEY `taille` (`taille`),
  KEY `livraison` (`livraison`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `formats_pizzas`;
CREATE TABLE IF NOT EXISTS `formats_pizzas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  `ratio` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `ingredients`;
CREATE TABLE IF NOT EXISTS `ingredients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `livraisons`;
CREATE TABLE IF NOT EXISTS `livraisons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `livreur` int(11) NOT NULL,
  `date_livraison` datetime DEFAULT NULL,
  `transport` int(11) NOT NULL,
  `statut` enum('terminée','en cours') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `livreur` (`livreur`),
  KEY `vehicule` (`transport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `livreur`;
CREATE TABLE IF NOT EXISTS `livreur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `pizzas`;
CREATE TABLE IF NOT EXISTS `pizzas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  `base_prix` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `transports`;
CREATE TABLE IF NOT EXISTS `transports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


ALTER TABLE `assoc_pizzas_ingredients`
  ADD CONSTRAINT `ingre` FOREIGN KEY (`ingredient`) REFERENCES `ingredients` (`id`),
  ADD CONSTRAINT `pizz` FOREIGN KEY (`pizza`) REFERENCES `pizzas` (`id`);


ALTER TABLE `commandes`
  ADD CONSTRAINT `client` FOREIGN KEY (`client`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `livraison` FOREIGN KEY (`livraison`) REFERENCES `livraisons` (`id`),
  ADD CONSTRAINT `pizza` FOREIGN KEY (`pizza`) REFERENCES `pizzas` (`id`),
  ADD CONSTRAINT `taille` FOREIGN KEY (`taille`) REFERENCES `formats_pizzas` (`id`);


ALTER TABLE `livraisons`
  ADD CONSTRAINT `livreur` FOREIGN KEY (`livreur`) REFERENCES `livreur` (`id`),
  ADD CONSTRAINT `vehicule` FOREIGN KEY (`transport`) REFERENCES `transports` (`id`);
COMMIT;

