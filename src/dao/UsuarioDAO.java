package dao;

import java.util.List;
import model.Usuario;

public interface UsuarioDAO {    
    void insere(Usuario obj);
    void update(Usuario obj);
    void delete(int id);
    Usuario acharPorId(int id);
    List<Usuario> listarUsuario();
    
}
