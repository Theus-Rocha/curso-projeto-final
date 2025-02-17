package com.livro.dao;

import com.livro.modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;


    public UsuarioDAO(){
        try {
           Class.forName("com.mysql.jdbc.Driver");
           String DATABASE_URL = "jdbc:mysql://localhost:3306/librarydesk";
           String usuario = "root";
           String senha = " "; //Lembre-se de por a sua senha do SQL 
           this.conn = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch ( ClassNotFoundException | SQLException e) {
           
        }
    }

    private boolean inserirDadosUsuario(Usuario usuario){
        String sql = "INSERT INTO USUARIO (nome, sexo, idade, email, senha) VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSexo());
            stmt.setInt(3, usuario.getIdade());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.execute();
            return true;
        } catch(SQLException e){
            return false;
        }
    }

    private boolean alterarDadosUsuario(Usuario usuario){
        String sql = "UPDATE USUARIO SET nome = ?, sexo = ?, idade = ?, email = ?, senha = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSexo());
            stmt.setInt(3, usuario.getIdade());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    private boolean removerDadosUsuario(Usuario usuario){
        String sql = "DELETE FROM USUARIO WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Usuario> Listar(){
        String sql = "SELECT * FROM USUARIO";
        List<Usuario> retornar = new ArrayList<>();
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                Usuario usuario = new Usuario();
                usuario.setId(result.getInt("id"));
                usuario.setNome(result.getString("nome"));
                usuario.setSexo(result.getString("sexo"));
                usuario.setIdade(result.getInt("idade"));
                usuario.setEmail(result.getString("email"));
                usuario.setSenha(result.getString("senha"));
                retornar.add(usuario);
            }
        } catch(SQLException e){

        }
        return retornar;
    }

    /** public Usuario buscarUsuario(Usuario usuario){
        String sql = "SELECT * FROM USUARIO WHERE ID = ?";

    }*/
}
