package repositorios;

import entidades.Libro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class RepositorioLibro {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Libro> getAllLibros() {
        return entityManager.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
    }

    public Optional<Libro> getLibroById(Long libroId) {
        return Optional.ofNullable(entityManager.find(Libro.class, libroId));
    }

    public Libro createLibro(Libro libro) {
        entityManager.persist(libro);
        return libro;
    }

    public void updateLibro(Libro libro) {
        entityManager.merge(libro);
    }

    public void deleteLibro(Long libroId) {
        Libro libro = entityManager.find(Libro.class, libroId);
        if (libro != null) {
            entityManager.remove(libro);
        }
    }

    public List<Libro> getLibrosByNombre(String nombre) {
        return entityManager.createQuery(
                        "SELECT l FROM Libro l WHERE l.nombre = :nombre", Libro.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }
}
