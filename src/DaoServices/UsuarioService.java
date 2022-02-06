package DaoServices;
import java.sql.Connection;
import dao.UsuarioDAO;
import db.DB;
import db.DbException;
import java.util.List;
import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioService implements UsuarioDAO{

    private Connection conn = null;

    public UsuarioService() {
    }
    public UsuarioService(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insere(Usuario obj) {
        String sql = "insert into usuario(nome_usuario,senha_usuario,email_usuario,nascimento,cadastro,endereco) values ( ? , md5(?), ? , ? , ? , ?)";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setString(1,obj.getNome_usuario());
            st.setString(2,obj.getSenha_usuario());
            st.setString(3,obj.getEmail_usuario());
            st.setDate(4,new java.sql.Date(obj.getNascimento().getTime()));
            st.setDate(5,new java.sql.Date(obj.getCadastro().getTime()));
            st.setString(6,obj.getEndereco());
            int rows = st.executeUpdate();
            
            if(rows > 0){
                JOptionPane.showMessageDialog(null,"Usuario Inserido com Sucesso");
            }else{
                JOptionPane.showMessageDialog(null,"Falha ao Inserir o Usuário");
            }
        }
        catch(SQLException e){
            throw new DbException("Erro na Inserção dos dados de Usuário em banco");
        }
        finally{
            DB.closeStatement(st); 
        }
    }

    @Override
    public void update(Usuario obj) {
        String sql = "update usuario set nome_usuario = ?, senha_usuario = md5(?) , email_usuario = ?, nascimento = ? , cadastro = ? , endereco = ?  where id_usuario = ? ";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, obj.getNome_usuario());
            st.setString(2, obj.getSenha_usuario());
            st.setString(3, obj.getEmail_usuario());
            st.setDate(4, new java.sql.Date(obj.getNascimento().getTime()));
            st.setDate(5, new java.sql.Date(obj.getCadastro().getTime()));
            st.setString(6, obj.getEndereco());
            st.setInt(7, obj.getId_usuario());
            
            int rows = st.executeUpdate();
            
            if(rows > 0){
                JOptionPane.showMessageDialog(null,"Usuário Atualizado com Sucesso");
            }else{
                JOptionPane.showMessageDialog(null,"Falha na Atualização do usuário");
            }
            DB.closeStatement(st);
        
        }
        catch(SQLException e){
            throw new DbException("Erro ao Atualizar dados do Usuário");
        }
    }

    @Override
    public void delete(int id) {
         String sql = "delete from usuario where id_usuario = ? ";
            PreparedStatement st = null;
            try{
                st = conn.prepareStatement(sql);
                st.setInt(1, id);
                int row = st.executeUpdate();
                if(row>0){
                    JOptionPane.showMessageDialog(null, "Ususário Apagado com Sucesso");
                }else{
                    JOptionPane.showMessageDialog(null, "Falha ao Remover Usuário: Inexistente");
                }   
                DB.closeStatement(st);
            }
            catch(SQLException e){
                throw new DbException("Erro ao Remover Usuários");
            }
    }

    @Override
    public Usuario acharPorId(int id) {
            String sql = "select * from usuario where id_usuario = ? ";
            PreparedStatement st = null;
            try{
                st = conn.prepareStatement(sql);
                st.setInt(1, id);
                ResultSet rs = st.executeQuery();
                Usuario user = null;

                while(rs.next()){
                    user = new Usuario(
                                       rs.getInt("id_usuario"),
                                       rs.getString("nome_usuario"),
                                       rs.getString("senha_usuario"),
                                       rs.getString("email_usuario"),
                                       rs.getDate("nascimento"),
                                       rs.getDate("cadastro"),
                                       rs.getString("endereco")
                                       );
                }
                DB.closeStatement(st);
                DB.closeResultSet(rs);
                return user;
            }
            catch(SQLException e){
                throw new DbException("Erro ao Listar Usuários");
            }
    }

    @Override
    public List<Usuario> listarUsuario() {
        String sql = "select * from usuario";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Usuario> list = new ArrayList<>();
            
            while(rs.next()){
                Usuario user = new Usuario(
                                           rs.getInt("id_usuario"),
                                           rs.getString("nome_usuario"),
                                           rs.getString("senha_usuario"),
                                           rs.getString("email_usuario"),
                                           rs.getDate("nascimento"),
                                           rs.getDate("cadastro"),
                                           rs.getString("endereco")
                                           );
                list.add(user);
            }
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            return list;
        }
        catch(SQLException e){
            throw new DbException("Erro ao Listar Usuários");
        }
    }
    
}
