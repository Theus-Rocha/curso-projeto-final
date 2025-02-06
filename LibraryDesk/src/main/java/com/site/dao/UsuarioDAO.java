package com.site.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.site.livro.Usuario;

public class UsuarioDAO {
	private Connection connection;
	
	public UsuarioDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String DATABASE_URL = "jdbc:mysql://localhost:3306/librarydesk";
			String usuario = "root";
			String senha = "M@7h3u$";
		}catch( ClassNotFoundException e) {
			return;
		}
	}
	
	
	public boolean inserirU(Usuario usuario) {
		String sql = "INSERT INTO Usuarios(Nome, idade, email, login, senha) VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getLogin());
			stm.setString(4, usuario.getSenha());
			stm.execute();
			return true;
		} catch(SQLException e)	{			
			return false;
		}
	}

	public boolean inserirU(Usuario usuario) {
		String sql = "INSERT INTO Usuarios(Nome, idade, email, login, senha) VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getLogin());
			stm.setString(4, usuario.getSenha());
			stm.execute();
			return true;
		} catch(SQLException e)	{			
			return false;
		}
	}
	
	public boolean deletarU(Usuario usuario) {
		String sql = "DELETE FROM Usuarios WHERE id=?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			stm.execute();
			return true;
		} catch(SQLException e) {
			return false;
		}
	}
	
	public boolean alterarU(Usuario usuario) {
		String sql = "UPDATE Usuarios SET Nome=?, idade=?, email=?, login=?, senha=?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setInt(2, usuario.getIdade);
			stm.setString(3, usuario.getEmail);
			stm.setString(4, usuario.getLogin);
			stm.setString(5, usuario.getSenha);
			stm.execute();
			return true;
		}catch(SQLException e) {
			return false;
		}
	}
	
	
	public boolean removerU(Usuario usuario) {
		String sql = "DELETE FROM Usuarios WHERE id=?";
		try {
			PreparedStatemnt stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			stm.execute();
			return true;
		}catch(SQLException e) {
			return false;
		}
	}

	
}


