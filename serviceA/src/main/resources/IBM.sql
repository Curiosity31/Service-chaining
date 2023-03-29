CREATE DATABASE service_a; 
USE service_a;
CREATE TABLE IBM(
        id INT PRIMARY KEY AUTO_INCREMENT,
        description VARCHAR(5) NOT NULL
);
INSERT INTO IBM(description) 
VALUES ("IBM");