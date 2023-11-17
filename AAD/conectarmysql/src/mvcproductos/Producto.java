package mvcproductos;

public class Producto {
	private int id;
    private String nombre;
    private String descripcion;
    private String fabricante;
    private int precio;
    private int n_serie;
	public Producto(int id, String nombre, String descripcion, String fabricante, int precio, int n_serie) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fabricante = fabricante;
		this.precio = precio;
		this.n_serie = n_serie;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getFabricante() {
		return fabricante;
	}
	public int getPrecio() {
		return precio;
	}
	public int getN_serie() {
		return n_serie;
	}
    
    
    
}
