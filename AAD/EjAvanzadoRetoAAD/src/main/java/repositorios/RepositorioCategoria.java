package repositorios;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import entidades.Categoria;

public class RepositorioCategoria {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Categoria> getAllCategorias() {
        return entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    public Optional<Categoria> getCategoriaById(Long categoriaId) {
        return Optional.ofNullable(entityManager.find(Categoria.class, categoriaId));
    }

    public Categoria createCategoria(Categoria categoria) {
        entityManager.persist(categoria);
        return categoria;
    }

    public void updateCategoria(Categoria categoria) {
        entityManager.merge(categoria);
    }

    public void deleteCategoria(Long categoriaId) {
        Categoria categoria = entityManager.find(Categoria.class, categoriaId);
        if (categoria != null) {
            entityManager.remove(categoria);
        }
    }

    public List<Categoria> getCategoriasByNombre(String nombre) {
        return entityManager.createQuery(
                        "SELECT c FROM Categoria c WHERE c.nombre = :nombre", Categoria.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }
}
