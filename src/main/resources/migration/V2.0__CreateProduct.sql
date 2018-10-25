drop table if exists product;

CREATE TABLE product (
  id int(11) NOT NULL ,
  name varchar(45) NOT NULL,
  price decimal(10,0) NOT NULL,
  quantity int(45) DEFAULT NULL,
  description varchar(450) DEFAULT NULL,
  photo varchar(100) DEFAULT NULL,
  active tinyint(1) DEFAULT NULL,
  createiondate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)