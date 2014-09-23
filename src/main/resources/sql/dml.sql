INSERT INTO Role (name) VALUES ('admin');
INSERT INTO Role (name) VALUES ('user');

INSERT INTO Person (name, email, password, role_id) VALUES ('Jerome', 'thejerome@mail.ru', 'qsawer', 1);

INSERT INTO Article (title, content, author_id, created) VALUES ('Test Article', 'Some 41', 1, sysdate);
INSERT INTO Article (title, content, author_id, created) VALUES ('Test Article 2', 'Some 42', 1, sysdate);
INSERT INTO Article (title, content, author_id, created) VALUES ('Test Article 3', 'Some 43', 1, sysdate);

INSERT INTO Tag (name) VALUES ('Java');
INSERT INTO Tag (name) VALUES ('sun is shining');

INSERT INTO Article_Tag (article_id, tag_id) VALUES (1,1);
