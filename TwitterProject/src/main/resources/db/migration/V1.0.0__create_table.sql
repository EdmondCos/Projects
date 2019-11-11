create table accounts(
username varchar(30) not null unique,
password varchar(255) not null,
email varchar(255) not null unique primary key
);