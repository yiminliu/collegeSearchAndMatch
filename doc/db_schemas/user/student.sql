DROP TABLE IF EXISTS student CASCADE;
CREATE TABLE student
(
  student_id    integer, 
  sat1_score    integer,
  act_score     integer,
  toefl_score   integer,
  ielts_score   integer,

  PRIMARY KEY(student_id),
  FOREIGN KEY (student_id) REFERENCES users (user_id),
  INDEX(student_id)
);

commit;
 
