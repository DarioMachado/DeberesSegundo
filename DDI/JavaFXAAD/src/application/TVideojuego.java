package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class TVideojuego {

	private StringProperty nombre = new SimpleStringProperty();
	private IntegerProperty year = new SimpleIntegerProperty();
	private StringProperty compania = new SimpleStringProperty();
	private DoubleProperty precio = new SimpleDoubleProperty();
	private StringProperty sinopsis = new SimpleStringProperty();
	private StringProperty plataforma = new SimpleStringProperty();
	
	public TVideojuego(int id, String nombre, int year, String compania, double precio, String sinopsis, String plataforma) {
		this.nombre.set(nombre);
		this.year.set(year);
		this.compania.set(compania);
		this.precio.set(precio);
		this.sinopsis.set(sinopsis);
		this.plataforma.set(plataforma);
	}

	public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String getCompania() {
        return compania.get();
    }

    public StringProperty companiaProperty() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania.set(compania);
    }

    public double getPrecio() {
        return precio.get();
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public String getSinopsis() {
        return sinopsis.get();
    }

    public StringProperty sinopsisProperty() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis.set(sinopsis);
    }

    public String getPlataforma() {
        return plataforma.get();
    }

    public StringProperty plataformaProperty() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma.set(plataforma);
    }

}


