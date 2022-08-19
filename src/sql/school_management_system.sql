-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 13, 2022 at 02:21 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `school_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

--
-- Database: `school_management_system`
--
CREATE DATABASE IF NOT EXISTS `school_management_system` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `school_management_system`;


DROP TABLE IF EXISTS `class`;
CREATE TABLE IF NOT EXISTS `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(255) NOT NULL,
  `section` varchar(255) NOT NULL,
  `student_strength` int(22) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;




-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
CREATE TABLE IF NOT EXISTS `exam` (
  `examid` int(22) NOT NULL AUTO_INCREMENT,
  `examname` varchar(255) NOT NULL,
  `examterm` varchar(255) NOT NULL,
  `examdate` varchar(255) NOT NULL,
  `examclass` varchar(255) NOT NULL,
  `examsection` varchar(255) NOT NULL,
  `examsubject` varchar(255) NOT NULL,
  PRIMARY KEY (`examid`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;



--
-- Table structure for table `mark`
--

DROP TABLE IF EXISTS `mark`;
CREATE TABLE IF NOT EXISTS `mark` (
  `studentid` int(22) NOT NULL,
  `studentname` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `class` varchar(255) NOT NULL,
  `marks` varchar(255) NOT NULL,
  `term` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `studentid` int(22) NOT NULL AUTO_INCREMENT,
  `studentname` varchar(255) NOT NULL,
  `parentname` varchar(255) NOT NULL,
  `dateofbirth` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `studentmobileno` varchar(255) NOT NULL,
  `studentaddress` varchar(255) NOT NULL,
  `studentclass` varchar(255) NOT NULL,
  `studentsection` varchar(255) NOT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;



-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subjectcode` varchar(22) NOT NULL,
  `subjectname` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;



-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `qualification` varchar(255) NOT NULL,
  `salary` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone` varchar(25) NOT NULL,
  `address` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `utype` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `phone`, `address`, `uname`, `password`, `utype`) VALUES
(1, 'Naveenkumar J', '9xxxxxxxxx8', 'Vellore, India', '18MIS0395', '1234', 'Admin'),
(2, 'Praveen', '9xxxxxxxx1', 'Vellore, India', '18MIS001', '1234', 'Student'),
(3, 'Jack', '9xxxxxxxx4', 'Vellore, India', '101', '1234', 'Teacher')
(4, 'guest', '9xxxxxxxx4', 'Vellore, India', 'guest', 'guest', 'Guest');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
