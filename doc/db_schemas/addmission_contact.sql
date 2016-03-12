DROP TABLE IF EXISTS addmission_contact CASCADE;
CREATE TABLE addmission_contact
(
  school_id       integer PRIMARY KEY, 
  director_name   varchar(50) NOT NULL,
  phone           varchar(20) NOT NULL,
  email           varchar(50),
);

commit;
 
