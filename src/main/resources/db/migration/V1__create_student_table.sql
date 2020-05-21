CREATE TABLE `student` (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL,
  birthday datetime,
  create_time datetime,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;