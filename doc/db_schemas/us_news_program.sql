DROP TABLE IF EXISTS us_news_program;
CREATE TABLE us_news_program
(
  Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(100) NOT NULL
);

Insert us_news_program(Name) values
('Business'),
('Engineering');

Commit;
