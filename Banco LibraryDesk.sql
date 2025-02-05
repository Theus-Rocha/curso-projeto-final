 -- criação de DB
create database librarydesk;

-- Uso de DB
use librarydesk;

-- consulta de tabelas 
show tables;
select * from Livros;
select * from Usuario;


-- Tabela Usuarios
create table Usuario(
idusuario int primary key auto_increment,
Nome varchar(100) not null,
email varchar(50) not null,
login varchar(50) not null unique,
senha varchar(50) not null);


-- Tabela Livros
create table Livros(
idlivro int primary key auto_increment,
titulo varchar(100) not null,
genero varchar(45),
editora varchar(100),
autor varchar(100),
ano_publi date,
isbn varchar (45));