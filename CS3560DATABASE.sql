CREATE DATABASE CPP_PARKING_SYSTEM;

USE CPP_PARKING_SYSTEM;

CREATE TABLE Customer (
	broncoID INT (9),
    firstName VARCHAR (20),
    lastName VARCHAR (50),
    emailAddress VARCHAR (50),
    address VARCHAR (50),
    checkStudent BOOLEAN,
    PRIMARY KEY (broncoID)
);

CREATE TABLE PaymentMethod (
	paymentMethodID INT (9),
    broncoID INT (9),
    cardNumber BIGINT (19),
    securityCode INT (3),
    expirationDateMonth INT (2),
    expirationDateYear INT (4),
    firstName VARCHAR (20),
    lastName VARCHAR (50),
    address VARCHAR (50),
    FOREIGN KEY (broncoID) REFERENCES Customer (broncoID),
    PRIMARY KEY (paymentMethodID, broncoID)
);

CREATE TABLE Vehicle (
	vin VARCHAR (17),
    broncoID INT (9),
    licensePlate VARCHAR (7),
    vehicleType VARCHAR (20),
    vehicleMake VARCHAR (20),
    vehicleColor VARCHAR (15),
    vehicleYear INT (4),
    state VARCHAR (15),
    FOREIGN KEY (broncoID) REFERENCES Customer (broncoID),
    PRIMARY KEY (vin)
);

CREATE TABLE Permit (
	permitID INT (9),
    vin VARCHAR (17),
    FOREIGN KEY (vin) REFERENCES Vehicle (vin),
    PRIMARY KEY (permitID)
);

CREATE TABLE Rate (
	rateID INT (2),
    permitID INT (9),
    rate INT (3),
    rateDescription VARCHAR (50),
    FOREIGN KEY (permitID) REFERENCES Permit (permitID),
    PRIMARY KEY (rateID, permitID)
);
