CREATE DATABASE service_c; 
USE service_c;
CREATE TABLE ACADEMY(
        id INT PRIMARY KEY AUTO_INCREMENT,
        description VARCHAR(10) NOT NULL
);
INSERT INTO ACADEMY(description) 
VALUES ("Academy");