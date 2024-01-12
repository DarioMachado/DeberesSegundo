package hibernate;

import java.sql.Date;

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
		Session session = null;
       
		try {
			
			Alumno alumno = new Alumno("Alberto", "Ruiz", "Rodríguez", Date.valueOf("1975-05-05"), false, "34234234");
			
			 session = context.currentSession();
			 
			session.beginTransaction();
			
			session.save(alumno);
			
			session.beginTransaction().commit();
			
			System.out.println("Alumno guardado... " +alumno);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally{ 
			session.close() ;
			}
		
		
	}

}
