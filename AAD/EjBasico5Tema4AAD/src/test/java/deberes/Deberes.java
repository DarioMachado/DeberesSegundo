package deberes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

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

import oracle.Empleado;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Deberes {
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String nombre = "system";
	private final String pass = "admin";
	
	Session conectar() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		return context.currentSession();
	}

	
	@Test
	@Order(1)
	void crearTabla() {
		//He buscado y supuestamente no se puede usando session.
		//La tabla Empleado tiene id, nombre y apellidos
		return;
	}
	@Test
	@Order(2)
	void insertar() {
		Session session = conectar();
		
		
		Random rng = new Random();
		Empleado empleado = new Empleado(rng.nextInt(), "Ejemplo", "Ejemplo 2");
		
		session.save(empleado);
		
		session.beginTransaction().commit();
		System.out.println("Insertar: ");
		System.out.println("Empleado guardado: "+empleado);
		System.out.println(leer());
		session.close();
	}
	
	
	String leer() {
		Session session = conectar();
		
		List<Empleado> empleados = session.createQuery("From Empleado", Empleado.class).list();
		StringBuilder strb = new StringBuilder();
		
		for(Empleado empleado: empleados) {
			strb.append(empleado+"\n");
		}
		return strb.toString();
		
	}
	
	@Test
	@Order(3)
	void modificar() {
		Session session = conectar();
		
		session.beginTransaction();
		
		Query<?> query = session.createQuery("UPDATE Empleado SET nombre = 'Alberto' WHERE nombre = 'Ejemplo'");
		
		query.executeUpdate();
		
		session.getTransaction().commit();
		System.out.println("Modificar: ");
		System.out.println(leer());
		session.close();
		
	}
	@Test
	@Order(4)
	void borrar() {
		Session session = conectar();
		session.beginTransaction();
		
		Query<?> borrar = session.createQuery("DELETE FROM Empleado WHERE id < 0");
		borrar.executeUpdate();
		
		session.getTransaction().commit();
		System.out.println("Borrar: ");
		System.out.println(leer());
	}
	
	
	
	
	
	
	

}
