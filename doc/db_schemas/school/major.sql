DROP TABLE IF EXISTS major;
CREATE TABLE major
(
  Id VARCHAR(10) NOT NULL PRIMARY KEY,
  Name VARCHAR(100) NOT NULL
);

Insert Into major(Id, Name) values
('COMM1', 'Accounting'), 
('COMM2', 'Business_Finance'),
('COMM3', 'Marketing and Sales'),
('COMM4-D', 'Computer Science and Computer Engineering-D'),
('COMM4-ND', 'Computer Science and Computer Engineering-ND'), 
('COMM5-D', 'Mechanical Engineering-D'),
('COMM5-ND', 'Mechanical Engineering-ND'),

('PR2', 'Agriculture'),
('PR3', 'Biology'), 
('PR5', 'Communications'), 
/*('PR6', 'Computer Science and Computer Engineering'),*/ 
('PR6', 'Criminology'),
('PR7', 'Education'), 
('PR8', 'Engineering'),
('PR9', 'English Literature and Language'),
('PR10', 'Environmental Studies'), 
('PR11', 'Health Services'),
('PR12', 'History'),
('PR13', 'Journalism'), 
('PR14', 'Mathematics'),
/*('PR15', 'Mechanical Engineering'),*/ 
('PR16', 'Nursing'),
('PR17', 'Political Science and Government'),
('PR18', 'Psychology'),

('UNED1', 'Aerospace-Aeronautical-Astronautical_Doctorate'),
('UNED2', 'Biological and Agricultural_Doctorate'),
('UNED3', 'Biomedical_Doctorate'),
('UNED4', 'Chemical_Doctorate'),
('UNED5', 'Civil_Doctorate'),
/*('UNED6', 'Computer_Doctorate'),*/
('UNED7', 'Electrical-Electronic-Communications_Doctorate'),
('UNED8', 'Environmental and Environmental Health_Doctorate'),
('UNED9', 'Industrial and Manufacturing_Doctorate'),
('UNED10', 'Materials_Doctorate'),
/*('UNED11', 'Mechanical_Doctorate'),*/
('UNEND1', 'Aerospace-Aeronautical-Astronautical_No_Doctorate'),
('UNEND2', 'Biomedical_No_Doctorate'),
('UNEND3', 'Civil_No_Doctorate'),
/*('UNEND4', 'Computer_No_Doctorate'),*/
('UNEND5', 'Electrical-Electronic-Communications_No_Doctorate'),
/*('UNEND6', 'Mechanical_No_Doctorate'),*/

('UNB1', 'Entrepreneurship'),
('UNB2', 'Insurance'),
('UNB3', 'International Business'),
('UNB4', 'Management'),
('UNB5', 'Management Information Systems'),
('UNB6', 'Production and Operations Management'),
('UNB7', 'Quantitative Analysis'),
('UNB8', 'Real Estate'),
('UNB9', 'Supply Chain Management and Logistics');

Commit;
