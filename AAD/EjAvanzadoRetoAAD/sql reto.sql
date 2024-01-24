DROP DATABASE IF EXISTS retodario;
CREATE DATABASE retodario;
USE retodario;

CREATE TABLE libros(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(128) NOT NULL,
	ISBN VARCHAR(13) NOT NULL,
	release_year INT(4),
	idioma VARCHAR(25),
	precio DECIMAL(10,2),
	cantidad INT
);

CREATE TABLE autores(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(128) NOT NULL,
	pais_origen VARCHAR(128) NOT NULL,
	fecha_nacimiento DATE
);

CREATE TABLE categorias(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(128) NOT NULL
);

CREATE TABLE clientes(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(128) NOT NULL,
	apellidos VARCHAR(255) NOT NULL,
	telefono VARCHAR(20),
	email VARCHAR(255)
);

CREATE TABLE pedidos(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_cliente INT,
    precio_total DECIMAL(10,2),
    fecha_pedido DATE NULL DEFAULT CURRENT_DATE,
    direccion_envio VARCHAR(255),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);