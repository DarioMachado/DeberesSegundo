package oracle;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import oracle.Empresa;

public class Main {

	public static void main(String[] args) {
			
			//Configurada sesión de hibernate en el método main
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();	
			ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
			context.bind(sessionFactory.openSession());
			
			Session session = context.currentSession();
			//Instanciado con session...
			EmpresaDAOHibernate dao = new EmpresaDAOHibernate(session);
			//Muestra de las empresas existentes
			List<Empresa> empresas = dao.obtenerTodasLasEmpresas();
			System.out.println(empresas); //Se ve feo pero bueno, funciona.
			
			//Actualizo el nombre de una empresa gracias a merge
			
			dao.actualizarEmpresa(new Empresa(1,"AAAAAA", "EEEEEEEEE"));
			//Y aquí acaba el ej 1
			
			//La opción de modificar ya estaba pero bueno
			dao.agregarEmpresa(new Empresa(6,"Juan", "España"));
			System.out.println(dao.obtenerEmpresa(6));
			dao.actualizarEmpresa(new Empresa(6, "Pedro", "España"));
			System.out.println(dao.obtenerEmpresa(6));
			dao.eliminarEmpresa(6);
			System.out.println(dao.obtenerEmpresa(6));
			
	}
	
	
	
}
