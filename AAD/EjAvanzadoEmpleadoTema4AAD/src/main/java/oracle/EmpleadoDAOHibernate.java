package oracle;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

public class EmpleadoDAOHibernate implements EmpleadoDAO{
	
	@PersistenceContext
    private Session session;
	
	public EmpleadoDAOHibernate(Session session) {
		this.session = session;
	};

	@Override
	public void agregarEmpleado(Empleado empleado) {
		try {
		session.save(empleado);
		
		session.beginTransaction().commit();
		}catch(Exception e) {
			
		}
	}

	@Override
	public void actualizarEmpleado(Empleado empleado) {
		session.beginTransaction();
		
		Query<?> query = session.createQuery("UPDATE Empleado SET nombre = '"+empleado.getNombre()+"', apellidos = '"+empleado.getApellidos()+"' WHERE id = '+"+empleado.getId()+"'");
		
		query.executeUpdate();
		
		session.getTransaction().commit();
		
	}

	@Override
	public void eliminarEmpleado(int id) {
		Empleado empleado = session.find(Empleado.class, id);
		session.beginTransaction();
		if(empleado!=null) {
			session.remove(empleado);
		}
		session.getTransaction().commit();
		
	}

	@Override
	public Empleado obtenerEmpleado(int id) {
		return (Empleado) (session.find(Empleado.class, id));
	}

	@Override
	public List<Empleado> obtenerTodosLosEmpleados() {
		return session.createQuery("From Empleado", Empleado.class).list();
	}

}
