DROP TABLE IF EXISTS princeton_review_great_school_major;
CREATE TABLE princeton_review_great_school_major
(
  Major_Id INT NOT NULL,
  School_Id INT NOT NULL,
   Good_At VARCHAR(6) DEFAULT 'False',
  Primary Key (School_Id, Major_Id)
);

Insert princeton_review_great_school_major values(1, 2046, 'True');
Insert princeton_review_great_school_major values(1, 142, 'True');
Insert princeton_review_great_school_major values(1, 3, 'True');
Insert princeton_review_great_school_major values(1, 4, 'True');
Insert princeton_review_great_school_major values(1, 5, 'True');
Insert princeton_review_great_school_major values(1, 6, 'True');
Insert princeton_review_great_school_major values(1, 7, 'True');
Insert princeton_review_great_school_major values(1, 8, 'True');
Insert princeton_review_great_school_major values(1, 9, 'True');
Insert princeton_review_great_school_major values(1, 10, 'True');
Insert princeton_review_great_school_major values(1, 11, 'True');
Insert princeton_review_great_school_major values(1, 12, 'True');
Insert princeton_review_great_school_major values(1, 13, 'True');
Insert princeton_review_great_school_major values(1, 14, 'True');
Insert princeton_review_great_school_major values(1, 15, 'True');
Insert princeton_review_great_school_major values(1, 16, 'True');
Insert princeton_review_great_school_major values(1, 17, 'True');
Insert princeton_review_great_school_major values(1, 18, 'True');
Insert princeton_review_great_school_major values(1, 19, 'True');
Insert princeton_review_great_school_major values(1, 20, 'True');

Insert princeton_review_great_school_major values(2, 1, 'True');
Insert princeton_review_great_school_major values(2, 2, 'True');
Insert princeton_review_great_school_major values(2, 3, 'True');
Insert princeton_review_great_school_major values(2, 4, 'True');
Insert princeton_review_great_school_major values(2, 5, 'True');
Insert princeton_review_great_school_major values(2, 6, 'True');
Insert princeton_review_great_school_major values(2, 7, 'True');
Insert princeton_review_great_school_major values(2, 8, 'True');
Insert princeton_review_great_school_major values(2, 9, 'True');
Insert princeton_review_great_school_major values(2, 10, 'True');
Insert princeton_review_great_school_major values(2, 11, 'True');
Insert princeton_review_great_school_major values(2, 12, 'True');
Insert princeton_review_great_school_major values(2, 13, 'True');
Insert princeton_review_great_school_major values(2, 14, 'True');
Insert princeton_review_great_school_major values(2, 15, 'True');
Insert princeton_review_great_school_major values(2, 16, 'True');
Insert princeton_review_great_school_major values(2, 17, 'True');
Insert princeton_review_great_school_major values(2, 18, 'True');
Insert princeton_review_great_school_major values(2, 19, 'True');
Insert princeton_review_great_school_major values(2, 20, 'True');

Insert princeton_review_great_school_major values(3, 1, 'True');
Insert princeton_review_great_school_major values(3, 2, 'True');
Insert princeton_review_great_school_major values(3, 3, 'True');
Insert princeton_review_great_school_major values(3, 4, 'True');
Insert princeton_review_great_school_major values(3, 5, 'True');
Insert princeton_review_great_school_major values(3, 6, 'True');
Insert princeton_review_great_school_major values(3, 7, 'True');
Insert princeton_review_great_school_major values(3, 8, 'True');
Insert princeton_review_great_school_major values(3, 9, 'True');
Insert princeton_review_great_school_major values(3, 10, 'True');
Insert princeton_review_great_school_major values(3, 11, 'True');
Insert princeton_review_great_school_major values(3, 12, 'True');
Insert princeton_review_great_school_major values(3, 13, 'True');
Insert princeton_review_great_school_major values(3, 14, 'True');
Insert princeton_review_great_school_major values(3, 15, 'True');
Insert princeton_review_great_school_major values(3, 16, 'True');
Insert princeton_review_great_school_major values(3, 17, 'True');
Insert princeton_review_great_school_major values(3, 18, 'True');
Insert princeton_review_great_school_major values(3, 19, 'True');
Insert princeton_review_great_school_major values(3, 20, 'True');
Commit;

select s.name, m.name from princeton_review_great_school_major g, school s, popular_major m 
where g.good_at = 'true' and School_Id=s.id and major_Id=m.id and s.name='Yale University';

select s.name, m.name from princeton_review_great_school_major g, school s, popular_major m 
where g.good_at = 'true' and School_Id=s.id and major_Id=m.id and m.name='Accounting';
