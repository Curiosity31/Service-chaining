CREATE DATABASE service_b;
USE service_b;
CREATE TABLE CLOUD(
        id INT PRIMARY KEY AUTO_INCREMENT,
        description VARCHAR(10) NOT NULL
);
INSERT INTO CLOUD(description) 
VALUES ("Cloud");