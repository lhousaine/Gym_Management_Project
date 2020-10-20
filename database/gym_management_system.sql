-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 02 jan. 2019 à 11:38
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gym_management_system`
--

-- --------------------------------------------------------

--
-- Structure de la table `admins`
--

DROP TABLE IF EXISTS `admins`;
CREATE TABLE IF NOT EXISTS `admins` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `CNI` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admins`
--

INSERT INTO `admins` (`Id`, `name`, `surname`, `tel`, `email`, `password`, `CNI`) VALUES
(74, 'lhouss', 'hgh', '0603708829', 'jhjhfcjh@hhfc.cbb', '147', 'pb554512'),
(76, 'root', 'root', '+444545', 'guyhggh@g.cghgh', '1234', 'fggghghgh');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `CNI` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `Surname` varchar(100) NOT NULL,
  `date de naissance` date NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Tel` varchar(20) NOT NULL,
  `payment_ment` int(10) NOT NULL,
  `payer` varchar(10) NOT NULL,
  `civilité` varchar(100) NOT NULL,
  `photo` varchar(500) NOT NULL,
  `groupe` varchar(50) NOT NULL,
  `date_inscription` date NOT NULL,
  `Sport` varchar(100) NOT NULL,
  PRIMARY KEY (`CNI`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`CNI`, `name`, `Surname`, `date de naissance`, `Email`, `Tel`, `payment_ment`, `payer`, `civilité`, `photo`, `groupe`, `date_inscription`, `Sport`) VALUES
('pb454545', 'lhous', 'ouarhou', '2018-12-11', 'lkfv@sdjjhd.com', '454545d', 100, 'ghfghfc', 'male', 'hhhv.g', 'ghghghghgh', '2018-12-11', 'football'),
('pb744545', 'mr', 'lahsayni', '2018-12-18', 'jhjhjh@djhjh.ma', '061225784578', 80, 'groupe 3', 'female', 'dbfhhf.png', 'groupe 1', '2018-12-10', 'tennis'),
('ghgh', 'vh', 'Kadim', '2018-11-27', 'ghgh', 'ghgh', 74545, 'groupe 1', 'male', 'profile', 'ghgh', '2018-12-27', 'ghgh'),
('dghghdgh75', 'ghghgndcbdv', 'elqoussi', '2018-12-05', 'fghfvc@gh.cgh', 'ghghh', 42, 'groupe 5', 'Female', 'C:\\Users\\Lhoussaine\\eclipse-workspace\\projet_sem\\src\\images\\th80RFX735.jpg', 'ghghgh', '2018-12-12', 'C2'),
('75ds4dx4', 'ssd42sd5', 'gh5c', '2018-11-28', 'bdcb@bhdb.cd', '+4124224454', 100, 'groupe 5', 'Male', 'C:\\Users\\Lhoussaine\\eclipse-workspace\\projet_sem\\src\\images\\45025166-Portrait-of-a-handsome-fitness-man-workout-with-dumbbells-in-gym-Stock-Photo.jpg', 'gh', '2018-11-29', 'C2');

-- --------------------------------------------------------

--
-- Structure de la table `entraineur`
--

DROP TABLE IF EXISTS `entraineur`;
CREATE TABLE IF NOT EXISTS `entraineur` (
  `CNI` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `Tel` int(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Sport` varchar(50) NOT NULL,
  `montantg` int(10) NOT NULL,
  `photo` varchar(100) NOT NULL,
  `experience` varchar(100) NOT NULL,
  `passemetsal` varchar(100) NOT NULL,
  `date_recrutement` date NOT NULL,
  PRIMARY KEY (`CNI`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `entraineur`
--

INSERT INTO `entraineur` (`CNI`, `name`, `surname`, `Tel`, `Email`, `Sport`, `montantg`, `photo`, `experience`, `passemetsal`, `date_recrutement`) VALUES
('', 'ghghdfghgf', 'vbvfbgvghgh ghgh', 1222354788, 'ggfggfhhfg@vggdf.com', 'yoga', 1235544554, '/images/user.png', 'master entrainer ', 'oui', '2018-12-19'),
('pdghhd45', 'gdggd', 'dghghf', 223882388, 'fvcs@dhj.com', 'Golf', 1234568, '/images/th80RFX735.jpg', 'master', 'non', '2018-12-18');

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `Numero` int(10) NOT NULL,
  `Entraineur` varchar(100) NOT NULL,
  `Sport` varchar(100) NOT NULL,
  `Taille` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `images`
--

DROP TABLE IF EXISTS `images`;
CREATE TABLE IF NOT EXISTS `images` (
  `Numero` int(10) NOT NULL AUTO_INCREMENT,
  `path` varchar(200) NOT NULL,
  PRIMARY KEY (`Numero`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `images`
--

INSERT INTO `images` (`Numero`, `path`) VALUES
(8, 'file:/C:/Users/Lhoussaine/eclipse-workspace/projet_sem/src/images/gym.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `id` int(11) NOT NULL,
  `sports` varchar(100) NOT NULL,
  `temps` varchar(100) NOT NULL,
  `jour` varchar(100) NOT NULL,
  `Entraineur` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`id`, `sports`, `temps`, `jour`, `Entraineur`) VALUES
(1, 'Golf-Football', '09-12', 'lundi', 'dgbdbchj-vchdch'),
(2, 'tennis-vole', '13-16', 'mardi', 'ffgd -gdghghd'),
(3, 'Nataion-basketBall', '16-19', 'mardi', 'ffgd -gdghghd'),
(4, 'Danse-Musculation-Fitness', '13-16', 'mardi', 'ffgd -gdghghd'),
(6, 'HandBall', '19-22', 'Dimanche', 'ghgh-dgghd'),
(10, 'Yoga', '19-22', 'Dimanche', 'ghgh-dgghd'),
(6, 'footBall', '19-22', 'Dimanche', 'ghgh-dgghd'),
(8, 'Paint Ball', '19-22', 'Dimanche', 'ghgh-dgghd'),
(10, 'Aerobi', '19-22', 'Samedi', 'ghgh-dgghd'),
(12, 'Tennis', '09-12', 'Jaudi', 'ghgh-dgghd');

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

DROP TABLE IF EXISTS `sport`;
CREATE TABLE IF NOT EXISTS `sport` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `Entraineur` varchar(100) NOT NULL,
  `Categorie` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sport`
--

INSERT INTO `sport` (`id`, `name`, `Entraineur`, `Categorie`) VALUES
(5, 'tennis', 'hfjhf', 'Categorie 1'),
(4, 'footbool', 'aamota', 'Categorie 1'),
(6, 'Basket ball', 'entrainer1', 'Categorie 1'),
(7, 'Paint ball', 'entraineur2', 'Categorie 1'),
(8, 'Hand ball', 'entraineur3', 'Categorie 1'),
(9, 'Dance', 'djhghfghf', 'Categorie 4'),
(10, 'Aerobic', 'hamid', 'Categorie 4\r\n'),
(11, 'Golf', 'gdghgd', 'Categorie 3'),
(12, 'Parapente', 'sdhgdhg', 'Categorie 3'),
(13, 'Yoga', 'aldd', 'Categorie 2'),
(14, 'Musculation', 'sds', 'Categorie 2'),
(15, 'Natation', 'sdghcd', 'Categorie 2'),
(16, 'Equitation', 'dghghd', 'Categorie 2');

-- --------------------------------------------------------

--
-- Structure de la table `tarifs`
--

DROP TABLE IF EXISTS `tarifs`;
CREATE TABLE IF NOT EXISTS `tarifs` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `N_mois` varchar(100) NOT NULL,
  `Categorie` varchar(100) NOT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tarifs`
--

INSERT INTO `tarifs` (`id`, `N_mois`, `Categorie`, `prix`) VALUES
(1, '1 mois', 'categorie 1', 100),
(2, '2 mois', 'Categorie 2', 160),
(3, '2 mois', 'Categorie 1', 180),
(4, '1 mois', 'Categorie 2', 100),
(5, '1 mois', 'Categorie 4', 120),
(6, '1 mois', 'Categorie 3', 70),
(7, '2 mois', 'Categorie 3', 120),
(8, '2 mois', 'Categorie 4', 200);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
