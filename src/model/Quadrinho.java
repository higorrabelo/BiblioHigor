package model;

public class Quadrinho {
    
   private int id_quadrinho;
   private String nome_quadrinho;
   private String nome_editora;
   private int numero;
   private String mes;
   private int ano;
   
   public Quadrinho(String nome_quadrinho, String nome_editora, int numero, String mes, int ano){ 
       this.nome_quadrinho=nome_quadrinho;
       this.nome_editora=nome_editora;
       this.numero=numero;
       this.mes=mes;
       this.ano=ano;
   }
     public Quadrinho(int id_quadrinho,String nome_quadrinho, String nome_editora, int numero, String mes, int ano){ 
       this.id_quadrinho=id_quadrinho;
       this.nome_quadrinho=nome_quadrinho;
       this.nome_editora=nome_editora;
       this.numero=numero;
       this.mes=mes;
       this.ano=ano;
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
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("ID Quadrinho: "+getId_quadrinho());
        sb.append("\nNome Quadrinho: "+getNome_quadrinho());
        sb.append("\nEditora: "+getNome_editora());
        sb.append("\nNúmero: "+ getNumero());
        sb.append("\nMes: "+getMes());
        sb.append("\nAno: "+getAno());
        return sb.toString();
    }
}
