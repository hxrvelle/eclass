CREATE DATABASE IF NOT EXISTS students_test;

USE students_test;

create table student
(
    id   int not null primary key,
    name varchar(256) null
);

INSERT INTO students_test.student (`id`, `name`) VALUES ('1', 'Ученик 1');
INSERT INTO students_test.student (`id`, `name`) VALUES ('2', 'Ученик 2');

create table class
(
    id int auto_increment primary key,
    name varchar(256) not null,
    student_id int null,
    constraint class_student_id_fk foreign key (student_id) references student (id)
);

INSERT INTO students_test.class (`name`, `student_id`) VALUES ('КТ-1', '1');
INSERT INTO students_test.class (`name`, `student_id`) VALUES ('КТ-2', '2');

create table discipline
(
    id int auto_increment primary key,
    name varchar(256) not null
);

INSERT INTO students_test.discipline (`name`) VALUES ('Математика');
INSERT INTO students_test.discipline (`name`) VALUES ('Информатика');

create table class_discipline
(
    id int auto_increment primary key,
    id_class int not null,
    id_discipline int not null,
    constraint class_discipline_class_id_fk foreign key (id_class) references class (id),
    constraint class_discipline_discipline_id_fk foreign key (id_discipline) references discipline (id)
);

INSERT INTO students_test.class_discipline (`id_class`, `id_discipline`) VALUES ('1', '1');
INSERT INTO students_test.class_discipline (`id_class`, `id_discipline`) VALUES ('2', '2');
