/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import dao.UsuarioDAO;
import dao.DaoFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Usuario;
import java.util.Date;

/**
 *
 * @author higor_x
 */
public class Program {
    
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        UsuarioDAO userDao = DaoFactory.criarUsuario();
        
        //Usuario user = new Usuario("Edmilson","Edmilson","edmilson@gmail.com",sdf.parse("24/09/1954"),new Date(),"Avenida Duque de Caxias");
        //userDao.insere(user);
        
        userDao.delete(3);
       /*
        
         for(Usuario user : userDao.listarUsuario()){
            System.out.println(user);
        }
        
        System.out.println(userDao.acharPorId(2));
        
        */ 
       
        
        
    }
    
}
