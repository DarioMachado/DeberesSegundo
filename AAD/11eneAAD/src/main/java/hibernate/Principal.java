package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class Principal {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor)sessionFactory);
		
		context.bind(sessionFactory.openSession());
		
		try {
		
		Session session = context.currentSession();
		
		session.beginTransaction();
		
		Fabricante fabricante = new Fabricante(222, "hola");
		
		session.save(fabricante);
		
		session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}

}
