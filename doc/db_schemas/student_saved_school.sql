
DROP TABLE IF EXISTS student_saved_school;
CREATE TABLE student_saved_school
(
  student_id INT NOT NULL,
  school_id INT NOT NULL,
  PRIMARY KEY (student_id, school_id),
  FOREIGN KEY (student_id) REFERENCES student (student_id),
  FOREIGN KEY (school_id) REFERENCES school (school_id)
);

Commit;