DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
  user_id       integer AUTO_INCREMENT PRIMARY KEY, 
  username      varchar(50) NOT NULL,
  password      varchar(20) NOT NULL,
  email         varchar(50),
  enabled       boolean DEFAULT false,
  dateEnabled   date,
  dateDisabled  date,
  
  INDEX(user_id),
  INDEX(username)
);


insert into users (user_id,username, password, email, enabled)
values(1, 'andmin', 'password', 'test@test.com', true);
 
insert into users (user_id,username, password, email, enabled)
values(3, 'test', 'password', 'test@test.com', true);
 
insert into users (user_id,username, password, email, enabled)
values(4, 'guest', '', 'test@test.com', true);
 
commit;
 
