create database veterinaria;

use veterinaria;

create table persona (
    documento varchar(20) primary key,
    nombre varchar(50),
    apellido varchar(50),
    telefono varchar(20),
    direccion varchar(100)
);

create table mascota (
    codigo varchar(20) primary key,
    nombre varchar(50),
    especie varchar(30),
    raza varchar(50),
    edad int,
    documento_propietario varchar(20),
    foreign key (documento_propietario) references persona(documento)
);
