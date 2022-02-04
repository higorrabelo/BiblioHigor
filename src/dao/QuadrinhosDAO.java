package dao;

import java.util.List;
import model.Quadrinhos;

public interface QuadrinhosDAO {
    void insere(Quadrinhos obj);
    void update(Quadrinhos obj);
    void delete(int id);
    Quadrinhos acharPorId(int id);
    List<Quadrinhos> listarQuadrinhos();
}
