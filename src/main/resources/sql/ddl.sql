CREATE TABLE IF NOT EXISTS Role(
  id number primary key AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL unique
);

CREATE TABLE IF NOT EXISTS Person(
  id number PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL unique ,
  password VARCHAR(255) NOT NULL,
  role_id INT NOT NULL references Role (id),
);

CREATE TABLE IF NOT EXISTS Article (
  id number PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(4000) ,
  content CLOB ,
  created DATETIME,
  updated DATETIME,
  author_id number NOT NULL REFERENCES Person (id)
);

CREATE TABLE IF NOT EXISTS Tag(
  id number PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL UNIQUE,
  parent_id number REFERENCES Tag(id)
);

CREATE TABLE IF NOT EXISTS Article_Tag(
  article_id INT NOT NULL REFERENCES Article(id),
  tag_id INT NOT NULL REFERENCES Tag(id),
  CONSTRAINT article_tag_unique UNIQUE (article_id,tag_id)
);

