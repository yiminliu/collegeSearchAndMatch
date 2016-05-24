DROP TABLE IF EXISTS sat2_requirement;
CREATE TABLE sat2_requirement
(
  School_Id INT NOT NULL,
  School_Name VARCHAR(80),
  SAT1_Or_Act_Required VARCHAR(10),
  SAT1_Reading_Requirement INT,
  SAT1_Math_Requirement INT,
  SAT1_Essay_Requirement INT,
  ACT_Reading_Requirement INT,
  ACT_Math_Requirement INT,
  SAT1_Reasoning_Requirement INT,
  ACT_Writing_Requirement INT,
  ACT_With_Writing_Required VARCHAR(10),
  Number_Of_Required_SAT2 INT DEFAULT 0,
  SAT2_Require_Level VARCHAR(80),
  SAT2_Required_Subjets VARCHAR(80),
  SAT2_Selective_Subjets VARCHAR(80),
  Division_Name VARCHAR(80),
  Substituted_With_ACT_With_Writing_For_SAT2 VARCHAR(10),
  Note VARCHAR(1000),
  Primary Key (School_Id),
  FOREIGN KEY (School_Id) REFERENCES school (Id)
);

Insert sat2_requirement values(1001, 'Amherst College', 'Yes', 'Yes', 2, null, null, 'Required','Yes', null, null);
Insert sat2_requirement values(1028, 'Barnard College',  'Yes', 'Yes', 2, null, null, 'Required','Yes', null, null);
Insert sat2_requirement values(14, 'Brown University',  'Yes', 'Yes', 2, 'least 1 science Subject', null, 'Required','Yes', 'Liberal Medical Education', 'least 1 science Subject for least 1 science Subject');
Insert sat2_requirement values(6, 'California Institute of Technology',  'Yes', 'Yes', 2, 'Math Level 2', 'Biology (Ecological), Biology (Molecular), Chemistry, or Physics', 'Required','No', null, null);
Insert sat2_requirement values(22, 'Carnegie Mellon University',  'Yes', 'Yes', 2, 'Math Level 1 or Math Level 2', null, 'Required','No', null, '2 SAT Subject Tests for most applicants. College of Fine Arts programs, with the exception of Architecture, do not require Subject Tests.');
Insert sat2_requirement values(9, 'Columbia University',  'Yes', 'Yes', 2, 'Math Level 1 or Math Level 2', 'Biology, Physics, or Chemistry', 'Required','Yes', 'Engineering', 'requires the SAT and 2 SAT Subject Tests OR ACT with Writing. Students who choose to take the ACT may submit Subject Test scores for consideration. Students may take any 2 Subject Tests for Columbia College. For Columbia Engineering, students must take a) either Math Level 1 or Math Level 2 and b) one of the following: Biology, Physics, or Chemistry');
Insert sat2_requirement values(13, 'Cornell University',  'Yes', 'Yes', 0, null, null, 'Required','No', null, 'Some Cornell colleges require 1 or 2 Subject Test(s)');
Insert sat2_requirement values(11, 'Dartmouth College',  'Yes', 'Yes', 2, null, null, 'Required','No', null, null);
Insert sat2_requirement values(8, 'Duke University',  'Yes', 'Yes', 2, null, 'foreign language recommended', 'Required','Yes', 'Engineering', 'Applicants to the Pratt School of Engineering who take the SAT must take one SAT Subject Test in Mathematics (level 1 or level 2).');
Insert sat2_requirement values(24, 'Georgetown University',  'Yes', 'Yes', 3, null, null, 'Required','No', null, 'Georgetown requires the SAT or ACT and does not consider the essay from either test. Georgetown expects to receive 3 Subject Tests except in "extenuating circumstances." Applicants are required to submit all College Board and ACT scores.');
Insert sat2_requirement values(2, 'Harvard University',  'Yes', 'Yes', 2, null, null, 'Required','No', null, 'Two SAT Subject Tests are “normally” required. “While we normally require two SAT Subject Tests, you may apply without them if the cost of taking the tests represents a financial hardship or if you prefer to have your application considered without them...If your first language is not English, a Subject Test in your first language may be less helpful.');
Insert sat2_requirement values(1014, 'Harvey Mudd College',  'Yes', 'Yes', 2, 'Math Level 2', null, 'Required','Yes', null, null);
Insert sat2_requirement values(1011, 'Haverford College',  'Yes', 'No', 2, null, null, 'Required','Yes', null, null);
Insert sat2_requirement values(7, 'Massachusetts Institute of Technology', 'Yes', 'Yes', 2, 'Math Level 1 or Math Level 2', 'Science', 'Required','No', null, null);
Insert sat2_requirement values(17, 'Rice University', 'Yes', 'Yes', 2, null, null, 'Required','Yes', null,'requires the SAT and 2 SAT Subject Tests OR ACT with Writing. It is recommended that Subject Tests be taken in subjects related to proposed area of study.');
Insert sat2_requirement values(29, 'Tufts University', 'Yes', 'Yes', 2, null, null, 'Required','Yes', null, 'Engineering applicants submitting Subject Tests are advised to take math and either physics or chemistry. Students considering a major in mathematics or the sciences are advised to take math and a science test.');
Insert sat2_requirement values(1012, 'Vassar College', 'Yes', 'Yes', 2, null, null, 'Required','Yes', null, 'requires the SAT and 2 SAT Subject Tests OR ACT with Writing');
Insert sat2_requirement values(10002, 'Webb Institute', 'Yes', 'Yes', 2, 'Level 1 or Level 2', 'Chemistry or Physics', 'Required','No', null, null);
Insert sat2_requirement values(1006, 'Wellesley College', 'Yes', 'Yes', 2, 'Math or Physics', null, 'Required','No', 'math or sciences', null);
Insert sat2_requirement values(1000, 'Williams College', 'Yes', 'Yes', 2, null, null, 'Required','No', null, null);
Insert sat2_requirement values(1007, 'Carleton College', 'Yes', 'Yes', 2, null, null, 'Recommended','No', null, 'SAT 2 scores “usually enhance a candidate’s credentials');
Insert sat2_requirement values(1009, 'Davidson College', 'Yes', 'Yes', 2, 'Math', null, 'Recommended','No', null, null);
Insert sat2_requirement values(18, 'Emory University', 'Yes', 'Yes', 1, null, null, 'Recommended','No', null, 'SAT Subject Tests are encouraged, but not required. Students are encouraged to submit SAT subject exam scores for academic areas of strength and/or interest');
Insert sat2_requirement values(1036, 'Lafayette College', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, null);
Insert sat2_requirement values(15, 'Northwestern University', 'Yes', 'Yes', 2, null, null, 'Recommened','No', null, 'The Honors Program in Medical Education (HPME) and the Integrated Science Program (ISP) require specific Subject Tests.');
Insert sat2_requirement values(2017, 'Pratt Institute', 'Yes', 'No', 1, 'Math Level 1 or Level 2', null, 'Recommened','No', 'Architecture', 'Subject Tests will be considered if submitted. Bachelor of Architecture applicants are encouraged to take Math Level 1 or Level 2.');
Insert sat2_requirement values(1, 'Princeton University', 'Yes', 'Yes', 2, 'chemistry or physics', null, 'Recommened','No', 'Enginerring', 'recommends that applicants submit 2 Subject Tests. Engineering candidates are advised to take a math Subject Test and either chemistry or physics');
Insert sat2_requirement values(4, 'Stanford University', 'Yes', 'Yes', 2, 'Math', 'chemistry or physics.', 'Recommened','No', 'Enginerring', 'SAT Subject Tests are recommended but not required. Applicants who do not take SAT Subject Tests will not be at a disadvantage. Because SAT Subject Tests are optional, applicants may use Score Choice to selectively send their SAT Subject Test scores');
Insert sat2_requirement values(21, 'UC Berkeley', 'Yes', 'Yes', 2, 'Math', null, 'Recommened','No', 'Chemistry and Engineering', 'College of Chemistry and College of Engineering recommend Math Level 2 and a science related to the applicant’s intended major.');
Insert sat2_requirement values(47, 'UC Irvine', 'Yes', 'Yes', 2, null, null, 'Recommened','No', null, 'School of Engineering, Department of Pharmaceutical Sciences, School of Physical Sciences, and Program in Public Health all have specific Subject Test recommendations');
Insert sat2_requirement values(25, 'UCLA', 'Yes', 'Yes', 2, null, null, 'Recommened','No', null, 'School of Engineering and Applied Sciences recommends Math Level 2 and a science test related to the applicant’s intended major.');
Insert sat2_requirement values(103, 'UC Riverside', 'Yes', 'Yes', 2, null, null, 'Recommened','No', null, 'College of Natural and Agricultural Sciences and College of Engineering recommend Math Level 2 and either Chemistry or Physics.');
Insert sat2_requirement values(39, 'UC San Diego', 'Yes', 'Yes', 2, null, null, 'Recommened','No', null, 'Biological or physical science applicants and applicants to the School of Engineering should take Math Level 2 and a science Subject Test related to the applicant’s intended major.');
Insert sat2_requirement values(46, 'UC Santa Barbara', 'Yes', 'Yes', 2, null, null, 'Recommened','No', null, 'Math Level 2 is recommended for College of Engineering applicants and College of Creative Studies applicants in math, physics, or computer science. In addition, physics, biology, chemistry, and biochemistry majors are encouraged to take the appropriate science Subject Test.');
Insert sat2_requirement values(73, 'University of Delaware', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, 'recommends (STRONGLY, for the Honors Program) that applicants take SAT Subject Tests.');
Insert sat2_requirement values(60, 'University of Georgia', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, null);
Insert sat2_requirement values(5, 'University of Pennsylvania', 'Yes', 'Yes', 2, null, null, 'Recommened','No', null, 'Any 2 Subject Tests are recommended for arts, humanities, and social sciences applicants. STEM applicants are strongly encouraged to take Math Level 2 and a science Subject Test (Physics recommended for engineering applicants). Math Level 2 is recommended for business applicants. Nursing applicants are encouraged to submit a science Subject Test (preferably, Chemistry). ');
Insert sat2_requirement values(27, 'University of Southern California', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, 'strongly recommends applicants submit SAT Subject Test scores. For students intending to study the sciences, one of the Math Subject Tests is recommended.');
Insert sat2_requirement values(23, 'University of Virginia', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, null);
Insert sat2_requirement values(1016, 'Washington and Lee University', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, 'Submission of 2 SAT Subject Tests in different subjects is strongly recommended. “[Subject Tests] can provide our admission committee with useful information as we seek to distinguish between the many highly qualified applicants');
Insert sat2_requirement values(3, 'Yale University', 'Yes', 'Yes', 2, null, null, 'Recommened','No', null, null);
Insert sat2_requirement values(10000, 'Babson College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(1024, 'Bates College', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, null);
Insert sat2_requirement values(37, 'Boston College', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, 'SAT Subject Tests may “highlight a talent in a specific area.”');
Insert sat2_requirement values(57, 'Boston University', 'Yes', 'Yes', 2, null, null, 'Recommened','No', null, 'Accelerated medical and dental programs require Subject Tests in Chemistry and Math 2. A Subject Test in a foreign language is also recommended for these programs.');
Insert sat2_requirement values(1003, 'Bowdoin College', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, null);
Insert sat2_requirement values(1031, 'Bucknell University', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(41, 'Case Western Reserve University', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, null);
Insert sat2_requirement values(1008, 'Claremont McKenna', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(1047, 'Connecticut College', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, null);
Insert sat2_requirement values(33, 'College of William & Mary', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(6001, 'The Cooper Union', 'Yes', 'Yes', 1, null, null, 'Recommened','No', null, 'School of Engineering requires SAT Subject tests in Math and either Physics or Chemistry.');
Insert sat2_requirement values(10001, 'Franklin Olin College of Engineering', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'School of Engineering requires SAT Subject tests in Math and either Physics or Chemistry.');
Insert sat2_requirement values(54, 'George Washington University', 'Yes', 'Yes', 2, null, null, 'Considered','No', null, 'Two SAT Subject Tests are required in science and mathematics for the Seven Year BA/MD program.');
Insert sat2_requirement values(2008, 'Ithaca College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'Ithaca is test optional. Students may submit SAT, ACT, or SAT Subject Tests as “supplemental information.');
Insert sat2_requirement values(16, 'Johns Hopkins University', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'Students may submit Subject Tests as a “way to demonstrate an academic strength . . . Engineering applicants are encouraged to submit Math Level 2 and one science.”');
Insert sat2_requirement values(1027, 'Kenyon College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(1022, 'Macalester College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(3004, 'Mills College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'A student’s overall record may be enhanced by the presentation of SAT Subject Tests');
Insert sat2_requirement values(1023, 'Oberlin College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(1042, 'Occidental College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(1005, 'Pomona College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'SAT Subject Tests are considered as part of a complete testing profile.');
Insert sat2_requirement values(1095, 'Reed College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(44, 'Rensselaer Polytechnic Institute', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'Applicants to the accelerated program must take the ACT with Writing or the SAT and 2 SAT Subject Tests (1 math and 1 science).');
Insert sat2_requirement values(1029, 'Scripps College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(1015, 'Smith College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(77, 'Stevens Institute of Technology', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'Subject Tests in Math (Level 1 or 2) and either Chemistry or Biology are required for the Accelerated Medical Program.');
Insert sat2_requirement values(1002, 'Swarthmore College', 'Yes', 'No', 1, null, null, 'Considered','No', null, 'The essay will not be considered. Subject Tests scores will be considered if submitted. Prospective engineers are encouraged to take Math Level 2.');
Insert sat2_requirement values(1038, 'Union College', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'Union is test optional except for the Law and Public Policy Program and the Leadership in Medicine Program. The 6-year law program requires the SAT or ACT. The 8-year medical program requires either the ACT with Writing or the SAT and 2 Subject Tests.');
Insert sat2_requirement values(43, 'UC Davids', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(3146, 'UC Merced', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(81, 'UC Santa Cruz', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, null);
Insert sat2_requirement values(10, 'University of Chicago', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'If you have done exceptionally well on a particular subject test and would like to show us, feel free to send us that score');
Insert sat2_requirement values(52, 'University of Miami', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'Honors Program in Medicine and Honors Program in Biochemistry & Molecular Biology require minimum scores of 600 on a math Subject Test and on a science Subject Test.');
Insert sat2_requirement values(26, 'University of Michigan', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'will consider SAT Subject Tests “only in light of how they might benefit your review.');
Insert sat2_requirement values(28, 'University of North Carolina, Chapel Hill', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'You may submit supplemental scores from AP, IB, or SAT Subject tests if you think they are a good reflection of your mastery of the material.');
Insert sat2_requirement values(20, 'University of Notre Dame', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'SAT Subject Tests, AP, and IB tests are only used in the application process if scores enhance an application.');
Insert sat2_requirement values(19, 'Vanderbilt University', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'School of Engineering applicants choosing to submit scores should strongly consider taking either Math Level 1 or Level 2.');
Insert sat2_requirement values(30, 'Wake Forest University', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'Considered	Wake Forest is test optional. SAT, ACT, and SAT Subject Tests will be considered if submitted.');
Insert sat2_requirement values(12, 'Washington University in St. Louis', 'Yes', 'N', 1, null, null, 'Considered','No', null, 'only “consider [SAT Subject Tests] if they strengthen your application.”');
Insert sat2_requirement values(1017, 'Wesleyan University', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'Considered	Wesleyan is test optional. SAT, ACT, and SAT Subject Tests will be considered if submitted.');
Insert sat2_requirement values(63, 'Worcester Polytechnic Institute', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'WPI is test optional. SAT, ACT, and SAT Subject Tests will be considered if submitted.');
Insert sat2_requirement values(1018, 'Colby College', 'Yes', 'Yes', 1, null, null, 'Alternative','Yes', null, 'testing requirements are satisfied with 1 of the following options: (1) SAT (2) ACT (3) Three Subject Tests.');
Insert sat2_requirement values(1026, 'Colorado College', 'Yes', 'Yes', 1, null, null, 'Alternative','No', null, 'testing requirements are satisfied with 1 of the following options: (1) SAT (2) ACT (3) Three Subject Tests.');
Insert sat2_requirement values(1013, 'Hamilton College', 'Yes', 'Yes', 1, null, null, 'Alternative','No', null, 'testing requirements are satisfied with 1 of the following options: (1) SAT (2) ACT (Writing optional) (3) Quantitative, verbal, and writing tests from among SAT, ACT, SAT Subject Tests, and APs.');
Insert sat2_requirement values(1043, 'Trinity College (CT)', 'Yes', 'Yes', 1, null, null, 'Considered','No', null, 'testing requirements are satisfied with 1 of the following options: (1) SAT (2) ACT (Writing recommended) (3) 2 SAT Subject Tests. SAT Subject Tests are also considered when submitted with the SAT or ACT.');
Insert sat2_requirement values(1004, 'Middlebury College', 'Yes', 'Yes', 1, null, null, 'Alternative','No', null, 'testing requirements are satisfied with 1 of the following options: (1) SAT (2) ACT (3) Three Subject Tests.');
Insert sat2_requirement values(34, 'New York University', 'Yes', 'Yes', 1, null, null, 'Alternative','No', null, 'testing requirements are satisfied by fulfilling one of the following: (A) SAT (B) ACT with Writing (C) 3 Subject Tests (D) 3 AP exams (E) The International Baccalaureate Diploma (F) 3 IB higher-level exams (if a student is not an IB Diploma candidate). Students who choose to submit three SAT Subject Test, AP, or IB scores must submit one in literature or the humanities, one in math or science, and one of the student’s choice. Some programs have additional requirements.');
Insert sat2_requirement values(35, 'University of Rochester', 'Yes', 'Yes', 1, null, null, 'Alternative','No', null, 'testing requirements are satisfied with 1 of the following options: (1) SAT (2) ACT (3) 2 or more results from SAT Subject Tests, AP exams, or IB exams.');
commit;