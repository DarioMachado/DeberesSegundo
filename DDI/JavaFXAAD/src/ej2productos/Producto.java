package ej2productos;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Producto {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty nombre = new SimpleStringProperty();
	private DoubleProperty precio = new SimpleDoubleProperty();
	private IntegerProperty codigo = new SimpleIntegerProperty();
	
	public Producto(int id, String nombre, double precio, int codigo) {
		this.id.set(id);
		this.nombre.set(nombre);
		this.precio.set(precio);
		this.codigo.set(codigo);
	}

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public double getPrecio() {
		return precio.get();
	}

	public void setPrecio(double precio) {
		this.precio.set(precio);
	}

	public int getCodigo() {
		return codigo.get();
	}

	public void setCodigo(int codigo) {
		this.codigo.set(codigo);
	}
	
	public IntegerProperty idProperty() {
		return id;
	}
	public IntegerProperty codigoProperty() {
		return codigo;
	}
	
	public DoubleProperty precioProperty() {
		return precio;
	}
	
	public StringProperty nombreProperty() {
		return nombre;
	}

}
