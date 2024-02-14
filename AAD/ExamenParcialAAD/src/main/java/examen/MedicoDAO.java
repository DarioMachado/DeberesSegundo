package examen;

import java.util.List;

public interface MedicoDAO {

	
	public abstract void agregarMedico(Medico medico);
	
	public abstract void actualizarMedico(Medico medico);
	
	public abstract List<Medico> mostrarMedicos();
	
	public abstract void eliminarMedico(int id);
	
}
