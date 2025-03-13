# curso-projeto-final
Repositório para projeto final do curso de Técnico em Desenvolvimento de Sistemas.

# Projeto proposto
Desejamos desenvolver um site de avaliação de livros de diversos generos, cujo objetivo será a divulgação dos mesmos e o compartilhamento das opiniões, críticas e sugestões dos usuários. O site contará com uma inscrição para que os usários se conectem e criem seus próprios perfis, com isso, também lhes será permitido avaliar livros recém lido e deixar opiniões. 

Para visitantes comuns, será apenas permitido a navegação pelos tópicos de discussão, livros em destaque e exploração do conteúdo disponível.

telas:

![image](https://github.com/user-attachments/assets/6732bf76-c891-4847-a0bf-5fa93bee2683)

![image](https://github.com/user-attachments/assets/ac4ca3be-6f62-4d11-8db0-7fec1e488791)

![image](https://github.com/user-attachments/assets/3d2c6357-321f-4fb8-bfba-95dd0d4e1c0a)

![image](https://github.com/user-attachments/assets/5a6f2021-60ab-4bcf-99d3-a55010b3649c)

![image](https://github.com/user-attachments/assets/1cfb2a8c-d6b8-47a9-be91-a704e5892981)

![image](https://github.com/user-attachments/assets/b10aabd7-fd55-47b4-bfdc-f101c169579b)



Banco de dados:
```
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

```


Agora segue o Main do codigo: 

```
package sLivros;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(10, 11, 364, 507);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Categoria");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Categoria c = new Categoria();
				c.setVisible(true);
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(137, 94, 89, 40);
		panel.add(btnNewButton);
		
		JButton btnAutor = new JButton("Autor");
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Autor a = new Autor();
				a.setVisible(true);
				
				
				
				
			}
		});
		btnAutor.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnAutor.setBounds(137, 145, 89, 40);
		panel.add(btnAutor);
		
		JButton btnPublisher = new JButton("Editora");
		btnPublisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Editora ed = new Editora();
				ed.setVisible(true);
				
				
				
				
			}
		});
		btnPublisher.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnPublisher.setBounds(137, 196, 89, 40);
		panel.add(btnPublisher);
		
		JButton btnLivro = new JButton("Livro");
		btnLivro.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Livro l = new Livro();
				l.setVisible(true);
				
				
			}
		});
		btnLivro.setBounds(137, 247, 89, 40);
		panel.add(btnLivro);
		
		JButton btnMembro = new JButton("Membro");
		btnMembro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Membro m = new Membro();
				m.setVisible(true);
				
			}
		});
		btnMembro.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnMembro.setBounds(137, 298, 89, 40);
		panel.add(btnMembro);
		
		JButton btnEdio = new JButton("Edição");
		btnEdio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EdLivro  l = new EdLivro();
				l.setVisible(true);
				
				
				
				
			}
		});
		btnEdio.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnEdio.setBounds(137, 349, 89, 40);
		panel.add(btnEdio);
		
		JButton btnDevoluo = new JButton("Devolução");
		btnDevoluo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RetornoLivro r = new RetornoLivro();
				r.setVisible(true);
				
				
				
				
			}
		});
		btnDevoluo.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDevoluo.setBounds(137, 402, 89, 40);
		panel.add(btnDevoluo);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login lo = new Login();
				//this.setVisible(false); O QUE FAZER?????
				lo.setVisible(true);
				
				
				
			}
		});
		btnSair.setBounds(12, 454, 89, 40);
		panel.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("LibraryDesk");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(112, 0, 140, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gerenciamento");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(117, 49, 130, 16);
		panel.add(lblNewLabel_1);
	}
}

```




