DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities
(
	user_id       integer, 
	role          varchar(20),
    
    PRIMARY KEY(user_id, role),
    
    FOREIGN KEY (user_id)
      REFERENCES users (user_id)
  
);

insert into authorities values(1, 'ROLE_ADMIN');
 
insert into authorities values(3, 'ROLE_USER');

insert into authorities values(3, 'ROLE_UNPAYED_USER');

insert into authorities values(4, 'ROLE_ANONYMOUS');
 

COMMIT;   

