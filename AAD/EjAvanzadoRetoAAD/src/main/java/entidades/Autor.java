package entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Table(name= "autores")
public class Autor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String nombre;

    @Column
    private String paisOrigen;

    @Column
    private Date fechaNacimiento;

    @ManyToMany(mappedBy = "autores")
    private Set<Libro> libros = new HashSet<>();

    public Autor(){};

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

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", paisOrigen='" + paisOrigen + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }
}
