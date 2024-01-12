package hibernate;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido1")
	private String apellido1;
	
	@Column(name="apellido2")
	private String apellido2;
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name="es_repetidor")
	private String repetidor;
	
	@Column(name="teléfono")
	private String telefono;

	public Alumno( String nombre, String apellido1, String apellido2, Date fechaNacimiento, boolean repetidor,
			String telefono) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
		this.repetidor = repetidor?"sí":"no";
		this.telefono = telefono;
	}

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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getRepetidor() {
		return repetidor;
	}

	public void setRepetidor(String repetidor) {
		this.repetidor = repetidor;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", fechaNacimiento=" + fechaNacimiento + ", repartidor=" + repetidor + ", telefono=" + telefono
				+ "]";
	}
	
	
	
	
}
