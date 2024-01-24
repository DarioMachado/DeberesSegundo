package entidades;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="libros")
public class Libro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String nombre;

    @Column
    private String ISBN;

    @Column(name = "release_year")
    private int releaseYear;

    @Column
    private String idioma;

    @Column
    private double precio;

    @Column
    private int cantidad;


    @ManyToMany
    private Set<Autor> autores = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "libros_categorias",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> categorias = new HashSet<>();

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @ManyToMany(mappedBy = "libros")
    private Set<Pedido> pedidos = new HashSet<>();

    public Libro(String nombre, String ISBN, int releaseYear, String idioma, double precio, int cantidad) {
        this.nombre = nombre;
        this.ISBN = ISBN;
        this.releaseYear = releaseYear;
        this.idioma = idioma;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Libro(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", releaseYear=" + releaseYear +
                ", idioma='" + idioma + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }
}
