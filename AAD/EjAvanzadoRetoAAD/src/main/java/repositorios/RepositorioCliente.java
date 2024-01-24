package repositorios;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import entidades.Cliente;

public class RepositorioCliente {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Cliente> getAllClientes() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    public Optional<Cliente> getClienteById(Long clienteId) {
        return Optional.ofNullable(entityManager.find(Cliente.class, clienteId));
    }

    public Cliente createCliente(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    public void updateCliente(Cliente cliente) {
        entityManager.merge(cliente);
    }

    public void deleteCliente(Long clienteId) {
        Cliente cliente = entityManager.find(Cliente.class, clienteId);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    public List<Cliente> getClientesByEmail(String email) {
        return entityManager.createQuery(
                        "SELECT c FROM Cliente c WHERE c.email = :email", Cliente.class)
                .setParameter("email", email)
                .getResultList();
    }
}

