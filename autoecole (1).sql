-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 10 sep. 2020 à 14:43
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `autoecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `avancement_employe`
--

DROP TABLE IF EXISTS `avancement_employe`;
CREATE TABLE IF NOT EXISTS `avancement_employe` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `employe` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5dpunncbou973vwlct4ecx79m` (`employe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` bigint(20) NOT NULL,
  `addressefr` varchar(255) DEFAULT NULL,
  `adressear` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_examen` date DEFAULT NULL,
  `date_inscription` date DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `generatedcode` varchar(255) DEFAULT NULL,
  `image` longblob,
  `langue_exam` varchar(255) DEFAULT NULL,
  `moniteur_pratique` varchar(255) DEFAULT NULL,
  `moniteur_theorique` varchar(255) DEFAULT NULL,
  `niveau_etude` varchar(255) DEFAULT NULL,
  `nomar` varchar(255) DEFAULT NULL,
  `nomfr` varchar(255) DEFAULT NULL,
  `numero_de_session` varchar(255) DEFAULT NULL,
  `permis_demande` varchar(255) DEFAULT NULL,
  `possede_permis` bit(1) DEFAULT NULL,
  `premis_numero` varchar(255) DEFAULT NULL,
  `prenomar` varchar(255) DEFAULT NULL,
  `prenomfr` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `status_condidat` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `vehicule` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `image_type` varchar(255) DEFAULT NULL,
  `prix_restantes` double DEFAULT NULL,
  `prix_total` double DEFAULT NULL,
  `total_heure_conduite` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `addressefr`, `adressear`, `cin`, `date_examen`, `date_inscription`, `date_naissance`, `generatedcode`, `image`, `langue_exam`, `moniteur_pratique`, `moniteur_theorique`, `niveau_etude`, `nomar`, `nomfr`, `numero_de_session`, `permis_demande`, `possede_permis`, `premis_numero`, `prenomar`, `prenomfr`, `profession`, `status_condidat`, `telephone`, `vehicule`, `email`, `gender`, `image_name`, `image_type`, `prix_restantes`, `prix_total`, `total_heure_conduite`) VALUES
(5, 'tamansourt', 'تامنصورت', '5678', NULL, '2020-09-23', '2020-09-15', 'TGBNJHG', NULL, 'arabe', 'hamza', 'hamza', 'bac', 'بويكروان', 'bouigrouane', '1', 'B', NULL, NULL, 'حمزة', 'hamza', 'tay9lab  3la khada', NULL, '9765434567', 'bnw', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, 'tranche1 tamansourt marrakech', 'الدارالبيضاء', '6788', '2020-09-26', '2020-09-15', '2020-09-16', '2/2020', NULL, 'arabe', 'hamza', 'hamza', 'bac', 'مرزوقي', 'marzouqi', '1', 'A', b'0', NULL, 'احمد', 'ahmed', 'Police', NULL, '9876544', 'toyota', 'shadeau99@gmail.com', 'Homme', 'voiture1', 'image/jpeg', 10, 100, 40);

-- --------------------------------------------------------

--
-- Structure de la table `client_heure_conduites`
--

DROP TABLE IF EXISTS `client_heure_conduites`;
CREATE TABLE IF NOT EXISTS `client_heure_conduites` (
  `client_id` bigint(20) NOT NULL,
  `heure_conduites` bigint(20) NOT NULL,
  UNIQUE KEY `UK_5kbmcul5d4n720ys5602sx6oo` (`heure_conduites`),
  KEY `FKn7mkr0tw0xgb98oaksc0nis3n` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client_observations`
--

DROP TABLE IF EXISTS `client_observations`;
CREATE TABLE IF NOT EXISTS `client_observations` (
  `client_id` bigint(20) NOT NULL,
  `observations` bigint(20) NOT NULL,
  UNIQUE KEY `UK_rltt6mo78hhlbg6dccptm9n2e` (`observations`),
  KEY `FKhl1hnfc4g3m7660ocpxnby705` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client_paiment_de_clients`
--

DROP TABLE IF EXISTS `client_paiment_de_clients`;
CREATE TABLE IF NOT EXISTS `client_paiment_de_clients` (
  `client_id` bigint(20) NOT NULL,
  `paiment_de_clients` bigint(20) NOT NULL,
  UNIQUE KEY `UK_n1e7tvb8rbb52vsa2g3t6od8b` (`paiment_de_clients`),
  KEY `FK7lv9wtv1jil4r9s8sdymwud29` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client_paiment_de_clients`
--

INSERT INTO `client_paiment_de_clients` (`client_id`, `paiment_de_clients`) VALUES
(11, 1);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `id` bigint(20) NOT NULL,
  `addressefr` varchar(255) DEFAULT NULL,
  `adressear` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `nomar` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nomfr` varchar(255) DEFAULT NULL,
  `prenomar` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenomfr` varchar(255) DEFAULT NULL,
  `salaire` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id`, `addressefr`, `adressear`, `cin`, `date_naissance`, `nomar`, `nomfr`, `prenomar`, `prenomfr`, `salaire`) VALUES
(5, 'tranche1 tamansourt marrakech', 'الدارالبيضاء', '63748', '2020-09-24', 'مرزوقي', 'marzouqi', 'احمد', 'ahmed', 1823);

-- --------------------------------------------------------

--
-- Structure de la table `etat_financiere`
--

DROP TABLE IF EXISTS `etat_financiere`;
CREATE TABLE IF NOT EXISTS `etat_financiere` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `monant` bigint(20) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `etat_financiere_par_mois`
--

DROP TABLE IF EXISTS `etat_financiere_par_mois`;
CREATE TABLE IF NOT EXISTS `etat_financiere_par_mois` (
  `id` bigint(20) NOT NULL,
  `annee` bigint(20) DEFAULT NULL,
  `mois` int(11) NOT NULL,
  `monant_restantes` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `etat_financiere_par_mois_etat_financieres`
--

DROP TABLE IF EXISTS `etat_financiere_par_mois_etat_financieres`;
CREATE TABLE IF NOT EXISTS `etat_financiere_par_mois_etat_financieres` (
  `etat_financiere_par_mois_id` bigint(20) NOT NULL,
  `etat_financieres` bigint(20) NOT NULL,
  UNIQUE KEY `UK_359t49kkniqkm3xpif13e8og0` (`etat_financieres`),
  KEY `FKitja4vdy36v9xkeherevmd4ru` (`etat_financiere_par_mois_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `heure_conduite`
--

DROP TABLE IF EXISTS `heure_conduite`;
CREATE TABLE IF NOT EXISTS `heure_conduite` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `duree` bigint(20) DEFAULT NULL,
  `client` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3c6jlwke0y3j5mt7wbbr6mbe` (`client`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `heure_conduite`
--

INSERT INTO `heure_conduite` (`id`, `date`, `duree`, `client`) VALUES
(2, '2020-09-16', 20, 11),
(12, '2020-09-02', 20, 11);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(16),
(16),
(16),
(16),
(16),
(16),
(16),
(16);

-- --------------------------------------------------------

--
-- Structure de la table `observation`
--

DROP TABLE IF EXISTS `observation`;
CREATE TABLE IF NOT EXISTS `observation` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `numero_session` varchar(255) DEFAULT NULL,
  `score` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `employe` bigint(20) DEFAULT NULL,
  `client` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK69fltkswxglr1uqhpr7kn1yhd` (`employe`),
  KEY `FKgqpiw603kltd07yng8cnuuean` (`client`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `paiment_de_client`
--

DROP TABLE IF EXISTS `paiment_de_client`;
CREATE TABLE IF NOT EXISTS `paiment_de_client` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `monatantpaye` bigint(20) DEFAULT NULL,
  `montant_restantes` bigint(20) DEFAULT NULL,
  `montant_total` bigint(20) DEFAULT NULL,
  `client` bigint(20) DEFAULT NULL,
  `montantpaye` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKslqns0m311u0fen0juacd8ou1` (`client`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `paiment_de_client`
--

INSERT INTO `paiment_de_client` (`id`, `date`, `monatantpaye`, `montant_restantes`, `montant_total`, `client`, `montantpaye`) VALUES
(1, '2020-09-07', 20, 80, 100, 11, 20);

-- --------------------------------------------------------

--
-- Structure de la table `paiment_de_employe`
--

DROP TABLE IF EXISTS `paiment_de_employe`;
CREATE TABLE IF NOT EXISTS `paiment_de_employe` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `monatantpaye` bigint(20) DEFAULT NULL,
  `montant_restantes` bigint(20) DEFAULT NULL,
  `montant_total` bigint(20) DEFAULT NULL,
  `client` bigint(20) DEFAULT NULL,
  `employe` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnook75p0fb5j0eh2k5uoyiapg` (`client`),
  KEY `FKhorm7g9h15vbatvine0pecnl1` (`employe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
