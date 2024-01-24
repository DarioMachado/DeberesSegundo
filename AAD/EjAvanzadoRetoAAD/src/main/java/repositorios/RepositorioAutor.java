package repositorios;

import entidades.Autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class RepositorioAutor {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Autor> getAllAutores() {
        return entityManager.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
    }

    public Optional<Autor> getAutorById(Long autorId) {
        return Optional.ofNullable(entityManager.find(Autor.class, autorId));
    }

    public Autor createAutor(Autor autor) {
        entityManager.persist(autor);
        return autor;
    }

    public void updateAutor(Autor autor) {
        entityManager.merge(autor);
    }

    public void deleteAutor(Long autorId) {
        Autor autor = entityManager.find(Autor.class, autorId);
        if (autor != null) {
            entityManager.remove(autor);
        }

}
}
