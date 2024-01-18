package orm;

import org.hibernate.Query;
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
		
		Session session = null;
		
		try {
			session = context.currentSession();
			session.beginTransaction();
			
			String updateHql = "UPDATE fabricante SET nombre = 'Gandalf' WHERE id = 14";
			
			Query<?> updateQuery = session.createQuery(updateHql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
