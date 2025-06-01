-- Create the database
CREATE DATABASE CabPro;

-- Switch to the CabPro database
USE CabPro;

-- Create a table to store cab information
CREATE TABLE Cabs (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      cab_type VARCHAR(50) NOT NULL,
                      rate DECIMAL(10, 2) NOT NULL
);

-- Insert cab types
INSERT INTO Cabs (cab_type, rate) VALUES ('Basic', 3.00);
INSERT INTO Cabs (cab_type, rate) VALUES ('Extended', 5.00);
INSERT INTO Cabs (cab_type, rate) VALUES ('Luxury', 7.00);