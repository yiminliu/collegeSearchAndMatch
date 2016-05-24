DROP TABLE IF EXISTS toefl_ielts_requirement;
CREATE TABLE toefl_ielts_requirement
(
  School_Id INT NOT NULL,
  School_Name VARCHAR(80),
  TOEFL_Minimal_Requirement INT,
  TOEFL_Average_Score INT,
  Accept_IELTS VARCHAR(10) DEFAULT 'Y',
  IELTS_Minimal_Requirement INT,
  IELTS_Average_Score INT,
  TOEFL_Reading_Requirement INT,
  TOEFL_Listning_Requirement INT,
  TOEFL_Speaking_Requirement INT,
  TOEFL_Writing_Requirement INT,
  IELTS_Reading_Requirement INT,
  IELTS_Listning_Requirement INT,
  IELTS_Speaking_Requirement INT,
  IELTS_Writing_Requirement INT,
  Note VARCHAR(1000),
  Primary Key (School_Id),
  FOREIGN KEY (School_Id) REFERENCES school (Id)
);

Insert toefl_ielts_requirement values(2, 'Harvard University', '109', null, 'N', null, null, null, null, null, null, null, null, null, null, null);
Insert toefl_ielts_requirement values(4, 'Stanford University', '100', null, 'N', null, null, null, null, null, null, null, null, null, null, null);
Insert toefl_ielts_requirement values(36,'Georgia Institute of Technology', '79', null, 'N', null, null, null, null, null, null, null, null, null, null, null);

commit;