DROP TABLE IF EXISTS princeton_review_popular_major;
CREATE TABLE princeton_review_popular_major
(
  Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(100) NOT NULL
);

Insert princeton_review_popular_major(Name) values
('Accounting'), 
('Agriculture'),
('Biology'), 
('Business_Finance'),
('Communications'), 
('Computer Science and Computer Engineering'), 
('Criminology'),
('Education'), 
('Engineering'),
('English Literature and Language'),
('Environmental Studies'), 
('Health Services'),
('History'),
('Journalism'), 
('Marketing and Sales'),
('Mathematics'),
('Mechanical Engineering'), 
('Nursing'),
('Political Science and Government'),
('Psychology');

Commit;
