SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `BAND` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `bio` varchar(255) NOT NULL,
  `genre` int(11) NOT NULL,
  `members` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `EVENT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `vid` int(11) NOT NULL,
  `vname` varchar(255) NOT NULL,
  `vaddress` varchar(255) NOT NULL,
  `vcapacity` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(255) NOT NULL,
  `bid` int(11) NOT NULL,
  `bname` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `INVOICE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `ucompany` varchar(255) NOT NULL,
  `eid` int(11) NOT NULL,
  `ename` varchar(255) NOT NULL,
  `eprice` int(11) NOT NULL,
  `eamount` int(11) NOT NULL,
  `edate` date NOT NULL,
  `etime` varchar(255) NOT NULL,
  `dop` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `TICKET` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `ufname` varchar(255) NOT NULL,
  `ulname` varchar(255) NOT NULL,
  `ucompany` varchar(255) NOT NULL,
  `eid` int(11) NOT NULL,
  `ename` varchar(255) NOT NULL,
  `eprice` int(11) NOT NULL,
  `evenue` varchar(255) NOT NULL,
  `edate` date NOT NULL,
  `etime` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `sud` date DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `VENUE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
