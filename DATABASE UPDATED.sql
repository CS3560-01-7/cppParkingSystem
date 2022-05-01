CREATE DATABASE CPP_PARKING_SYSTEM;

USE CPP_PARKING_SYSTEM;

CREATE TABLE Customer (
	broncoID INT (9),
    firstName VARCHAR (20),
    lastName VARCHAR (20), 
    emailAddress VARCHAR (50),
    address VARCHAR(50),
    checkStudent BOOLEAN,
    PRIMARY KEY (broncoID));
    
INSERT INTO Customer VALUES 
('111222333', 'Scott', 'Butter', 'scott_butter@cpp.edu', '3402 Central Park', 1),
('222333444', 'Celine', 'Swift', 'celine_swift@cpp.edu', '1108 Beverly Hills', 1),
('333444555', 'Olivia', 'Rodrigo', 'olivia_rodrigo@cpp.edu', '999 Catarina Island', 1);

SELECT * FROM Customer;

CREATE TABLE PaymentMethod (
    broncoID INT (9),
    cardNumber BIGINT (19),
    securityCode INT (3),
    expirationDateMonth INT (2),
    expirationDateYear INT (4),
    firstName VARCHAR (20),
    lastName VARCHAR (50),
    address VARCHAR (50),
    FOREIGN KEY (broncoID) REFERENCES Customer (broncoID),
    PRIMARY KEY (cardNumber, broncoID));

INSERT INTO PaymentMethod VALUES
('111222333', '345298765', '345', '09', '2025', 'Scott', 'Butter', '3402 Central Park'),
('222333444', '897342658', '122', '12', '2026', 'Celine', 'Swift', '1108 Beverly Hills'),
('333444555', '834982344', '089', '01', '2028', 'Olivia', 'Rodrigo', '999 Catarina Islands');

SELECT * FROM PaymentMethod;

CREATE TABLE Vehicle (
    vin VARCHAR (17),
	broncoID INT (9),
    licensePlate VARCHAR (20),
    vehicleType VARCHAR (20),
    vehicleMake VARCHAR (20),
    vehicleColor VARCHAR (15),
    vehicleYear INT (4),
    state VARCHAR (15),
    FOREIGN KEY (broncoID) REFERENCES Customer (broncoID),
    PRIMARY KEY (vin));

INSERT INTO Vehicle VALUES
('1HGBH41JXMN109186', '111222333', 'ANY TEXT', 'Sedan', 'Jeep', 'White', '2020', 'California'),
('1AUIE64JCLS358308', '222333444', 'SUNKISS', 'SUV', 'HyunDai', 'Black', '2019', 'Nevada'),
('4DKSG08JFCW275927', '333444555', 'YES MOM', 'Convertible', 'Toyoda', 'Red', '2018', 'Washington');

SELECT * FROM Vehicle;

CREATE TABLE Rate (
	rateID INT (1),
    price INT (3),
    PRIMARY KEY (rateID));

INSERT INTO Rate VALUES
('1', '100'),
('2', '200'),
('3', '300');

SELECT * FROM Rate;

CREATE TABLE Permit (
	permitNumber INT (9),
    rateID INT (2),
    FOREIGN KEY (rateID) REFERENCES Rate (rateID),
    PRIMARY KEY (permitNumber));
    
INSERT INTO Permit VALUES
('111111111', '1'),
('222222222', '2'),
('333333333', '3');

SELECT * FROM Permit;


CREATE TABLE Cart (
	orderNumber BIGINT (12),
    broncoID INT (9),
    FOREIGN KEY (broncoID) REFERENCES Customer (broncoID),
    PRIMARY KEY (orderNumber));

INSERT INTO Cart VALUES 
('343787612345', '111222333'),
('356257864246', '222333444'),
('345672345098', '333444555');

SELECT * FROM Cart;    
    
