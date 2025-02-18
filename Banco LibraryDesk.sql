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
id integer not null,
Nome varchar(100) not null,
Sexo varchar(10) not null,
Idade int,
Email varchar(50) not null,
Senha varchar(50) not null);

-- Inserir dados
insert into Usuario (Nome, Sexo, Idade, Email, Senha) values("Giuseppe", "masculino", 26, "giuseppe@gmail.com", "giu1234");

insert into Usuario (Nome, Sexo, Idade, Email, Senha) values("Marcus", "masculino", 21, "nogueira@gmail.com", "nog1234");

insert into Usuario(Nome, Sexo, Idade, Email, Senha) values("Neymar", "masculino", 35, "meninoney@gmail.com", "ney1234");

-- Tabela Livros
/*
create table Livros(
idlivro int primary key auto_increment,
titulo varchar(100) not null,
genero varchar(45),
editora varchar(100),
autor varchar(100),
isbn varchar (45));
*/
