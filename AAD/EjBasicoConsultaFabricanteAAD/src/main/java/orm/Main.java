package orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import org.hibernate.query.Query;



public class Main {

	public static void main(String[] args) {

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		ThreadLocalSessionContext context= new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		
		Session session = null;
		
		try {
			
			session = context.currentSession();
			session.beginTransaction();
			
			String hql = "FROM Fabricante";
			Query<Fabricante> query = session.createQuery(hql, Fabricante.class);
			
			List<Fabricante> fabricantes = query.list();
			
			System.out.println("Registro de la tabla:");
			for(Fabricante fabricante: fabricantes) System.out.println(fabricante);
		
			session.getTransaction().commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

}
