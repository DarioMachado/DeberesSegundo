package oracle;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();	
			ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
			context.bind(sessionFactory.openSession());
			
			
	}
	
	
	
}
