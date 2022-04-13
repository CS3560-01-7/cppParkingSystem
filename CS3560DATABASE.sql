CREATE DATABASE CPP_PARKING_SYSTEM;

USE CPP_PARKING_SYSTEM;

CREATE TABLE Customer (
	broncoID INT (9),
    firstName VARCHAR (50),
    lastName VARCHAR (50),
    emailAddress VARCHAR (50),
    customerPassword VARCHAR (50),
    address VARCHAR (50),
    checkStudent BOOLEAN,
    PRIMARY KEY (broncoID)
);

CREATE TABLE PaymentMethod (
	paymentMethodID INT (9),
    cardNumber INT (16),
    securityCode INT (3),
    expirationDate INT (4),
    cardName VARCHAR (50),
    address VARCHAR (50),
    PRIMARY KEY (paymentMethodID)
);

CREATE TABLE Vehicle (
	vehicleID INT (9),
    broncoID INT (9),
    licensePlate VARCHAR (7),
    vehicleType VARCHAR (20),
    vehicleMake VARCHAR (20),
    vehicleColor VARCHAR (15),
    vehicleYear INT (4),
    state VARCHAR (15),
    FOREIGN KEY (broncoID) REFERENCES Customer (broncoID),
    PRIMARY KEY (vehicleID, broncoID)
);

CREATE TABLE Cart (
	cartID INT (9),
    broncoID INT (9),
    permitID INT (9),
    FOREIGN KEY (broncoID) REFERENCES Customer (broncoID),
    FOREIGN KEY (permitID) REFERENCES Permit (permitID),
    PRIMARY KEY (cartID, broncoID, permitID)
);

CREATE TABLE Permit (
	permitID INT (9),
    vehicleID INT (9),
	cartID INT (9),
    rateID INT (2),
    FOREIGN KEY (vehicleID) REFERENCES Vehicle (vehicleID),
    FOREIGN KEY (rateID) REFERENCES Rate (rateID),
    PRIMARY KEY (permitID, vehicleID, cartID, rateID)
);

CREATE TABLE Rate (
	rateID INT (2),
    rate INT (3),
    rateDescription VARCHAR (50),
    PRIMARY KEY (rateID)
);