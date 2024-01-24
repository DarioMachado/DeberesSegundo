package servicios;

import entidades.Autor;
import repositorios.RepositorioAutor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ServicioAutor {

    private final RepositorioAutor repositorioAutor;

    public ServicioAutor(RepositorioAutor repositorioAutor) {
        this.repositorioAutor = repositorioAutor;
    }

    public List<Autor> getAllAutores() {
        return repositorioAutor.getAllAutores();
    }

    public Optional<Autor> getAutorById(Long autorId) {
        return repositorioAutor.getAutorById(autorId);
    }

    @Transactional
    public Autor createAutor(Autor autor) {
        return repositorioAutor.createAutor(autor);
    }

    @Transactional
    public void updateAutor(Autor autor) {
        repositorioAutor.updateAutor(autor);
    }

    @Transactional
    public void deleteAutor(Long autorId) {
        repositorioAutor.deleteAutor(autorId);
    }
}
