Drop database if exists Vilebe;
create database Vilebe;
use Vilebe;

create table Cliente(
    idCliente int not null auto_increment primary key,
    CPF VARCHAR(20) not null,
    CNH VARCHAR(20),
    email VARCHAR(60) not null,
    nome VARCHAR(50) not null,
    data_nasc Date not null,
    cartao_cred VARCHAR(20),
    endereco VARCHAR(150) not null,
    telefone VARCHAR(20) not null
);

create table Telefone(
    idCliente integer not null,
    telefone VARCHAR (20) not null
    );

create table Tipo(
    idTipo integer not null auto_increment primary key,
    Tipo VARCHAR(40) not null
);

create table Caracteristicas(
    idCara integer not null auto_increment primary key,
    modelo VARCHAR(30) not null,
    placa VARCHAR(10) not null,
    marca VARCHAR(30) not null,
    espf VARCHAR(150)
);

create table Veiculo(
    idVeiculo integer not null auto_increment primary key,
    idTipo integer not null,
    idCara integer not null,
    DataRevisao DATE not null,
    KM_Inicial VARCHAR(50) not null   
);


create table Locacoes(
    idLoc integer not null auto_increment primary key,
    idCliente integer not null,
    idVeiculo integer not null,
    DataDevolucao date not null,
    DataRetirada date not null,
    LocalRetirada VARCHAR(150) not null,
    LocalDevolucao VARCHAR(150) not null,
    KM_Final VARCHAR(50) not null
);

create table Venda(
    idLoc integer not null auto_increment primary key,
    idVeiculo integer not null,
    idCliente integer not null,
    ValorDiaria decimal(9,2) not null,
    DataCompra date not null
);

create table Aeroportos(
    idAero integer not null auto_increment primary key,
    estado varchar(3) not null
);

alter table Telefone add
constraint fk_telefone foreign key (idCliente)
references Cliente(idCliente);

alter table Veiculo add 
constraint fk_Cara foreign key (idCara)
references Caracteristicas(idCara);

alter table Veiculo add 
constraint fk_tipo foreign key (idTipo)
references Tipo(idTipo);

alter table Locacoes add constraint fk_idCliente foreign key (idCliente)
references Cliente(idCliente);

alter table Locacoes add constraint fk_idVeiculo foreign key (idVeiculo)
references Veiculo(idVeiculo);

alter table Venda add constraint fk_idCliente2 foreign key (idCliente)
references Locacoes(idCliente);

alter table Venda add constraint fk_idVeiculo2 foreign key (idVeiculo)
references Locacoes(idVeiculo);

alter table Venda add constraint fk_idLoc foreign key (idLoc)
references Locacoes(idLoc);