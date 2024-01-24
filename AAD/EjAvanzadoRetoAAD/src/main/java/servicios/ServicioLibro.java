package servicios;

import entidades.Libro;
import repositorios.RepositorioLibro;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ServicioLibro {

    private final RepositorioLibro repositorioLibro;

    public ServicioLibro(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public List<Libro> getAllLibros() {
        return repositorioLibro.getAllLibros();
    }

    public Optional<Libro> getLibroById(Long libroId) {
        return repositorioLibro.getLibroById(libroId);
    }

    @Transactional
    public Libro createLibro(Libro libro) {
        // Additional business logic, validation, or processing can go here
        return repositorioLibro.createLibro(libro);
    }

    @Transactional
    public void updateLibro(Libro libro) {
        // Additional business logic, validation, or processing can go here
        repositorioLibro.updateLibro(libro);
    }

    @Transactional
    public void deleteLibro(Long libroId) {
        // Additional business logic, validation, or processing can go here
        repositorioLibro.deleteLibro(libroId);
    }

    public List<Libro> getLibrosByNombre(String nombre) {
        // Example of using the custom query method in the service
        return repositorioLibro.getLibrosByNombre(nombre);
    }
}
