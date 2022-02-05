package model;

import java.io.Serializable;

public class Quadrinhos implements Serializable{
    private static final long serialVersionUID=1L;
    private int id_quadrinho;
    private String nome_quadrinho;
    private String nome_editora;
    private int numero;
    private String mes;
    private int ano;

    public Quadrinhos(String nome_quadrinho, String nome_editora, int numero, String mes, int ano) {
        this.nome_quadrinho = nome_quadrinho;
        this.nome_editora = nome_editora;
        this.numero = numero;
        this.mes = mes;
        this.ano = ano;
    }

    public Quadrinhos(int id_quadrinho, String nome_quadrinho, String nome_editora, int numero, String mes, int ano) {
        this.id_quadrinho = id_quadrinho;
        this.nome_quadrinho = nome_quadrinho;
        this.nome_editora = nome_editora;
        this.numero = numero;
        this.mes = mes;
        this.ano = ano;
    }

    public int getId_quadrinho() {
        return id_quadrinho;
    }

    public void setId_quadrinho(int id_quadrinho) {
        this.id_quadrinho = id_quadrinho;
    }

    public String getNome_quadrinho() {
        return nome_quadrinho;
    }

    public void setNome_quadrinho(String nome_quadrinho) {
        this.nome_quadrinho = nome_quadrinho;
    }

    public String getNome_editora() {
        return nome_editora;
    }

    public void setNome_editora(String nome_editora) {
        this.nome_editora = nome_editora;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_quadrinho;
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
        final Quadrinhos other = (Quadrinhos) obj;
        if (this.id_quadrinho != other.id_quadrinho) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quadrinhos{" + "id_quadrinho=" + id_quadrinho + ", nome_quadrinho=" + nome_quadrinho + ", nome_editora=" + nome_editora + ", numero=" + numero + ", mes=" + mes + ", ano=" + ano + '}';
    }
    
    
}
