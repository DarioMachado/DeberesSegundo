package main;

import entidades.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		//Aquí empiezan los deberes...

		//Requerimientos:

		//1 - Implementar las identidades y relaciones utilizando Hibernate.
		//Hecho. Técnicamente he usado las anotaciones de persistence pero imagino que se refiere a eso.

		//2 - Crear operaciones CRUD para todas las identidades.
		//Hecho, en la clase repositorio y servicios. No sé si es eso a lo que se refiere porque no sale nada en los apuntes, pero bueno me lo dijo chat gpt.

		//3 - Implementar consultas HQL para obtener información como:
		//Obtener todos los libros de un autor especifico.
		//Obtener todos los libros de una categoría dada
		//Obtener el historial de pedidos de un cliente

		//Para esto tendré que introducir datos en la db.


		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		Session session = null;



		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
																				//Que alguien mate al que se le ocurrió hacer las fechas así en java, por favor.
			Autor stephenKing = new Autor("Stephen King", "USA", new Date(47,7,21));
			Autor allanPoe = new Autor("Edgar Allan Poe", "USA", new Date(0, 1, 19));

			Categoria terror = new Categoria("Terror");
			Categoria comedia = new Categoria("Comedia");

			Libro shining = new Libro("The Shining", "IDK12323123", 1977, "Español", 29.99, 10);
			Libro theraven = new Libro("The Raven", "AAAAAAAA", 1845, "Español", 19.99, 5);
			Libro inventado = new Libro("Libro de king y poe inventado", "12312321", 2025, "Esperanto", 55.55, 10);

			Cliente cliente = new Cliente("Alberto", "Profesor", "123456789", "elprofesor@email.com");

			Pedido pedido = new Pedido(cliente, 49.98, new Date(), "DirecciónEnvio");

			shining.getAutores().add(stephenKing);
			shining.getCategorias().add(terror);
			shining.getPedidos().add(pedido);

			theraven.getAutores().add(allanPoe);
			theraven.getCategorias().add(comedia);
			theraven.getPedidos().add(pedido);

			inventado.getAutores().add(stephenKing);
			inventado.getAutores().add(allanPoe);
			inventado.getCategorias().add(terror);

			cliente.getPedidos().add(pedido);

			pedido.getLibros().add(shining);
			pedido.getLibros().add(theraven);


			session.save(stephenKing);
			session.save(allanPoe);
			session.save(inventado);

			session.save(terror);
			session.save(comedia);

			session.save(shining);
			session.save(theraven);

			session.save(cliente);

			session.save(pedido);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

		//A continuación, haré las 3 consultas esas.


		try{

			session = sessionFactory.openSession();

			List<Autor> autores = session.createQuery("FROM Autor", Autor.class).getResultList();


			List<Categoria> categorias =session.createQuery("FROM Categoria", Categoria.class).getResultList();


			List<Cliente> clientes = session.createQuery("FROM Cliente", Cliente.class).getResultList();




			System.out.println("=== Autores ===");
			for (Autor autor : autores) {
				System.out.println("Autor: " + autor.getNombre());
				System.out.println("Libros:");
				for (Libro libro : autor.getLibros()) {
					System.out.println("  - " + libro.getNombre());
				}
				System.out.println("------------------------");
			}
			System.out.println("=== Categorias ===");
			for (Categoria categoria : categorias) {
				System.out.println("Categoria: " + categoria.getNombre());
				System.out.println("Libros:");
				for (Libro libro : categoria.getLibros()) {
					System.out.println("  - " + libro.getNombre());
				}
				System.out.println("------------------------");
			}

			System.out.println("=== Clientes ===");
			for (Cliente cliente : clientes) {
				System.out.println("Cliente: " + cliente.getNombre());
				for (Pedido pedido : cliente.getPedidos()) {
					System.out.println("  - Order ID: " + pedido.getId() + ", Total Price: " + pedido.getPrecioTotal());
				}
				System.out.println("------------------------");
			}



		}catch (Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

		//Y ya estaría.
		//Podría hacer lo de implementar un control de stocks, pero entre que llevo todo el día con esto, que son las 10 y media y que quedan 1 hora y media para entregarlo, y que estoy 99% seguro de que nada de esto lo va a leer nadie, pues aquí se queda.
		//Dicho esto, ahí pone que son opcionales y esto está perfecto así que no me haría falta nada opcional.


	}

}
