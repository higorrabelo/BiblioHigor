package db;
import java.sql.*;
import java.util.*;
import java.io.*;
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
                throw new DbException("Erro na conexão com o banco de dados");
            }
        }
        return conn;
    }
    
    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }
            catch(SQLException e){
                throw new DbException("Erro ao Fechar a Conexão");
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
            throw new DbException("Erro em carregar o arquivo de propriedades");
        }
    }
    
    public static void closeStatement(Statement st){
        if(st != null){
            try{
                st.close();
            }
            catch(SQLException e){
                throw new DbException("Erro ao fechar o Statement");
            }
        }
    }
      public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }
            catch(SQLException e){
                throw new DbException("Erro ao fechar o ResultSet");
            }
        }
    }
}
