
package application;
import java.sql.Connection;
import db.*;
import services.QuadrinhoService;
//import java.sql.*;
import model.Quadrinho;
public class Program {
    
    public static void main(String[] args){
  
        Connection conn = DB.getConnection();
        
        QuadrinhoService qs = new QuadrinhoService();
        
        for (Quadrinho hq : qs.getList()){
             System.out.println(hq);
        }
    }
    
}
