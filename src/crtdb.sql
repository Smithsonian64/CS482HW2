/*
 Michael Smith
 9/16/2020
 SQL Statement to create the DB for the team project
 */
CREATE TABLE Video (
    videoCode integer NOT NULL,
    videoLength integer,
    PRIMARY KEY (videoCode)
);

CREATE TABLE Model (
    modelNo char(10),
    width numeric(6, 2),
    height numeric(6, 2),
    weight numeric(6, 2),
    depth numeric(6, 2),
    screenSize numeric(6, 2),
    PRIMARY KEY (modelNo)
);

CREATE TABLE Site (
    siteCode integer,
    type varchar(16) CHECK ( type = 'bar' OR
                             type = 'restaurant' ),
    address varchar(100),
    phone varchar(16),
    PRIMARY KEY (siteCode)
);

CREATE TABLE DigitalDisplay (
    serialNo char(10),
    schedulerSystem char(10) check ( schedulerSystem = 'Random' OR
                                    schedulerSystem = 'Smart' OR
                                    schedulerSystem = 'Virtue' ),
    modelNo char(10),
    PRIMARY KEY (serialNo),
    FOREIGN KEY (modelNo) REFERENCES Model(modelNo)
);

CREATE TABLE Client (
    clientId integer,
    name varchar(40),
    phone varchar(16),
    address varchar(100),
    PRIMARY KEY (clientId)
);

CREATE TABLE TechnicalSupport (
    empId integer,
    name varchar(40),
    gender char(1),
    PRIMARY KEY (empId)
);

CREATE TABLE Administrator (
    empId integer,
    name varchar(40),
    gender char(1),
    PRIMARY KEY (empId)
);

CREATE TABLE Salesman (
    empId integer,
    name varchar(40),
    gender char(1),
    PRIMARY KEY (empId)
);

CREATE TABLE AirtimePackage (
    packageId integer,
    class varchar(16) CHECK ( class = 'economy' OR
                              class = 'whole day' OR
                              class = 'golden hours' ),
    startDate date,
    lastDate date,
    frequency integer,
    videoCode integer,
    PRIMARY KEY (packageId)
);

CREATE TABLE AdmWorkHours (
    empId integer,
    day date,
    hours numeric(4, 2),
    PRIMARY KEY (empId, day),
    FOREIGN KEY (empId) REFERENCES Administrator(empId)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Broadcasts (
    videoCode integer,
    siteCode integer,
    PRIMARY KEY (videoCode, sitecode),
    FOREIGN KEY (videoCode) REFERENCES Video(videoCode)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (siteCode) REFERENCES Site (siteCode)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Administers (
    empId integer,
    siteCode integer,
    PRIMARY KEY (empId, sitecode),
    FOREIGN KEY (empId) REFERENCES Administrator(empId)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (siteCode) REFERENCES Site(siteCode)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Specializes (
    empId integer,
    modelNo char(10),
    PRIMARY KEY (empId, modelNo),
    FOREIGN KEY (empId) REFERENCES TechnicalSupport(empId)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (modelNo) REFERENCES Model(modelNo)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Purchases (
    clientId integer,
    empId integer,
    packageId integer,
    commissionRate numeric(4, 2),
    PRIMARY KEY (clientId, empId, packageId),
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (empId) REFERENCES Salesman(empId)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (packageId) REFERENCES AirtimePackage(packageId)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Locates (
    serialNo char(10),
    siteCode integer,
    PRIMARY KEY (serialNo, siteCode),
    FOREIGN KEY (serialNo) REFERENCES DigitalDisplay(serialNo)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (siteCode) REFERENCES Site(siteCode)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);