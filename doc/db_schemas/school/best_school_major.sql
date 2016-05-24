DROP TABLE IF EXISTS best_school_major;
DROP TABLE IF EXISTS major;
CREATE TABLE major
(
  Id VARCHAR(10) NOT NULL PRIMARY KEY,
  Name VARCHAR(100) NOT NULL
);
CREATE TABLE best_school_major
(
  Major_Id VARCHAR(10) NOT NULL,
  Rank INT,
  School_Id INT NOT NULL,
  School_Name VARCHAR(80),
  Primary Key (Major_Id, School_Id),
  FOREIGN KEY (School_Id) REFERENCES school (Id),
  FOREIGN KEY (Major_Id) REFERENCES major (Id)
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
('UNED2', 'Biological-Agricultural_Doctorate'),
('UNED3', 'Biomedical_Doctorate'),
('UNED4', 'Chemical_Doctorate'),
('UNED5', 'Civil_Doctorate'),
/*('UNED6', 'Computer_Doctorate'),*/
('UNED7', 'Electrical-Electronic-Communications_Doctorate'),
('UNED8', 'Environmental-Environmental Health_Doctorate'),
('UNED9', 'Industrial-Manufacturingh_Doctorate'),
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
('UNB6', 'Production-Operations Management'),
('UNB7', 'Quantitative Analysis'),
('UNB8', 'Real Estate'),
('UNB9', 'Supply Chain Management and Logistics');

/*Aerospace-Aeronautical-Astronautical_Doctorate*/
Insert best_school_major values('UNED1',1,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNED1',2,36,'Georgia Institute of Technology');
Insert best_school_major values('UNED1',3,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNED1',4,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNED1',5,6,'California Institute of Technology');
Insert best_school_major values('UNED1',6,4,'Stanford University');
Insert best_school_major values('UNED1',7,1,'Princeton University');
Insert best_school_major values('UNED1',7,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNED1',9,56,'University of Maryland-College Park');
Insert best_school_major values('UNED1',10,80,'University of Colorado-Boulder');
Insert best_school_major values('UNED1',10,45,'University of Texas-Austin');
Insert best_school_major values('UNED1',12,62,'Texas A&M University-College Station');
Insert best_school_major values('UNED1',12,21,'University of California-Berkeley');
Insert best_school_major values('UNED1',14,48,'Pennsylvania State University-University Park');
Insert best_school_major values('UNED1',15,42,'University of Washington');
Insert best_school_major values('UNED1',15,71,'Virginia Tech');

/*Biological-Agricultural_Doctorate*/
Insert best_school_major values('UNED2',1,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNED2',2,86,'Iowa State University');
Insert best_school_major values('UNED2',2,62,'Texas A&M University-College Station');
Insert best_school_major values('UNED2',2,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNED2',5,43,'University of California-Davis');
Insert best_school_major values('UNED2',6,49,'University of Florida');
Insert best_school_major values('UNED2',6,71,'Virginia Tech');
Insert best_school_major values('UNED2',8,13,'Cornell University');
Insert best_school_major values('UNED2',9,95,'University of Nebraska-Lincoln');
Insert best_school_major values('UNED2',10,89,'North Carolina State University-Raleigh');
Insert best_school_major values('UNED2',10,58,'Ohio State University-Columbus');
Insert best_school_major values('UNED2',12,72,'Michigan State University');

/*Biomedical_Doctorate*/
Insert best_school_major values('UNED3',1,16,'Johns Hopkins University');
Insert best_school_major values('UNED3',2,8,'Duke University');
Insert best_school_major values('UNED3',3,36,'Georgia Institute of Technology');
Insert best_school_major values('UNED3',4,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNED3',4,17,'Rice University');
Insert best_school_major values('UNED3',4,4,'Stanford University');
Insert best_school_major values('UNED3',7,39,'University of California-San Diego');
Insert best_school_major values('UNED3',8,5,'University of Pennsylvania');
Insert best_school_major values('UNED3',9,21,'University of California-Berkeley');
Insert best_school_major values('UNED3',10,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNED3',11,42,'University of Washington');
Insert best_school_major values('UNED3',12,57,'Boston University');
Insert best_school_major values('UNED3',12,41,'Case Western Reserve University');
Insert best_school_major values('UNED3',12,15,'Northwestern University');
Insert best_school_major values('UNED3',15,19,'Vanderbilt University');
Insert best_school_major values('UNED3',16,45,'University of Texas-Austin');
Insert best_school_major values('UNED3',17,38,'University of Wisconsin-Madison');
Insert best_school_major values('UNED3',18,23,'University of Virginia');
Insert best_school_major values('UNED3',18,12,'Washington University in St. Louis');
Insert best_school_major values('UNED3',20,6,'California Institute of Technology');
Insert best_school_major values('UNED3',21,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNED3',21,61,'University of Pittsburgh');

/*Chemical_Doctorate*/
Insert best_school_major values('UNED4',1,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNED4',2,21,'University of California-Berkeley');
Insert best_school_major values('UNED4',3,4,'Stanford University');
Insert best_school_major values('UNED4',4,45,'University of Texas-Austin');
Insert best_school_major values('UNED4',5,74,'University of Minnesota-Twin Cities');
Insert best_school_major values('UNED4',6,36,'Georgia Institute of Technology');
Insert best_school_major values('UNED4',6,38,'University of Wisconsin-Madison');
Insert best_school_major values('UNED4',8,6,'California Institute of Technology');
Insert best_school_major values('UNED4',9,1,'Princeton University');
Insert best_school_major values('UNED4',10,73,'University of Delaware');
Insert best_school_major values('UNED4',11,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNED4',12,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNED4',13,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNED4',14,13,'Cornell University');
Insert best_school_major values('UNED4',14,15,'Northwestern University');
Insert best_school_major values('UNED4',16,48,'Pennsylvania State University-University Park');
Insert best_school_major values('UNED4',17,22,'Carnegie Mellon University');
Insert best_school_major values('UNED4',17,46,'University of California-Santa Barbara');
Insert best_school_major values('UNED4',19,89,'North Carolina State University-Raleigh');
Insert best_school_major values('UNED4',20,80,'University of Colorado-Boulder');
Insert best_school_major values('UNED4',21,62,'Texas A&M University-College Station');

/*Civil_Doctorate*/
Insert best_school_major values('UNED5',1,21,'University of California-Berkeley');
Insert best_school_major values('UNED5',2,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNED5',3,36,'Georgia Institute of Technology');
Insert best_school_major values('UNED5',4,4,'Stanford University');
Insert best_school_major values('UNED5',5,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNED5',6,45,'University of Texas-Austin');
Insert best_school_major values('UNED5',7,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNED5',8,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNED5',9,13,'Cornell University');
Insert best_school_major values('UNED5',9,71,'Virginia Tech');
Insert best_school_major values('UNED5',11,62,'Texas A&M University-College Station');
Insert best_school_major values('UNED5',12,38,'University of Wisconsin-Madison');
Insert best_school_major values('UNED5',13,22,'Carnegie Mellon University');
Insert best_school_major values('UNED5',14,15,'Northwestern University');
Insert best_school_major values('UNED5',15,6,'California Institute of Technology');
Insert best_school_major values('UNED5',15,48,'Pennsylvania State University-University Park');
Insert best_school_major values('UNED5',17,1,'Princeton University');
Insert best_school_major values('UNED5',17,80,'University of Colorado-Boulder');

/*Computer Science and Computer Engineering-D*/
Insert best_school_major values('COMM4-D',1,7,'Massachusetts Institute of Technology');
Insert best_school_major values('COMM4-D',2,4,'Stanford University');
Insert best_school_major values('COMM4-D',3,22,'Carnegie Mellon University');
Insert best_school_major values('COMM4-D',4,21,'University of California-Berkeley');
Insert best_school_major values('COMM4-D',5,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('COMM4-D',6,36,'Georgia Institute of Technology');
Insert best_school_major values('COMM4-D',7,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('COMM4-D',8,45,'University of Texas-Austin');
Insert best_school_major values('COMM4-D',9,6,'California Institute of Technology');
Insert best_school_major values('COMM4-D',10,13,'Cornell University');
Insert best_school_major values('COMM4-D',11,42,'University of Washington');
Insert best_school_major values('COMM4-D',12,1,'Princeton University');
Insert best_school_major values('COMM4-D',13,66,'Purdue University-West Lafayette');
Insert best_school_major values('COMM4-D',13,38,'University of Wisconsin-Madison');
Insert best_school_major values('COMM4-D',15,27,'University of Southern California');

Insert best_school_major values('COMM4-D',null, 142, 'Auburn University');
Insert best_school_major values('COMM4-D',null, 57, 'Boston University');
Insert best_school_major values('COMM4-D',null, 4003, 'Bradley University');
Insert best_school_major values('COMM4-D',null, 14,'Brown University');
Insert best_school_major values('COMM4-D',null, 68, 'Clemson University');
Insert best_school_major values('COMM4-D',null, 108, 'Drexel University');
Insert best_school_major values('COMM4-D',null, 112, 'Florida State University');
Insert best_school_major values('COMM4-D',null, 139, 'George Mason University');
Insert best_school_major values('COMM4-D',null, 100, 'Illinois Institute of Technology');
Insert best_school_major values('COMM4-D',null, 86, 'Iowa State University');
Insert best_school_major values('COMM4-D',null, 16, 'Johns Hopkins University');
Insert best_school_major values('COMM4-D',null, 31, 'Lehigh University');
Insert best_school_major values('COMM4-D',null, 72, 'Michigan State University');
Insert best_school_major values('COMM4-D',null, 117, 'Missouri University of Science & Technology');
Insert best_school_major values('COMM4-D',null, 122, 'New Jersey Institute of Technology');
Insert best_school_major values('COMM4-D',null, 97, 'Northeastern University');
Insert best_school_major values('COMM4-D',null, 15, 'Northwestern University');
Insert best_school_major values('COMM4-D',null, 48, 'Pennsylvania State University-University Park');
Insert best_school_major values('COMM4-D',null, 17, 'Rice University');
Insert best_school_major values('COMM4-D',null, 44, 'Rensselaer Polytechnic Institute');
Insert best_school_major values('COMM4-D',null, 3005, 'Seattle University');
Insert best_school_major values('COMM4-D',null, 82, 'SUNY-Binghamton');
Insert best_school_major values('COMM4-D',null, 62, 'Texas A&M University-College Station');
Insert best_school_major values('COMM4-D',null, 1030, 'United States Air Force Academy');
Insert best_school_major values('COMM4-D',null, 105,'University of Arizona');
Insert best_school_major values('COMM4-D',null, 25, 'University of California-Los Angeles');
Insert best_school_major values('COMM4-D',null, 103, 'University of California-Riverside');
Insert best_school_major values('COMM4-D',null, 156,'University of Maryland-Baltimore County');
Insert best_school_major values('COMM4-D',null, 96, 'University of Massachusetts-Amherst');
Insert best_school_major values('COMM4-D',null, 63, 'Worcester Polytechnic Institute');
Insert best_school_major values('COMM4-D',null, 6014, 'Champlain College');
Insert best_school_major values('COMM4-D',null, 3003, 'Gonzaga University');
Insert best_school_major values('COMM4-D',null, 5018, 'Hampton University');

/*Computer Science and Computer Engineering-ND*/
Insert best_school_major values('COMM4-ND',1,10003,'Rose-Hulman Institute of Technology');
Insert best_school_major values('COMM4-ND',2,1014,'Harvey Mudd College');
Insert best_school_major values('COMM4-ND',3,1031,'Bucknell University');
Insert best_school_major values('COMM4-ND',4,6001,'Cooper Union');
Insert best_school_major values('COMM4-ND',5,10001,'Franklin W. Olin College of Engineering');

/*Electrical-Electronic-Communications_Doctorate*/
Insert best_school_major values('UNED7',1,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNED7',2,4,'Stanford University');
Insert best_school_major values('UNED7',3,21,'University of California-Berkeley');
Insert best_school_major values('UNED7',4,36,'Georgia Institute of Technology');
Insert best_school_major values('UNED7',5,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNED7',6,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNED7',7,6,'California Institute of Technology');
Insert best_school_major values('UNED7',8,45,'University of Texas-Austin');
Insert best_school_major values('UNED7',9,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNED7',10,13,'Cornell University');
Insert best_school_major values('UNED7',11,22,'Carnegie Mellon University');
Insert best_school_major values('UNED7',12,1,'Princeton University');
Insert best_school_major values('UNED7',13,25,'University of California-Los Angeles');
Insert best_school_major values('UNED7',14,38,'University of Wisconsin-Madison');
Insert best_school_major values('UNED7',14,71,'Virginia Tech');
Insert best_school_major values('UNED7',14,39,'University of California-San Diego');

/*Environmental-Environmental Health_Doctorate*/
Insert best_school_major values('UNED8',1,4,'Stanford University');
Insert best_school_major values('UNED8',2,21,'University of California-Berkeley');
Insert best_school_major values('UNED8',3,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNED8',4,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNED8',5,45,'University of Texas-Austin');
Insert best_school_major values('UNED8',6,36,'Georgia Institute of Technology');
Insert best_school_major values('UNED8',7,16,'Johns Hopkins University');
Insert best_school_major values('UNED8',8,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNED8',9,22,'Carnegie Mellon University');
Insert best_school_major values('UNED8',10,13,'Cornell University');
Insert best_school_major values('UNED8',11,71,'Virginia Tech');
Insert best_school_major values('UNED8',12,6,'California Institute of Technology');
Insert best_school_major values('UNED8',13,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNED8',13,80,'University of Colorado-Boulder');
Insert best_school_major values('UNED8',15,89,'North Carolina State University-Raleigh');
Insert best_school_major values('UNED8',15,49,'University of Florida');

/*Industrial-Manufacturingh_Doctorate*/
Insert best_school_major values('UNED9',1,36,'Georgia Institute of Technology');
Insert best_school_major values('UNED9',2,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNED9',3,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNED9',3,21,'University of California-Berkeley');
Insert best_school_major values('UNED9',5,15,'Northwestern University');
Insert best_school_major values('UNED9',5,4,'Stanford University');
Insert best_school_major values('UNED9',5,71,'Virginia Tech');
Insert best_school_major values('UNED9',8,48,'Pennsylvania State University-University Park');
Insert best_school_major values('UNED9',9,38,'University of Wisconsin-Madison');
Insert best_school_major values('UNED9',10,13,'Cornell University');
Insert best_school_major values('UNED9',11,62,'Texas A&M University-College Station');
Insert best_school_major values('UNED9',12,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNED9',13,89,'North Carolina State University-Raleigh');
Insert best_school_major values('UNED9',14,58,'Ohio State University-Columbus');
Insert best_school_major values('UNED9',15,9,'Columbia Universityh');

/*Materials_Doctorate*/
Insert best_school_major values('UNED10',1,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNED10',2,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNED10',3,21,'University of California-Berkeley');
Insert best_school_major values('UNED10',4,15,'Northwestern University');
Insert best_school_major values('UNED10',5,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNED10',6,4,'Stanford University');
Insert best_school_major values('UNED10',7,36,'Georgia Institute of Technology');
Insert best_school_major values('UNED10',8,13,'Cornell University');
Insert best_school_major values('UNED10',9,48,'Pennsylvania State University-University Park');
Insert best_school_major values('UNED10',10,46,'University of California-Santa Barbara');
Insert best_school_major values('UNED10',11,22,'Carnegie Mellon University');
Insert best_school_major values('UNED10',12,6,'California Institute of Technology');
Insert best_school_major values('UNED10',13,49,'University of Florida');
Insert best_school_major values('UNED10',14,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNED10',14,5,'University of Pennsylvania');
Insert best_school_major values('UNED10',16,58,'Ohio State University-Columbus');
Insert best_school_major values('UNED10',17,78,'Colorado School of Mines');
Insert best_school_major values('UNED10',17,17,'Rice University');
Insert best_school_major values('UNED10',17,71,'Virginia Tech');

/*Mechanical Engineering-D*/
Insert best_school_major values('COMM5-D',1,7,'Massachusetts Institute of Technology');
Insert best_school_major values('COMM5-D',2,36,'Georgia Institute of Technology');
Insert best_school_major values('COMM5-D',3,21,'University of California-Berkeley');
Insert best_school_major values('COMM5-D',4,4,'Stanford University');
Insert best_school_major values('COMM5-D',5,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('COMM5-D',6,66,'Purdue University-West Lafayette');
Insert best_school_major values('COMM5-D',6,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('COMM5-D',8,13,'Cornell University');
Insert best_school_major values('COMM5-D',9,6,'California Institute of Technology');
Insert best_school_major values('COMM5-D',10,45,'University of Texas-Austin');
Insert best_school_major values('COMM5-D',11,22,'Carnegie Mellon University');
Insert best_school_major values('COMM5-D',12,1,'Princeton University');
Insert best_school_major values('COMM5-D',13,15,'Northwestern University');
Insert best_school_major values('COMM5-D',14,38,'University of Wisconsin-Madison');
Insert best_school_major values('COMM5-D',15,62,'Texas A&M University-College Station');
Insert best_school_major values('COMM5-D',15,71,'Virginia Tech');
Insert best_school_major values('COMM5-D',17,48,'Pennsylvania State University-University Park');
Insert best_school_major values('COMM5-D',17,5,'University of Pennsylvania');
Insert best_school_major values('COMM5-D',19,56,'University of Maryland-College Park');
Insert best_school_major values('COMM5-D',null, 142, 'Auburn University');
Insert best_school_major values('COMM5-D',null, 4003, 'Bradley University');
Insert best_school_major values('COMM5-D',null, 124, 'Clarkson University');
Insert best_school_major values('COMM5-D',null, 125, 'Colorado State University');
Insert best_school_major values('COMM5-D',null, 108, 'Drexel University');
Insert best_school_major values('COMM5-D',null, 100, 'Illinois Institute of Technology');
Insert best_school_major values('COMM5-D',null, 86, 'Iowa State University');
Insert best_school_major values('COMM5-D',null, 31, 'Lehigh University');
Insert best_school_major values('COMM5-D',null, 122, 'New Jersey Institute of Technology');
Insert best_school_major values('COMM5-D',null, 89,'North Carolina State University-Raleigh');
Insert best_school_major values('COMM5-D',null, 2006, 'Rochester Institute of Technology');
Insert best_school_major values('COMM5-D',null, 118, 'University at Buffalo-SUNY');

/*Mechanical Engineering-ND*/
Insert best_school_major values('COMM5-ND',1,10003,'Rose-Hulman Institute of Technology');
Insert best_school_major values('COMM5-ND',2,10001,'Franklin W. Olin College of Engineering');
Insert best_school_major values('COMM5-ND',3,3009,'California Polytechnic State University-San Luis Obispo');
Insert best_school_major values('COMM5-ND',4,1021,'United States Military Academy');
Insert best_school_major values('COMM5-ND',5,1014,'Harvey Mudd College');
Insert best_school_major values('COMM5-ND',5,1030,'United States Air Force Academy');
Insert best_school_major values('COMM5-ND',7,1031,'Bucknell University');
Insert best_school_major values('COMM5-ND',7,4024,'Kettering University');
Insert best_school_major values('COMM5-ND',9,6001,'Cooper Union');
Insert best_school_major values('COMM5-ND',10,1010,'United States Naval Academy');
Insert best_school_major values('COMM5-ND',null, 1133, 'Grove City College');

/*Aerospace-Aeronautical-Astronautical_No_Doctorate*/
Insert best_school_major values('UNEND1',1,5009,'Embry-Riddle Aeronautical University');
Insert best_school_major values('UNEND1',2,1030,'United States Air Force Academy');
Insert best_school_major values('UNEND1',3,5133,'Embry-Riddle Aeronautical University-Prescott');

/*Biomedical_No_Doctorate*/
Insert best_school_major values('UNEND2',1,10003,'Rose-Hulman Institute of Technology');

/*UNEND3*/
Insert best_school_major values('UNEND3',1,10003,'Rose-Hulman Institute of Technology');
Insert best_school_major values('UNEND3',2,1021,'United States Military Academy');
Insert best_school_major values('UNEND3',3,3009,'California Polytechnic State University-San Luis Obispo');
Insert best_school_major values('UNEND3',4,1031,'Bucknell University');
Insert best_school_major values('UNEND3',5,4056,'Lawrence Technological University');

/*Electrical-Electronic-Communications_No_Doctorate*/
Insert best_school_major values('UNEND5',1,10003,'Rose-Hulman Institute of Technology');
Insert best_school_major values('UNEND5',2,1031,'Bucknell University');
Insert best_school_major values('UNEND5',2,10001,'Franklin W. Olin College of Engineering');
Insert best_school_major values('UNEND5',4,1014,'Harvey Mudd College');
Insert best_school_major values('UNEND5',5,1030,'United States Air Force Academy');

/*Accounting*/
Insert best_school_major values('COMM1',1,45,'University of Texas-Austin');
Insert best_school_major values('COMM1',2,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('COMM1',3,79,'Brigham Young University-Provo');
Insert best_school_major values('COMM1',4,20,'University of Notre Dame');
Insert best_school_major values('COMM1',4,5,'University of Pennsylvania');
Insert best_school_major values('COMM1',6,27,'University of Southern California');
Insert best_school_major values('COMM1',7,75,'Indiana University-Bloomington');
Insert best_school_major values('COMM1',8,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('COMM1',9,34,'New York University');
Insert best_school_major values('COMM1',10,49,'University of Florida');
Insert best_school_major values('COMM1',11,42,'University of Washington');
Insert best_school_major values('COMM1',12,72,'Michigan State University');
Insert best_school_major values('COMM1',13,58,'Ohio State University-Columbus');
Insert best_school_major values('COMM1',13,3005,'Seattle University');
Insert best_school_major values('COMM1',13,21,'University of California-Berkeley');
Insert best_school_major values('COMM1',13,60,'University of Georgia');
Insert best_school_major values('COMM1',17,37,'Boston College');
Insert best_school_major values('COMM1',17,38,'University of Wisconsin-Madison');
Insert best_school_major values('COMM1',19,4000,'Creighton University');
Insert best_school_major values('COMM1',19,3002,'Loyola Marymount University');
Insert best_school_major values('COMM1',21,2005,'Fairfield University');
Insert best_school_major values('COMM1',21,2014,'St. Joseph-s University');
Insert best_school_major values('COMM1',21,28,'University of North Carolina-Chapel Hill');
Insert best_school_major values('COMM1',21,23,'University of Virginia');
Insert best_school_major values('COMM1',21,30,'Wake Forest UniversityWake Forest University');
Insert best_school_major values('COMM1',26,2002,'Bentley University');
Insert best_school_major values('COMM1',26,4006,'John Carroll University');
Insert best_school_major values('COMM1',26,62,'Texas A&M University-College Station');
Insert best_school_major values('COMM1',29,111,'Loyola University Chicago');
Insert best_school_major values('COMM1',29,2004,'Loyola University Maryland');
Insert best_school_major values('COMM1',31,13,'Cornell University');
Insert best_school_major values('COMM1',31,2007,'University of Scranton');
Insert best_school_major values('COMM1',33,127,'Arizona State University-Tempe');
Insert best_school_major values('COMM1',33,188,'University of Alabama');
Insert best_school_major values('COMM1',null, 2046, 'Alfred University');
Insert best_school_major values('COMM1',null, 142, 'Auburn University');
Insert best_school_major values('COMM1',null, 10000, 'Babson College');
Insert best_school_major values('COMM1',null, 76, 'Baylor University');
Insert best_school_major values('COMM1',null, 1119, 'Birmingham-Southern College');
Insert best_school_major values('COMM1',null, 57, 'Boston University');
Insert best_school_major values('COMM1',null, 1031, 'Bucknell University');
Insert best_school_major values('COMM1',null, 1120, 'Calvin College');
Insert best_school_major values('COMM1',null, 1008, 'Claremont McKenna College');
Insert best_school_major values('COMM1',null, 68, 'Clemson University');
Insert best_school_major values('COMM1',null, 5011, 'College of Charleston');
Insert best_school_major values('COMM1',null, 133, 'DePaul University');
Insert best_school_major values('COMM1',null, 108, 'Drexel University');
Insert best_school_major values('COMM1',null, 130, 'Duquesne University');
Insert best_school_major values('COMM1',null, 5000, 'Elon University');
Insert best_school_major values('COMM1',null, 18, 'Emory University');
Insert best_school_major values('COMM1',null, 69, 'Fordham University');
Insert best_school_major values('COMM1',null, 24, 'Georgetown University');
Insert best_school_major values('COMM1',null, 86, 'Iowa State University');
Insert best_school_major values('COMM1',null, 5007, 'James Madison University');
Insert best_school_major values('COMM1',null, 2019, 'Le Moyne College');
Insert best_school_major values('COMM1',null, 31, 'Lehigh University');
Insert best_school_major values('COMM1',null, 84, 'Marquette University');
Insert best_school_major values('COMM1',null, 15, 'Northwestern University');
Insert best_school_major values('COMM1',null, 48, 'Pennsylvania State University-University Park');
Insert best_school_major values('COMM1',null, 55, 'Pepperdine University');
Insert best_school_major values('COMM1',null, 2022, 'Rider University');
Insert best_school_major values('COMM1',null, 2006, 'Rochester Institute of Technology');
Insert best_school_major values('COMM1',null, 134, 'Seton Hall University');
Insert best_school_major values('COMM1',null, 2061, 'Suffolk University');
Insert best_school_major values('COMM1',null, 129, 'Temple University');
Insert best_school_major values('COMM1',null, 189, 'University of Houston');
Insert best_school_major values('COMM1',null, 147, 'University of Texas-Dallas');

/*Business_Finance*/
Insert best_school_major values('COMM2',1,5,'University of Pennsylvania');
Insert best_school_major values('COMM2',2,34,'New York University');
Insert best_school_major values('COMM2',3,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('COMM2',4,7,'Massachusetts Institute of Technology');
Insert best_school_major values('COMM2',5,21,'University of California—​Berkeley');
Insert best_school_major values('COMM2',6,45,'University of Texas-Austin');
Insert best_school_major values('COMM2',7,23,'University of Virginia');
Insert best_school_major values('COMM2',8,22,'Carnegie Mellon University');
Insert best_school_major values('COMM2',9,28,'University of North Carolina-Chapel Hill');
Insert best_school_major values('COMM2',10,75,'Indiana University-Bloomington');
Insert best_school_major values('COMM2',11,3005,'Seattle University');
Insert best_school_major values('COMM2',12,37,'Boston College');
Insert best_school_major values('COMM2',13,58,'Ohio State University-Columbus');
Insert best_school_major values('COMM2',14,4000,'Creighton University');
Insert best_school_major values('COMM2',15,4005,'Xavier University');
Insert best_school_major values('COMM2',16,69,'Fordham University');
Insert best_school_major values('COMM2',16,12,'Washington University in St. Louis');
Insert best_school_major values('COMM2',18,13,'Cornell University');
Insert best_school_major values('COMM2',18,2005,'Fairfield University');
Insert best_school_major values('COMM2',20,20,'University of Notre Dame');
Insert best_school_major values('COMM2',21,84,'Marquette University');
Insert best_school_major values('COMM2',22,2004,'Loyola University Maryland');
Insert best_school_major values('COMM2',22,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('COMM2',22,2007,'University of Scranton');
Insert best_school_major values('COMM2',22,27,'University of Southern California');
Insert best_school_major values('COMM2',22,38,'University of Wisconsin-Madison');
Insert best_school_major values('COMM2',27,2033,'Canisius College');
Insert best_school_major values('COMM2',27,49,'University of Florida');
Insert best_school_major values('COMM2',29,72,'Michigan State University');
Insert best_school_major values('COMM2',29,48,'Pennsylvania State University-University Park');

/*Marketing and Sales*/
Insert best_school_major values('COMM3',1,5,'University of Pennsylvania');
Insert best_school_major values('COMM3',2,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('COMM3',3,34,'New York University');
Insert best_school_major values('COMM3',4,21,'University of California—​Berkeley');
Insert best_school_major values('COMM3',5,45,'University of Texas-Austin');
Insert best_school_major values('COMM3',6,28,'University of North Carolina-Chapel Hill');
Insert best_school_major values('COMM3',7,75,'Indiana University-Bloomington');
Insert best_school_major values('COMM3',8,23,'University of Virginia');
Insert best_school_major values('COMM3',9,38,'University of Wisconsin-Madison');
Insert best_school_major values('COMM3',10,2014,'St. Joseph-s University');
Insert best_school_major values('COMM3',11,27,'University of Southern California');
Insert best_school_major values('COMM3',12,74,'University of Minnesota-Twin Cities');
Insert best_school_major values('COMM3',13,2005,'Fairfield University');
Insert best_school_major values('COMM3',14,3002,'Loyola Marymount University');
Insert best_school_major values('COMM3',15,58,'Ohio State University-Columbus');
Insert best_school_major values('COMM3',16,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('COMM3',16,20,'University of Notre Dame');
Insert best_school_major values('COMM3',18,13,'Cornell University');
Insert best_school_major values('COMM3',18,69,'Fordham University');
Insert best_school_major values('COMM3',18,2004,'Loyola University Maryland');
Insert best_school_major values('COMM3',21,18,'Emory University');
Insert best_school_major values('COMM3',21,3003,'Gonzaga University');
Insert best_school_major values('COMM3',21,111,'Loyola University Chicago');
Insert best_school_major values('COMM3',21,7,'Massachusetts Institute of Technology');
Insert best_school_major values('COMM3',21,48,'Pennsylvania State University-University Park');
Insert best_school_major values('COMM3',21,12,'Washington University in St. Louis');
Insert best_school_major values('COMM3',27,49,'University of Florida');
Insert best_school_major values('COMM3',null, 10000, 'Babson College');
Insert best_school_major values('COMM3',null, 76, 'Baylor University');
Insert best_school_major values('COMM3',null, 2002, 'Bentley University');
Insert best_school_major values('COMM3',null, 130, 'Duquesne University');
Insert best_school_major values('COMM3',null, 2005, 'Fairfield University');
Insert best_school_major values('COMM3',null, 140, 'Hofstra University');
Insert best_school_major values('COMM3',null, 86, 'Iowa State University');
Insert best_school_major values('COMM3',null, 5007, 'James Madison University');
Insert best_school_major values('COMM3',null, 70, 'Miami University-Oxford');
Insert best_school_major values('COMM3',null, 2001, 'Providence College');
Insert best_school_major values('COMM3',null, 3005, 'Seattle University');
Insert best_school_major values('COMM3',null, 1113, 'Siena College');
Insert best_school_major values('COMM3',null, 51, 'Syracuse University');
Insert best_school_major values('COMM3',null, 62, 'Texas A&M University-College Station');
Insert best_school_major values('COMM3',null, 170, 'University of Central Florida');
Insert best_school_major values('COMM3',null, 146, 'University of Mississippi');
Insert best_school_major values('COMM3',null, 158, 'University of South Florida');
Insert best_school_major values('COMM3',null, 45, 'University of Texas-Austin');

/*Entrepreneurship*/
Insert best_school_major values('UNB1',1,10000,'Babson College');
Insert best_school_major values('UNB1',2,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNB1',3,27,'University of Southern California');
Insert best_school_major values('UNB1',4,21,'University of California—​Berkeley');
Insert best_school_major values('UNB1',4,5,'University of Pennsylvania');
Insert best_school_major values('UNB1',6,75,'Indiana University-Bloomington');
Insert best_school_major values('UNB1',7,3002,'Loyola Marymount University');
Insert best_school_major values('UNB1',7,83,'Saint Louis University');
Insert best_school_major values('UNB1',7,105,'University of Arizona');
Insert best_school_major values('UNB1',10,28,'University of North Carolina-Chapel Hill');
Insert best_school_major values('UNB1',10,4005,'Xavier University');
Insert best_school_major values('UNB1',12,51,'Syracuse University');
Insert best_school_major values('UNB1',13,45,'University of Texas-Austin');
Insert best_school_major values('UNB1',14,76,'Baylor University');
Insert best_school_major values('UNB1',15,69,'Fordham University');
Insert best_school_major values('UNB1',16,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNB1',17,34,'New York University');
Insert best_school_major values('UNB1',17,56,'University of Maryland-College Park');
Insert best_school_major values('UNB1',19,3003,'Gonzaga University');
Insert best_school_major values('UNB1',20,107,'Texas Christian University');
Insert best_school_major values('UNB1',21,151,'San Diego State University');
Insert best_school_major values('UNB1',22,2007,'University of Scranton');
Insert best_school_major values('UNB1',23,168,'Ball State University');
Insert best_school_major values('UNB1',23,2002,'Bentley University');
Insert best_school_major values('UNB1',23,79,'Brigham Young University-Provo');
Insert best_school_major values('UNB1',23,42,'University of Washington');

/*Insurance*/
Insert best_school_major values('UNB2',1,5,'University of Pennsylvania');
Insert best_school_major values('UNB2',2,60,'University of Georgia');
Insert best_school_major values('UNB2',3,2014,'St. Joseph-s University');
Insert best_school_major values('UNB2',4,38,'University of Wisconsin-Madison');
Insert best_school_major values('UNB2',5,129,'Temple University');
Insert best_school_major values('UNB2',6,215,'Georgia State University');
Insert best_school_major values('UNB2',7,112,'Florida State University');
Insert best_school_major values('UNB2',8,34,'New York University');
Insert best_school_major values('UNB2',9,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNB2',10,45,'University of Texas-Austin');
Insert best_school_major values('UNB2',11,113,'University of South Carolina');
Insert best_school_major values('UNB2',12,149,'Illinois State University');
Insert best_school_major values('UNB2',12,48,'Pennsylvania State University-University Park');

/*International Business*/
Insert best_school_major values('UNB3',1,113,'University of South Carolina');
Insert best_school_major values('UNB3',2,34,'New York University');
Insert best_school_major values('UNB3',3,27,'University of Southern California');
Insert best_school_major values('UNB3',4,5,'University of Pennsylvania');
Insert best_school_major values('UNB3',5,21,'University of California—​Berkeley');
Insert best_school_major values('UNB3',6,213,'Florida International University');
Insert best_school_major values('UNB3',7,83,'Saint Louis University');
Insert best_school_major values('UNB3',7,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNB3',9,24,'Georgetown University');
Insert best_school_major values('UNB3',10,151,'San Diego State University');
Insert best_school_major values('UNB3',11,54,'George Washington University');
Insert best_school_major values('UNB3',12,250,'University of Missouri-St. Louis');
Insert best_school_major values('UNB3',13,129,'Temple University');
Insert best_school_major values('UNB3',14,69,'Fordham University');
Insert best_school_major values('UNB3',15,97,'Northeastern University');
Insert best_school_major values('UNB3',16,166,'University of Hawaii-Manoa');
Insert best_school_major values('UNB3',17,72,'Michigan State University');
Insert best_school_major values('UNB3',17,42,'University of Washington');
Insert best_school_major values('UNB3',19,79,'Brigham Young University-Provo');
Insert best_school_major values('UNB3',20,119,'Washington State University');
Insert best_school_major values('UNB3',21,87,'American University');
Insert best_school_major values('UNB3',21,45,'University of Texas-Austin');
Insert best_school_major values('UNB3',21,23,'University of Virginia');
Insert best_school_major values('UNB3',24,4006,'John Carroll University');
Insert best_school_major values('UNB3',24,2004,'Loyola University Maryland');
Insert best_school_major values('UNB3',24,5012,'Loyola University New Orleans');
Insert best_school_major values('UNB3',24,28,'University of North Carolina-Chapel Hill');
Insert best_school_major values('UNB3',28,75,'Indiana University-Bloomington');
Insert best_school_major values('UNB3',28,2000,'Villanova University');
Insert best_school_major values('UNB3',30,127,'Arizona State University-Tempe');
Insert best_school_major values('UNB3',30,110,'University of Oklahoma');
Insert best_school_major values('UNB3',30,1033,'University of Richmond');

/*Management*/
Insert best_school_major values('UNB4',1,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNB4',2,5,'University of Pennsylvania');
Insert best_school_major values('UNB4',3,21,'University of California—​Berkeley');
Insert best_school_major values('UNB4',4,23,'University of Virginia');
Insert best_school_major values('UNB4',5,28,'University of North Carolina-Chapel Hill');
Insert best_school_major values('UNB4',6,34,'New York University');
Insert best_school_major values('UNB4',7,45,'University of Texas-Austin');
Insert best_school_major values('UNB4',8,75,'Indiana University-Bloomington');
Insert best_school_major values('UNB4',9,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNB4',10,4018,'Rockhurst University');
Insert best_school_major values('UNB4',10,4025,'University of Detroit Mercy');
Insert best_school_major values('UNB4',12,20,'University of Notre Dame');
Insert best_school_major values('UNB4',13,13,'Cornell University');
Insert best_school_major values('UNB4',14,74,'​University of Minnesota-Twin Cities');
Insert best_school_major values('UNB4',15,127,'Arizona State University-Tempe');
Insert best_school_major values('UNB4',16,27,'University of Southern California');
Insert best_school_major values('UNB4',17,62,'Texas A&M University-College Station');
Insert best_school_major values('UNB4',18,41,'Case Western Reserve University');
Insert best_school_major values('UNB4',19,56,'University of Maryland-College Park');
Insert best_school_major values('UNB4',20,72,'Michigan State University');
Insert best_school_major values('UNB4',20,58,'Ohio State University-Columbus');
Insert best_school_major values('UNB4',20,48,'Pennsylvania State University-University Park');
Insert best_school_major values('UNB4',20,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNB4',20,38,'University of Wisconsin-Madison');
Insert best_school_major values('UNB4',25,18,'Emory University');
Insert best_school_major values('UNB4',25,52,'University of Washington');

/*Management Information Systems*/
Insert best_school_major values('UNB5',1,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNB5',2,22,'Carnegie Mellon University');
Insert best_school_major values('UNB5',3,74,'University of Minnesota-Twin Cities');
Insert best_school_major values('UNB5',4,105,'University of Arizona');
Insert best_school_major values('UNB5',5,45,'University of Texas-Austin');
Insert best_school_major values('UNB5',6,5,'University of Pennsylvania');
Insert best_school_major values('UNB5',7,36,'Georgia Institute of Technology');
Insert best_school_major values('UNB5',8,75,'Indiana University-Bloomington');
Insert best_school_major values('UNB5',9,56,'University of Maryland-College Park');
Insert best_school_major values('UNB5',10,34,'New York University');
Insert best_school_major values('UNB5',11,215,'Georgia State University');
Insert best_school_major values('UNB5',12,4018,'Rockhurst University');
Insert best_school_major values('UNB5',13,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNB5',14,129,'Temple University');
Insert best_school_major values('UNB5',15,111,'Loyola University Chicago');
Insert best_school_major values('UNB5',15,21,'University of California—​Berkeley');
Insert best_school_major values('UNB5',15,60,'University of Georgia');
Insert best_school_major values('UNB5',18,127,'Arizona State University-Tempe');
Insert best_school_major values('UNB5',19,2002,'Bentley University');
Insert best_school_major values('UNB5',19,66,'Purdue University-West Lafayette');

/*Production-Operations Management*/
Insert best_school_major values('UNB6',1,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNB6',2,22,'Carnegie Mellon University');
Insert best_school_major values('UNB6',3,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNB6',4,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNB6',5,21,'University of California—​Berkeley');
Insert best_school_major values('UNB6',6,5,'University of Pennsylvania');
Insert best_school_major values('UNB6',7,58,'Ohio State University-Columbus');
Insert best_school_major values('UNB6',8,72,'Michigan State University');
Insert best_school_major values('UNB6',9,28,'University of North Carolina-Chapel Hill');
Insert best_school_major values('UNB6',10,75,'Indiana University-Bloomington');
Insert best_school_major values('UNB6',11,45,'University of Texas-Austin');
Insert best_school_major values('UNB6',12,36,'Georgia Institute of Technology');
Insert best_school_major values('UNB6',13,147,'University of Texas-Dallas');
Insert best_school_major values('UNB6',14,34,'New York University');
Insert best_school_major values('UNB6',15,23,'University of Virginia');

/*Quantitative Analysis*/
Insert best_school_major values('UNB7',1,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNB7',2,22,'Carnegie Mellon University');
Insert best_school_major values('UNB7',3,5,'University of Pennsylvania');
Insert best_school_major values('UNB7',4,21,'University of California—​Berkeley');
Insert best_school_major values('UNB7',5,36,'Georgia Institute of Technology');
Insert best_school_major values('UNB7',6,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNB7',7,34,'New York University');
Insert best_school_major values('UNB7',8,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNB7',9,45,'University of Texas-Austin');
Insert best_school_major values('UNB7',10,49,'University of Florida');
Insert best_school_major values('UNB7',11,13,'Cornell University');
Insert best_school_major values('UNB7',11,75,'Indiana University-Bloomington');

/*Real Estate*/
Insert best_school_major values('UNB8',1,5,'University of Pennsylvania');
Insert best_school_major values('UNB8',2,38,'University of Wisconsin-Madison');
Insert best_school_major values('UNB8',3,60,'University of Georgia');
Insert best_school_major values('UNB8',4,21,'University of California—​Berkeley');
Insert best_school_major values('UNB8',5,27,'University of Southern California');
Insert best_school_major values('UNB8',6,34,'New York University');
Insert best_school_major values('UNB8',7,49,'University of Florida');
Insert best_school_major values('UNB8',8,45,'University of Texas-Austin');
Insert best_school_major values('UNB8',9,84,'Marquette University');
Insert best_school_major values('UNB8',10,112,'Florida State University');
Insert best_school_major values('UNB8',10,40,'University of Illinois-Urbana-Champaign');
Insert best_school_major values('UNB8',12,13,'Cornell University');
Insert best_school_major values('UNB8',13,65,'University of Connecticut');

/*Supply Chain Management and Logistics*/
Insert best_school_major values('UNB9',1,72,'Michigan State University');
Insert best_school_major values('UNB9',2,7,'Massachusetts Institute of Technology');
Insert best_school_major values('UNB9',3,58,'Ohio State University-Columbus');
Insert best_school_major values('UNB9',4,48,'Pennsylvania State University-University Park');
Insert best_school_major values('UNB9',5,127,'Arizona State University-Tempe');
Insert best_school_major values('UNB9',5,101,'University of Tennessee');
Insert best_school_major values('UNB9',7,22,'Carnegie Mellon University');
Insert best_school_major values('UNB9',8,26,'University of Michigan-Ann Arbor');
Insert best_school_major values('UNB9',9,66,'Purdue University-West Lafayette');
Insert best_school_major values('UNB9',10,56,'University of Maryland-College Park');
Insert best_school_major values('UNB9',11,45,'University of Texas-Austin');
Insert best_school_major values('UNB9',12,36,'Georgia Institute of Technology');
Insert best_school_major values('UNB9',13,21,'University of California—​Berkeley');
Insert best_school_major values('UNB9',14,84,'Marquette University');
Insert best_school_major values('UNB9',14,5,'University of Pennsylvania');
Insert best_school_major values('UNB9',16,126,'University of Arkansas-Fayetteville');
Insert best_school_major values('UNB9',17,75,'Indiana University-Bloomington');
Insert best_school_major values('UNB9',18,124,'Clarkson University');
Insert best_school_major values('UNB9',18,38,'University of Wisconsin-Madison');

/*Agriculture*/
Insert best_school_major values('PR2',null,3091, 'Angelo State University');
Insert best_school_major values('PR2',null,127, 'Arizona State University-Tempe');
Insert best_school_major values('PR2',null,142, 'Auburn University');
Insert best_school_major values('PR2',null,1067,'Berea College');
Insert best_school_major values('PR2',null,3056,'California State University-Stanislaus');
Insert best_school_major values('PR2',null,68, 'Clemson University');
Insert best_school_major values('PR2',null,1081,'College of the Atlantic');
Insert best_school_major values('PR2',null,8003, 'College of the Ozarks');
Insert best_school_major values('PR2',null,125, 'Colorado State University');
Insert best_school_major values('PR2',null,13, 'Cornell University');
Insert best_school_major values('PR2',null,1197, 'Green Mountain College');
Insert best_school_major values('PR2',null,86, 'Iowa State University');
Insert best_school_major values('PR2',null,123, 'Kansas State University');
Insert best_school_major values('PR2',null,138, 'Louisiana State University-Baton Rouge');
Insert best_school_major values('PR2',null,72, 'Michigan State University');
Insert best_school_major values('PR2',null,89,'North Carolina State University-Raleigh');
Insert best_school_major values('PR2',null,48, 'Pennsylvania State University-University Park');
Insert best_school_major values('PR2',null,3084, 'Prescott College');
Insert best_school_major values('PR2',null,66, 'Purdue University-West Lafayette');
Insert best_school_major values('PR2',null,62, 'Texas A&M University-College Station');
Insert best_school_major values('PR2',null,107,'Texas Christian University');
Insert best_school_major values('PR2',null,4007, 'Truman State University');
Insert best_school_major values('PR2',null,9009, 'Tuskegee University');
Insert best_school_major values('PR2',null,105,'University of Arizona');
Insert best_school_major values('PR2',null,126,'University of Arkansas-Fayetteville');
Insert best_school_major values('PR2',null,43, 'University of California-Davis');
Insert best_school_major values('PR2',null,49,'University of Florida');
Insert best_school_major values('PR2',null,60, 'University of Georgia');
Insert best_school_major values('PR2',null,166, 'University of Hawaii-Manoa');
Insert best_school_major values('PR2',null,171, 'University of Idaho');
Insert best_school_major values('PR2',null,40, 'University of Illinois-Urbana-Champaign');
Insert best_school_major values('PR2',null,120, 'University of Kentucky');
Insert best_school_major values('PR2',null,173, 'University of Maine');
Insert best_school_major values('PR2',null,56, 'University of Maryland-College Park');
Insert best_school_major values('PR2',null,96, 'University of Massachusetts-Amherst');
Insert best_school_major values('PR2',null,92, 'University of Missouri-Columbia');
Insert best_school_major values('PR2',null,95, 'University of Nebraska-Lincon');
Insert best_school_major values('PR2',null,101, 'University of Tennessee');
Insert best_school_major values('PR2',null,98, 'University of Vermont');
Insert best_school_major values('PR2',null,38, 'University of Wisconsin-Madison');
Insert best_school_major values('PR2',null,174, 'University of Wyoming');
Insert best_school_major values('PR2',null,119, 'Washington State University');
Insert best_school_major values('PR2',null,179, 'West Virginia University');

/*Biology*/
Insert best_school_major values('PR3',null,1066, 'Agnes Scott College');
Insert best_school_major values('PR3',null,1099, 'Albion College');
Insert best_school_major values('PR3',null,1078, 'Austin College');
Insert best_school_major values('PR3',null,1071, 'Allegheny College');
Insert best_school_major values('PR3',null,76, 'Baylor University');
Insert best_school_major values('PR3',null,32, 'Brandeis University');
Insert best_school_major values('PR3',null,1007, 'Carleton College');
Insert best_school_major values('PR3',null,5014, 'Christopher Newport University');
Insert best_school_major values('PR3',null,1018, 'Colby College');
Insert best_school_major values('PR3',null,13, 'Cornell University');
Insert best_school_major values('PR3',null,108, 'Drexel University');
Insert best_school_major values('PR3',null,8,'Duke University');
Insert best_school_major values('PR3',null,1159, 'Guilford College');
Insert best_school_major values('PR3',null,2,'Harvard University');
Insert best_school_major values('PR3',null,1011, 'Haverford College');
Insert best_school_major values('PR3',null,102, 'Howard University');
Insert best_school_major values('PR3',null,1072, 'Illinois Wesleyan University');
Insert best_school_major values('PR3',null,75,'Indiana University-Bloomington');
Insert best_school_major values('PR3',null,16, 'Johns Hopkins University');
Insert best_school_major values('PR3',null,138, 'Louisiana State University-Baton Rouge');
Insert best_school_major values('PR3',null,111, 'Loyola University of Chicago');
Insert best_school_major values('PR3',null,7,'Massachusetts Institute of Technology');
Insert best_school_major values('PR3',null,1094, 'Millsaps College');
Insert best_school_major values('PR3',null,1034, 'Mount Holyoke College');
Insert best_school_major values('PR3',null,58, 'Ohio State University-Columbus');
Insert best_school_major values('PR3',null,116, 'Ohio University');
Insert best_school_major values('PR3',null,1005, 'Pomona College');
Insert best_school_major values('PR3',null,1095, 'Reed College');
Insert best_school_major values('PR3',null,17, 'Rice University');
Insert best_school_major values('PR3',null,1002, 'Swarthmore College');
Insert best_school_major values('PR3',null,129, 'Temple University');
Insert best_school_major values('PR3',null,62, 'Texas A&M University-College Station');
Insert best_school_major values('PR3',null,6000, 'United States Coast Guard Academy');
Insert best_school_major values('PR3',null,43, 'University of California-Davis');
Insert best_school_major values('PR3',null,39,'University of California-San Diego');
Insert best_school_major values('PR3',null,10, 'University of Chicago');
Insert best_school_major values('PR3',null,3014, 'University of Dallas');
Insert best_school_major values('PR3',null,73, 'University of Delaware');
Insert best_school_major values('PR3',null,88, 'University of Denver');
Insert best_school_major values('PR3',null,189, 'University of Houston');
Insert best_school_major values('PR3',null,182, 'University of New Mexico');
Insert best_school_major values('PR3',null,104, 'University of the Pacific');
Insert best_school_major values('PR3',null,1088, 'Wofford College');
Insert best_school_major values('PR3',null,1234, 'Xavier University of Louisiana');

/*Communications*/
Insert best_school_major values('PR5',null,76, 'Baylor University');
Insert best_school_major values('PR5',null,37, 'Boston College');
Insert best_school_major values('PR5',null,57, 'Boston University');
Insert best_school_major values('PR5',null,4003, 'Bradley University');
Insert best_school_major values('PR5',null,2047, 'CUNY-Hunter College');
Insert best_school_major values('PR5',null,68, 'Clemson University');
Insert best_school_major values('PR5',null,5011, 'College of Charleston');
Insert best_school_major values('PR5',null,13, 'Cornell University');
Insert best_school_major values('PR5',null,1054, 'Denison University');
Insert best_school_major values('PR5',null,133, 'DePaul University');
Insert best_school_major values('PR5',null,130, 'Duquesne University');
Insert best_school_major values('PR5',null,1127, 'Eckerd College');
Insert best_school_major values('PR5',null,5000, 'Elon University');
Insert best_school_major values('PR5',null,2009, 'Emerson College');
Insert best_school_major values('PR5',null,2005, 'Fairfield University');
Insert best_school_major values('PR5',null,69, 'Fordham University');
Insert best_school_major values('PR5',null,3003, 'Gonzaga University');
Insert best_school_major values('PR5',null,1079, 'Gustavus Adolphus College');
Insert best_school_major values('PR5',null,1108, 'Hollins University');
Insert best_school_major values('PR5',null,75, 'Indiana University-Bloomington');
Insert best_school_major values('PR5',null,86, 'Iowa State University');
Insert best_school_major values('PR5',null,2008, 'Ithaca College');
Insert best_school_major values('PR5',null,5007, 'James Madison University');
Insert best_school_major values('PR5',null,1109, 'Lake Forest College');
Insert best_school_major values('PR5',null,5012, 'Loyola University New Orleans');
Insert best_school_major values('PR5',null,72, 'Michigan State University');
Insert best_school_major values('PR5',null,1075, 'Muhlenberg College');
Insert best_school_major values('PR5',null,34, 'New York University');
Insert best_school_major values('PR5',null,15, 'Northwestern University');
Insert best_school_major values('PR5',null,55, 'Pepperdine University');
Insert best_school_major values('PR5',null,2011, 'Quinnipiac University');
Insert best_school_major values('PR5',null,1117, 'Ripon College');
Insert best_school_major values('PR5',null,2071, 'Salisbury University');
Insert best_school_major values('PR5',null,134, 'Seton Hall University');
Insert best_school_major values('PR5',null,155, 'St. John-s University');
Insert best_school_major values('PR5',null,9, 'Stanford University');
Insert best_school_major values('PR5',null,2061, 'Suffolk University');
Insert best_school_major values('PR5',null,51, 'Syracuse University');
Insert best_school_major values('PR5',null,39, 'University of California-San Diego');
Insert best_school_major values('PR5',null,46, 'University of California-Santa Barbara');
Insert best_school_major values('PR5',null,64, 'University of Iowa');
Insert best_school_major values('PR5',null,56, 'University of Maryland-College Park');
Insert best_school_major values('PR5',null,27, 'University of Southern California');
Insert best_school_major values('PR5',null,45, 'University of Texas-Austin');
Insert best_school_major values('PR5',null,147, 'University of Texas-Dallas');
Insert best_school_major values('PR5',null,132, 'University of Utah');
Insert best_school_major values('PR5',null,23, 'University of Virginia');
Insert best_school_major values('PR5',null,12, 'Washington University in St. Louis');

/*Criminology*/
Insert best_school_major values('PR6',null, 87, 'American University');
Insert best_school_major values('PR6',null, 142, 'Auburn University');
Insert best_school_major values('PR6',null, 112, 'Florida State University');
Insert best_school_major values('PR6',null, 1159, 'Guilford College');
Insert best_school_major values('PR6',null, 217, 'Indiana University of Pennsylvania');
Insert best_school_major values('PR6',null, 89,'North Carolina State University-Raleigh');
Insert best_school_major values('PR6',null, 58, 'Ohio State University-Columbus');
Insert best_school_major values('PR6',null, 116, 'Ohio University');
Insert best_school_major values('PR6',null, 2011, 'Quinnipiac University');
Insert best_school_major values('PR6',null, 2061, 'Suffolk University');
Insert best_school_major values('PR6',null, 73, 'University of Delaware');
Insert best_school_major values('PR6',null, 88, 'University of Denver');
Insert best_school_major values('PR6',null, 56, 'University of Maryland-College Park');
Insert best_school_major values('PR6',null, 52, 'University of Miami');
Insert best_school_major values('PR6',null, 109, 'University of New Hampshire');
Insert best_school_major values('PR6',null, 158, 'University of South Florida');
Insert best_school_major values('PR6',null, 132, 'University of Utah');
Insert best_school_major values('PR6',null, 4004, 'Valparaiso University');
Insert best_school_major values('PR6',null, 1230, 'Virginia Wesleyan College');
Insert best_school_major values('PR6',null, 1132, 'Whittier College');

/*Education*/
Insert best_school_major values('PR7',null, 142, 'Auburn University');
Insert best_school_major values('PR7',null, 1028, 'Barnard College');
Insert best_school_major values('PR7',null, 1031, 'Bucknell University');
Insert best_school_major values('PR7',null, 2082, 'CUNY-Brooklyn College');
Insert best_school_major values('PR7',null, 2047, 'CUNY-Hunter College');
Insert best_school_major values('PR7',null, 1019, 'Colgate University');
Insert best_school_major values('PR7',null, 8003, 'College of the Ozarks');
Insert best_school_major values('PR7',null, 33, 'College of William and Mary');
Insert best_school_major values('PR7',null, 4,'Columbia University');
Insert best_school_major values('PR7',null, 1093, 'Cornell College');
Insert best_school_major values('PR7',null, 13, 'Cornell University');
Insert best_school_major values('PR7',null, 130, 'Duquesne University');
Insert best_school_major values('PR7',null, 5000, 'Elon University');
Insert best_school_major values('PR7',null, 3003, 'Gonzaga University');
Insert best_school_major values('PR7',null, 1112, 'Goucher College');
Insert best_school_major values('PR7',null, 1068, 'Hillsdale College');
Insert best_school_major values('PR7',null, 75, 'Indiana University-Bloomington');
Insert best_school_major values('PR7',null, 1073, 'Knox College');
Insert best_school_major values('PR7',null, 3002, 'Loyola Marymount University');
Insert best_school_major values('PR7',null, 84, 'Marquette University');
/*Insert best_school_major values('PR7',null, -2, 'McGill University');*/
Insert best_school_major values('PR7',null, 70, 'Miami University-Oxford');
Insert best_school_major values('PR7',null, 2036, 'Monmouth University');
Insert best_school_major values('PR7',null, 2029, 'Nazareth College');
Insert best_school_major values('PR7',null, 34, 'New York University');
Insert best_school_major values('PR7',null, 97, 'Northeastern University');
Insert best_school_major values('PR7',null, 15, 'Northwestern University');
Insert best_school_major values('PR7',null, 58, 'Ohio State University-Columbus');
Insert best_school_major values('PR7',null, 3084, 'Prescott College');
Insert best_school_major values('PR7',null, 2015, 'Simmons College');
Insert best_school_major values('PR7',null, 1037, 'Skidmore College');
Insert best_school_major values('PR7',null, 1015, 'Smith College');
Insert best_school_major values('PR7',null, 3000, 'Trinity University');
Insert best_school_major values('PR7',null, 173, 'University of Maine');
Insert best_school_major values('PR7',null, 146, 'University of Mississippi');
Insert best_school_major values('PR7',null, 251, 'University of Montana');
Insert best_school_major values('PR7',null, 19, 'Vanderbilt University');
Insert best_school_major values('PR7',null, 2000, 'Villanova University');
Insert best_school_major values('PR7',null, 2027, 'Wagner College');
Insert best_school_major values('PR7',null, 1006, 'Wellesley College');
Insert best_school_major values('PR7',null, 1125, 'Westminster College');
Insert best_school_major values('PR7',null, 1162, 'William Jewell College');
Insert best_school_major values('PR7',null, 4005, 'Xavier University');

/*English Literature and Language*/
Insert best_school_major values('PR9',null, 1001, 'Amherst College');
Insert best_school_major values('PR9',null, 142, 'Auburn University');
Insert best_school_major values('PR9',null, 1044, 'Bard College');
Insert best_school_major values('PR9',null, 1024, 'Bates College');
Insert best_school_major values('PR9',null, 37, 'Boston College');
Insert best_school_major values('PR9',null, 57, 'Boston University');
Insert best_school_major values('PR9',null, 1025, 'Bryn Mawr College');
Insert best_school_major values('PR9',null, 2047, 'CUNY-Hunter College');
Insert best_school_major values('PR9',null, 1008, 'Claremont McKenna College');
Insert best_school_major values('PR9',null, 68, 'Clemson University');
Insert best_school_major values('PR9',null, 1018, 'Colby College');
Insert best_school_major values('PR9',null, 1019, 'Colgate University');
Insert best_school_major values('PR9',null, 4,'Columbia University');
Insert best_school_major values('PR9',null, 13, 'Cornell University');
Insert best_school_major values('PR9',null, 11, 'Dartmouth College');
Insert best_school_major values('PR9',null, 1054, 'Denison University');
Insert best_school_major values('PR9',null, 8,'Duke University');
Insert best_school_major values('PR9',null, 18, 'Emory University');
Insert best_school_major values('PR9',null, 69, 'Fordham University');
Insert best_school_major values('PR9',null, 5007, 'James Madison University');
Insert best_school_major values('PR9',null, 1048, 'Gettysburg College');
Insert best_school_major values('PR9',null, 1158, 'Gordon College');
Insert best_school_major values('PR9',null, 1020, 'Grinnell College');
Insert best_school_major values('PR9',null, 2,'Harvard University');
Insert best_school_major values('PR9',null, 16, 'Johns Hopkins University');
Insert best_school_major values('PR9',null, 1065, 'Kalamazoo College');
Insert best_school_major values('PR9',null, 1027, 'Kenyon College');
Insert best_school_major values('PR9',null, 1138, 'Marlboro College');
Insert best_school_major values('PR9',null, 1023, 'Oberlin College');
Insert best_school_major values('PR9',null, 1035, 'Pitzer College');
Insert best_school_major values('PR9',null, 1005,'Pomona College');
Insert best_school_major values('PR9',null, 1,'Princeton University');
Insert best_school_major values('PR9',null, 1095, 'Reed College');
Insert best_school_major values('PR9',null, 17, 'Rice University');
Insert best_school_major values('PR9',null, 1049, 'Sewanee-University of the South');
Insert best_school_major values('PR9',null, 1015, 'Smith College');
Insert best_school_major values('PR9',null, 9,'Stanford University');
Insert best_school_major values('PR9',null, 1096, 'St. Mary-s College of Maryland');
Insert best_school_major values('PR9',null, 137, 'University at Albany-SUNY');
Insert best_school_major values('PR9',null, 51, 'Syracuse University');
Insert best_school_major values('PR9',null, 29, 'Tufts University');
Insert best_school_major values('PR9',null, 21, 'University of California-Berkeley');
Insert best_school_major values('PR9',null, 10, 'University of Chicago');
Insert best_school_major values('PR9',null, 26, 'University of Michigan-Ann Arbor');
Insert best_school_major values('PR9',null, 150, 'University of North Carolina-Asheville');
Insert best_school_major values('PR9',null, 20, 'University of Notre Dame');
Insert best_school_major values('PR9',null, 132, 'University of Utah');
Insert best_school_major values('PR9',null, 1012, 'Vassar College');
Insert best_school_major values('PR9',null, 12, 'Washington University in St. Louis');
Insert best_school_major values('PR9',null, 1006, 'Wellesley College');
Insert best_school_major values('PR9',null, 1000, 'Williams College');
Insert best_school_major values('PR9',null, 3,'Yale University');

/*Environmental Studies*/
Insert best_school_major values('PR10',null, 1071, 'Allegheny College');
Insert best_school_major values('PR10',null, 1024, 'Bates College');
Insert best_school_major values('PR10',null, 1003, 'Bowdoin College');
Insert best_school_major values('PR10',null, 9014, 'Catawba College');
Insert best_school_major values('PR10',null, 1018, 'Colby College');
Insert best_school_major values('PR10',null, 1081, 'College of the Atlantic');
Insert best_school_major values('PR10',null, 1026, 'Colorado College');
Insert best_school_major values('PR10',null, 1039, 'Dickinson College');
Insert best_school_major values('PR10',null, 1127, 'Eckerd College');
Insert best_school_major values('PR10',null, 18, 'Emory University');
Insert best_school_major values('PR10',null, 3035, 'Evergreen State College');
Insert best_school_major values('PR10',null, 1197, 'Green Mountain College');
Insert best_school_major values('PR10',null, 2,'Harvard University');
Insert best_school_major values('PR10',null, 1063, 'Hobart and William Smith Colleges');
Insert best_school_major values('PR10',null, 1105, 'Juniata College');
Insert best_school_major values('PR10',null, 1004, 'Middlebury College');
Insert best_school_major values('PR10',null, 1083, 'New College of Florida');
Insert best_school_major values('PR10',null, 97, 'Northeastern University');
Insert best_school_major values('PR10',null, 1042, 'Occidental College');
Insert best_school_major values('PR10',null, 1035, 'Pitzer College');
Insert best_school_major values('PR10',null, 1005,'Pomona College');
Insert best_school_major values('PR10',null, 232, 'Portland State University');
Insert best_school_major values('PR10',null, 3084, 'Prescott College');
Insert best_school_major values('PR10',null, 1049, 'Sewanee-University of the South');
Insert best_school_major values('PR10',null, 3047, 'Sonoma State University');
Insert best_school_major values('PR10',null, 82, 'SUNY-Binghamton');
Insert best_school_major values('PR10',null, 90, 'SUNY College of Environmental Science and Forestry');
Insert best_school_major values('PR10',null, 21, 'University of California-Berkeley');
Insert best_school_major values('PR10',null, 81, 'University of California-Santa Cruz');
Insert best_school_major values('PR10',null, 80, 'University of Colorado-Boulder');
Insert best_school_major values('PR10',null, 171, 'University of Idaho');
Insert best_school_major values('PR10',null, 251, 'University of Montana');
Insert best_school_major values('PR10',null, 109, 'University of New Hampshire');
Insert best_school_major values('PR10',null, 150, 'University of North Carolina-Asheville');
Insert best_school_major values('PR10',null, 28, 'University of North Carolina-Chapel Hill');
Insert best_school_major values('PR10',null, 114, 'University of Oregon');
Insert best_school_major values('PR10',null, 3011, 'University of Redlands');
Insert best_school_major values('PR10',null, 104, 'University of the Pacific');
Insert best_school_major values('PR10',null, 98, 'University of Vermont');
Insert best_school_major values('PR10',null, 1165, 'Warren Wilson College');
Insert best_school_major values('PR10',null, 1103, 'Washington College');

/*Health Services*/
Insert best_school_major values('PR11',null, 5013, 'Bellarmine University');
Insert best_school_major values('PR11',null, 57, 'Boston University');
Insert best_school_major values('PR11',null, 68, 'Clemson University');
Insert best_school_major values('PR11',null, 1168, 'College of Idaho');
Insert best_school_major values('PR11',null, 8003, 'College of the Ozarks');
Insert best_school_major values('PR11',null, 4000, 'Creighton University');
Insert best_school_major values('PR11',null, 108, 'Drexel University');
Insert best_school_major values('PR11',null, 130, 'Duquesne University');
Insert best_school_major values('PR11',null, 2005, 'Fairfield University');
Insert best_school_major values('PR11',null, 1048, 'Gettysburg College');
Insert best_school_major values('PR11',null, 1079, 'Gustavus Adolphus College');
Insert best_school_major values('PR11',null, 5018, 'Hampton University');
Insert best_school_major values('PR11',null, 102, 'Howard University');
Insert best_school_major values('PR11',null, 2008, 'Ithaca College');
Insert best_school_major values('PR11',null, 16, 'Johns Hopkins University');
Insert best_school_major values('PR11',null, 1065, 'Kalamazoo College');
Insert best_school_major values('PR11',null, 111, 'Loyola University of Chicago');
Insert best_school_major values('PR11',null, 2041, 'Marywood University');
Insert best_school_major values('PR11',null, 2036, 'Monmouth University');
Insert best_school_major values('PR11',null, 2029, 'Nazareth College');
Insert best_school_major values('PR11',null, 97, 'Northeastern University');
Insert best_school_major values('PR11',null, 116, 'Ohio University');
Insert best_school_major values('PR11',null, 66, 'Purdue University-West Lafayette');
Insert best_school_major values('PR11',null, 2011, 'Quinnipiac University');
Insert best_school_major values('PR11',null, 2044, 'Sacred Heart University');
Insert best_school_major values('PR11',null, 1114, 'St. Anselm College');
Insert best_school_major values('PR11',null, 83, 'Saint Louis University');
Insert best_school_major values('PR11',null, 134, 'Seton Hall University');
Insert best_school_major values('PR11',null, 2015, 'Simmons College');
Insert best_school_major values('PR11',null, 99, 'SUNY-Stony Brook');
Insert best_school_major values('PR11',null, 8029, 'Stephens College');
Insert best_school_major values('PR11',null, 2061, 'Suffolk University');
Insert best_school_major values('PR11',null, 62, 'Texas A&M University-College Station');
Insert best_school_major values('PR11',null, 107, 'Texas Christian University');
Insert best_school_major values('PR11',null, 50, 'Tulane University');
Insert best_school_major values('PR11',null, 152, 'University of Alabama-Birmingham');
Insert best_school_major values('PR11',null, 170, 'University of Central Florida');
Insert best_school_major values('PR11',null, 145, 'University of Cincinnati');
Insert best_school_major values('PR11',null, 49,'University of Florida');
Insert best_school_major values('PR11',null, 189, 'University of Houston');
Insert best_school_major values('PR11',null, 52, 'University of Miami');
Insert best_school_major values('PR11',null, 110, 'University of Oklahoma');
Insert best_school_major values('PR11',null, 132, 'University of Utah');
Insert best_school_major values('PR11',null, 2027, 'Wagner College');
Insert best_school_major values('PR11',null, 12, 'Washington University in St. Louis');
Insert best_school_major values('PR11',null, 1125, 'Westminster College');
Insert best_school_major values('PR11',null, 1058, 'Wheaton College');
Insert best_school_major values('PR11',null, 1162, 'William Jewell College');

/*History*/
Insert best_school_major values('PR12',null, 1024, 'Bates College');
Insert best_school_major values('PR12',null, 1003, 'Bowdoin College');
Insert best_school_major values('PR12',null, 14,'Brown University');
Insert best_school_major values('PR12',null, 1045, 'Centre College');
Insert best_school_major values('PR12',null, 1019, 'Colgate University');
Insert best_school_major values('PR12',null, 1032, 'College of the Holy Cross');
Insert best_school_major values('PR12',null, 1061, 'College of Wooster');
Insert best_school_major values('PR12',null, 4, 'Columbia University');
Insert best_school_major values('PR12',null, 1009, 'Davidson College');
Insert best_school_major values('PR12',null, 1111, 'Drew University');
Insert best_school_major values('PR12',null, 1051, 'Furman University');
Insert best_school_major values('PR12',null, 24, 'Georgetown University');
Insert best_school_major values('PR12',null, 1020, 'Grinnell College');
Insert best_school_major values('PR12',null, 1107, 'Hampden-Sydney College');
Insert best_school_major values('PR12',null, 2,'Harvard University');
Insert best_school_major values('PR12',null, 1011, 'Haverford College');
Insert best_school_major values('PR12',null, 1068, 'Hillsdale College');
Insert best_school_major values('PR12',null, 1027, 'Kenyon College');
Insert best_school_major values('PR12',null, 1138, 'Marlboro College');
Insert best_school_major values('PR12',null, 1023, 'Oberlin College');
Insert best_school_major values('PR12',null, 1,'Princeton University');
Insert best_school_major values('PR12',null, 1117, 'Ripon College');
Insert best_school_major values('PR12',null, 1043, 'Trinity College');
Insert best_school_major values('PR12',null, 50, 'Tulane University');
Insert best_school_major values('PR12',null, 23, 'University of Virginia');
Insert best_school_major values('PR12',null, 1064, 'Wabash College');
Insert best_school_major values('PR12',null, 1000, 'Williams College');
Insert best_school_major values('PR12',null, 3,'Yale University');

/*Journalism*/
Insert best_school_major values('PR13',null, 87, 'American University');
Insert best_school_major values('PR13',null, 127, 'Arizona State University-Tempe');
Insert best_school_major values('PR13',null, 142, 'Auburn University');
Insert best_school_major values('PR13',null, 168, 'Ball State University');
Insert best_school_major values('PR13',null, 57, 'Boston University');
Insert best_school_major values('PR13',null, 185, 'Bowling Green State University');
Insert best_school_major values('PR13',null, 1007, 'Carleton College');
Insert best_school_major values('PR13',null, 8,'Duke University');
Insert best_school_major values('PR13',null, 2009, 'Emerson College');
Insert best_school_major values('PR13',null, 54, 'George Washington University');
Insert best_school_major values('PR13',null, 5018, 'Hampton University');
Insert best_school_major values('PR13',null, 102, 'Howard University');
Insert best_school_major values('PR13',null, 75,'Indiana University-Bloomington');
Insert best_school_major values('PR13',null, 86, 'Iowa State University');
Insert best_school_major values('PR13',null, 2008, 'Ithaca College');
Insert best_school_major values('PR13',null, 123, 'Kansas State University');
Insert best_school_major values('PR13',null, 5012, 'Loyola University New Orleans');
Insert best_school_major values('PR13',null, 72, 'Michigan State University');
Insert best_school_major values('PR13',null, 34, 'New York University');
Insert best_school_major values('PR13',null, 15, 'Northwestern University');
Insert best_school_major values('PR13',null, 116, 'Ohio University');
Insert best_school_major values('PR13',null, 48, 'Pennsylvania State University-University Park');
Insert best_school_major values('PR13',null, 2023, 'St. Bonaventure University');
Insert best_school_major values('PR13',null, 99, 'SUNY-Stony Brook');
Insert best_school_major values('PR13',null, 51, 'Syracuse University');
Insert best_school_major values('PR13',null, 129, 'Temple University');
Insert best_school_major values('PR13',null, 93, 'University of Alabama');
Insert best_school_major values('PR13',null, 105,'University of Arizona');
Insert best_school_major values('PR13',null, 49,'University of Florida');
Insert best_school_major values('PR13',null, 60, 'University of Georgia');
Insert best_school_major values('PR13',null, 85, 'University of Kansas');
Insert best_school_major values('PR13',null, 120, 'University of Kentucky');
Insert best_school_major values('PR13',null, 171, 'University of Idaho');
Insert best_school_major values('PR13',null, 40, 'University of Illinois-Urbana-Champaign');
Insert best_school_major values('PR13',null, 64, 'University of Iowa');
Insert best_school_major values('PR13',null, 56, 'University of Maryland-College Park');
Insert best_school_major values('PR13',null, 74, 'University of Minnesota-Twin Cities');
Insert best_school_major values('PR13',null, 146, 'University of Mississippi');
Insert best_school_major values('PR13',null, 92, 'University of Missouri-Columbia');
Insert best_school_major values('PR13',null, 251, 'University of Montana');
Insert best_school_major values('PR13',null, 95, 'University of Nebraska-Lincon');
Insert best_school_major values('PR13',null, 28, 'University of North Carolina-Chapel Hill');
Insert best_school_major values('PR13',null, 110, 'University of Oklahoma');
Insert best_school_major values('PR13',null, 114, 'University of Oregon');
Insert best_school_major values('PR13',null, 27, 'University of Southern California');
Insert best_school_major values('PR13',null, 45, 'University of Texas-Austin');
Insert best_school_major values('PR13',null, 38, 'University of Wisconsin-Madison');
Insert best_school_major values('PR13',null, 119, 'Washington State University');

/*Mathmatics*/
Insert best_school_major values('PR14',null, 1066, 'Agnes Scott College');
Insert best_school_major values('PR14',null, 1003, 'Bowdoin College');
Insert best_school_major values('PR14',null, 2010, 'Bryant University');
Insert best_school_major values('PR14',null, 1025, 'Bryn Mawr College');
Insert best_school_major values('PR14',null, 6, 'California Institute of Technology');
Insert best_school_major values('PR14',null, 1007, 'Carleton College');
Insert best_school_major values('PR14',null, 1032, 'College of the Holy Cross');
Insert best_school_major values('PR14',null, 1168, 'College of Idaho');
Insert best_school_major values('PR14',null, 1020, 'Grinnell College');
Insert best_school_major values('PR14',null, 1013, 'Hamilton College');
Insert best_school_major values('PR14',null, 6014, 'Champlain College');
Insert best_school_major values('PR14',null, 2,'Harvard University');
Insert best_school_major values('PR14',null, 1014, 'Harvey Mudd College');
Insert best_school_major values('PR14',null, 1011, 'Haverford College');
Insert best_school_major values('PR14',null, 1022, 'Macalester College');
Insert best_school_major values('PR14',null, 7,'Massachusetts Institute of Technology');
Insert best_school_major values('PR14',null, 1160, 'Randolph College');
Insert best_school_major values('PR14',null, 1095, 'Reed College');
Insert best_school_major values('PR14',null, 17, 'Rice University');
Insert best_school_major values('PR14',null, 1059, 'St. Lawrence University');
Insert best_school_major values('PR14',null, 1053, 'St. Olaf College');
Insert best_school_major values('PR14',null, 137, 'SUNY-Albany');
Insert best_school_major values('PR14',null, 6000, 'United States Coast Guard Academy');
Insert best_school_major values('PR14',null, 10, 'University of Chicago');
Insert best_school_major values('PR14',null, 35, 'University of Rochester');
Insert best_school_major values('PR14',null, 1064, 'Wabash College');

/*Nursing*/
Insert best_school_major values('PR16',null, 3091, 'Angelo State University');
Insert best_school_major values('PR16',null, 76, 'Baylor University');
Insert best_school_major values('PR16',null, 5013, 'Bellarmine University');
Insert best_school_major values('PR16',null, 1120, 'Calvin College');
Insert best_school_major values('PR16',null, 121, 'Cathodtc University of America');
Insert best_school_major values('PR16',null, 108, 'Drexel University');
Insert best_school_major values('PR16',null, 130, 'Duquesne University');
Insert best_school_major values('PR16',null, 2005, 'Fairfield University');
Insert best_school_major values('PR16',null, 9003, 'Florida Southern College');
Insert best_school_major values('PR16',null, 217, 'Indiana University of Pennsylvania');
Insert best_school_major values('PR16',null, 111, 'Loyola University of Chicago');
Insert best_school_major values('PR16',null, 7005, 'Montana Tech of the University of Montana');
Insert best_school_major values('PR16',null, 8002, 'Ohio Northern University');
Insert best_school_major values('PR16',null,  83, 'Saint Louis University');
Insert best_school_major values('PR16',null, 107,'Texas Christian University');
Insert best_school_major values('PR16',null, 93, 'University of Alabama');
Insert best_school_major values('PR16',null, 5, 'University of Pennsylvania');
Insert best_school_major values('PR16',null, 174, 'University of Wyoming');
Insert best_school_major values('PR16',null, 4004, 'Valparaiso University');
Insert best_school_major values('PR16',null, 2000, 'Villanova University');
Insert best_school_major values('PR16',null, 119, 'Washington State University');
Insert best_school_major values('PR16',null, 4005, 'Xavier University');
Insert best_school_major values('PR16',null, 9034, 'Keiser University');
Insert best_school_major values('PR16',null, 272, 'Capella University');
Insert best_school_major values('PR16',null, 3143, 'Western Governors University');
Insert best_school_major values('PR16',null, 278, 'Walden University');
Insert best_school_major values('PR16',null, 273, 'Colorado Technical University');







/*Political Science and Government*/
Insert best_school_major values('PR17',null, 87, 'American University');
Insert best_school_major values('PR17',null, 1001, 'Amherst College');
Insert best_school_major values('PR17',null, 1044, 'Bard College');
Insert best_school_major values('PR17',null, 1024, 'Bates College');
Insert best_school_major values('PR17',null, 1003, 'Bowdoin College');
Insert best_school_major values('PR17',null, 79, 'Brigham Young University-Provo');
Insert best_school_major values('PR17',null, 1025, 'Bryn Mawr College');
Insert best_school_major values('PR17',null, 1007, 'Carleton College');
Insert best_school_major values('PR17',null, 1008, 'Claremont McKenna College');
Insert best_school_major values('PR17',null, 1032, 'College of the Holy Cross');
Insert best_school_major values('PR17',null, 4,'Columbia University');
Insert best_school_major values('PR17',null, 1009, 'Davidson College');
Insert best_school_major values('PR17',null, 1039, 'Dickinson College');
Insert best_school_major values('PR17',null, 1111, 'Drew University');
Insert best_school_major values('PR17',null, 1051, 'Furman University');
Insert best_school_major values('PR17',null, 139, 'George Mason University');
Insert best_school_major values('PR17',null, 54, 'George Washington University');
Insert best_school_major values('PR17',null, 24, 'Georgetown University');
Insert best_school_major values('PR17',null, 1048, 'Gettysburg College');
Insert best_school_major values('PR17',null, 3003, 'Gonzaga University');
Insert best_school_major values('PR17',null, 2,'Harvard University');
Insert best_school_major values('PR17',null, 1027, 'Kenyon College');
Insert best_school_major values('PR17',null, 1022, 'Macalester College');
Insert best_school_major values('PR17',null, 1,'Princeton University');
Insert best_school_major values('PR17',null, 9,'Stanford University');
Insert best_school_major values('PR17',null, 1002, 'Swarthmore College');
Insert best_school_major values('PR17',null, 51, 'Syracuse University');
Insert best_school_major values('PR17',null, 105,'University of Arizona');
Insert best_school_major values('PR17',null, 21, 'University of California-Berkeley');
Insert best_school_major values('PR17',null, 25, 'University of California-Los Angeles');
Insert best_school_major values('PR17',null, 42, 'University of Washington');
Insert best_school_major values('PR17',null, 1012, 'Vassar College');
Insert best_school_major values('PR17',null, 3,'Yale University');

/*Psychology*/
Insert best_school_major values('PR18',null, 1099, 'Albion College');
Insert best_school_major values('PR18',null, 1024, 'Bates College');
Insert best_school_major values('PR18',null, 22, 'Carnegie Mellon University');
Insert best_school_major values('PR18',null, 5014, 'Christopher Newport University');
Insert best_school_major values('PR18',null, 8013, 'Clarke University');
Insert best_school_major values('PR18',null, 125, 'Colorado State University');
Insert best_school_major values('PR18',null, 4,'Columbia University');
Insert best_school_major values('PR18',null, 13, 'Cornell University');
Insert best_school_major values('PR18',null, 11, 'Dartmouth College');
Insert best_school_major values('PR18',null, 8,'Duke University');
Insert best_school_major values('PR18',null, 1048, 'Gettysburg College');
Insert best_school_major values('PR18',null, 2,'Harvard University');
Insert best_school_major values('PR18',null, 5007, 'James Madison University');
Insert best_school_major values('PR18',null, 7025, 'Lewis-Clark State College');
Insert best_school_major values('PR18',null, 111, 'Loyola University of Chicago');
Insert best_school_major values('PR18',null, 34, 'New York University');
Insert best_school_major values('PR18',null, 1035, 'Pitzer College');
Insert best_school_major values('PR18',null, 232, 'Portland State University');
Insert best_school_major values('PR18',null, 1,'Princeton University');
Insert best_school_major values('PR18',null, 1144, 'Roanoke College');
Insert best_school_major values('PR18',null, 1015, 'Smith College');
Insert best_school_major values('PR18',null, 9, 'Stanford University');
Insert best_school_major values('PR18',null, 43, 'University of California-Davis');
Insert best_school_major values('PR18',null, 25, 'University of California-Los Angeles');
Insert best_school_major values('PR18',null, 103, 'University of California-Riverside');
Insert best_school_major values('PR18',null, 46, 'University of California-Santa Barbara');
Insert best_school_major values('PR18',null, 81, 'University of California-Santa Cruz');
Insert best_school_major values('PR18',null, 189, 'University of Houston');
Insert best_school_major values('PR18',null, 26, 'University of Michigan-Ann Arbor');
Insert best_school_major values('PR18',null, 27, 'University of Southern California');
Insert best_school_major values('PR18',null, 45, 'University of Texas-Austin');
Insert best_school_major values('PR18',null, 132, 'University of Utah');
Insert best_school_major values('PR18',null, 12, 'Washington University in St. Louis');
Insert best_school_major values('PR18',null, 3,'Yale University');


commit;