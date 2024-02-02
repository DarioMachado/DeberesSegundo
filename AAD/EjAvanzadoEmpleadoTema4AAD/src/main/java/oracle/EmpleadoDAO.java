package oracle;

import java.util.List;

public interface EmpleadoDAO {
	
	public abstract void agregarEmpleado(Empleado empleado);
	
	public abstract void actualizarEmpleado(Empleado empleado);
	
	public abstract void eliminarEmpleado(int id);
	
	public abstract Empleado obtenerEmpleado(int id);
	
	public abstract List<Empleado> obtenerTodosLosEmpleados();
	

}
