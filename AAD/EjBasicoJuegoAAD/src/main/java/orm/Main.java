package orm;

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
			Videojuego videojuego = new Videojuego("World of Warcraft", 2004, "Blizzard", 80.00,"Skinner Box", "PC");
			session = context.currentSession();
			session.beginTransaction();
			session.save(videojuego);
			session.getTransaction().commit();
			System.out.println("Videojuego insertado... "  +videojuego);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
		}
		
	}

}
