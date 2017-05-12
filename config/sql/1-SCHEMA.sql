drop schema if exists `computer-database-db`;
  create schema if not exists `computer-database-db`;
  use `computer-database-db`;

  drop table if exists computer;
  drop table if exists company;

  create table company (
    id                        bigint not null auto_increment,
    name                      varchar(255),
    constraint pk_company primary key (id))
  ;

  create table computer (
    id                        bigint not null auto_increment,
    name                      varchar(255),
    introduced                timestamp NULL,
    discontinued              timestamp NULL,
    company_id                bigint default NULL,
    constraint pk_computer primary key (id))
  ;

  CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(70) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

  CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
	

  alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
	
  CREATE INDEX computer_name_asc ON computer (name ASC);
  CREATE INDEX computer_name_desc ON computer (name DESC);

  CREATE INDEX computer_company_asc ON computer (company_id ASC);
  CREATE INDEX computer_company_desc ON computer (company_id DESC);

  CREATE INDEX company_name_asc ON company (name ASC);
  CREATE INDEX company_name_desc ON company (name DESC);

  CREATE INDEX user_name_asc ON users (username ASC);
  CREATE INDEX user_name_desc ON users (username DESC);
 

