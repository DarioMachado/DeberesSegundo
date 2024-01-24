package entidades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="categorias")
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String nombre;

    @ManyToMany
    private Set<Libro> libros = new HashSet<>();


    public Categoria(){}

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

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
