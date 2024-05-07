CREATE DATABASE wiss_db;
CREATE USER wiss_user IDENTIFIED BY "secretpw";
GRANT ALL ON wiss_db.* TO wiss_user;

USE wiss_db;

CREATE TABLE Fact (
    id INT PRIMARY KEY NOT NULL,
    fact VARCHAR(300)
);

INSERT INTO Fact (id, fact)
VALUES ("1", "Benin, a country in central Africa, has the highest birth rate of twins around the world. The world average is around 1.3% twins, but the rate in Benin is more than double that, at 3%."),
("2", "You can hear a blue whale's heartbeat from over 2 miles away. Their hearts alone can weigh close to 400 lbs."),
("3", "In 1987, American Airlines saved $40,000 annually by removing one olive from their first class salads."),
("4", "The last letter added to the English alphabet was j in 1524. Prior to that, the j sound was represented by the letter i."),
("5", "Venus is the only planet in our solar system that rotates clockwise."),
("6", "The bark on larger Redwood trees can be as much as two feet thick."),
("7", "One teaspoon of soil contains more microorganisms than there are people on the entire planet.");