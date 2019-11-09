create database courses;

use courses;

show tables;

CREATE TABLE IF NOT EXISTS teacher (

    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    first_name VARCHAR(255) NOT NULL,

    last_name VARCHAR(255) NOT NULL,

    hire_date DATE

)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS course (

    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    code VARCHAR(30) NOT NULL,

    description VARCHAR(255) NOT NULL,  

    teacher_id INT,

    FOREIGN KEY fk_course_teacher(teacher_id) REFERENCES teacher(id)

)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS address (

    id int not null auto_increment primary key,

    city VARCHAR(255) NOT NULL,

    street VARCHAR(255) NOT NULL

)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS student (

    id int not null auto_increment primary key,

    first_name VARCHAR(255) NOT NULL,

    last_name VARCHAR(255) NOT NULL,  

    birth_date DATE,

    address_id INT NOT NULL,

    FOREIGN KEY fk_stud_address(address_id) REFERENCES address(id)

)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS student_course (

    stud_id INT,

    course_id INT   

)  ENGINE=INNODB;

select * from teacher; 