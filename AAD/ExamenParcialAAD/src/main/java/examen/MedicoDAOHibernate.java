package examen;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MedicoDAOHibernate implements MedicoDAO{
	
	@PersistenceContext
	private Session session;
	
	public MedicoDAOHibernate(Session session) {
		this.session=session;
	}

	@Override
	public void agregarMedico(Medico medico) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(medico);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	}

	@Override
	public void actualizarMedico(Medico medico) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(medico);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	}

	@Override
	public List<Medico> mostrarMedicos() {
		return session.createQuery("From Medico", Medico.class).list();
	}

	@Override
	public void eliminarMedico(int id) {
		Medico medico = session.find(Medico.class, id);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.remove(medico);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	}

}
