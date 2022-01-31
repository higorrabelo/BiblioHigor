
package application;
import java.sql.Connection;
import db.*;
import services.QuadrinhoService;
import java.sql.*;
public class Program {
    
    public static void main(String[] args){
    try{
        Connection conn = DB.getConnection();
        
        QuadrinhoService qs = new QuadrinhoService();
        ResultSet rs = qs.getList();
        
        while(rs.next()){
            System.out.println(rs.getString("nome_quadrinho"));
        }
      }
    catch(SQLException e){
        throw new DbException("Erro na aplicação");
    }
    }
    
}
