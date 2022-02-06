package DaoServices;
import java.sql.*;
import dao.QuadrinhosDAO;
import db.DB;
import db.DbException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Quadrinhos;

public class QuadrinhosService implements QuadrinhosDAO{
    
    private Connection conn = null;

    public QuadrinhosService() {
    }
    public QuadrinhosService(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insere(Quadrinhos obj) {
        String sql = "insert into quadrinhos"
                     +"(nome_quadrinho, nome_editora, numero, mes, ano) "
                     +"values "
                     +"(?, ?, ?, ?, ?)";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1,obj.getNome_quadrinho());
            st.setString(2,obj.getNome_editora());
            st.setInt(3, obj.getNumero());
            st.setString(4,obj.getMes());
            st.setInt(5,obj.getAno());
            
            int rows = st.executeUpdate();
            
            if(rows>0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                int id = rs.getInt(1);
                obj.setId_quadrinho(id);
                JOptionPane.showMessageDialog(null,"Quadrinho Inserido com Sucesso!!!! ID: "+ id);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Falha na inserção do Quadrinho");
            }
        }
        catch(SQLException e){
            throw new DbException("Erro ao inserir Quadrinho");
        }
        
    }

    @Override
    public void update(Quadrinhos obj) {
       String sql = "update quadrinhos "
                    +"set nome_quadrinho = ? , nome_editora = ? , numero = ? , mes = ? , ano = ? "
                    +" where id_quadrinho = ? ";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setString(1,obj.getNome_quadrinho());
            st.setString(2,obj.getNome_editora());
            st.setInt(3, obj.getNumero());
            st.setString(4,obj.getMes());
            st.setInt(5,obj.getAno());
            st.setInt(6,obj.getId_quadrinho());
            
            int rows = st.executeUpdate();
            
            if(rows>0){
                JOptionPane.showMessageDialog(null,"Quadrinho Atualizado com Sucesso!!!!");
            }else{
                JOptionPane.showMessageDialog(null,"Falha na Atualização do Quadrinho");
            }
        }
        catch(SQLException e){
            throw new DbException("Erro ao inserir Quadrinho");
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from quadrinhos where id_quadrinho = ? ";
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement(sql);
            st.setInt(1,id);
            int rows = st.executeUpdate();
            
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Quadrinho removido com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Quadrinho não encontrado. Não pode ser Removido");
            }
            
        }
        catch(SQLException e){
            throw new DbException("Erro ao listar Quadrinhos");
        }
        
        finally{
            DB.closeStatement(st);
        }
  
    }

    @Override
    public Quadrinhos acharPorId(int id) {
        String sql = "select * from quadrinhos where id_quadrinho = ? ";
        ResultSet rs = null;
        PreparedStatement st = null;
        Quadrinhos hq = null;
        try{
            st = conn.prepareStatement(sql);
            st.setInt(1,id);
            rs = st.executeQuery();
            while(rs.next()){
                int id_q = rs.getInt("id_quadrinho");
                String nome = rs.getString("nome_quadrinho");
                String editora = rs.getString("nome_editora");
                int numero = rs.getInt("numero");
                String mes = rs.getString("mes");
                int ano = rs.getInt("ano");
                hq = new Quadrinhos(id_q,nome,editora,numero,mes,ano);
            }
        }
        catch(SQLException e){
            throw new DbException("Erro ao listar Quadrinhos");
        }
        
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return hq;
    }

    @Override
    public List<Quadrinhos> listarQuadrinhos() { 
        String sql = "select * from quadrinhos";
        ResultSet rs = null;
        PreparedStatement st = null;
        List<Quadrinhos> list = new ArrayList<>();
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                int id_quadrinho = rs.getInt("id_quadrinho");
                String nome = rs.getString("nome_quadrinho");
                String editora = rs.getString("nome_editora");
                int numero = rs.getInt("numero");
                String mes = rs.getString("mes");
                int ano = rs.getInt("ano");
                Quadrinhos hq = new Quadrinhos(id_quadrinho,nome,editora,numero,mes,ano);
                list.add(hq);
            }
        }
        catch(SQLException e){
            throw new DbException("Erro ao listar Quadrinhos");
        }
        
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return list;
    }
    
}
