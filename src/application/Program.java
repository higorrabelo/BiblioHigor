/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import dao.UsuarioDAO;
import dao.DaoFactory;
import dao.QuadrinhosDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import model.Quadrinhos;

/**
 *
 * @author higor_x
 */
public class Program {
    
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       
        QuadrinhosDAO hqDao = DaoFactory.criarQuadrinho();
       
        List<Quadrinhos> hqs = hqDao.listarQuadrinhos();
        
        
        
 
        
        for(Quadrinhos hq : hqDao.listarQuadrinhos()){
            System.out.println(hq);
        }
        
        /*
         String nome="Homem Aranha".toUpperCase();
        String editora="Panini".toUpperCase();
        int numero = 22;
        String mes = "JANEIRO".toUpperCase();
        int ano = 2016;
        Quadrinhos hq = hqDao.acharPorId(5);
        
        hq.setNome_quadrinho(nome);
        hq.setNome_editora(editora);
        hq.setNumero(numero);
        hq.setMes(mes);
        hq.setAno(ano);
        
        hqDao.update(hq);
        */
        
    }
    
}
