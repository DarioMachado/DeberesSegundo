package servicios;

import entidades.Cliente;
import entidades.Pedido;
import repositorios.RepositorioPedido;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ServicioPedido {

    private final RepositorioPedido repositorioPedido;

    public ServicioPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public List<Pedido> getAllPedidos() {
        return repositorioPedido.getAllPedidos();
    }

    public Optional<Pedido> getPedidoById(Long pedidoId) {
        return repositorioPedido.getPedidoById(pedidoId);
    }

    @Transactional
    public Pedido createPedido(Pedido pedido) {
        return repositorioPedido.createPedido(pedido);
    }

    @Transactional
    public void updatePedido(Pedido pedido) {
        repositorioPedido.updatePedido(pedido);
    }

    @Transactional
    public void deletePedido(Long pedidoId) {
        repositorioPedido.deletePedido(pedidoId);
    }

    public List<Pedido> getPedidosByCliente(Cliente cliente) {
        return repositorioPedido.getPedidosByCliente(cliente);
    }
}
