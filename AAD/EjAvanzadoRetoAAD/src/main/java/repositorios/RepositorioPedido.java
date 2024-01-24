package repositorios;

import entidades.Cliente;
import entidades.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class RepositorioPedido {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pedido> getAllPedidos() {
        return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
    }

    public Optional<Pedido> getPedidoById(Long pedidoId) {
        return Optional.ofNullable(entityManager.find(Pedido.class, pedidoId));
    }

    public Pedido createPedido(Pedido pedido) {
        entityManager.persist(pedido);
        return pedido;
    }

    public void updatePedido(Pedido pedido) {
        entityManager.merge(pedido);
    }

    public void deletePedido(Long pedidoId) {
        Pedido pedido = entityManager.find(Pedido.class, pedidoId);
        if (pedido != null) {
            entityManager.remove(pedido);
        }
    }

    public List<Pedido> getPedidosByCliente(Cliente cliente) {
        return entityManager.createQuery(
                        "SELECT p FROM Pedido p WHERE p.cliente = :cliente", Pedido.class)
                .setParameter("cliente", cliente)
                .getResultList();
    }
}

