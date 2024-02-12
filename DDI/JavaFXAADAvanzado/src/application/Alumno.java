package application;

import java.util.Date;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Alumno {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty apellido1 = new SimpleStringProperty();
	private StringProperty apellido2 = new SimpleStringProperty();
	private ObjectProperty<Date> fecha = new SimpleObjectProperty<Date>();
	private BooleanProperty repetidor = new SimpleBooleanProperty();
	private StringProperty telefono = new SimpleStringProperty();
	
	public Alumno(int id, String nombre, String apellido1, String apellido2, Date fecha, boolean repetidor, String telefono) {
		this.id.set(id);
		this.nombre.set(nombre);
		this.apellido1.set(apellido1);
		this.apellido2.set(apellido2);
		this.fecha.set(fecha);
		this.repetidor.set(repetidor);
		this.telefono.set(telefono);
	}

	public int getId() {
		return id.get();
	}

	public String getNombre() {
		return nombre.get();
	}

	public String getApellido1() {
		return apellido1.get();
	}

	public String getApellido2() {
		return apellido2.get();
	}

	public Date getFecha() {
		return fecha.get();
	}
	public boolean getRepetidor() {
		return repetidor.get();
	}
	public String getTelefono() {
		return telefono.get();
	}
	
	public void setId(int id) {
		this.id.set(id);
	}
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	public void setApellido1(String apellido1) {
		this.apellido1.set(apellido1);
	}
	public void setApellido2(String apellido2) {
		this.apellido2.set(apellido2);
	}
	public void setFecha(Date fecha) {
		this.fecha.set(fecha);
	}
	public void setRepetidor(boolean repetidor) {
		this.repetidor.set(repetidor);
	}
	public void setTelefono(String telefono) {
		this.telefono.set(telefono);
	}
	
	
	public IntegerProperty getIdProperty() {
		return id;
	}
	public StringProperty getNombreProperty() {
		return nombre;
	}
	public StringProperty getApellido1Property() {
		return apellido1;
	}
	public StringProperty getApellido2Property() {
		return apellido2;
	}
	public ObjectProperty<Date> getFechaProperty(){
		return fecha;
	}
	public BooleanProperty getRepetidorProperty() {
		return repetidor;
	}
	public StringProperty getTelefonoProperty() {
		return telefono;
	}

}
