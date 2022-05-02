USE CPP_PARKING_SYSTEM;
DROP TABLE PaymentMethod;
DROP TABLE Permit;
DROP TABLE Rate;
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
    customerbroncoID INT (9),
    cardNumber BIGINT (19),
    securityCode INT (3),
    expirationDateMonth INT (2),
    expirationDateYear INT (4),
    firstName VARCHAR (20),
    lastName VARCHAR (50),
    address VARCHAR (50),
    FOREIGN KEY (customerbroncoID) REFERENCES Customer (broncoID),
    PRIMARY KEY (cardNumber, customerbroncoID)
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

CREATE TABLE Rate (
	rateID INT (2),
    rate INT (3),
    rateDescription VARCHAR (50),
    studentcheck BOOLEAN,
    PRIMARY KEY (rateID)
);

CREATE TABLE Permit (
	permitID INT (9),
    rateID INT (2),
    vin VARCHAR (17),
    FOREIGN KEY (vin) REFERENCES Vehicle (vin),
    FOREIGN KEY (rateID) REFERENCES Rate (rateID),
    PRIMARY KEY (permitID)
);



INSERT INTO Customer VALUES ('111111111', 'Lynn', 'Takahashi','pizzahut@gmail.com','123 Sesame Street',TRUE),
('111111112','Professor','Poopypants','professorpoopy@gmail.com','246 Captain Underpants', FALSE),
('111111113','Ethan','Vazquez','evaq@gmail.com','541 Vazqueef Drive', FALSE);
INSERT INTO PaymentMethod VALUES ('111111111','123456789','123','11','25','Lynn','Takahashi','123 Sesame Street');
INSERT INTO Vehicle VALUES ('12345678901234567','111111111','ABCDEFG','Corolla','Toyota','gray','2012', 'CA');
INSERT INTO Rate VALUES ('1', '150', 'STUDENT FALL MO/WE/FRI', true),
('2', '150', 'STUDENT FALL TU/TH', true),('3', '200', 'STUDENT FALL WEEK', true),
('4', '100', 'FACULTY FALL WEEK', false);
INSERT INTO Permit values ('1', '1', '12345678901234567');


SELECT * FROM Rate;
