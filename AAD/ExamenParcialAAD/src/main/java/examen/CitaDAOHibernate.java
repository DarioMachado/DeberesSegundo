package examen;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CitaDAOHibernate implements CitaDAO{
	
	@PersistenceContext
	private Session session;

	public CitaDAOHibernate(Session session) {
		this.session=session;
	}
	
	@Override
	public void agregarCita(Cita cita) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(cita);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
	}

	@Override
	public void actualizarCita(Cita cita) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(cita);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
	}

	@Override
	public List<Cita> mostrarCitas() {
		return session.createQuery("From Cita", Cita.class).list();
	}

	@Override
	public void eliminarCita(int id) {
		Cita cita = session.find(Cita.class, id);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.remove(cita);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	}

}
