package orm;

import javax.persistence.*;

@Entity
@Table
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int codigo;
	
	@Column
	private String nombre;
	
	@Column
	private double precio;
	
	
	@ManyToOne
	@JoinColumn(name = "codigo_fabricante", nullable = false)
	private Fabricante fabricante;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	
	
	public Producto(String nombre, double precio, Fabricante fabricante) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", fabricante=" + fabricante
				+ "]";
	}

	public Producto() {}
	
	
	
	
}
