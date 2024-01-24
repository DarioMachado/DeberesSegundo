package servicios;

import entidades.Cliente;
import repositorios.RepositorioCliente;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ServicioCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public List<Cliente> getAllClientes() {
        return repositorioCliente.getAllClientes();
    }

    public Optional<Cliente> getClienteById(Long clienteId) {
        return repositorioCliente.getClienteById(clienteId);
    }

    @Transactional
    public Cliente createCliente(Cliente cliente) {
        return repositorioCliente.createCliente(cliente);
    }

    @Transactional
    public void updateCliente(Cliente cliente) {
        repositorioCliente.updateCliente(cliente);
    }

    @Transactional
    public void deleteCliente(Long clienteId) {
        repositorioCliente.deleteCliente(clienteId);
    }

    public List<Cliente> getClientesByEmail(String email) {
        return repositorioCliente.getClientesByEmail(email);
    }
}

