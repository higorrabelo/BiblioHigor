
package application;
import java.sql.Connection;
import db.*;
public class Program {
    
    public static void main(String[] args){
    
        Connection conn = DB.getConnection();
        
        if(conn!=null){
        System.out.println("Conexão REalizada com sucesso");
        }else{
        System.out.println("Falha na Conexão");
        }
    
    }
    
}
