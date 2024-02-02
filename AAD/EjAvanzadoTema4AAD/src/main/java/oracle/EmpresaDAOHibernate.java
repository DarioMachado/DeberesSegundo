package oracle;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;

public class EmpresaDAOHibernate implements EmpresaDAO{
	
	@PersistenceContext
    private Session session;
	
	public EmpresaDAOHibernate(Session session) {
		this.session = session;
	};

	@Override
	public void agregarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarEmpresa(Empresa empresa) {
		session.merge(empresa);
		
	}

	@Override
	public void eliminarEmpresa(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empresa obtenerEmpresa(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empresa> obtenerTodasLasEmpresas() {
		return session.createQuery("From Empresa", Empresa.class).list();
	}

}
