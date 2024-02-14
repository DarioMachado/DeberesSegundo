CREATE DATABASE hospitalapp;
USE hospitalapp;


CREATE TABLE pacientes(
	id int primary key,
    nombre varchar(250),
    apellidos varchar(250),
    ciudad varchar(250),
    direccion varchar(250),
	telefono varchar(20),
	edad int,
	historial varchar(250)
);


CREATE TABLE medicos(
	id int primary key,
	nombre varchar(250),
	apellidos varchar(250),
	especialidad varchar(250)


);


CREATE TABLE citas(
	id int primary key,
	id_paciente int,
	id_medico int,
	fecha date,
	hora varchar(5),
	foreign key (id_paciente) references pacientes(id),
	foreign key (id_medico) references medicos(id)

);