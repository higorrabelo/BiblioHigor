package model;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable{
    private static final long serialVersionUID=1L;
    private int id_usuario;
    private String nome_usuario;
    private String senha_usuario;
    private String email_usuario;
    private Date nascimento;
    private Date cadastro;
    private String endereco;  

    public Usuario(String nome_usuario, String senha_usuario, String email_usuario, Date nascimento, Date cadastro, String endereco) {
        this.nome_usuario = nome_usuario;
        this.senha_usuario = senha_usuario;
        this.email_usuario = email_usuario;
        this.nascimento = nascimento;
        this.cadastro = cadastro;
        this.endereco = endereco;
    }

    public Usuario(int id_usuario, String nome_usuario, String senha_usuario, String email_usuario, Date nascimento, Date cadastro, String endereco) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.senha_usuario = senha_usuario;
        this.email_usuario = email_usuario;
        this.nascimento = nascimento;
        this.cadastro = cadastro;
        this.endereco = endereco;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id_usuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nome_usuario=" + nome_usuario + ", senha_usuario=" + senha_usuario + ", email_usuario=" + email_usuario + ", nascimento=" + nascimento + ", cadastro=" + cadastro + ", endereco=" + endereco + '}';
    }
    
}
