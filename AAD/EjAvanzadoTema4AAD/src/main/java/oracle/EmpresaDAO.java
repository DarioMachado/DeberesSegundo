package oracle;

import java.util.List;

public interface EmpresaDAO {
	
	public abstract void agregarEmpresa(Empresa empresa);
	
	public abstract void actualizarEmpresa(Empresa empresa);
	
	public abstract void eliminarEmpresa(int id);
	
	public abstract Empresa obtenerEmpresa(int id);
	
	public abstract List<Empresa> obtenerTodasLasEmpresas();
	

}
