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
			Producto productos[] = {
					new Producto("Asterix y Obelix en Hispania", "Un emocionante libro para los amantes de los cómics", 29.99, "Editorial ABC", 50),
					new Producto("Dune", "El mejor libro de ciencia ficción", 15.50,"Editorial Marvel", 100),
					new Producto("Iliada", "Un clásico para regalar", 50.00, "Editorial Homero", 30),
					new Producto("Juego la batalla del abismo de Helm", "Juego de estrategia para divertirse en familia", 39.99, "Juegos divertidos SL", 20)
			};
			
			session = context.currentSession();
			session.beginTransaction();
			
			for(Producto producto: productos) session.save(producto);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

}
