create table accounts(
username varchar(30) not null unique,
password varchar(255) not null,
email varchar(255) not null unique primary key
);

create table messages(
id int auto_increment primary key unique,
message longtext,
postdate varchar(20),
username varchar(30) not null
);