CREATE DATABASE veterinaria;

USE veterinaria;

CREATE TABLE persona (
    documento VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    telefono VARCHAR(20),
    direccion VARCHAR(100)
);

CREATE TABLE mascota (
    codigo VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50),
    especie VARCHAR(30),
    raza VARCHAR(50),
    edad INT,
    documento_propietario VARCHAR(20),
    FOREIGN KEY (documento_propietario) REFERENCES persona(documento)
);