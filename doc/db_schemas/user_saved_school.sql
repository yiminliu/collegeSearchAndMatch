
DROP TABLE IF EXISTS user_saved_school;
CREATE TABLE user_saved_school
(
  user_id INT NOT NULL,
  school_id INT NOT NULL,
  PRIMARY KEY (user_id, school_id)
);

Commit;