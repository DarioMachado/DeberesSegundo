package examen;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PacienteDAOHibernate implements PacienteDAO {
	
	@PersistenceContext
	private Session session;
	
	public PacienteDAOHibernate(Session session) {
		this.session=session;
	}

	@Override
	public void agregarPaciente(Paciente paciente) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(paciente);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(paciente);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	}

	@Override
	public List<Paciente> mostrarPacientes() {
		return session.createQuery("From Paciente", Paciente.class).list();
	}

	@Override
	public void eliminarPaciente(int id) {
		Paciente paciente = session.find(Paciente.class, id);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.remove(paciente);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	}

}
