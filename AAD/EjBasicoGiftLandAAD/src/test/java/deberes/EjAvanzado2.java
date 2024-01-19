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

import orm.Producto;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EjAvanzado2 {
	
	
	Session conectar() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());
		return context.currentSession();
	}
	
	@Test
	@Order(1)
	void modificarRegistro() {
		Session session = conectar();
		session.beginTransaction();
		Query<?> updateQuery = session.createQuery("UPDATE Producto SET nombre = 'Crepúsculo' WHERE id % 2 = 0");
		updateQuery.executeUpdate();
		
		Query<Producto> selectQuery = session.createQuery("FROM Producto", Producto.class);
		List<Producto> productos = selectQuery.list();
		System.out.println("Lista de productos mejorada:");
		for(Producto producto: productos) System.out.println(producto);
		
		session.close();
	}
	
	@Test
	@Order(2)
	void borrarRegistros() {
		Session session = conectar();
		session.beginTransaction();
		Query<?> quemaDeLibros = session.createQuery("DELETE FROM Producto WHERE nombre != 'Crepúsculo' ");
		quemaDeLibros.executeUpdate();
		
		Query<Producto> selectQuery = session.createQuery("From Producto", Producto.class);
		List<Producto> productos = selectQuery.list();
		System.out.println("Lista de productos mejorada aún más:");
		for(Producto producto: productos) System.out.println(producto);
		
		session.close();
	}

}
