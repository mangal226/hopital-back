DROP DATABASE  IF EXISTS hopital;
CREATE DATABASE hopital;


CREATE TABLE compte (
    id INT PRIMARY KEY NOT NULL,
    login VARCHAR(100),
    password VARCHAR(100),
    type VARCHAR(100)
);


CREATE TABLE medecin (
    id INT PRIMARY KEY NOT NULL,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(255),
    date_naissance DATE,
    pays VARCHAR(255),
    ville VARCHAR(255),
    code_postal VARCHAR(5),
    nombre_achat INT
);


CREATE TABLE patient (
    id INT PRIMARY KEY NOT NULL,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    date_naissance DATE
);

CREATE TABLE secretaire (
    id INT PRIMARY KEY NOT NULL,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(255),
    date_naissance DATE,
    pays VARCHAR(255),
    ville VARCHAR(255),
    code_postal VARCHAR(5),
    nombre_achat INT
);

CREATE TABLE visite (
    id INT PRIMARY KEY NOT NULL,
    prix VARCHAR(50),
    salle VARCHAR(100),
    date_visite VARCHAR(100)
);