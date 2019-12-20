CREATE DATABASE basealumnos;

CREATE TABLE docente(id_docente int PRIMARY KEY, 
nombre varchar(50) not null, 
apellido varchar(50) not null, 
contrato varchar(59) not null );

create table grado(id_grado int PRIMARY KEY, 
nombre varchar(50) not null);

create table pago(id_pago int PRIMARY KEY, 
nombre varchar(50) not null, cantidad double not null);

create table tutor(id_tutor int PRIMARY KEY, 
nombre varchar(50) not null, apellido varchar(50) not null,
telefono varchar(50) not null);

create table alumno(carnet int PRIMARY key, 
nombre varchar(50) not null, apellido varchar(50) not null,
edad int not null, telefono varchar(50) not null, 
id_tutor int not null, id_grado int not null);

create table curso(id_curso int PRIMARY KEY, 
nombre varchar(50) not null,id_docente int not null);

create table horario(id_grado int not null,
id_curso int not null,hora varchar(10) not null, 
dia varchar(10) not null);

create table alumno_pago(carnet int not null, 
id_pago int not null,detalle varchar(50) not null);

create table control_de_notas(carnet int not null, 
id_curso int not null,nota int not null);