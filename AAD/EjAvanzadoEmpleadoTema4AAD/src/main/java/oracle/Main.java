package oracle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();	
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		
		Session session = context.currentSession();
		EmpleadoDAOHibernate dao = new EmpleadoDAOHibernate(session);
		
		Empleado miEmpleado = new Empleado(3, "EEQEQWEWQE", "asfasfsdf");
		dao.agregarEmpleado(new Empleado(1, "Ejemplo", "Empleado2"));
		dao.agregarEmpleado(new Empleado(2, "AWAWAWWAWAWA", "Emple32ado2"));
		dao.agregarEmpleado(miEmpleado);
		
		miEmpleado.setNombre("QEQEQEQEQWE");
		dao.actualizarEmpleado(miEmpleado);
		System.out.println(dao.obtenerTodosLosEmpleados());
		
		dao.eliminarEmpleado(3);
		System.out.println(dao.obtenerTodosLosEmpleados());

		
	}

}
