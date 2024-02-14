package examen;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "citas")
public class Cita {
	
	@Id
	@Column
	private int id;
	
	@Column
	private int id_paciente;
	
	@Column
	private int id_medico;
	
	@Column
	private Date fecha;
	
	@Column
	private String hora;
	
	public Cita() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}

	public int getId_medico() {
		return id_medico;
	}

	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Cita [id=" + id + ", id_paciente=" + id_paciente + ", id_medico=" + id_medico + ", fecha=" + fecha
				+ ", hora=" + hora + "]";
	}
	
	
}
