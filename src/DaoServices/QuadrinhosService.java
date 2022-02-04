package DaoServices;
import java.sql.Connection;
import dao.QuadrinhosDAO;
import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Quadrinhos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Quadrinhos acharPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Quadrinhos> listarQuadrinhos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
