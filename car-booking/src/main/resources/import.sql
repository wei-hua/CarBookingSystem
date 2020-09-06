create database bookcar;

CREATE TABLE IF NOT EXISTS `user`(
   `id` bigint(20) UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(300) NOT NULL,
   `password` VARCHAR(200) NOT NULL,
   `phone` VARCHAR(20),
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `user` (`name`,`password`,`phone`) values ("tester","tester","13323456789");


CREATE TABLE IF NOT EXISTS `car`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `category` VARCHAR(300),
   `name` VARCHAR(200) NOT NULL,
   `stock` INT,
   `price` DECIMAL,
   `version` INT,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `car` (`category`,`name`,`stock`,`price`) values ("Toyota","Toyota Camry",2,200);
insert into `car` (`category`,`name`,`stock`,`price`) values ("BMW","BMW 650",2,500);

CREATE TABLE IF NOT EXISTS `order`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `car_id` INT,
   `user_id` INT,
   `start_time` bigint(20),
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;