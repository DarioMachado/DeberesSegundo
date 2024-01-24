package entidades;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name="precio_total")
    private double precioTotal;

    @Column(name="fecha_pedido")
    private Date fechaPedido;

    @Column(name="direccion_envio")
    private String direccionEnvio;


    @ManyToMany
    private Set<Libro> libros = new HashSet<>();

    public Pedido(Cliente cliente, double precioTotal, Date fechaPedido, String direccionEnvio) {
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.fechaPedido = fechaPedido;
        this.direccionEnvio = direccionEnvio;
    }

    public Pedido(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", Cliente=" + cliente +
                ", precioTotal=" + precioTotal +
                ", fechaPedido=" + fechaPedido +
                ", direccionEnvio='" + direccionEnvio + '\'' +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }
}
