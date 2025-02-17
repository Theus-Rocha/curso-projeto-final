package com.livro.modelo;

public class Usuario {
    private Integer id;
    private String nome;
    private String sexo;
    private int idade;
    private String email;
    private String senha;

    public Usuario(){

    }

    public Usuario(String nome, String sexo, int idade, String email, String senha){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(Integer id, String nome, String sexo, int idade, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
    }
    
   
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSexo(){
        return sexo;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
}
