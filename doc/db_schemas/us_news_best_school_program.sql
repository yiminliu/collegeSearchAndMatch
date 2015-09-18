DROP TABLE IF EXISTS us_news_best_school_program;
CREATE TABLE us_news_best_school_program
(
  School_Id INT NOT NULL,
  Program_Id INT NOT NULL,
  Rank INT NOT NULL,
  Primary Key (School_Id, Program_Id)
);

Insert us_news_best_school_program values(4, 1, 1);
Insert us_news_best_school_program values(7, 1, 2);
Insert us_news_best_school_program values(21, 1, 2);
Insert us_news_best_school_program values(26, 1, 4);
Insert us_news_best_school_program values(34, 1, 5);
Insert us_news_best_school_program values(28, 1, 6);
Insert us_news_best_school_program values(23, 1, 7);
Insert us_news_best_school_program values(22, 1, 8);
Insert us_news_best_school_program values(45, 1, 8);
Insert us_news_best_school_program values(75, 1, 8);

Insert us_news_best_school_program values(7, 2, 1);
Insert us_news_best_school_program values(5, 2, 2);
Insert us_news_best_school_program values(21, 2, 3);
Insert us_news_best_school_program values(6, 2, 4);
Insert us_news_best_school_program values(36, 2, 4);
Insert us_news_best_school_program values(40, 2, 6);
Insert us_news_best_school_program values(22, 2, 7);
Insert us_news_best_school_program values(26, 2, 7);
Insert us_news_best_school_program values(66, 2, 9);
Insert us_news_best_school_program values(13, 2, 10);
Insert us_news_best_school_program values(3, 2, 10);
Insert us_news_best_school_program values(45, 2, 10);


Commit;


select s.name, b.rank from  us_news_best_school_program b, school s, us_news_program p 
where b.School_Id=s.id and b.program_Id=p.id and p.name='Business';
