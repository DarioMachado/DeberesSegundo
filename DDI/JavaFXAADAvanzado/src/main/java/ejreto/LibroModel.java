package ejreto;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LibroModel {
	@PersistenceContext
	private Session session;


	public LibroModel(Session session){
		this.session = session;
	}

	public List<Libro> getAllLibros() {
		return session.createQuery("From Libro", Libro.class).list();
	}

	public void agregarLibro(Libro libro){
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(libro);
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}


	public void borrarLibro(Libro libro){
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(libro);
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}
