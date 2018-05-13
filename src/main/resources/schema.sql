create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table task
(
   id integer not null auto_increment,
   name varchar(255) not null,
   description varchar(255) not null,
   done boolean not null,
   primary key(id)
);