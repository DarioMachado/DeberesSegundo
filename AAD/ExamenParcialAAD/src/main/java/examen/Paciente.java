package examen;

import javax.persistence.*;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	@Id
	@Column
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String ciudad;
	
	@Column
	private String direccion;
	
	@Column
	private String telefono;
	
	@Column
	private int edad;
	
	@Column
	private String historial;
	
	
	public Paciente() {}


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


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getHistorial() {
		return historial;
	}


	public void setHistorial(String historial) {
		this.historial = historial;
	}


	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ciudad=" + ciudad
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", edad=" + edad + ", historial=" + historial
				+ "]";
	}
	
	
	

}
