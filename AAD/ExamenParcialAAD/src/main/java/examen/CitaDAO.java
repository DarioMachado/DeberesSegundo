package examen;

import java.util.List;

public interface CitaDAO {
	
	public abstract void agregarCita(Cita cita);
	
	public abstract void actualizarCita(Cita cita);
	
	public abstract List<Cita> mostrarCitas();
	
	public abstract void eliminarCita(int id);
}
