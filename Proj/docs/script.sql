DROP database IF EXISTS Vilebe;

CREATE database Vilebe;

use Vilebe;

CREATE TABLE Cliente(
    idCliente int not null auto_increment primary key,
    nome VARCHAR(50) not null,
    idade integer not null,
    cnh VARCHAR(20),
    cpf VARCHAR(20) not null,
    telefone VARCHAR(20) not null
);

CREATE table login (
    idCliente integer not null,
    email VARCHAR(256) NOT NULL,
    senha VARCHAR(50) NOT NULL
);

CREATE TABLE Telefone(
    idCliente integer not null,
    telefone VARCHAR (20) not null
);

CREATE TABLE Veiculo(
    idVeiculo integer not null auto_increment primary key,
    tipo varchar(50) not null,
    modelo VARCHAR(50) not null,
    marca VARCHAR(50) not null,
    placa VARCHAR(50) not null,
    espf VARCHAR(150) not null,
    img VARCHAR(6000)
);

CREATE TABLE Locacao(
    idLoc integer not null auto_increment primary key,
    idCliente integer NOT NULL,
    idVeiculo INTEGER NOT NULL,
    DataDevolucao VARCHAR(20) not null,
    DataRetirada VARCHAR(20) not null,
    LocalRetirada VARCHAR(150) not null,
    LocalDevolucao VARCHAR(150) not null
);

CREATE TABLE Sede(
    idSede integer not null auto_increment primary key,
    nome VARCHAR(100),
    estado VARCHAR(3)
);

alter TABLE
    Telefone
add
    constraint fk_telefone foreign key (idCliente) references Cliente(idCliente);

alter TABLE
    Locacao
add
    constraint fk_idCliente foreign key (idCliente) references Cliente(idCliente);

alter TABLE
    Locacao
add
    constraint fk_idVeiculo foreign key (idVeiculo) references Veiculo(idVeiculo);

alter TABLE
    Locacao
add
    constraint fk_idSede foreign key (idSede) references Sede(idSede);

ALTER TABLE
    LOGIN
add
    CONSTRAINT fk_idCliente2 FOREIGN key (idCliente) references Cliente(idCliente);