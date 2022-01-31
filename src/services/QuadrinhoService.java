package services;
import db.*;
import model.Quadrinho;
import java.sql.*;
import javax.swing.JOptionPane;
public class QuadrinhoService {
    
    private Quadrinho quad = null;
    private Connection conn = null;
    
    public void insereQuadrinho(Quadrinho qd){
        try{
            conn = DB.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "insert into quadrinhos(nome_quadrinho, nome_editora, numero, mes, ano) "
                    +"values "
                    +"(?,?,?,?,?)");
            st.setString(1,qd.getNome_quadrinho().toUpperCase());
            st.setString(2,qd.getNome_editora().toUpperCase());
            st.setInt(3, qd.getNumero());
            st.setString(4,qd.getMes().toUpperCase());
            st.setInt(5, qd.getAno());  
            int rows = st.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Quadrinho Inserido com Sucesso");
            
        }
        catch(SQLException e){
            throw new DbException("Erro ao inserir Quadrinho no banco"+e.getMessage());
        }
        
    }
    
}
