CREATE DATABASE  session01_hibernate;
USE session01_hibernate;
CREATE TABLE category (
                          categoryId INT PRIMARY KEY AUTO_INCREMENT,
                          categoryName VARCHAR(50) NOT NULL UNIQUE,
                          status BOOLEAN DEFAULT true
);

CREATE TABLE  products (
    productId INT PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DOUBLE NOT NULL,
    image VARCHAR(255),
    stock INT NOT NULL,
    categoryId INT,
    FOREIGN KEY (categoryId) REFERENCES category(categoryId)
    );


INSERT INTO category (categoryName, status) VALUES ('Category 1', true);
INSERT INTO category (categoryName, status) VALUES ('Category 2', true);
INSERT INTO category (categoryName, status) VALUES ('Category 3', false)