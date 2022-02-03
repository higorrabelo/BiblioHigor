package services;
import db.*;
import model.Quadrinho;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
                    +"(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            st.setString(1,qd.getNome_quadrinho().toUpperCase());
            st.setString(2,qd.getNome_editora().toUpperCase());
            st.setInt(3, qd.getNumero());
            st.setString(4,qd.getMes().toUpperCase());
            st.setInt(5, qd.getAno());  
            int rows = st.executeUpdate();
            
            if(rows > 0){
                ResultSet rs = st.getGeneratedKeys();
                while(rs.next()){
                    int id = rs.getInt(1);
                    JOptionPane.showMessageDialog(null, "Item Adicionado com Sucesso: "+id);
                }      
            }
            
        }
        catch(SQLException e){
            throw new DbException("Erro ao inserir Quadrinho no banco"+e.getMessage());
        }
        
    }
    
    public List<Quadrinho> getList(){
       try{
            List<Quadrinho> qlist = new ArrayList<>();
            conn = DB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from quadrinhos");
            while(rs.next()){
                int id_quadrinho = rs.getInt("id_quadrinho");
                String nome = rs.getString("nome_quadrinho");
                String editora = rs.getString("nome_editora");
                int numero = rs.getInt("numero");
                String mes = rs.getString("mes");
                int ano = rs.getInt("ano");
                Quadrinho hq = new Quadrinho(id_quadrinho,nome,editora,numero,mes,ano);
                qlist.add(hq);
            }
            return qlist;
       }
       catch(SQLException e){
           throw new DbException("Não foi possível restaurar a Lista de HQS");
       }
    }
}
