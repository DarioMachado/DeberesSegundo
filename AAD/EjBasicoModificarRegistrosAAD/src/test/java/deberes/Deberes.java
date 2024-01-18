package deberes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import orm.Fabricante;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Deberes {

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
	void ModificarDatos() {
		
		Session session = context.currentSession();
		session.beginTransaction();
		
		String updateHql = "UPDATE Fabricante SET nombre = 'Gandalf' WHERE id = 5";
		
		Query<?> updateQuery = session.createQuery(updateHql);
		
		int columnasAfectadas = updateQuery.executeUpdate();
		
		assertTrue(columnasAfectadas > 0);
		
		
	}
	@Test
	@Order(3)
	void verDatosModificados() {
		
		
		assertDoesNotThrow(() -> Deberes.mitest());
	}
	
	static void mitest() {
		Session session = context.currentSession();
		String selectHql = "FROM Fabricante WHERE id = 5";
		Query<Fabricante> selectQuery = session.createQuery(selectHql, Fabricante.class);
		List<Fabricante> fabricantes = selectQuery.list();
		
		System.out.println("Tabla fabricantes después de modificar Gandalf");
		for(Fabricante fabricante: fabricantes) System.out.println(fabricante);
	}

	@Test
	@Order(4)
	void consultaAntesDeBorrado(){
		String selectHqlBeforeDelete = "FROM Fabricante WHERE id = 5";
		Query<Fabricante> selectQueryBeforeDelete = session.createQuery(selectHql, Fabricante.class);
		List<Fabricante> FabricantesBeforeDelete = selectQueryBeforeDelete.list();
		System.out.println("Registros de la tabla fabricante antes de la eliminación:");
		for(Fabricante fabricante: fabricantesBeforeDelete) System.out.println(fabricante);
		
	}
	
	
	
	
	
}
