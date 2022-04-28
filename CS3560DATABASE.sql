CREATE DATABASE CPP_PARKING_SYSTEM;

USE CPP_PARKING_SYSTEM;
DROP TABLE Rate;
DROP TABLE PaymentMethod;
DROP TABLE Permit;
DROP TABLE Vehicle;
DROP TABLE Customer;

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
    broncoID INT (9),
    cardNumber BIGINT (19),
    securityCode INT (3),
    expirationDateMonth INT (2),
    expirationDateYear INT (4),
    firstName VARCHAR (20),
    lastName VARCHAR (50),
    address VARCHAR (50),
    FOREIGN KEY (broncoID) REFERENCES Customer (broncoID),
    PRIMARY KEY (cardNumber, broncoID)
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

INSERT INTO Customer VALUES ('111111111', 'Lynn', 'Takahashi','pizzahut@gmail.com','123 Sesame Street',TRUE),
('111111112','Professor','Poopypants','professorpoopy@gmail.com','246 Captain Underpants', FALSE),
('111111113','Ethan','Vazquez','evaq@gmail.com','541 Vazqueef Drive', FALSE);
INSERT INTO PaymentMethod VALUES ('111111111','123456789','123','11','25','Lynn','Takahashi','123 Sesame Street');
