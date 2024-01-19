package orm;

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
			Fabricante fabricante = new Fabricante("pc gaming2");
			session = context.currentSession();
			session.beginTransaction();
			
			session.save(fabricante);
			session.getTransaction().commit();
			
			Producto producto = new Producto("PORTATIL gaming2", 300.00, fabricante);
			
			Session session2 = context.currentSession();
			session2.beginTransaction();
			session2.save(producto);
			session2.getTransaction().commit();
			System.out.println(producto);
			System.out.println(fabricante);
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}
