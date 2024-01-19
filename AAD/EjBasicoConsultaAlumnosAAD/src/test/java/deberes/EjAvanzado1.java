package deberes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import orm.Alumno;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EjAvanzado1 {
	
	static SessionFactory sessionFactory;
	static ThreadLocalSessionContext context;
	@Test
	@Order(1)
	void inicializar() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		
		context.bind(sessionFactory.openSession());
		
		
	}
	
	@Test
	@Order(2)
	void modificarDatos() {
		Session session = context.currentSession();
		session.beginTransaction();
		Query<?> updateQuery = session.createQuery("UPDATE Alumno SET apellido1 = 'Borbón' where id = 1");
		updateQuery.executeUpdate();
		
		Query<Alumno> selectQuery = session.createQuery("FROM Alumno WHERE id = 1", Alumno.class);
		List<Alumno> alumnos = selectQuery.list();
		System.out.println("El alumno tras ser modificado:");
		for(Alumno alumno: alumnos) System.out.println(alumno);
		session.close();
		
	}
	
	@Test
	@Order(3)
	void borrarDatos() {
		inicializar();
		Session session = context.currentSession();
		session.beginTransaction();
		Query<?> deleteQuery = session.createQuery("DELETE FROM Alumno WHERE id = 5");
		deleteQuery.executeUpdate();
		Query<Alumno> selectQuery = session.createQuery("From Alumno", Alumno.class);
		List<Alumno> alumnos = selectQuery.list();
		System.out.println("Alumnos después de borrar a un alumno");
		for(Alumno alumno: alumnos) System.out.println(alumno);
		session.close();
	}

}
