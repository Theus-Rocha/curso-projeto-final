-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 24/02/2025 às 05:50
-- Versão do servidor: 8.0.30
-- Versão do PHP: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `slivro`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `autor`
--

DROP TABLE IF EXISTS `autor`;
CREATE TABLE IF NOT EXISTS `autor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `endereco` text NOT NULL,
  `telefone` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `autor`
--

INSERT INTO `autor` (`id`, `nome`, `endereco`, `telefone`) VALUES
(1, 'José Saramagos', 'Portugal', 1145691982),
(4, 'Alice Maria G.', 'Portugal', 612563684),
(5, 'Hortsman', 'EUA', 40028925);

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `catnome` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`id`, `catnome`, `status`) VALUES
(1, 'Java', 'Ativado'),
(2, 'Python', 'Ativado');

-- --------------------------------------------------------

--
-- Estrutura para tabela `devolucaolivro`
--

DROP TABLE IF EXISTS `devolucaolivro`;
CREATE TABLE IF NOT EXISTS `devolucaolivro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mid` int NOT NULL,
  `mnome` varchar(255) NOT NULL,
  `lnome` varchar(255) NOT NULL,
  `dataretorno` varchar(255) NOT NULL,
  `elp` int NOT NULL,
  `taxa` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `editora`
--

DROP TABLE IF EXISTS `editora`;
CREATE TABLE IF NOT EXISTS `editora` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `endereco` text NOT NULL,
  `telefone` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `editora`
--

INSERT INTO `editora` (`id`, `nome`, `endereco`, `telefone`) VALUES
(1, 'Victor Civita', 'São Paulo', 11659845),
(2, 'Editora34', 'Rio de Janeiro', 21659847),
(3, 'JavaLivros', 'EUA', 27463951);

-- --------------------------------------------------------

--
-- Estrutura para tabela `emprestalivro`
--

DROP TABLE IF EXISTS `emprestalivro`;
CREATE TABLE IF NOT EXISTS `emprestalivro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `membroid` int NOT NULL,
  `livroid` int NOT NULL,
  `emissaodata` date NOT NULL,
  `retornodata` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `livro`
--

DROP TABLE IF EXISTS `livro`;
CREATE TABLE IF NOT EXISTS `livro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lnome` varchar(255) NOT NULL,
  `categoria` int NOT NULL,
  `autor` int NOT NULL,
  `editora` int NOT NULL,
  `conteudos` varchar(11) NOT NULL,
  `paginas` int NOT NULL,
  `edicao` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `membro`
--

DROP TABLE IF EXISTS `membro`;
CREATE TABLE IF NOT EXISTS `membro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `telefone` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `membro`
--

INSERT INTO `membro` (`id`, `nome`, `endereco`, `telefone`) VALUES
(1, 'Alessandra', 'Gama', 40028922),
(2, 'Chaves', 'Gama Leste', 40028923),
(3, 'JoJo', 'Gama', 40028924);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
