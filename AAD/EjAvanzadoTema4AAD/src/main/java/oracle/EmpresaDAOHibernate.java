package oracle;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

public class EmpresaDAOHibernate implements EmpresaDAO{
	
	@PersistenceContext
    private Session session;
	
	public EmpresaDAOHibernate(Session session) {
		this.session = session;
	};

	@Override
	public void agregarEmpresa(Empresa empresa) {
		session.save(empresa);
		
		session.beginTransaction().commit();
		
	}

	@Override
	public void actualizarEmpresa(Empresa empresa) {
		session.beginTransaction();
		
		Query<?> query = session.createQuery("UPDATE Empresa SET nombre = '"+empresa.getNombre()+"', pais = '"+empresa.getPais()+"' WHERE id = '+"+empresa.getId()+"'");
		
		query.executeUpdate();
		
		session.getTransaction().commit();
		
	}

	@Override
	public void eliminarEmpresa(int id) {
		Empresa empresa = session.find(Empresa.class, id);
		session.beginTransaction();
		if(empresa!=null) {
			session.remove(empresa);
		}
		session.getTransaction().commit();
		
	}

	@Override
	public Empresa obtenerEmpresa(int id) {
		return (Empresa) (session.find(Empresa.class, id));
	}

	@Override
	public List<Empresa> obtenerTodasLasEmpresas() {
		return session.createQuery("From Empresa", Empresa.class).list();
	}

}
