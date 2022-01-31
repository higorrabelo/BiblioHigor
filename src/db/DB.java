package db;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.*;
public class DB {
    
    private static Connection conn = null;
    
    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url,props);
            }
            catch(SQLException e){
                throw new DbException("Erro ao conectar ao banco de dados");
            }
        } 
        return conn;
    }
    
    public static void closeConneciton(){
        if(conn != null){
            try{
                conn.close();
            }
            catch(SQLException e){
                throw new DbException("Erro ao FEchar o Banco de dados");
            }
        }
    }
    private static Properties loadProperties(){
  
        try(FileInputStream fs = new FileInputStream("banco.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
       catch(IOException e){
          throw new DbException("Erro ao conectar ao arquivo de propriedades");
       }
        
    }
    public static void closeStatement(Statement st){
        if(st != null){
            try{
                st.close();
            }
            catch(SQLException e){
                throw new DbException("Statement Não pode ser Fechado");
            }
        }
    }
    public static void closeResultSet(ResultSet rs){
        if(rs != null){
        try{
            rs.close();
        }
        catch(SQLException e){
            throw new DbException("Erro ao Fechar o ResultSet");
        }
        }
    }
   
    
}
