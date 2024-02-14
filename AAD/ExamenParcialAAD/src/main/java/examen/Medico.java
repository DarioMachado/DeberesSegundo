package examen;

import javax.persistence.*;

@Entity
@Table(name="medicos")
public class Medico {

	@Id
	@Column
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String especialidad;
	
	public Medico() {}
	

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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", especialidad=" + especialidad
				+ "]";
	}
	
	
	
	
}
