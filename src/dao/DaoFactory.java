package dao;

import DaoServices.QuadrinhosService;
import DaoServices.UsuarioService;
import db.DB;
public class DaoFactory {
    
    public static UsuarioDAO criarUsuario(){
        return new UsuarioService(DB.getConnection());
    }
    public static QuadrinhosDAO criarQuadrinho(){
        return new QuadrinhosService(DB.getConnection());
    }
}
