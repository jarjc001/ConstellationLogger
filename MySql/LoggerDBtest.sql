-- Defines the data base and creates the tables in it

-- Drops any existing databases, then rebuilds a database with the same name. It will then be ready to use

DROP DATABASE IF EXISTS constellationloggertest;
CREATE DATABASE constellationloggertest;
USE constellationloggertest;

-- Creates Primary Tables of the data Base

-- users table
DROP TABLE IF EXISTS users;
CREATE TABLE users(
	username VARCHAR(25) PRIMARY KEY,
    password VARCHAR(25) NOT NULL,
    userFirstName VARCHAR(25) NOT NULL,
    userLastName VARCHAR(25) NOT NULL,
    email VARCHAR(50) NOT NULL,
    premium boolean NOT NULL);
    
-- constellation info 
DROP TABLE IF EXISTS constellations;
CREATE TABLE constellations(
	Abbr CHAR(3) PRIMARY KEY,
    latinName VARCHAR(20) NOT NULL,
    englishName VARCHAR(35) NOT NULL,
    conMonth TINYINT NOT NULL,
    maxLat DOUBLE NOT NULL,
    minLat DOUBLE NOT NULL,
    brightStar VARCHAR(20) NOT NULL,
    extraInfo LONGTEXT NULL);
    
    -- related tables
    
    -- log table for users with a FK from users
DROP TABLE IF EXISTS log;
CREATE TABLE log (
    logId INT PRIMARY KEY AUTO_INCREMENT,
    logDate date NOT NULL,
    username VARCHAR(25) NOT NULL,
    lat DOUBLE NOT NULL,
    extraInfo MEDIUMTEXT Null,
    
    CONSTRAINT fk_log_users
		FOREIGN KEY (username)
		REFERENCES users(username)
);


	-- star constellations table for many to many 
    
DROP TABLE IF EXISTS constellationsLog;
CREATE TABLE constellationsLog(
	Abbr CHAR(3),
    logId INT,
    CONSTRAINT pk_constellationsLog 
    	PRIMARY KEY (Abbr, logId),
	CONSTRAINT fk_constellationsLog_constellations
    	FOREIGN KEY (Abbr)
    	REFERENCES constellations(Abbr),
    CONSTRAINT fk_constellationsLog_log
    	FOREIGN KEY (logId)
    	REFERENCES log(logId)
);




