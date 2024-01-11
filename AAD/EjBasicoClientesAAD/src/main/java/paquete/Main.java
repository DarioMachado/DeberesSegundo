package paquete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Main {

	public static void main(String[] args) {

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor)sessionFactory);
		context.bind(sessionFactory.openSession());
		
		try {
			Cliente cliente = new Cliente("Eva","Sevilla");
			Session session = context.currentSession();
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
			
			System.out.println("cliente guardado..." +cliente);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
