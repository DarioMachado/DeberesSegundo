package servicios;
import entidades.Categoria;
import repositorios.RepositorioCategoria;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ServicioCategoria {

    private final RepositorioCategoria repositorioCategoria;

    public ServicioCategoria(RepositorioCategoria repositorioCategoria) {
        this.repositorioCategoria = repositorioCategoria;
    }

    public List<Categoria> getAllCategorias() {
        return repositorioCategoria.getAllCategorias();
    }

    public Optional<Categoria> getCategoriaById(Long categoriaId) {
        return repositorioCategoria.getCategoriaById(categoriaId);
    }

    @Transactional
    public Categoria createCategoria(Categoria categoria) {
        return repositorioCategoria.createCategoria(categoria);
    }

    @Transactional
    public void updateCategoria(Categoria categoria) {
        repositorioCategoria.updateCategoria(categoria);
    }

    @Transactional
    public void deleteCategoria(Long categoriaId) {
        repositorioCategoria.deleteCategoria(categoriaId);
    }

    public List<Categoria> getCategoriasByNombre(String nombre) {
        return repositorioCategoria.getCategoriasByNombre(nombre);
    }
}
