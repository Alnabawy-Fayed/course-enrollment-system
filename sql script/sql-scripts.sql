create database courses_management_system;

use courses_management_system;

create table student_course(
student_id bigint(22),
course_id bigint(22));

create table category(
id bigint(22) not null auto_increment,
name varchar(255) default null,
primary key(id));

create table teacher(
id bigint(22) not null auto_increment,
name varchar(255),
email varchar(255),
primary key(id));

create table student(
id bigint(22) not null auto_increment,
first_name varchar(255) default null,
last_name varchar(255) default null,
email varchar(255) default null,
password varchar(300) default null,
role varchar(255) default 'USER',
primary key(id)
);

create table course (
id bigint(22) not null auto_increment,
name varchar(255) default null,
start_at date default null,
end_at date default null,
course_code varchar(255) default null,
price decimal(13.2) default null,
category_id bigint(22) not null,
teacher_id bigint(22) not null,
primary key(id),
foreign key(category_id) references category(id),
foreign key(teacher_id) references teacher(id));

insert into teacher(name,email) values
('nabawy fayed','nabawy@yahoo.com'),
('ahmed fayed','ahmed@yahoo.com'),
('mohamed fayed','mohemad@yahoo.com');

insert into category(name) values
('programimng'),
('Math'),
('design'),
('medical'),
('engineering');

insert into course(name,start_at,end_at,course_code,price,category_id,teacher_id) values
('java','2022-5-27','2022-6-27','c2004',500,1,2),
('c++','2022-5-27','2022-6-27','c2005',1000,1,3),
('pathon','2022-5-27','2022-6-27','c2006',500,1,1),
('c#','2022-5-27','2022-6-27','c2007',500,1,2),
('php','2022-5-27','2022-6-27','c2008',500,1,1),
('ruby','2022-5-27','2022-6-27','c2009',500,1,2),
('linear Algebra','2022-5-27','2022-6-27','c2004',500,2,2),
('calculas','2022-5-27','2022-6-27','c2005',1000,2,3),
('photoshop','2022-5-27','2022-6-27','c2006',500,3,1);

alter table student_course add is_active bit(1) default 1;
alter table student_course add subscription_date date;
alter table student_course add last_update date;