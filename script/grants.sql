--przyznanie praw do bazy użytkownikowi vregister  ! nie tworzyć w sytemie użytkowników!  
-- tworzę bazę użytkownikiem postgres createdb vregister, loguję się i tworzę użytkownika oraz nadaję prawa
Create user osp with password '123test456';
GRANT ALL ON DATABASE osp TO osp;
