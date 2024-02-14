package examen;

import java.util.List;

public interface PacienteDAO {
	
	public abstract void agregarPaciente(Paciente paciente);
	
	public abstract void actualizarPaciente(Paciente paciente);
	
	public abstract List<Paciente> mostrarPacientes();
	
	public abstract void eliminarPaciente(int id);
	
}
