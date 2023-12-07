CREATE DATABASE  session01_hibernate;
USE session01_hibernate;
CREATE TABLE category (
                          categoryId INT PRIMARY KEY AUTO_INCREMENT,
                          categoryName VARCHAR(50) NOT NULL UNIQUE,
                          status BOOLEAN DEFAULT true
);


INSERT INTO category (categoryName, status) VALUES ('Category 1', true);
INSERT INTO category (categoryName, status) VALUES ('Category 2', true);
INSERT INTO category (categoryName, status) VALUES ('Category 3', false)