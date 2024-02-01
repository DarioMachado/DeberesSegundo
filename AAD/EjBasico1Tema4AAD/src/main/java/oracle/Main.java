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

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();	
			ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
			context.bind(sessionFactory.openSession());
			
			Session session = context.currentSession();
			
			List<Empresa> empresas = session.createQuery("from Empresa", Empresa.class).list();
			
			for(Empresa empresa: empresas) {
				System.out.println(empresa);
			}
			
	}
	
	
	
}
